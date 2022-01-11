package com.lgior.katas

import calculateTraits
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class TraitsCalculatorTest {
    @Test
    fun `filter candidates given size`() {
        val list = DummyWordList("cara", "asa", "arca", "casa")
        val candidates = list.findWordsOf(4)

        Assertions.assertEquals(3, candidates.size)
    }

    @Test
    fun `find traits of word cara`() {
        val candidate = "cara"
        val traits = calculateTraits(candidate)
        assertEquals(3,  traits.size)
        assertEquals(1, traits['c'])
        assertEquals(2, traits['a'])
        assertEquals(1, traits['r'])
    }

    @Test
    fun `find traits of word matambre`() {
        val candidate = "matambre"
        val traits = calculateTraits(candidate)
        assertEquals(6,  traits.size)
        assertEquals(2, traits['m'])
        assertEquals(2, traits['a'])
        assertEquals(1, traits['t'])
        assertEquals(1, traits['b'])
        assertEquals(1, traits['r'])
        assertEquals(1, traits['e'])
    }


    @Test
    fun `compare traits that matches`() {
        val first = calculateTraits("cara")
        val second = calculateTraits("arca")

        assertEquals(first, second)
    }

    @Test
    fun `compare traits that does not matches`() {
        val first = calculateTraits("cara")
        val second = calculateTraits("casa")

        assertNotEquals(first, second)
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
