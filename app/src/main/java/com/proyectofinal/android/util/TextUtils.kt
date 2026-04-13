package com.proyectofinal.android.util

fun normalizarTexto(texto: String): String =
    texto.lowercase()
        .replace('á', 'a').replace('é', 'e')
        .replace('í', 'i').replace('ó', 'o')
        .replace('ú', 'u').replace('ü', 'u')
        .replace('ñ', 'n')
