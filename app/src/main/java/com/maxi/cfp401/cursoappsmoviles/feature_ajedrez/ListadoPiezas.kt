package com.maxi.cfp401.cursoappsmoviles.feature_ajedrez

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ListadoPiezas(
    listadoPiezas: List<Pieza>,
    lazyListState: LazyListState = rememberLazyListState(),
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        state = lazyListState
    ) {
        items(listadoPiezas) { piezaActual ->
            TarjetaPieza(piezaActual)
        }
        item {
            DisclaimerChess()
        }
    }
}