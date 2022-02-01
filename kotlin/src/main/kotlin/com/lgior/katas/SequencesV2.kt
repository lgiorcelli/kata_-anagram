import com.lgior.katas.calculateTraits
import com.lgior.katas.processGroup
import kotlinx.coroutines.runBlocking
import java.io.File
import kotlin.system.measureTimeMillis

private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/src/main/resources/words.txt"

fun usingSequencesV2() {
    val start = System.currentTimeMillis()
    val timeMillis = measureTimeMillis {
        File(FILE).useLines { sequence ->
            sequence
                .map { ClassifiedWord(it, calculateTraits(it.toLowerCase())) }.also {
                    println("calculate traits = ${System.currentTimeMillis() - start}")
                }
                .groupBy { it.traits.size }.also {
                    println("group traits = ${System.currentTimeMillis() - start}")
                }
                .filter { it.value.size > 1 }.also {
                    println("filter > 1 = ${System.currentTimeMillis() - start}")
                }
                .map {
                    runBlocking {
                        it.value.processGroup()
                    }
                }.also {
                    println("process group = ${System.currentTimeMillis() - start}")
                }
            /*

        .groupBy { it.length }
        .filter { it.value.size > 1 }
        .map { wordsByLength ->
            wordsByLength.value.map { ClassifiedWord(it, calculateTraits(it.toLowerCase())) }
        }
        .map { classifiedWords ->
            classifiedWords.processGroup()
        }

             */
        }
        //grouped.entries.prettyPrint()
    }
    println("sequences took = $timeMillis")
}

/*
 sequences took = 5070
*/

