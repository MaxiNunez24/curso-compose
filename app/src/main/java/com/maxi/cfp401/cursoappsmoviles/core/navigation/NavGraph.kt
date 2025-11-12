package com.maxi.cfp401.cursoappsmoviles.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maxi.cfp401.cursoappsmoviles.feature_ajedrez.AjedrezApp
import com.maxi.cfp401.cursoappsmoviles.feature_color_picker.ColorPickerApp
import com.maxi.cfp401.cursoappsmoviles.feature_ejercicios.ListadoPrueba

@Preview(showSystemUi = true)
@Composable
fun NavGraph(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Launcher.route
    ){
        composable(Screen.Launcher.route){
            LauncherScreen(navController)
        }
        composable(Screen.Ajedrez.route){
            AjedrezApp()
        }
        composable(Screen.ListadoPrueba.route){
            ListadoPrueba()
        }
        composable(Screen.ColorPicker.route){
            ColorPickerApp()
        }
    }
}