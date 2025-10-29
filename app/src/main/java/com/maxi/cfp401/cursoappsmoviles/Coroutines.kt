package com.maxi.cfp401.cursoappsmoviles

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun problema2Cap49() {
    GlobalScope.launch {
        for (i in 1..10) {
            print("$i ")
            delay(1000)
        }
    }
    GlobalScope.launch {
        for (i in 11..20) {
            print("$i ")
            delay(1000)
        }
    }
    readln()
}

fun problemaPropuestoCap49() = runBlocking {
    val adivina = Random.nextInt(1, 100)

    GlobalScope.launch {
        var intento: Int
        var inicio = 1
        var fin = 100

        var gane = false
        do {
            intento = Random.nextInt(inicio, fin)

            if (intento == adivina) {
                println("Gané con el número $intento")
                gane = true
            } else {
                delay(500)
                if (intento < adivina) {
                    println("El número es mayor a $intento")
                    inicio = intento
                } else {
                    println("El número es menor a $intento")
                    fin = intento
                }
            }

        } while (!gane)
    }

    readln()
}

fun busquedaDicotomica() = runBlocking {
    val adivina = Random.nextInt(1, 100)

    GlobalScope.launch {
        var intento: Int
        var inicio = 1
        var fin = 100
        var medio: Int

        var gane = false
        do {
            medio = (inicio + fin) / 2

            if (medio == adivina) {
                println("Gané con el número $medio")
                gane = true
            } else {
                delay(500)
                if (medio < adivina) {
                    println("El número es mayor a $medio")
                    inicio = medio + 1
                } else {
                    println("El número es menor a $medio")
                    fin = medio - 1
                }
            }

        } while (!gane)
    }

    readln()
}

// Coroutinas mucho más livianas que Threads
fun experimentoVolumen() = runBlocking {
    // Probar lo mismo sin asincronía y con asincronía
    for (i in 1..100000) {
        launch {
            delay(Random.nextInt(1, 3) * 1000L)
            println(i)
        }
    }
}

fun esperarParaSeguir() = runBlocking {
    val corrutina1 = launch {
        delay(1000)
        println("Pasó un segundo")
    }

    // Esperar a que termine corrutina1
    corrutina1.join()

    val corrutina2 = launch {
        delay(1000)
        println("Pasó otro segundo")
    }

    // Esperar a que termine corrutina2
    corrutina2.join()
}

fun ejemploCoroutineScope() = runBlocking {

    // Es parecida a runBlocking, sólo que debe ser llamada desde una función suspend y no bloquea(sincrónico), sino que suspende

    suspend fun tareas(num: Int) = coroutineScope {
        launch {
            delay(1000)
            println("Tarea $num parte A")
        }

        launch {
            delay(1000)
            println("Tarea $num parte B")
        }

        println("Esperando a que terminen las dos tareas $num")
    }

    tareas(1)
    tareas(2)

    println("Fin de las tareas")
}

// Ejemplo secuencial
fun ejemploSuspend() = runBlocking {

    // Las funciones con suspend sólo pueden ser llamadas desde otras funciones con suspend o corrutinas
    // Por defecto se ejecutan en forma secuencial dentro de una corrutina
    suspend fun dato1(): Int {
        delay(3000)
        return 3
    }

    suspend fun dato2(): Int {
        delay(3000)
        return 3
    }

    val d1 = dato1()
    println("Fin de la primera función de suspensión (3seg)")
    val d2 = dato2()
    println("Fin de la segundo función de suspensión (3seg)")
    println("${d1 + d2} segundos")
}

// Ejemplo concurrente
fun ejemploParalelo() = runBlocking {
    // Paralelo es concurrente pero con ayuda del hardware (un proceso para cada núcleo)
    val tiempo1 = System.currentTimeMillis()

    suspend fun dato1(): Int{
        delay(3000)
        return 3
    }

    suspend fun dato2(): Int{
        delay(3000)
        return 3
    }

    val corrutina1 = async { dato1() }
    val corrutina2 = async { dato2() }

    println(corrutina1.await() + corrutina2.await())

    val tiempo2 = System.currentTimeMillis()

    println("Tiempo total: ${tiempo2-tiempo1} milisegundos")
}

fun main() {

}
