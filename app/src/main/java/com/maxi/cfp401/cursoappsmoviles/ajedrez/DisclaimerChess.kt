package com.maxi.cfp401.cursoappsmoviles.ajedrez

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun DisclaimerChess() {
    val context = LocalContext.current
    val url = "https://www.chess.com/es"

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(bottom = 24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFf3f3f3))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¿Querés seguir aprendiendo o jugar en línea?",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Podés practicar tus aperturas, resolver ejercicios o jugar con personas de todo el mundo en ",
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Chess.com ♟️",
                color = Color(0xFF1A73E8),
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                    }
                    .padding(top = 4.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Esta aplicación es solo de carácter informativo y educativo sobre las piezas de ajedrez.",
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}