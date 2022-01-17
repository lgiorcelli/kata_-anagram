import com.lgior.katas.calculateTraits
import java.io.File
import kotlin.system.measureTimeMillis

//private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/five_chars_words.txt"
private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/src/main/resources/words.txt"

fun main(args: Array<String>) {
    val timeMillis = measureTimeMillis {

        val words = mutableListOf<ClassifiedWord>()
        File(FILE).useLines {
            it.filter { preprocessed -> preprocessed.length == 5 }.forEach { word ->
                words.add(ClassifiedWord(word, calculateTraits(word.toLowerCase())))
            }
        }
        val grouped = words.groupBy { it.traits }
        println("words = ${words.size}")
        println("keys = ${grouped.entries.filter { it.value.size > 1 }.size}")
//    println("values = ${grouped.values.size}")

        //grouped.entries.filter { entry -> entry.value.size > 1 }
        //.sortedByDescending { it.value.size }
        //.map { it.value }
        //.forEach { entry -> println("size: ${entry.size} - values: ${entry.map { value -> value.word }}") }
    }
    println("timeMillis = ${timeMillis}")
}

