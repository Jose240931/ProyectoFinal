package com.proyectofinal.android.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.proyectofinal.android.data.db.entity.Lista
import com.proyectofinal.android.data.db.entity.ListaItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ListaDao {
    @Query("SELECT * FROM lista ORDER BY fecha_creacion DESC")
    fun getAllListas(): Flow<List<Lista>>

    @Query("SELECT * FROM lista_item WHERE id_lista = :idLista ORDER BY nombre_categoria, nombre_item")
    fun getItemsByLista(idLista: Int): Flow<List<ListaItem>>

    @Query("SELECT * FROM lista_item WHERE id_lista = :idLista ORDER BY nombre_categoria, nombre_item")
    suspend fun getItemsByListaOnce(idLista: Int): List<ListaItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLista(lista: Lista): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<ListaItem>)

    @Delete
    suspend fun deleteLista(lista: Lista)

    @Query("DELETE FROM lista_item WHERE id_lista = :idLista")
    suspend fun deleteItemsByLista(idLista: Int)

    @Update
    suspend fun updateLista(lista: Lista)
}
