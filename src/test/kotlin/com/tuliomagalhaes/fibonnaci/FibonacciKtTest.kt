package com.tuliomagalhaes.fibonnaci

import org.junit.Assert.assertEquals
import org.junit.Test

internal class FibonacciKtTest {

    @Test
    fun `calculates correct fib value for 0`() {
        // Given
        val value = 0

        // When
        val result = value.fibonacci()

        // Then
        assertEquals(0, result)
    }

    @Test
    fun `calculates correct fib value for 1`() {
        // Given
        val value = 1

        // When
        val result = value.fibonacci()

        // Then
        assertEquals(1, result)
    }

    @Test
    fun `calculates correct fib value for 2`() {
        // Given
        val value = 2

        // When
        val result = value.fibonacci()

        // Then
        assertEquals(1, result)
    }

    @Test
    fun `calculates correct fib value for 3`() {
        // Given
        val value = 3

        // When
        val result = value.fibonacci()

        // Then
        assertEquals(2, result)
    }

    @Test
    fun `calculates correct fib value for 4`() {
        // Given
        val value = 4

        // When
        val result = value.fibonacci()

        // Then
        assertEquals(3, result)
    }

    @Test
    fun `calculates correct fib value for 15`() {
        // Given
        val value = 15

        // When
        val result = value.fibonacci()

        // Then
        assertEquals(610, result)
    }

    @Test
    fun `calculates correct fib value for 39`() {
        // Given
        val value = 39

        // When
        val result = value.fibonacci()

        // Then
        assertEquals(63245986, result)
    }
}