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

fun Map<Traits, List<ClassifiedWord>>.countAnagrams() =
    entries.filter { it.value.size > 1 }.size

suspend fun List<ClassifiedWord>.processGroup() {
    //println("hola")
    //val start = System.currentTimeMillis()
    val grouped = groupBy { it.traits }
        .also { println("process one group of ${this.size}= ${System.currentTimeMillis()}") }
    //println("words = $size")
    println("thread 2: ${Thread.currentThread().name}")
    println("anagrams found = ${grouped.countAnagrams()}")
    //grouped.entries.prettyPrint()
}
