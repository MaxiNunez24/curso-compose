package com.maxi.cfp401.cursoappsmoviles.feature_ajedrez

import com.maxi.cfp401.cursoappsmoviles.R

data class NavPieza(val id: Int, val imagen: Int, val nombre: String)

val navPiezas: List<NavPieza> = buildList {
    repeat(4) {
        add(
            NavPieza(
                1,
                R.drawable.peon_blanco,
                "Peón"
            )
        )
        add(
            NavPieza(
                1,
                R.drawable.peon_negro,
                "Peón"
            )
        )
    }
    add(
        NavPieza(
            2,
            R.drawable.torre_negra,
            "Torre"
        )
    )
    add(
        NavPieza(
            3,
            R.drawable.caballo_blanco,
            "Caballo"
        )
    )
    add(
        NavPieza(
            4,
            R.drawable.alfil_negro,
            "Alfil"
        )
    )
    add(
        NavPieza(
            5,
            R.drawable.reina_nav,
            "Reina"
        )
    )
    add(
        NavPieza(
            6,
            R.drawable.rey_nav,
            "Rey"
        )
    )
    add(
        NavPieza(
            4,
            R.drawable.alfil_blanco,
            "Alfil"
        )
    )
    add(
        NavPieza(
            3,
            R.drawable.caballo_negro,
            "Caballo"
        )
    )
    add(
        NavPieza(
            2,
            R.drawable.torre_blanca,
            "Torre"
        )
    )
}