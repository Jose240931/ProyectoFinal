package com.proyectofinal.android.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.proyectofinal.android.data.db.entity.Producto

@Dao
interface ProductoDao {
    @Query("""
        SELECT p.nombre_producto, c.nombre_categoria
        FROM producto p
        JOIN categoria c ON p.id_categoria = c.id_categoria
        WHERE LOWER(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(
              p.nombre_producto,'á','a'),'é','e'),'í','i'),'ó','o'),'ú','u'))
              LIKE '%' || :query || '%'
    """)
    suspend fun buscarProductos(query: String): List<ProductoConCategoria>

    @Query("SELECT COUNT(*) FROM producto")
    suspend fun count(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(producto: Producto): Long

    @Query("""
        SELECT EXISTS(
            SELECT 1
            FROM producto
            WHERE LOWER(nombre_producto) = LOWER(:nombreProducto)
              AND id_categoria = :idCategoria
        )
    """)
    suspend fun existeProductoEnCategoria(nombreProducto: String, idCategoria: Int): Boolean

    @Query("""
        SELECT DISTINCT nombre_producto
        FROM producto
        WHERE LOWER(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(
              nombre_producto,'á','a'),'é','e'),'í','i'),'ó','o'),'ú','u'))
              LIKE '%' || :query || '%'
        ORDER BY
            CASE
                WHEN LOWER(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(
                     nombre_producto,'á','a'),'é','e'),'í','i'),'ó','o'),'ú','u'))
                     LIKE :query || '%'
                THEN 0
                ELSE 1
            END,
            LENGTH(nombre_producto),
            nombre_producto
        LIMIT :limit
    """)
    suspend fun sugerirProductos(query: String, limit: Int): List<String>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(productos: List<Producto>)
}

data class ProductoConCategoria(
    val nombre_producto: String,
    val nombre_categoria: String
)
