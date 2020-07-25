package com.tuliomagalhaes.capitalize

import org.junit.Assert.assertEquals
import org.junit.Test

internal class CapitalizeKtTest {

    @Test
    fun `capitalizes the first letter of every word in a sentence`() {
        // Given
        val str = "hi there, how is it going?"

        // When
        val result = str.capitalize()

        // Then
        assertEquals("Hi There, How Is It Going?", result)
    }

    @Test
    fun `capitalizes the first letter`() {
        // Given
        val str = "i love breakfast at bill miller bbq"

        // When
        val result = str.capitalize()

        // Then
        assertEquals("I Love Breakfast At Bill Miller Bbq", result)
    }
}