package com.maxi.cfp401.cursoappsmoviles.feature_color_picker

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class ColorViewModel(): ViewModel(){

    private val _red = mutableIntStateOf(0)
    val red: State<Int> get() = _red

    private val _green = mutableIntStateOf(0)
    val green: State<Int> get() = _green

    private val _blue = mutableIntStateOf(0)
    val blue: State<Int> get() = _blue


    fun setRed(value: Int){_red.value = value}
    fun setGreen(value: Int){_green.value = value}
    fun setBlue(value: Int){_blue.value = value}
}