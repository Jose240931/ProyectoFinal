package com.proyectofinal.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.proyectofinal.android.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onVerListasGuardadas: () -> Unit,
    viewModel: MainViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var showAbout by remember { mutableStateOf(false) }
    var showSaveDialog by remember { mutableStateOf(false) }
    var saveListName by remember { mutableStateOf("") }
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var showAddDialog by remember { mutableStateOf(false) }
    var selectedCategoria by remember { mutableStateOf("") }

    val snackbarHostState = remember { SnackbarHostState() }
    val selectedItem = selectedIndex?.let { uiState.listaOrdenada.getOrNull(it) }
    val selectedNoClasificado = selectedIndex?.let { esProductoNoClasificado(it, uiState.listaOrdenada) } == true

    LaunchedEffect(uiState.savedMessage) {
        uiState.savedMessage?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearSavedMessage()
        }
    }
    LaunchedEffect(uiState.listaOrdenada) {
        selectedIndex?.let { if (it >= uiState.listaOrdenada.size) selectedIndex = null }
    }
    LaunchedEffect(uiState.categoriasDisponibles) {
        if (selectedCategoria.isBlank() && uiState.categoriasDisponibles.isNotEmpty()) {
            selectedCategoria = uiState.categoriasDisponibles.first()
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("Lista Auto Ordenada") },
                actions = {
                    IconButton(onClick = { showSaveDialog = true }) {
                        Icon(Icons.Default.Save, contentDescription = "Guardar lista")
                    }
                    IconButton(onClick = onVerListasGuardadas) {
                        Icon(Icons.Default.List, contentDescription = "Listas guardadas")
                    }
                    IconButton(onClick = { showAbout = true }) {
                        Icon(Icons.Default.Info, contentDescription = "Acerca de")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = uiState.inputText,
                onValueChange = viewModel::onInputChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                placeholder = { Text("Introduzca su lista (un artículo por línea)") },
                maxLines = 10
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = viewModel::ordenar,
                    modifier = Modifier.weight(1f),
                    enabled = !uiState.isLoading
                ) {
                    if (uiState.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(18.dp),
                            strokeWidth = 2.dp,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    } else {
                        Text("Ordenar")
                    }
                }
                OutlinedButton(
                    onClick = viewModel::borrar,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Borrar")
                }
            }

            if (uiState.listaOrdenada.isNotEmpty()) {
                Text(
                    text = "Lista ordenada:",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    itemsIndexed(uiState.listaOrdenada) { index, item ->
                        val isHeader = item.startsWith("====") && item.endsWith("====")
                        val isSelected = selectedIndex == index
                        if (isHeader) {
                            Text(
                                text = item,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colorScheme.primaryContainer)
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        } else {
                            Text(
                                text = item,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        selectedIndex = if (isSelected) null else index
                                    }
                                    .background(
                                        if (isSelected) MaterialTheme.colorScheme.secondaryContainer
                                        else MaterialTheme.colorScheme.surface
                                    )
                                    .padding(horizontal = 8.dp, vertical = 6.dp),
                                style = MaterialTheme.typography.bodyMedium,
                                color = if (isSelected) MaterialTheme.colorScheme.onSecondaryContainer
                                        else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }

                Button(
                    onClick = {
                        selectedItem?.let {
                            viewModel.eliminarItem(it)
                            selectedIndex = null
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = selectedItem != null,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Text("Borrar seleccionado")
                }

                if (selectedNoClasificado) {
                    OutlinedButton(
                        onClick = {
                            showAddDialog = true
                        },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = uiState.categoriasDisponibles.isNotEmpty()
                    ) {
                        Text("Añadir producto a categoría")
                    }
                }
            }
        }
    }

    if (showAbout) {
        AlertDialog(
            onDismissRequest = { showAbout = false },
            title = { Text("Acerca de Lista Auto Ordenada") },
            text = { Text("Programa realizado por Jose Garrido Luna 2026 2ºDAM\n\nVersión Android desarrollada con Jetpack Compose y Room.") },
            confirmButton = {
                TextButton(onClick = { showAbout = false }) { Text("Aceptar") }
            }
        )
    }

    if (showSaveDialog) {
        AlertDialog(
            onDismissRequest = { showSaveDialog = false },
            title = { Text("Guardar lista") },
            text = {
                OutlinedTextField(
                    value = saveListName,
                    onValueChange = { saveListName = it },
                    label = { Text("Nombre de la lista") },
                    singleLine = true
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (saveListName.isNotBlank()) {
                            viewModel.guardarLista(saveListName)
                            saveListName = ""
                            showSaveDialog = false
                        }
                    }
                ) { Text("Guardar") }
            },
            dismissButton = {
                TextButton(onClick = {
                    saveListName = ""
                    showSaveDialog = false
                }) { Text("Cancelar") }
            }
        )
    }

    if (showAddDialog && selectedItem != null) {
        var expanded by remember { mutableStateOf(false) }

        AlertDialog(
            onDismissRequest = { showAddDialog = false },
            title = { Text("Añadir producto no clasificado") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Producto: $selectedItem")
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded }
                    ) {
                        OutlinedTextField(
                            value = selectedCategoria,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Categoría") },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth()
                        )
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            uiState.categoriasDisponibles.forEach { categoria ->
                                DropdownMenuItem(
                                    text = { Text(categoria) },
                                    onClick = {
                                        selectedCategoria = categoria
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (selectedCategoria.isNotBlank()) {
                            viewModel.anadirProductoNoClasificado(selectedItem, selectedCategoria)
                            selectedIndex = null
                            showAddDialog = false
                        }
                    },
                    enabled = selectedCategoria.isNotBlank()
                ) { Text("Guardar") }
            },
            dismissButton = {
                TextButton(onClick = { showAddDialog = false }) { Text("Cancelar") }
            }
        )
    }
}

private fun esProductoNoClasificado(index: Int, lista: List<String>): Boolean {
    if (index < 0 || index >= lista.size) return false
    if (lista[index].startsWith("====") && lista[index].endsWith("====")) return false

    for (i in index downTo 0) {
        val item = lista[i]
        if (item.startsWith("====") && item.endsWith("====")) {
            return item.equals("==== No clasificado ====", ignoreCase = true)
        }
    }
    return false
}
