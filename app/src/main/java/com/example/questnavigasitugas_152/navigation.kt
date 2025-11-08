package com.example.questnavigasitugas_152

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_152.view.*

@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") { Welcome(navController) }
        composable("list") { Peserta(navController) }
        composable("form") { Formulir(navController) }
    }
}