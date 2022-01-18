package com.lgior.katas

fun calculateTraits(candidate: String): Traits {
    val chars = candidate.toCharArray().distinct()
    return Traits( chars.associateWith { char -> candidate.count { char == it } })
}

@JvmInline
value class Traits(private val value: Map<Char, Int>) {
    operator fun get(char: Char): Int {
        return value[char] ?: 0
    }
    val size: Int
        get() = value.size
}