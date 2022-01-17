package com.lgior.katas

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class TraitsComparatorTest {
    @Test
    fun `compare traits must return equals, beyond its order`() {
        val traits1 = mapOf('a' to 1, 'b' to 2, 'c' to 3)
        val traits2 = mapOf('c' to 3, 'b' to 2, 'a' to 1)

        val result = traits1 == traits2

        assertTrue(result, "traits are equals")
    }

    @Test
    fun `compare traits must return distinct when amounts are different`() {
        val traits1 = mapOf('a' to 1, 'b' to 2, 'c' to 2)
        val traits2 = mapOf('c' to 3, 'b' to 2, 'a' to 1)

        val result = traits1 == traits2

        assertFalse(result, "traits are equals")
    }

    @Test
    fun `compare traits must return distinct when characters are different`() {
        val traits1 = mapOf('a' to 1, 'b' to 2, 'd' to 3)
        val traits2 = mapOf('c' to 3, 'b' to 2, 'a' to 1)

        val result = traits1 == traits2

        assertFalse(result, "traits are equals")
    }

}
