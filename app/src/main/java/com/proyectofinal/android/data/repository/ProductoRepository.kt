package com.proyectofinal.android.data.repository

import com.proyectofinal.android.data.db.dao.ProductoDao
import com.proyectofinal.android.data.db.dao.ProductoConCategoria
import com.proyectofinal.android.data.db.dao.CategoriaDao
import com.proyectofinal.android.data.db.entity.Producto
import com.proyectofinal.android.util.normalizarTexto

class ProductoRepository(
    private val productoDao: ProductoDao,
    private val categoriaDao: CategoriaDao
) {

    /**
     * Finds the best matching category for a product name.
     * Mirrors the relevance-scoring logic from the original Java DBService.
     */
    suspend fun obtenerCategoria(nombreProducto: String): ProductoConCategoria? {
        val query = normalizarTexto(nombreProducto.trim())
        val candidatos = productoDao.buscarProductos(query)
        if (candidatos.isEmpty()) return null

        return candidatos.minByOrNull { candidato ->
            calcularRelevancia(normalizarTexto(candidato.nombre_producto), query)
        }
    }

    suspend fun obtenerCategorias(): List<String> = categoriaDao.getNombresCategorias()

    suspend fun guardarProductoEnCategoria(nombreProducto: String, nombreCategoria: String): Boolean {
        val nombreNormalizado = nombreProducto.trim()
        if (nombreNormalizado.isBlank()) return false

        val idCategoria = categoriaDao.getIdCategoriaPorNombre(nombreCategoria) ?: return false
        val yaExiste = productoDao.existeProductoEnCategoria(nombreNormalizado, idCategoria)
        if (yaExiste) return false

        // Room returns -1L from insert() when OnConflictStrategy.IGNORE hits a conflict.
        return productoDao.insert(
            Producto(
                nombreProducto = nombreNormalizado,
                idCategoria = idCategoria
            )
        ) != -1L
    }

    private fun calcularRelevancia(nombreNormalizado: String, queryNormalizado: String): Int {
        if (nombreNormalizado == queryNormalizado) return 0
        if (nombreNormalizado.startsWith(queryNormalizado)) {
            return 10 + (nombreNormalizado.length - queryNormalizado.length)
        }
        val pattern = Regex("\\b${Regex.escape(queryNormalizado)}\\b")
        if (pattern.containsMatchIn(nombreNormalizado)) return 20
        if (nombreNormalizado.contains(queryNormalizado)) return 30
        return 40 + levenshtein(nombreNormalizado, queryNormalizado)
    }

    private fun levenshtein(a: String, b: String): Int {
        val la = a.length; val lb = b.length
        val dp = Array(la + 1) { IntArray(lb + 1) }
        for (i in 0..la) dp[i][0] = i
        for (j in 0..lb) dp[0][j] = j
        for (i in 1..la) {
            for (j in 1..lb) {
                dp[i][j] = if (a[i - 1] == b[j - 1]) dp[i - 1][j - 1]
                else 1 + minOf(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1])
            }
        }
        return dp[la][lb]
    }
}
