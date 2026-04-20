package com.proyectofinal.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.proyectofinal.android.ui.screens.MainScreen
import com.proyectofinal.android.ui.screens.ListasGuardadasScreen

sealed class Screen(val route: String) {
    object Main : Screen("main?listaId={listaId}") {
        const val baseRoute = "main"
        fun createRoute(listaId: Int? = null): String =
            listaId?.let { "main?listaId=$it" } ?: baseRoute
    }
    object ListasGuardadas : Screen("listas_guardadas")
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.baseRoute
    ) {
        composable(
            route = Screen.Main.route,
            arguments = listOf(
                navArgument("listaId") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) { backStackEntry ->
            val listaId = backStackEntry.arguments?.getInt("listaId")?.takeIf { it > 0 }
            MainScreen(
                onVerListasGuardadas = { navController.navigate(Screen.ListasGuardadas.route) },
                listaIdToLoad = listaId
            )
        }
        composable(Screen.ListasGuardadas.route) {
            ListasGuardadasScreen(
                onBack = { navController.popBackStack() },
                onCargarLista = { listaId ->
                    navController.navigate(Screen.Main.createRoute(listaId)) {
                        popUpTo(Screen.Main.baseRoute) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
