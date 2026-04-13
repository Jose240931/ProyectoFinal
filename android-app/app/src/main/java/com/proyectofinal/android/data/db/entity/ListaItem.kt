package com.proyectofinal.android.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "lista_item",
    foreignKeys = [ForeignKey(
        entity = Lista::class,
        parentColumns = ["id_lista"],
        childColumns = ["id_lista"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("id_lista")]
)
data class ListaItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_item") val idItem: Int = 0,
    @ColumnInfo(name = "id_lista") val idLista: Int,
    @ColumnInfo(name = "nombre_item") val nombreItem: String,
    @ColumnInfo(name = "nombre_categoria") val nombreCategoria: String
)
