package com.maxi.cfp401.cursoappsmoviles.feature_ejercicios

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// @Preview(showBackground = true)
@Composable
fun PrevisualizacionMatriz() {
    MatrizIdentidad(7)
}

//@Preview(showBackground = true)
@Composable
fun PrevisualizacionTabla() {
    TablaDeMultiplicar(7)
}
@Composable
fun TablaDeMultiplicar(tabla: Int) {
    Column(
        Modifier.padding(16.dp)
    ) {
        for (i in 1..10) {
            Text("$tabla * $i = ${tabla * i}")
        }
    }
}

@Composable
fun MatrizIdentidad(size: Int) {
    Row {
        for (i in 1..size) {
            Column (Modifier.padding(3.dp)) {
                for (j in 1..size) {
                    Row {
                        if (i == j) {
                            Text("1")
                        } else {
                            Text("0")
                        }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun PrevisualizacionTablas() {
    FlowColumn {
        for (i in 1..10) {
            TablaDeMultiplicar(i)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ControlCantidad() {
    val cantidad = remember { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Decremento(cantidad)
            Text(
                "${cantidad.value}", fontSize = 35.sp, modifier = Modifier.padding(20.dp)
            )
            Incremento(cantidad)
        }
        Reset(cantidad)
    }
}

@Composable
fun Reset(cantidad: MutableState<Int>) {
    Button(
        onClick = { cantidad.value = 0 },
        colors = ButtonColors(
            Color.Black,
            Color.White,
            Color.Gray,
            Color.Black
        )) {
        Text("Resetear")
    }
}

@Composable
fun Decremento(cantidad: MutableState<Int>) {
    Button(
        onClick = { if (cantidad.value > 0) cantidad.value-- }, modifier = Modifier.padding(16.dp),
        colors = ButtonColors(
            Color.Red,
            Color.White,
            Color.Gray,
            Color.Red
        )
    ) {
        Text("—", fontSize = 20.sp)
    }
}

@Composable
fun Incremento(cantidad: MutableState<Int>) {
    Button(
        onClick = { cantidad.value++ }, modifier = Modifier.padding(16.dp),
        colors = ButtonColors(
            Color.Green,
            Color.White,
            Color.Gray,
            Color.Green
        )
    ) {
        Text("+", fontSize = 20.sp)
    }
}