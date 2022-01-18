import com.lgior.katas.calculateTraits
import com.lgior.katas.processGroup
import java.io.File
import kotlin.system.measureTimeMillis

//private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/five_chars_words.txt"
private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/src/main/resources/words.txt"

fun usingSequences() {
    val timeMillis = measureTimeMillis {
        File(FILE).useLines { sequence ->
            sequence
                .groupBy { it.length }
                .filter { it.value.size > 1 }
                .map { wordsByLength ->
                    wordsByLength.value.map { ClassifiedWord(it, calculateTraits(it.toLowerCase())) }
                }
                .map { classifiedWords ->
                    classifiedWords.processGroup()
                }
        }
        //grouped.entries.prettyPrint()
    }
    println("sequences took = $timeMillis")
}
/*
 sequences took = 5070
*/

