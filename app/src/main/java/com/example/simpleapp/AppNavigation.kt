package com.example.simpleapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = "login",
        modifier = modifier
    ) {

        composable("login") {
            LoginScreen { login ->
                navController.navigate("welcome/$login")
            }
        }

        composable("welcome/{login}") { backStackEntry ->
            val login = backStackEntry.arguments?.getString("login") ?: ""
            WelcomeScreen(login)
        }
    }
}