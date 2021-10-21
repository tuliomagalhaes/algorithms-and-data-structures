package com.tuliomagalhaes.algorithms.palindrome

import com.tuliomagalhaes.algorithms.palindrome
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

internal class PalindromeKtTest {

    @Test
    fun `palindrome should return true when "aba" is given`() {
        // Given
        val str = "aba"

        // When
        val result = str.palindrome()

        // Then
        assertTrue(result)
    }

    @Test
    fun `palindrome should return false when " aba" is given`() {
        // Given
        val str = " aba"

        // When
        val result = str.palindrome()

        // Then
        assertFalse(result)
    }

    @Test
    fun `palindrome should return false when "aba " is given`() {
        // Given
        val str = "aba "

        // When
        val result = str.palindrome()

        // Then
        assertFalse(result)
    }

    @Test
    fun `palindrome should return false when "greetings" is given`() {
        // Given
        val str = "greetings"

        // When
        val result = str.palindrome()

        // Then
        assertFalse(result)
    }

    @Test
    fun `palindrome should return true when "1000000001" is given`() {
        // Given
        val str = "1000000001"

        // When
        val result = str.palindrome()

        // Then
        assertTrue(result)
    }

    @Test
    fun `palindrome should return false when "Fish hsif" is given`() {
        // Given
        val str = "Fish hsif"

        // When
        val result = str.palindrome()

        // Then
        assertFalse(result)
    }

    @Test
    fun `palindrome should return true when "pennep" is given`() {
        // Given
        val str = "pennep"

        // When
        val result = str.palindrome()

        // Then
        assertTrue(result)
    }
}