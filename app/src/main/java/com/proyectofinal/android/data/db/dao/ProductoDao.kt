package com.proyectofinal.android.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.proyectofinal.android.data.db.entity.Producto
import kotlinx.coroutines.flow.Flow

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
    suspend fun insertAll(productos: List<Producto>)
}

data class ProductoConCategoria(
    val nombre_producto: String,
    val nombre_categoria: String
)
