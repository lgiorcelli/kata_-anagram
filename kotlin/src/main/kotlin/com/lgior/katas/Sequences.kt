import com.lgior.katas.calculateTraits
import com.lgior.katas.countAnagrams
import com.lgior.katas.prettyPrint
import java.io.File
import kotlin.system.measureTimeMillis

//private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/five_chars_words.txt"
private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/src/main/resources/words.txt"

fun usingSequences() {
    val timeMillis = measureTimeMillis {
        val words = mutableListOf<ClassifiedWord>()
        File(FILE).useLines {
            sequence -> val groupedByLength = sequence
            .groupBy { it.length }[5]!!
            .forEach {
                words.add(ClassifiedWord(it, calculateTraits(it.toLowerCase())))
            }

        }
        val grouped = words.groupBy { it.traits }
        println("words = ${words.size}")
        println("anagrams found = ${grouped.countAnagrams()}")

        //grouped.entries.prettyPrint()
    }
    println("sequences took = $timeMillis")
}

