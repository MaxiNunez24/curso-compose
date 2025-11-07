package com.maxi.cfp401.cursoappsmoviles.feature_ajedrez

import com.maxi.cfp401.cursoappsmoviles.R

val listadoPiezas = listOf<Pieza>(

    Pieza(
        "Peón",
        R.drawable.peon,
        "1",
        "El peón se mueve una casilla hacia adelante, con la opción de dos casillas en su primer movimiento, siempre que las casillas estén libres. Captura en diagonal una casilla adelante, pero no puede avanzar si tiene una pieza delante. Si llega a la última fila, se promociona a una pieza mayor (reina, torre, alfil o caballo).",
        mapOf(
            "Avanza: El peón avanza una casilla hacia adelante en cada jugada."
                    to R.drawable.peon_avance,
            "Primer movimiento: En su primer movimiento, puede optar por avanzar una o dos casillas, siempre que ambos casilleros estén desocupados."
                    to R.drawable.peon_primer_avance,
            "No retrocede: Un peón nunca puede moverse hacia atrás."
                    to R.drawable.peon_no_retrocede,
            "Movimiento y captura: A diferencia de otras piezas, el peón captura de forma diferente a cómo se mueve. Captura una pieza adversaria en la casilla diagonalmente frente a él, no en la casilla que avanza."
                    to R.drawable.peon_captura,
            "Bloqueo: No puede avanzar si tiene una pieza (propia o del oponente) directamente delante de él."
                    to R.drawable.peon_bloqueo,
            "Promoción: Si un peón alcanza la última fila del tablero, debe ser reemplazado por una reina, torre, alfil o caballo del mismo color. La reina es la promoción más común."
                    to R.drawable.peon_promocion
        ),
    ),
    Pieza(
        "Torre",
        R.drawable.torre,
        "5",
        "La torre se mueve en línea recta horizontal o vertical a través de cualquier número de casillas, siempre que no haya piezas en su camino. Es una pieza poderosa en el final del juego y se usa para controlar filas y columnas.",
        mapOf(
            "Dirección: Puede moverse hacia adelante, atrás o a los lados, en línea recta."
                    to R.drawable.torre_movimiento,
            "Distancia: Puede avanzar cualquier cantidad de casillas hasta que encuentre una pieza."
                    to R.drawable.torre_distancia,
            "Bloqueo: No puede saltar sobre otras piezas."
                    to R.drawable.torre_bloqueo,
            "Captura: Captura ocupando la casilla donde se encuentra la pieza adversaria.."
                    to R.drawable.torre_captura,
        ),
    ),
    Pieza(
        "Caballo",
        R.drawable.caballo,
        "3",
        "El caballo se mueve en forma de “L”: dos casillas en una dirección (horizontal o vertical) y luego una casilla perpendicular. Es la única pieza que puede saltar sobre otras piezas.",
        mapOf(
            "Patrón en L: Dos casillas en una dirección y una en perpendicular."
                    to R.drawable.caballo_patron,
            "Salto: Puede saltar sobre cualquier pieza, propia o del oponente."
                    to R.drawable.caballo_salto,
            "Captura: Captura ocupando la casilla de destino."
                    to R.drawable.caballo_captura,
            "Particularidad: Su movimiento alterna entre casillas claras y oscuras."
                    to R.drawable.caballo_particularidad,
        ),
    ),
    Pieza(
        "Alfil",
        R.drawable.alfil,
        "3",
        "El alfil se mueve en diagonal cualquier número de casillas, siempre sobre el mismo color de casillas. Cada jugador comienza con un alfil de casillas claras y uno de casillas oscuras.",
        mapOf(
            "Dirección: Solo en diagonal."
                    to R.drawable.alfil_direccion,
            "Distancia: Puede avanzar tantas casillas como estén libres en esa dirección."
                    to R.drawable.alfil_distancia,
            "Bloqueo: No puede saltar sobre otras piezas."
                    to R.drawable.alfil_bloqueo,
            "Captura: Captura en la misma dirección diagonal."
                    to R.drawable.alfil_captura,
        ),
    ),
    Pieza(
        "Dama (Reina)",
        R.drawable.reina,
        "9",
        "La dama combina el poder de la torre y el alfil, moviéndose en línea recta en cualquier dirección: vertical, horizontal o diagonal. Es la pieza más fuerte del tablero.",
        mapOf(
            "Dirección: Puede moverse en cualquier dirección (horizontal, vertical o diagonal)."
                    to R.drawable.dama_direccion,
            "Distancia: Puede recorrer cualquier número de casillas mientras estén libres."
                    to R.drawable.dama_distancia,
            "Bloqueo: No puede saltar sobre otras piezas."
                    to R.drawable.dama_bloqueo,
            "Captura: Captura ocupando la casilla de destino."
                    to R.drawable.dama_captura,
        ),
    ),
    Pieza(
        "Rey",
        R.drawable.rey,
        "∞",
        "El rey es la pieza más importante: si se lo amenaza y no puede escapar, la partida termina. Se mueve una casilla en cualquier dirección. Valor en material: Infinito (ya que su pérdida significa el fin del juego).",
        mapOf(
            "Distancia y dirección: Solo una casilla por jugada en cualquier dirección."
                    to R.drawable.rey_direccion,
            "Captura: Captura moviéndose a la casilla de la pieza enemiga."
                    to R.drawable.rey_captura,
            "Enroque: Movimiento especial junto con una torre, en el cual el rey se mueve dos casillas hacia la torre y esta salta al lado del rey. Solo puede hacerse si ninguna de las dos piezas se movió antes y no hay piezas entre ellas. (Enroque largo y corto)"
                    to R.drawable.rey_enroque,
        ),
    )
)