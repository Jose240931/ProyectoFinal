package com.proyectofinal.android.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.proyectofinal.android.data.db.AppDatabase
import com.proyectofinal.android.data.db.entity.ListaItem
import com.proyectofinal.android.data.repository.ListaRepository
import com.proyectofinal.android.data.repository.ProductoRepository
import com.proyectofinal.android.util.normalizarTexto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class MainUiState(
    val inputText: String = "",
    val listaOrdenada: List<String> = emptyList(),
    val categoriasDisponibles: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val savedMessage: String? = null
)

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val productoRepository = ProductoRepository(db.productoDao(), db.categoriaDao())
    private val listaRepository = ListaRepository(db.listaDao())

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(
                    categoriasDisponibles = productoRepository.obtenerCategorias(),
                    errorMessage = null
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    errorMessage = "No se han podido cargar las categorías"
                )
            }
        }
    }

    fun onInputChanged(text: String) {
        _uiState.value = _uiState.value.copy(inputText = text)
    }

    fun ordenar() {
        val texto = _uiState.value.inputText
        if (texto.isBlank()) return

        _uiState.value = _uiState.value.copy(isLoading = true, listaOrdenada = emptyList())

        viewModelScope.launch {
            val lineas = texto.lines().filter { it.isNotBlank() }
            val porCategoria = sortedMapOf<String, MutableList<String>>()

            for (lineaOriginal in lineas) {
                val lineaTrimmed = lineaOriginal.trim()
                if (lineaTrimmed.isEmpty()) continue

                var query = normalizarTexto(lineaTrimmed)
                if (query.length > 3 && query.endsWith('s') && !query.endsWith("ss")) {
                    query = query.dropLast(1)
                }

                val info = productoRepository.obtenerCategoria(query)
                val categoria = info?.nombre_categoria ?: "No clasificado"
                val nombre = info?.nombre_producto ?: lineaTrimmed

                porCategoria.getOrPut(categoria) { mutableListOf() }.add(nombre)
            }

            val resultado = mutableListOf<String>()
            porCategoria.forEach { (cat, items) ->
                resultado.add("==== $cat ====")
                resultado.addAll(items)
            }

            _uiState.value = _uiState.value.copy(
                listaOrdenada = resultado,
                isLoading = false
            )
        }
    }

    fun borrar() {
        _uiState.value = _uiState.value.copy(inputText = "", listaOrdenada = emptyList())
    }

    fun eliminarItem(item: String) {
        val nuevaLista = _uiState.value.listaOrdenada.toMutableList()
        nuevaLista.remove(item)
        _uiState.value = _uiState.value.copy(listaOrdenada = nuevaLista)
    }

    fun guardarLista(nombre: String) {
        val items = _uiState.value.listaOrdenada
        if (items.isEmpty()) return

        viewModelScope.launch {
            var categoriaActual = "Sin categoría"
            val listaItems = mutableListOf<ListaItem>()

            items.forEach { linea ->
                if (linea.startsWith("====") && linea.endsWith("====")) {
                    categoriaActual = linea.removeSurrounding("==== ", " ====").trim()
                } else {
                    listaItems.add(
                        ListaItem(
                            idLista = 0,
                            nombreItem = linea,
                            nombreCategoria = categoriaActual
                        )
                    )
                }
            }

            listaRepository.guardarLista(nombre, listaItems)
            _uiState.value = _uiState.value.copy(savedMessage = "Lista \"$nombre\" guardada")
        }
    }

    fun clearSavedMessage() {
        _uiState.value = _uiState.value.copy(savedMessage = null)
    }

    fun anadirProductoACategoria(nombreProducto: String, nombreCategoria: String) {
        viewModelScope.launch {
            val guardado = productoRepository.guardarProductoEnCategoria(nombreProducto, nombreCategoria)
            _uiState.value = _uiState.value.copy(
                savedMessage = if (guardado) {
                    "Producto \"$nombreProducto\" añadido a \"$nombreCategoria\""
                } else {
                    "No se ha podido añadir el producto"
                }
            )
            if (guardado) ordenar()
        }
    }
}
