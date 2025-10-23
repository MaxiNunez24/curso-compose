package com.maxi.cfp401.cursoappsmoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxi.cfp401.cursoappsmoviles.ui.theme.CursoAppsMovilesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoAppsMovilesTheme {
                Listado()
            }
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun PrevisualizacionDark() {
    CursoAppsMovilesTheme(
        darkTheme = true
    ) {
        Surface{
            Listado()
        }
    }
}

// @Preview(showSystemUi = false)
@Composable
fun Previsualizacion() {
    CursoAppsMovilesTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ){
            Tarjeta()
        }
    }
}

@Composable
fun Listado() {

    val scrollState = rememberScrollState()

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for(i in 1..20)Tarjeta()
    }
}

@Composable
fun Tarjeta() {

    val contador = remember { mutableStateOf(0) }

    Row(
        Modifier.padding(8.dp)
    ) {
        Imagen()
        Spacer(Modifier.width(6.dp))
        Saludo("Compose")
        Boton()
    }
}

@Composable
fun Imagen() {
    Image(
        painterResource(R.drawable.wolf),
        "Un lobo aullando a la luna llena",
        Modifier
            .size(45.dp)
            .clip(CircleShape)
            .border(
                2.dp,
                MaterialTheme.colorScheme.outline,
                CircleShape
            )
    )
}

@Composable
fun Saludo(lugar: String) {
    Column {
        Text("Hola Mundo desde $lugar!", color = MaterialTheme.colorScheme.primary, fontFamily = FontFamily(Font(R.font.starkwalker_classic)))
        Spacer(Modifier.height(3.dp))
        Text("¿Preparado?", color = MaterialTheme.colorScheme.primary, fontFamily = FontFamily(Font(R.font.starkwalker_classic)))
    }
}

@Composable
fun Boton(){
    val contador = remember{ mutableStateOf(0) }
    Button(
        onClick = {contador.value++},
        colors = ButtonColors(Color.Black, Color.White, Color.Gray, Color.Black),
        enabled = true

    ) {
        Text("Clicks ${contador.value}")
    }
}


// @Preview(showBackground = true)
@Composable
private fun HelloContent() {
    var valor by    remember{ mutableStateOf("")}
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello!",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        OutlinedTextField(
            value =  valor,
            onValueChange = { valor = it},
            label = { Text("Name") }
        )
    }
}