package com.proyectofinal.android.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.proyectofinal.android.data.db.entity.Categoria
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriaDao {
    @Query("SELECT * FROM categoria ORDER BY nombre_categoria ASC")
    fun getAllCategorias(): Flow<List<Categoria>>

    @Query("SELECT nombre_categoria FROM categoria ORDER BY nombre_categoria ASC")
    suspend fun getNombresCategorias(): List<String>

    @Query("SELECT id_categoria FROM categoria WHERE nombre_categoria = :nombreCategoria LIMIT 1")
    suspend fun getIdCategoriaPorNombre(nombreCategoria: String): Int?

    @Query("SELECT COUNT(*) FROM categoria")
    suspend fun count(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(categorias: List<Categoria>)
}
