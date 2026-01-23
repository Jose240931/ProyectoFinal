package org.main;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InitDataBase {
    public static void main(String[] args) throws Exception {

        //Creo la conexion
        Connection conn = DriverManager.getConnection("jdbc:sqlite:src/data/info.db");
        Statement stmt = conn.createStatement();

        System.out.println("Conectado a SQLite correctamente");

        // Leer todó el contenido de schema.sql
        String sql = Files.readString(Paths.get("src/main/resources/schemas.sql"));
        //Con esto creo el esquema de la base de datos
        stmt.executeUpdate(sql);

        stmt.close();
        conn.close();

    }
}
