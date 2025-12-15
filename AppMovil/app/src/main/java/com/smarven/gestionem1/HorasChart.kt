package com.smarven.gestionem1

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size

@Composable
fun HorasChart(horasSemana: Double, horasMes: Double) {

    val maxHoras = maxOf(horasSemana, horasMes, 1.0)

    Column {
        Text("Gráfica de Horas", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {

            val anchoBarra = size.width / 4f

            // Barra Semana
            val alturaSemana =
                (size.height * (horasSemana / maxHoras).toFloat())

            drawRect(
                color = Color(0xFF4CAF50),
                topLeft = Offset(
                    x = anchoBarra,
                    y = size.height - alturaSemana
                ),
                size = Size(
                    width = anchoBarra,
                    height = alturaSemana
                )
            )

            // Barra Mes
            val alturaMes =
                (size.height * (horasMes / maxHoras).toFloat())

            drawRect(
                color = Color(0xFF2196F3),
                topLeft = Offset(
                    x = anchoBarra * 2.5f,
                    y = size.height - alturaMes
                ),
                size = Size(
                    width = anchoBarra,
                    height = alturaMes
                )
            )
        }

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Semana", color = Color(0xFF4CAF50))
            Text("Mes", color = Color(0xFF2196F3))
        }
    }
}
