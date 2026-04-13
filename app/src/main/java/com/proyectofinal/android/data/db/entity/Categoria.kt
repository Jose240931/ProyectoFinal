package com.proyectofinal.android.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categoria")
data class Categoria(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_categoria") val idCategoria: Int = 0,
    @ColumnInfo(name = "nombre_categoria") val nombreCategoria: String
)
