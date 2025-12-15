package com.smarven.gestionem1


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun LoginScreen(navController: NavController) {
    var pin by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Ingreso de Empleado", style = MaterialTheme.typography.titleLarge)


        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = pin,
            onValueChange = { pin = it },
            label = { Text("PIN") },
            visualTransformation = PasswordVisualTransformation()
        )


        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = {
            if (pin == "1234") {
                navController.navigate("main") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }) {
            Text("Entrar")
        }
    }
}