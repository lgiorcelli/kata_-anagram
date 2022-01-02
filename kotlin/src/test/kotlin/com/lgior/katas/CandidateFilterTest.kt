package com.lgior.katas

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CandidateFilterTest {
    @Test
    fun `filter candidates given size`() {
        val list = DummyWordList("cara", "asa", "arca", "casa")
        val candidates = list.findWordsOf(4)

        Assertions.assertEquals(3, candidates.size)
    }

    @Test
    fun `find traits of word`() {
        val candidate = "cara"
        val chars = candidate.toCharArray().distinct()
        assertEquals(3, chars.size)
        val map = chars.associateWith { countOccurrences(candidate, it) }
        assertEquals(3,  map.size)
        assertEquals(1, map['c'])
        assertEquals(2, map['a'])
        assertEquals(1, map['r'])
    }

    private fun countOccurrences(word: String, character: Char): Int {
        return word.count { it == character }
    }

}

interface WordList {
    fun findWordsOf(longitude: Int): List<String>
}

class DummyWordList(vararg words: String) : WordList {
    private val _words = words.toList()
    override fun findWordsOf(longitude: Int): List<String> {
        return _words.filter { it.length == longitude }
    }
}

class CharMatcher(val letter: Char, val amount: Int = 1)