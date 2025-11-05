package com.maxi.cfp401.cursoappsmoviles.ajedrez

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxi.cfp401.cursoappsmoviles.DisclaimerChess
import kotlinx.coroutines.launch

@Preview(showSystemUi = true)
@Composable
fun AjedrezApp() {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val onPiezaClick: (Int) -> Unit = { piezaIndex ->
        coroutineScope.launch {
            lazyListState.animateScrollToItem(piezaIndex)
        }
    }
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Box(
        Modifier.fillMaxSize()
    ) {
        Background()
        Column {
            Header()
            NavBar(
                onPiezaClick,
                screenWidth
            )
            ListadoPiezas(
                listadoPiezas,
                lazyListState
            )
        }
    }
}
