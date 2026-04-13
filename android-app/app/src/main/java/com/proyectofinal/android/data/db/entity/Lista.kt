package com.proyectofinal.android.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lista")
data class Lista(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_lista") val idLista: Int = 0,
    @ColumnInfo(name = "nombre_lista") val nombreLista: String,
    @ColumnInfo(name = "fecha_creacion") val fechaCreacion: String,
    @ColumnInfo(name = "fecha_modificacion") val fechaModificacion: String? = null
)
