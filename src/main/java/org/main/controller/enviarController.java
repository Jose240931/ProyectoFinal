package org.main.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.main.services.EmailService;
import org.main.services.FileService;

import java.io.File;
import java.util.List;


public class enviarController {

    public ProgressIndicator progress;
    private List<String> lista;
    @FXML
    private TextField emailDestino;
    public void setLista (List < String > lista) {
        this.lista = lista;
    }

    public void enviarCorreo(ActionEvent actionEvent) {
        progress.setVisible(true);
        emailDestino.setDisable(true);

        Task<Void> tareaEnvio = new Task<>() {
            @Override
            protected Void call() throws Exception {
                FileService fileService = new FileService();
                EmailService emailService = new EmailService();

                File txt = fileService.crearTxtDesdeLista(lista);
                emailService.enviarCorreoConAdjunto(emailDestino.getText(), txt);

                return null;
            }
        };

        tareaEnvio.setOnSucceeded(e -> {
            progress.setVisible(false);

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Correo enviado");
            alerta.setHeaderText("Correo enviado");
            alerta.setContentText("Correo enviado con éxito");
            alerta.showAndWait();

            Stage stage = (Stage) emailDestino.getScene().getWindow();
            stage.close();
        });

        tareaEnvio.setOnFailed(e -> {
            progress.setVisible(false);
            emailDestino.setDisable(false);

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al enviar correo");
            alerta.setContentText(tareaEnvio.getException().getMessage());
            alerta.show();
        });

        new Thread(tareaEnvio).start();
    }
}
