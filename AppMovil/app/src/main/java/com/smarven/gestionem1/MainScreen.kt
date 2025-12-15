package com.smarven.gestionem1


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun MainScreen(navController: NavController, db: AppDatabase) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Panel del Empleado", style = MaterialTheme.typography.headlineMedium)


        Button(onClick = { navController.navigate("registro") }, modifier = Modifier.fillMaxWidth()) {
            Text("Registrar Entrada / Salida")
        }


        Button(onClick = { navController.navigate("historial") }, modifier = Modifier.fillMaxWidth()) {
            Text("Historial")
        }


        Button(onClick = { navController.navigate("resumen") }, modifier = Modifier.fillMaxWidth()) {
            Text("Resumen y Nómina")
        }
    }
}