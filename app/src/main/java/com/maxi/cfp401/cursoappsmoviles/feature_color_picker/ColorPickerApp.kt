package com.maxi.cfp401.cursoappsmoviles.feature_color_picker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Preview(showSystemUi = true)
@Composable
fun ColorPickerApp() {
    var redValue by remember { mutableFloatStateOf(0f) }
    var greenValue by remember { mutableFloatStateOf(0f) }
    var blueValue by remember { mutableFloatStateOf(0f) }

    Column(
        Modifier.padding(26.dp)
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
            Modifier.fillMaxSize()
                .padding(16.dp)
                .background(
                    Color(
                        redValue.toInt(),
                        greenValue.toInt(),
                        blueValue.toInt()
                    )
                )
        )
    }
}