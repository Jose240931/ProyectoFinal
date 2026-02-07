package org.main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class Controller {

    public TextArea input;
    public ListView listaOrdenada;

    @FXML
    public void initialize() {
        //Datos de ejemplo y prueba
        listaOrdenada.getItems().addAll(
                "Artículo 1",
                "Artículo 2",
                "Artículo 3"
        );
    }

    //Borra tanto la lista escrita sin ordenar como la ordenada
    public void borrar(ActionEvent actionEvent) {
        input.clear();
        listaOrdenada.getItems().removeAll(listaOrdenada.getItems());
    }

    //Metodo principal con el que se ordenaran los articulos en una lista por secciones
    public void ordenar(ActionEvent actionEvent) {
        //TODO
    }

    //Al pulsar en salir cierra el programa de la misma manera que si pulsaras sobre la x de la esquina superior
    public void salir(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void enviar(ActionEvent actionEvent) {
        //TODO
    }

    public void guardar(ActionEvent actionEvent) {
        //TODO
    }
}
