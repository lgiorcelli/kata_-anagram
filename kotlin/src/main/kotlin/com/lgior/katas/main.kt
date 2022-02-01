package com.lgior.katas

import kotlinx.coroutines.runBlocking
import usingSequences
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val timeMillis = measureTimeMillis {
        usingSequences()
    }
    println("sequences took = $timeMillis")
    //usingCollections()
}