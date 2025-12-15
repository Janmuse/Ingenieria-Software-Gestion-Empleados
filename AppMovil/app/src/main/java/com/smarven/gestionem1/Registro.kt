package com.smarven.gestionem1


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "registros")
data class Registro(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val empleado: String,
    val tipo: String,
    val fecha: String
)