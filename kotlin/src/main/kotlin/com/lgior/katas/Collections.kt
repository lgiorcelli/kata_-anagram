import com.lgior.katas.calculateTraits
import com.lgior.katas.processGroup
import java.io.File
import kotlin.system.measureTimeMillis

private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/src/main/resources/words.txt"

fun usingCollections() {
    val timeMillis = measureTimeMillis {
        val wordsByLength = mutableMapOf<Int, List<ClassifiedWord>>()
        val wordsOfLengthFive = mutableListOf<ClassifiedWord>()
        val wordsOfLengthSix = mutableListOf<ClassifiedWord>()
        wordsByLength[5] = wordsOfLengthFive
        wordsByLength[6] = wordsOfLengthSix
        File(FILE).forEachLine {
            if (it.length == 5) {
                wordsOfLengthFive.add(ClassifiedWord(it, calculateTraits(it.toLowerCase())))
            }
            if (it.length == 6) {
                wordsOfLengthSix.add(ClassifiedWord(it, calculateTraits(it.toLowerCase())))
            }
        }
        wordsByLength[5]!!.processGroup()
        wordsByLength[6]!!.processGroup()
    }
    println("collections took = $timeMillis")
}


