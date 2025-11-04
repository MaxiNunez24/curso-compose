package com.maxi.cfp401.cursoappsmoviles.ajedrez

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TarjetaPieza(pieza: Pieza) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Column(
            modifier = Modifier
                .drawBehind {
                    drawRoundRect(
                        Color.White,
                        cornerRadius = CornerRadius(10.dp.toPx()),
                    )
                }
                .border(3.dp, Color.Black, RectangleShape),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .border(1.dp, Color.Black, RectangleShape),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = pieza.nombre,
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )

                Image(
                    painterResource(pieza.imagen), pieza.nombre, modifier = Modifier.padding(10.dp)
                )
            }
            Text(
                "Valor en material: ${pieza.puntaje}",
                modifier = Modifier.padding(bottom = 8.dp, top = 4.dp)
            )
        }
        Text(
            text = pieza.descripcion,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 16.dp)
                .drawBehind {
                    drawRoundRect(
                        Color.White,
                        cornerRadius = CornerRadius(10.dp.toPx()),
                    )
                }
                .padding(16.dp)
        )
        Column(
            Modifier
                .padding(start = 20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Movimientos",
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
                    .drawBehind {
                        drawRoundRect(Color.White, cornerRadius = CornerRadius(10f))
                    }
                    .border(1.dp, Color.Black, RectangleShape)
                    .padding(8.dp)
            )
            Image(painterResource(pieza.movimientos), "Movimientos de ${pieza.nombre}")
        }
    }
    Spacer(Modifier.height(24.dp))
}
