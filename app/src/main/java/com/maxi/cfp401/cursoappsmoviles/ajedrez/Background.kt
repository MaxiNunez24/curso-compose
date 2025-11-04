package com.maxi.cfp401.cursoappsmoviles.ajedrez

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.maxi.cfp401.cursoappsmoviles.R

@Composable
fun Background() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 130.dp)
            .clip(RectangleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(R.drawable.piezas_blancas), "Piezas de ajedrez de fondo",
            modifier = Modifier
                .rotate(90F)
                .scale(3f)
        )
    }
}