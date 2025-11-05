package com.maxi.cfp401.cursoappsmoviles.ajedrez

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun NavBar(onPiezaClick: (Int) -> Unit, screenWidth: Dp) {
    val pieceWidth = screenWidth / 8
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
    ) {
        navPiezas.forEach { pieza ->
            PiezaNav(pieza, onPiezaClick, pieceWidth)
        }
    }
}

@Composable
fun PiezaNav(
    piezaNav: NavPieza,
    onPiezaClick: (Int) -> Unit = {},
    size: Dp
) {
    Image(
        painterResource(piezaNav.imagen),
        piezaNav.nombre,
        modifier = Modifier
            .width(size)
            .height(size)
            .clickable { onPiezaClick(piezaNav.id - 1) }
    )
}