package com.lgior.katas

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.random.Random

private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/five_chars_words.txt"
class ParallelExecutionTest {

    @Test
    fun playground() = runBlocking {
        File(FILE).useLines { sequence ->
            val flow = sequence
                .groupBy { it.length }.also { println("group by = ${System.currentTimeMillis()}") }
                .map { it.value }
                .asFlow()
            flow.collect {
                launch {
                    process(it.first())
                }
            }
        }

    }

    private suspend fun process(string: String) {
        delay(Random.nextLong(from = 0L, until = 200L))
        println(Thread.currentThread().name)
        println("string = $string")
    }
}