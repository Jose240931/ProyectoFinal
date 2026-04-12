package org.main.services;

import org.main.model.ProductoInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    //Path para que encuentre la base de datos una vez empaquetado el programa
    private static final String URL = "jdbc:sqlite:" +
            java.nio.file.Paths.get(System.getProperty("user.dir"), "info.db").toString();

    private Connection getConexion() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró org.sqlite.JDBC en el runtime (sqlite-jdbc no está incluido).", e);
        }
        return DriverManager.getConnection(URL);
    }
    public ProductoInfo obtenerCategoria(String producto) {

        // Normaliza el texto de búsqueda (sin tildes, minúsculas, sin espacios extra)
        String query = normalizar(producto.trim());

        // Recoge todos los productos que contengan el texto de búsqueda
        // Se usa '%' || ? || '%' en lugar de ? || '%' para no perderse palabras que coincidan teniendo otra delante
        String sql = """
            SELECT c.nombre_categoria, p.nombre_producto
            FROM producto p
            JOIN categoria c ON p.id_categoria = c.id_categoria
            WHERE REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(
                  LOWER(p.nombre_producto),'á','a'),'é','e'),'í','i'),'ó','o'),'ú','u')
                  LIKE '%' || ? || '%'
        """;

        List<ProductoInfo> candidatos = new ArrayList<>();

        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String categoria   = rs.getString("nombre_categoria");
                String nombreReal  = rs.getString("nombre_producto");
                candidatos.add(new ProductoInfo(categoria, nombreReal));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (candidatos.isEmpty()) {
            return null;
        }

        // Ordena los candidatos por relevancia y devuelve el mejor
        return candidatos.stream()
                .min((a, b) -> calcularRelevancia(normalizar(a.getNombreReal()), query)
                             - calcularRelevancia(normalizar(b.getNombreReal()), query))
                .orElse(null);
    }

    /**
     * Calcula la relevancia de un nombre de producto respecto a la búsqueda.
     * Puntuación más baja = mejor coincidencia.
     *
     * Ejemplos con búsqueda "pollo":
     *   "pollo"          → 0   (exacta)
     *   "pollo asado"    → 15  (empieza por query, 6 chars extra)
     *   "pollo teriyaki" → 18  (empieza por query, 9 chars extra)
     *   "carne de pollo" → 20  (contiene como palabra completa)
     */
    private int calcularRelevancia(String nombreNormalizado, String queryNormalizado) {

        //Coincidencia exacta
        if (nombreNormalizado.equals(queryNormalizado)) {
            return 0;
        }

        //Empieza por el query exactamente (el nombre solo añade chars al final)
        if (nombreNormalizado.startsWith(queryNormalizado)) {
            // Penaliza proporcionalmente a cuánto "sobra" en el nombre
            return 10 + (nombreNormalizado.length() - queryNormalizado.length());
        }

        // 3. El query aparece como palabra completa dentro del nombre
        // Ej: "carne de pollo" contiene "pollo" como palabra
        if (nombreNormalizado.matches(".*\\b" + escapeRegex(queryNormalizado) + "\\b.*")) {
            return 20;
        }

        // 4. El query aparece en cualquier posición (substring)
        if (nombreNormalizado.contains(queryNormalizado)) {
            return 30;
        }

        // 5. Fallback: distancia de Levenshtein para errores tipográficos leves
        return 40 + levenshtein(nombreNormalizado, queryNormalizado);
    }

    /**
     * Elimina tildes y pasa a minúsculas para comparar sin problemas de acentuación.
     */
    private String normalizar(String texto) {
        if (texto == null) return "";
        return texto
                .toLowerCase()
                .replace("á", "a").replace("é", "e")
                .replace("í", "i").replace("ó", "o")
                .replace("ú", "u").replace("ü", "u")
                .replace("ñ", "n");
    }

    /**
     * Escapa caracteres especiales de regex para usarlos literalmente en matches().
     */
    private String escapeRegex(String texto) {
        return texto.replaceAll("([\\\\\\[\\]{}()*+?.^$|])", "\\\\$1");
    }

    /**
     * Distancia de Levenshtein: mide cuántas ediciones (inserción, borrado,
     * sustitución) separan dos cadenas. Útil para tolerar errores tipográficos.
     */
    private int levenshtein(String a, String b) {
        int la = a.length(), lb = b.length();
        int[][] dp = new int[la + 1][lb + 1];

        for (int i = 0; i <= la; i++) dp[i][0] = i;
        for (int j = 0; j <= lb; j++) dp[0][j] = j;

        for (int i = 1; i <= la; i++) {
            for (int j = 1; j <= lb; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                                   Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[la][lb];
    }
}
