package com.proyectofinal.android.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "producto",
    foreignKeys = [ForeignKey(
        entity = Categoria::class,
        parentColumns = ["id_categoria"],
        childColumns = ["id_categoria"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("id_categoria")]
)
data class Producto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_producto") val idProducto: Int = 0,
    @ColumnInfo(name = "nombre_producto") val nombreProducto: String,
    @ColumnInfo(name = "descripcion") val descripcion: String? = null,
    @ColumnInfo(name = "id_categoria") val idCategoria: Int
)
