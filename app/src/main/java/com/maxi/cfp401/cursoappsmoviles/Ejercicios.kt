package com.maxi.cfp401.cursoappsmoviles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
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


@OptIn(ExperimentalLayoutApi::class)
//@Preview(showBackground = true)
@Composable
fun PrevisualizacionTablas() {
    FlowColumn {
        for (i in 1..10) {
            TablaDeMultiplicar(i)
        }
    }
}