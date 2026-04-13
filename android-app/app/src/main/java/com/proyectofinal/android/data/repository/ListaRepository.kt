package com.proyectofinal.android.data.repository

import com.proyectofinal.android.data.db.dao.ListaDao
import com.proyectofinal.android.data.db.entity.Lista
import com.proyectofinal.android.data.db.entity.ListaItem
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ListaRepository(private val listaDao: ListaDao) {

    val todasLasListas: Flow<List<Lista>> = listaDao.getAllListas()

    fun getItemsByLista(idLista: Int): Flow<List<ListaItem>> =
        listaDao.getItemsByLista(idLista)

    suspend fun guardarLista(nombre: String, items: List<ListaItem>): Long {
        val ahora = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        val lista = Lista(nombreLista = nombre, fechaCreacion = ahora)
        val newId = listaDao.insertLista(lista)
        val itemsConId = items.map { it.copy(idLista = newId.toInt()) }
        listaDao.insertItems(itemsConId)
        return newId
    }

    suspend fun eliminarLista(lista: Lista) {
        listaDao.deleteItemsByLista(lista.idLista)
        listaDao.deleteLista(lista)
    }
}
