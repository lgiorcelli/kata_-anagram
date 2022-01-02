package com.lgior.katas

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CandidateFilterTest {
    @Test
    fun `filter candidates given size`() {
        val list = DummyWordList("cara", "asa", "arca", "casa")
        val candidates = list.findWordsOf(4)

        Assertions.assertEquals(3, candidates.size)
    }

    @Test
    fun `group by anagrams`() {
        val candidates = listOf("casa", "arca", "cara")

        val matchers = listOf(CharMatcher('c'), CharMatcher('r'), CharMatcher('a', 2))
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