package com.smarven.gestionem1


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.smarven.gestionem1.TimeUtils


@Composable
fun HistorialScreen(db: AppDatabase) {
    var registros by remember { mutableStateOf<List<Registro>>(emptyList()) }
    val hoy = java.time.LocalDate.now()


    LaunchedEffect(Unit) {
        registros = db.registroDao().obtenerTodos()
    }

    val horasHoy = TimeUtils.calcularHorasDelDia(registros, hoy)


    Column(modifier = Modifier.padding(16.dp)) {
        Text("Historial", style = MaterialTheme.typography.titleLarge)


        Spacer(modifier = Modifier.height(8.dp))


        Text(
            "Total trabajado hoy: %.2f horas".format(horasHoy),
            style = MaterialTheme.typography.titleMedium
        )


        Spacer(modifier = Modifier.height(12.dp))


        LazyColumn {
            items(registros) { r ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Empleado: ${r.empleado}")
                        Text("Tipo: ${r.tipo}")
                        Text("Fecha: ${r.fecha}")
                    }
                }
            }
        }
    }
}

