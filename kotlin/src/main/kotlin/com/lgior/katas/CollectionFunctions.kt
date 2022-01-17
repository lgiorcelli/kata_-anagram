package com.lgior.katas

import ClassifiedWord

class CollectionFunctions {
}

fun Set<Map.Entry<Map<Char, Int>, List<ClassifiedWord>>>.prettyPrint(): Unit {
    this
        .filter { entry -> entry.value.size > 1 }
        .sortedByDescending { it.value.size }
        .map { it.value }
        .toList()
        .forEach { entry -> println("size: ${entry.size} - values: ${entry.map { value -> value.word }}") }
}

fun Map<Map<Char, Int>, List<ClassifiedWord>>.countAnagrams() =
    entries.filter { it.value.size > 1 }.size