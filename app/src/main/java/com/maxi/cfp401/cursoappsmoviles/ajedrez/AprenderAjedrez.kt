package com.maxi.cfp401.cursoappsmoviles.ajedrez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.maxi.cfp401.cursoappsmoviles.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxi.cfp401.cursoappsmoviles.ajedrez.ui.theme.CursoAppsMovilesTheme

class AprenderAjedrez : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AjedrezApp()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Previsualizacion() {
    AjedrezApp()
}

@Composable
fun AjedrezApp() {
    Box() {
        Image(
            painterResource(R.drawable.piezas_blancas), "Piezas de ajedrez de fondo",
            modifier = Modifier
                .fillMaxSize()
                .rotate(90F)
                .scale(2.4f),
            contentScale = ContentScale.Fit
        )
        Scaffold(
            containerColor = Color.Transparent
        ) {
            ListadoPiezas(listadoPiezas)

        }
    }
}

@Composable
fun Header() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painterResource(R.drawable.banner),
            "Tablero de Ajedrez",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            "Piezas de Ajedrez",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            modifier = Modifier
                .padding(top = 55.dp)
                .drawBehind() {
                    drawRoundRect(
                        Color.Black,
                        cornerRadius = CornerRadius(10.dp.toPx()),
                    )
                }
                .padding(16.dp)
        )
    }
}

@Composable
fun ListadoPiezas(listadoPiezas: List<Pieza>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
    ) {
        item { Header() }
        items(listadoPiezas) { piezaActual ->
            TarjetaPieza(piezaActual)
        }
    }
}

@Composable
fun TarjetaPieza(pieza: Pieza) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .padding(2.dp)
                .drawBehind{
                    drawRoundRect(
                        Color.White,
                        cornerRadius = CornerRadius(10.dp.toPx()),
                    )
                },
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
            text = pieza.descripcion,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )
        Column(
            Modifier.padding(start = 20.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Movimientos",
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Image(painterResource(pieza.movimientos), "Movimientos de ${pieza.nombre}")
        }
    }
}







