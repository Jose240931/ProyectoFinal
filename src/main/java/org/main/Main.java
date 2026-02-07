package org.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    //Creacion de la ventana y carga de interfaz del usuario
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/vista.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Lista auto ordenada");
        stage.getIcons().add(
                new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/icons/app.png")))
        );
        stage.setScene(scene);
        stage.show();
    }
}
