package com.lgior.katas

fun calculateTraits(candidate: String): Map<Char, Int> {
    val chars = candidate.toCharArray().distinct()
    return chars.associateWith { char -> candidate.count { char == it } }
}

