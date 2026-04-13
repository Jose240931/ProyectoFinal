package com.proyectofinal.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.proyectofinal.android.ui.screens.MainScreen
import com.proyectofinal.android.ui.screens.ListasGuardadasScreen

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object ListasGuardadas : Screen("listas_guardadas")
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(Screen.Main.route) {
            MainScreen(
                onVerListasGuardadas = { navController.navigate(Screen.ListasGuardadas.route) }
            )
        }
        composable(Screen.ListasGuardadas.route) {
            ListasGuardadasScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
