package com.maxi.cfp401.cursoappsmoviles.feature_ajedrez

data class Pieza(
    val nombre: String,
    val imagen: Int,
    val puntaje: String,
    val descripcion: String,
    val movimientos: Map<String, Int>,
)
