package org.main.services;

import org.main.model.ProductoInfo;

import java.sql.*;

public class DBService {

    private static final String URL = "jdbc:sqlite:src/data/info.db";

    private Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL);
    }
    public ProductoInfo obtenerCategoria(String producto){

        //Consulta sql que busca el nombre de la categoria de un producto especifico en minuscula, eliminando tildes y buscando coincidencias
        String sql = """
        SELECT c.nombre_categoria, p.nombre_producto
        FROM PRODUCTO p
        JOIN CATEGORIA c ON p.id_categoria = c.id_categoria
        WHERE REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(
              LOWER(p.nombre_producto),'á','a'),'é','e'),'í','i'),'ó','o'),'ú','u') LIKE ? || '%'
    """;
        //Conexion con la base de datos
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String categoria = rs.getString("nombre_categoria");
                String nombreReal = rs.getString("nombre_producto");
                return new ProductoInfo(categoria, nombreReal);
            }

            //Captura de excepciones
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public void almacenarLista(){
        //TODO
    }
}
