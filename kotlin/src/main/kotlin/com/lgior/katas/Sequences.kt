import com.lgior.katas.calculateTraits
import com.lgior.katas.processGroup
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File
import kotlin.system.measureTimeMillis

private const val FILE = "/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/src/main/resources/words.txt"

suspend fun usingSequences() = runBlocking {
    val start = System.currentTimeMillis()

        File(FILE).useLines { sequence ->
            val flow = sequence
                .groupBy { it.length }.also { println("group by = ${System.currentTimeMillis() - start}") }
                .filter { it.value.size > 1 }.also { println("filter = ${System.currentTimeMillis() - start}") }
                .map { wordsByLength ->
                    wordsByLength.value.map { ClassifiedWord(it, calculateTraits(it.toLowerCase())) }
                }.also { println("map classified words = ${System.currentTimeMillis() - start}") }
                .asFlow()

            println("flow created in : ${System.currentTimeMillis() - start}")

            flow.collect {
                launch(Dispatchers.IO) {
                    println("thread: ${Thread.currentThread().name}")
                    it.processGroup()
                }
            }
        }
}

/*
 sequences took = 5070
*/

