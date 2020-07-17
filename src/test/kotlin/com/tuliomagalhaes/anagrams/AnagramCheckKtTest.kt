package com.tuliomagalhaes.anagrams

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AnagramCheckKtTest {

    @Test
    fun `'"hello" is an anagram of "llohe"'`() {
        // Given
        val str = "hello"

        // When
        val result = str.isAnagramOf("llohe")

        // Then
        assertTrue(result)
    }

    @Test
    fun `"Whoa! Hi!" is an anagram of "Hi! Whoa!"`() {
        // Given
        val str = "Whoa! Hi!"

        // When
        val result = str.isAnagramOf("Hi! Whoa!")

        // Then
        assertTrue(result)
    }

    @Test
    fun `"Whoa! Hi!" is an anagram of "Hi Whoa!"`() {
        // Given
        val str = "Whoa! Hi!"

        // When
        val result = str.isAnagramOf("Hi Whoa!")

        // Then
        assertTrue(result)
    }

    @Test
    fun `"One One" is not an anagram of "Two two two"`() {
        // Given
        val str = "One One"

        // When
        val result = str.isAnagramOf("Two two two")

        // Then
        assertFalse(result)
    }

    @Test
    fun `"One one" is not an anagram of "One one c"`() {
        // Given
        val str = "One One"

        // When
        val result = str.isAnagramOf("One one c")

        // Then
        assertFalse(result)
    }

    @Test
    fun `"A tree, a life, a bench" is not an anagram of "A tree, a fence, a yard"`() {
        // Given
        val str = "A tree, a life, a bench"

        // When
        val result = str.isAnagramOf("A tree, a fence, a yard")

        // Then
        assertFalse(result)
    }
}