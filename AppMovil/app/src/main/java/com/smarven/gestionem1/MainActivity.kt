package com.smarven.gestionem1


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import com.smarven.gestionem1.ui.theme.GestionEm1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            GestionEm1Theme {
                val navController = rememberNavController()
                val db = AppDatabase.getDatabase(this)


                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable("main") {
                        MainScreen(navController, db)
                    }
                    composable("historial") {
                        HistorialScreen(db)
                    }
                    composable("registro") {
                        RegistroEntradaSalidaScreen(db)
                    }
                    composable("resumen") {
                        ResumenScreen(db)
                    }
                }
            }
        }
    }
}