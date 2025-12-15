package com.smarven.gestionem1


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ResumenScreen(db: AppDatabase) {
    var registros by remember { mutableStateOf<List<Registro>>(emptyList()) }


    LaunchedEffect(Unit) {
        registros = db.registroDao().obtenerTodos()
    }


    val horasSemana = TimeUtils.horasSemana(registros)
    val horasMes = TimeUtils.horasMes(registros)
    val salario = TimeUtils.salarioQuincenal(horasMes)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Resumen", style = MaterialTheme.typography.titleLarge)


        Card {
            Column(Modifier.padding(16.dp)) {
                Text("Horas semana: %.2f".format(horasSemana))
                Text("Horas mes: %.2f".format(horasMes))
                Spacer(Modifier.height(8.dp))
                Text("Pago quincenal estimado", style = MaterialTheme.typography.titleMedium)
                Text("$ %.2f MXN".format(salario), style = MaterialTheme.typography.titleLarge)
            }
        }


        HorasChart(horasSemana, horasMes)
    }
}