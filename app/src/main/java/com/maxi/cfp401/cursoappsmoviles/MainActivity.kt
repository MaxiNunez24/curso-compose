package com.maxi.cfp401.cursoappsmoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Listado()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Previsualizacion(){
    Listado()
}

@Composable
fun Listado(){
    val scrollState = rememberScrollState()
    Column (
        Modifier.verticalScroll(scrollState).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
        Tarjeta()
    }
}

@Composable
fun Imagen(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "Icono de Android",
        modifier = Modifier.clip(CircleShape).background(Color.Green).size(60.dp)
    )
}

@Composable
fun Saludo(lugar: String){
    Column(
        Modifier.padding(6.dp)
    ) {
        Text("Hola Mundo desde $lugar!")
        Spacer(Modifier.height(6.dp))
        Text("¿Preparado?")
    }
}

@Composable
fun Tarjeta(){
    Row(
        Modifier.padding(6.dp)
    ){
        Imagen()
        Saludo("Compose")
    }
}