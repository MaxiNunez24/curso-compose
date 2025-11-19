package com.maxi.cfp401.cursoappsmoviles.feature_color_picker

import android.content.ClipData
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.runBlocking


@Preview
@Composable
fun ColorPickerScreen(viewModel: ColorViewModel = viewModel()){
    val red by viewModel.red
    val green by viewModel.green
    val blue by viewModel.blue

    val clipBoardManager = LocalClipboard.current

    fun copiarColor(color: String) = runBlocking {
        clipBoardManager.setClipEntry(
            ClipEntry(
                ClipData.newPlainText(
                    "color", color
                )
            )
        )
    }

    Column(Modifier.padding(16.dp)) {
        ColorSlider(
            value = red.toFloat(),
            onValueChange = { viewModel.setRed(it.toInt()) },
            listOf(Color.Black, Color.Red)
        )

        ColorSlider(
            value = green.toFloat(),
            onValueChange = { viewModel.setGreen(it.toInt()) },
            listOf(Color.Black, Color.Green)
        )

        ColorSlider(
            value = blue.toFloat(),
            onValueChange = { viewModel.setBlue(it.toInt()) },
            listOf(Color.Black, Color.Blue)
        )

        Box(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .clickable(
                    onClick = { copiarColor("rgb($red, $green, $blue)") }
                )
                .background(
                    Color( red, green, blue )
                ),
            contentAlignment = Alignment.Center,

            ) {
            Text(
                text = """
                    Toque para copiar el color: 
                    rgb($red, $green, $blue)
                """.trimIndent(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color =
                    if (red + green + blue > 382)
                        Color.Black
                    else Color.White,
                textAlign = TextAlign.Center
            )
        }

    }
}