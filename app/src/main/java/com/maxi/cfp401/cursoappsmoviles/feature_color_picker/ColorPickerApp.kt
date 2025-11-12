package com.maxi.cfp401.cursoappsmoviles.feature_color_picker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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


@Composable
fun ColorSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    colors: List<Color>
) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                Brush.linearGradient(
                    colors = colors
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = Color.White,
                activeTrackColor = Color.Transparent,
                inactiveTrackColor = Color.Transparent,
                activeTickColor = Color.Gray,
                inactiveTickColor = Color.Transparent
            )
        )
        Text(value.toInt().toString(), color = Color.White)
    }
}