import com.lgior.katas.calculateTraits
import com.lgior.katas.processGroup
import java.io.File
import kotlin.system.measureTimeMillis

//private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/five_chars_words.txt"
private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/src/main/resources/words.txt"

fun usingUngrupedCollections() {
    val timeMillis = measureTimeMillis {
        val words = mutableListOf<ClassifiedWord>()
        File(FILE).forEachLine {
                words.add(ClassifiedWord(it, calculateTraits(it.toLowerCase())))
        }
        words.processGroup()
    }
    println("collections took = $timeMillis")
}
/*
words = 338882
anagrams found = 30404
collections took = 28866
 */

