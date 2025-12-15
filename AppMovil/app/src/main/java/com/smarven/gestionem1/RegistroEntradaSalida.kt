package com.smarven.gestionem1


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import java.time.LocalDateTime


@Composable
fun RegistroEntradaSalidaScreen(db: AppDatabase) {
    val scope = rememberCoroutineScope()
    var mensaje by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Registrar Asistencia", style = MaterialTheme.typography.titleLarge)


        Button(onClick = {
            scope.launch {
                db.registroDao().insertar(
                    Registro(
                        empleado = "Empleado",
                        tipo = "ENTRADA",
                        fecha = LocalDateTime.now().toString()
                    )
                )
                mensaje = "Entrada registrada"
            }
        }) {
            Text("Registrar ENTRADA")
        }


        Button(onClick = {
            scope.launch {
                db.registroDao().insertar(
                    Registro(
                        empleado = "Empleado",
                        tipo = "SALIDA",
                        fecha = LocalDateTime.now().toString()
                    )
                )
                mensaje = "Salida registrada"
            }
        }) {
            Text("Registrar SALIDA")
        }


        if (mensaje.isNotEmpty()) {
            Text(mensaje, color = MaterialTheme.colorScheme.primary)
        }
    }
}