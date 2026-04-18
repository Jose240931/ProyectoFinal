package org.main.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.main.services.DBService;
import org.main.model.ProductoInfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Controller {

    public TextArea input;
    public ListView<String> listaOrdenada;
    public Button botonAñadir;
    private String productoNoClasificadoSeleccionado;

    public void initialize(){
        añadirACategoria();
    }

    public List<String> obtenerListaOrdenada() {
        return new ArrayList<>(listaOrdenada.getItems());
    }

    // Borra tanto la lista escrita sin ordenar como la ordenada
    public void borrar(ActionEvent actionEvent) {
        input.clear();
        listaOrdenada.getItems().clear();
    }

    // Método principal con el que se ordenan los artículos en una lista por secciones
    public void ordenar(ActionEvent actionEvent) {
        DBService db = new DBService();
        listaOrdenada.getItems().clear();

        String texto = input.getText();

        if (texto == null || texto.isBlank()) {
            return;
        }

        String[] productos = texto.split("\\R");
        Map<String, List<String>> porCategoria = new TreeMap<>();

        for (String lineaOriginal : productos) {
            String lineaTrimmed = lineaOriginal.trim();

            if (lineaTrimmed.isEmpty()) {
                continue;
            }

            // Se normaliza y se almacena en una variable
            String productoNormalizado = Normalizer
                    .normalize(lineaTrimmed, Normalizer.Form.NFD)
                    .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                    .toLowerCase()
                    .trim();

            // Manejo de plurales: quita la "s" final si el producto tiene más de 3 letras
            String productoQuery = productoNormalizado;
            if (productoQuery.length() > 3 && productoQuery.endsWith("s")
                    && !productoQuery.endsWith("ss")) {
                productoQuery = productoQuery.substring(0, productoQuery.length() - 1);
            }

            ProductoInfo info = db.obtenerCategoria(productoQuery);

            String categoria;
            String nombreMostrar;

            if (info == null) {
                categoria    = "No clasificado";
                // Muestra el texto original del usuario (con mayúsculas y tildes)
                nombreMostrar = lineaTrimmed;
            } else {
                categoria    = info.getCategoria();
                nombreMostrar = info.getNombreReal();
            }

            porCategoria
                    .computeIfAbsent(categoria, k -> new ArrayList<>())
                    .add(nombreMostrar);
        }

        // Vuelca el mapa ordenado en el ListView
        for (String categoria : porCategoria.keySet()) {
            listaOrdenada.getItems().add("====" + categoria + "====");
            for (String producto : porCategoria.get(categoria)) {
                listaOrdenada.getItems().add(producto);
            }
        }
    }

    public void salir(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void enviar(ActionEvent actionEvent) throws IOException {
        //Carga y abre el fxml de la ventana de envio
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enviar.fxml"));
        Parent root = loader.load();

        enviarController controller = loader.getController();
        controller.setLista(obtenerListaOrdenada());

        Stage stage = new Stage();
        stage.setTitle("Enviar lista");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void guardar(ActionEvent actionEvent) {
        //Uso el filechooser para abrir la ventana del explorador de archivos del sistema operativo
        FileChooser guardarArchivo = new FileChooser();
        guardarArchivo.setTitle("Guardar archivo");

        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Archivo de texto (*.txt)", "*.txt");
        guardarArchivo.getExtensionFilters().add(extFilter);

        //Apertura del dialogo del sistema operativo
        Stage stage = (Stage) listaOrdenada.getScene().getWindow();
        File file = guardarArchivo.showSaveDialog(stage);

        //Si el arhivo no esta vacio escribe en el archivo
        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                //Escribimos cada línea de la lista ordenada en el archivo
                for (String item : listaOrdenada.getItems()) {
                    writer.write(item + System.lineSeparator());
                }
                writer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void marcado(ActionEvent actionEvent) {
        //capturo el producto seleccionado y lo borra de la lista
        String seleccionado = listaOrdenada.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaOrdenada.getItems().remove(seleccionado);
        }
    }

    public void acercaDe(ActionEvent actionEvent) {
        //Alerta de informacion sobre el programa
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de lista auto ordenada");
        alert.setHeaderText("Acerca de");
        alert.setContentText("Programa realizado por Jose Garrido Luna 2026 2ºDAM");
        alert.showAndWait();
    }

    //Metodo para añadir un prodcuto no registrado a una categoria existente de la base de datos
    public void añadirACategoria() {
        //Listener de la lista para detectar cambios cada vez que se clicka sobre una celda distinta
        listaOrdenada.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) return;

            int idx = newValue.intValue();
            if (idx < 0) return;

            String selected = listaOrdenada.getItems().get(idx);
            if (selected == null) return;

            // Si es una cabecera ignora
            if ((selected.startsWith("====")&& selected.endsWith("===="))) return;

            String cabecera = encontrarCabeceraAnterior(idx);
            if (cabecera == null) return;

            //Detecta si el click ha sido sobre un producto no clasificado
            if (cabecera.toLowerCase().contains("no clasificado".toLowerCase()) || cabecera.toLowerCase().contains("no clasificado")) {
                System.out.println("Click en producto NO CLASIFICADO: " + selected);
                //Guarda el string del producto no clasificado
                productoNoClasificadoSeleccionado = selected;
                //Añado el boton de añadir a la interfaz
                botonAñadir.setManaged(true);
                botonAñadir.setVisible(true);
            } else {
                // Producto de otra categoría oculto el boton
                botonAñadir.setVisible(false);
                botonAñadir.setManaged(false);
            }
        });
    }

    private boolean esCabecera(String s) {
        return s.startsWith("====") && s.endsWith("====");
    }

    private String encontrarCabeceraAnterior(int fromIndex) {
        for (int i = fromIndex; i >= 0; i--) {
            String item = listaOrdenada.getItems().get(i);
            if (item != null && esCabecera(item)) {
                return item;
            }
        }
        return null;
    }

    public void AñadirProducto(ActionEvent actionEvent) throws IOException {
        DBService db = new DBService();
        List<String> categorias = db.obtenerCategorias();
        //Carga y abre el fxml de la ventana de añadir
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/anadir.fxml"));
        Parent root = loader.load();

        anadirController controller = loader.getController();
        controller.init(productoNoClasificadoSeleccionado, categorias);

        Stage stage = new Stage();
        stage.setTitle("Añadir producto");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        ordenar(null);
    }
}
