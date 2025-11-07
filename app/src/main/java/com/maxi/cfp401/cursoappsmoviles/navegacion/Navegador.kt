package com.maxi.cfp401.cursoappsmoviles.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maxi.cfp401.cursoappsmoviles.ajedrez.AjedrezApp

@Preview(showSystemUi = true)
@Composable
fun Navegador(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        "launcher_screen"
    ){
        composable("launcher_screen"){
            LauncherScreen(navController)
        }
        composable("ajedrez_app"){
            AjedrezApp(navController)
        }
    }
}