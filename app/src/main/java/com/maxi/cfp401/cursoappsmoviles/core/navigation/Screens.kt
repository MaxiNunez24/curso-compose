package com.maxi.cfp401.cursoappsmoviles.core.navigation

sealed class Screen(val route: String){

    data object Ajedrez: Screen("ajedrez_screen")
    data object ColoresRGB: Screen("colores_rgb_screen")
    data object ListadoPrueba: Screen("listado_prueba_screen")
    data object Launcher: Screen("launcher_screen")

}