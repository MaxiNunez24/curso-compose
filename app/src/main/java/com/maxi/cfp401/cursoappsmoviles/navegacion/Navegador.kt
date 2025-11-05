package com.maxi.cfp401.cursoappsmoviles.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navegador(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        "launcher_screen"
    ){
        composable("launcher_screen"){
            LauncherScreen()
        }
    }
}