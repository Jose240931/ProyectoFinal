package org.main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Prueba {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:src/data/info.db");
        System.out.println("Conectado a SQLite correctamente");
        conn.close();
    }
}
