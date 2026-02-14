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
    public ListView <String> listaOrdenada;

    public List<String> obtenerListaOrdenada() {
        return new ArrayList<>(listaOrdenada.getItems());
    }


    //Borra tanto la lista escrita sin ordenar como la ordenada
    public void borrar(ActionEvent actionEvent) {
        input.clear();
        listaOrdenada.getItems().removeAll(listaOrdenada.getItems());
    }

    //Metodo principal con el que se ordenaran los articulos en una lista por secciones
    public void ordenar(ActionEvent actionEvent) {
        //Inicializo el service de la base de datos
        DBService db = new DBService();
        //limpio la lista ordenada antes de volver a ordenar otra lista
        listaOrdenada.getItems().clear();

        //almaceno la lista en un string
        String texto = input.getText();
        //Normalizo el texto quitando tildes y pasando a minuscula ademas de quitar espacios en blanco
        Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase()
                .trim();

        //en caso de que el texto este vacio y el boton ordenar se haya pulsado no devuelve nada, simplemente vacia la lista
        if(texto.isEmpty()){
            return;
        }

        //Creo un array de string que esta formada por el texto dividido en los salots de linea
        String [] productos = texto.split("\\R");

        //Almaceno la relacion de categorias y productos en un treemap, que ordena automaticamente por orden de lista
        Map<String, List<String>> porCategoria = new TreeMap<>();

        //Recorro el array de productos para buscarlos en la base de datos
        for(int i =0; i<productos.length; i++){
            String producto =productos[i].trim().toLowerCase();

            // Manejo de plurales simples quitando "s" al final si tiene más de 3 letras (apaño cutre)
            if (producto.length() > 3 && producto.endsWith("s")) {
                producto = producto.substring(0, producto.length() - 1);
            }

            ProductoInfo info = db.obtenerCategoria(producto);
            String categoria;
            String nombreMostrar;

            if(info==null){
                categoria="No clasificado";
                nombreMostrar=productos[i];
            }else{
                categoria=info.getCategoria();
                nombreMostrar=info.getNombreReal();
            }

            //Almaceno en mi tree map la asosiacion de cada producto a su correspondiente categoria
            porCategoria.computeIfAbsent(categoria, k -> new ArrayList<>())
                    .add(nombreMostrar);

        }

        //Bloque donde muestro en el list view mi lista ordenada
        for(String categoria: porCategoria.keySet()){
            listaOrdenada.getItems().add("===="+categoria+"====");
            for (String producto : porCategoria.get(categoria)) {
                listaOrdenada.getItems().add(producto);
            }
        }

    }

    //Al pulsar en salir cierra el programa de la misma manera que si pulsaras sobre la x de la esquina superior
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

        //Creo un filtro para que el archivo se guarde como txt
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivo de texto(*.txt)", "*.txt");
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
        alert.setHeaderText("Acerca de ");
        alert.setContentText("Programa realizado por Jose Garrido Luna 2026 2ºDAM");
        alert.showAndWait();
    }
}
