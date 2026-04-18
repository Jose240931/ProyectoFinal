package org.main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import org.main.services.DBService;

import java.util.List;

public class anadirController {

    public ComboBox <String> ComboBox;
    String producto;

    public void initialize() {
    }

    public void init(String producto, List<String> categorias) {
        this.producto = producto;
        ComboBox.getItems().setAll(categorias);
    }
    @FXML
    //Con este metodo se guarda se llama al servicio de insercion en la base de datos
    public void guardar(ActionEvent actionEvent) {
        System.out.println("Se ha llamado a guardar: "+ComboBox.getValue()+producto);
        String categoria = ComboBox.getValue();
        if (categoria == null || categoria.isBlank()) return;

        DBService db = new DBService();
        db.guardar(producto, categoria);

        Stage stage = (Stage) ComboBox.getScene().getWindow();
        stage.close();


    }
}
