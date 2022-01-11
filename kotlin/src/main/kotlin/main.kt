import java.io.File

fun main(args: Array<String>) {
    val words = mutableListOf<ClassifiedWord>()
    File("/Users/leonardo.giorcelli/sources/mio/kata_anagram/kotlin/five_chars_words.txt").forEachLine {
        words.add(ClassifiedWord(it, calculateTraits(it.toLowerCase())))
    }
    val grouped = words.groupBy { it.traits }
    println("words = ${words.size}")
    println("keys = ${grouped.keys.size}")
    println("values = ${grouped.values.size}")

    grouped.entries.filter { entry -> entry.value.size > 1 }
        .sortedByDescending { it.value.size }
        .map { it.value }
        .forEach { entry -> println("size: ${entry.size} - values: ${entry.map { value -> value.word }}") }
}

fun calculateTraits(candidate: String): Map<Char, Int> {
    val chars = candidate.toCharArray().distinct()
    return chars.associateWith { char ->  candidate.count { char == it } }
}

data class ClassifiedWord(val word: String, val traits: Map<Char, Int>)
