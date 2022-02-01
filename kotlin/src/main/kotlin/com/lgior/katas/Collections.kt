import com.lgior.katas.calculateTraits
import com.lgior.katas.processGroup
import kotlinx.coroutines.runBlocking
import java.io.File
import kotlin.system.measureTimeMillis

private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/src/main/resources/words.txt"

fun usingCollections() {
    val timeMillis = measureTimeMillis {
        val wordsByLength = mutableMapOf<Int, MutableList<ClassifiedWord>>()
        File(FILE).forEachLine {
            val processed = getListGivenWordSize(wordsByLength, it)
            processed.add(ClassifiedWord(it, calculateTraits(it.toLowerCase())))
        }
        wordsByLength
            .filter { it.value.size > 1 }
            .map {
                runBlocking { it.value.processGroup()
                }
            }
    }
    println("collections took = $timeMillis")
}

private fun getListGivenWordSize(
    wordsByLength: MutableMap<Int, MutableList<ClassifiedWord>>,
    it: String
): MutableList<ClassifiedWord> {
    val processed = wordsByLength[it.length] ?: run {
        val list = mutableListOf<ClassifiedWord>()
        wordsByLength[it.length] = list
        list
    }
    return processed
}


