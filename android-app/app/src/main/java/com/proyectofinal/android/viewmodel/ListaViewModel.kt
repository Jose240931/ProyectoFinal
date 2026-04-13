package com.proyectofinal.android.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.proyectofinal.android.data.db.AppDatabase
import com.proyectofinal.android.data.db.entity.Lista
import com.proyectofinal.android.data.db.entity.ListaItem
import com.proyectofinal.android.data.repository.ListaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class ListaDetailUiState(
    val lista: Lista? = null,
    val items: List<ListaItem> = emptyList()
)

class ListaViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val listaRepository = ListaRepository(db.listaDao())

    val todasLasListas: StateFlow<List<Lista>> = run {
        val flow = MutableStateFlow<List<Lista>>(emptyList())
        viewModelScope.launch {
            listaRepository.todasLasListas.collect { flow.value = it }
        }
        flow.asStateFlow()
    }

    private val _detailState = MutableStateFlow(ListaDetailUiState())
    val detailState: StateFlow<ListaDetailUiState> = _detailState.asStateFlow()

    fun cargarDetalleLista(lista: Lista) {
        viewModelScope.launch {
            listaRepository.getItemsByLista(lista.idLista).collect { items ->
                _detailState.value = ListaDetailUiState(lista = lista, items = items)
            }
        }
    }

    fun eliminarLista(lista: Lista) {
        viewModelScope.launch {
            listaRepository.eliminarLista(lista)
        }
    }
}
