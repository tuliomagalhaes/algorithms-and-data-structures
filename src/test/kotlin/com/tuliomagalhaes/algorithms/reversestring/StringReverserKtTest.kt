package com.tuliomagalhaes.algorithms.reversestring

import com.tuliomagalhaes.algorithms.reverse
import org.junit.Assert.assertEquals
import org.junit.Test

internal class StringReverserKtTest {

    @Test
    fun reverse_should_reverse_a_normal_string() {
        // Given
        val str = "abcd"

        // When
        val newStr = str.reverse()

        // Then
        assertEquals("dcba", newStr)
    }

    @Test
    fun reverse_should_reverse_a_string_with_spaces() {
        // Given
        val str = "   abcd"

        // When
        val newStr = str.reverse()

        // Then
        assertEquals("dcba   ", newStr)
    }
}