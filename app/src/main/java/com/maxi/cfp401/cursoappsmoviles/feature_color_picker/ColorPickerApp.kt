package com.maxi.cfp401.cursoappsmoviles.feature_color_picker

import android.content.ClipData
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.runBlocking
import kotlin.math.roundToInt

@Preview(showSystemUi = true)
@Composable
fun ColorPickerApp() {
    var redValue by remember { mutableFloatStateOf(0f) }
    var greenValue by remember { mutableFloatStateOf(0f) }
    var blueValue by remember { mutableFloatStateOf(0f) }

    val clipBoardManager = LocalClipboard.current

    val context = LocalContext.current

    fun copiarColor(color: String) = runBlocking {
        clipBoardManager.setClipEntry(
            ClipEntry(
                ClipData.newPlainText(
                    "color", color
                )
            )
        )
    }


    Column(
        Modifier.padding(26.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ColorSlider(
            redValue,
            { value -> redValue = value.roundToInt().toFloat() },
            listOf(Color.Black, Color.Red)
        )

        ColorSlider(
            greenValue,
            { value -> greenValue = value.roundToInt().toFloat() },
            listOf(Color.Black, Color.Green)
        )

        ColorSlider(
            blueValue,
            { value -> blueValue = value.roundToInt().toFloat() },
            listOf(Color.Black, Color.Blue)
        )

        Box(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .clickable(
                    onClick = {
                        copiarColor("rgb(${redValue.toInt()}, ${greenValue.toInt()}, ${blueValue.toInt()})")
                        Toast.makeText(context, "Copiado al portapapeles", Toast.LENGTH_SHORT).show()
                    }
                )
                .background(
                    Color(
                        redValue.toInt(),
                        greenValue.toInt(),
                        blueValue.toInt()
                    )
                ),
            contentAlignment = Alignment.Center,

            ) {
            Text(
                text = """
                    Toque para copiar el color: 
                    rgb(${redValue.toInt()}, ${greenValue.toInt()}, ${blueValue.toInt()})
                """.trimIndent(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color =
                    if (redValue.toInt() + greenValue.toInt() + blueValue.toInt() > 382)
                        Color.Black
                    else Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}