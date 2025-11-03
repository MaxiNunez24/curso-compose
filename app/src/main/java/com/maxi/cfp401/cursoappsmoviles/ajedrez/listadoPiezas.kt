package com.maxi.cfp401.cursoappsmoviles.ajedrez

import com.maxi.cfp401.cursoappsmoviles.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

fun cargarPiezas(): Flow<Pieza> = flow {
    val pieza =
        Pieza(
            nombre = "Peón",
            imagen = R.drawable.peon,
            puntaje = 1,
            movimientos = R.drawable.movimientos_peon,
            descripcion =  """
            ○ El peón es la pieza de ajedrez más sencilla, su valor en material es 1 punto. 
            ○ Se mueve únicamente una casilla hacia adelante a la vez, a excepción del primer movimiento donde puede moverse dos casillas. 
            ○ No puede retroceder. 
            ○ Come en diagonal.
            ○ Si tiene una pieza adelante no puede avanzar.
        """.trimIndent()
        )

    (1..30).forEach {
        emit(pieza)
    }
}

val listadoPiezas = runBlocking{ cargarPiezas().toList() }
