package com.maxi.cfp401.cursoappsmoviles

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/* Un flujo es un tipo de corrutina que puede emitir varios valores
    (del mismo tipo de dato) de manera secuencial, en lugar de las funciones
    de suspensión que pueden retornar un único valor.
 */

/* Un flujo conceptualmente es una transmisión de datos que
    se puede efectuar de forma asíncrona.
 */

/* Un flujo puede enviar de forma segura una solicitud de red para
    producir el siguiente valor sin bloquear el subproceso principal
    de la aplicación y evitar su bloqueo.
 */

data class Usuario(val nombre: String, val edad: Int)

fun retornarUsuario(): Flow<Usuario> = flow {
    val lista = listOf(
        Usuario("Juan", 21),
        Usuario("Pedro", 55),
        Usuario("Maria", 36)
    )
    for (usuario in lista) {
        delay(1000)
        emit(usuario)
    }
}

fun consultaBaseDeDatosUsuarios() = runBlocking {
    // collect() es una suspend fun, por lo que se debe llamar dentro de una corrutina (runBlocking en nuestro caso)
    retornarUsuario().collect { usuario -> println(usuario.nombre + " " + usuario.edad) }
    println("Fin de la consulta")
}

fun consultaBaseDeDatosUsuariosAsincrona() = runBlocking {
    // collect() es una suspend fun, por lo que se debe llamar dentro de una corrutina (runBlocking en nuestro caso)
    async { retornarUsuario().collect { usuario -> println(usuario.nombre + " " + usuario.edad) } }
    println("Fin de la consulta")
}

fun main() {

}


