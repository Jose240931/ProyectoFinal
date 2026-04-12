module ProyectoFinal.main {
    requires java.sql;

    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.mail;
    requires org.xerial.sqlitejdbc;

    uses java.sql.Driver;

    opens org.main.controller to javafx.fxml;

    exports org.main;
    exports org.main.model;
    exports org.main.services;
}