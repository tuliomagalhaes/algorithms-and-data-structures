package com.tuliomagalhaes.reverseint

import org.junit.Assert.assertEquals
import org.junit.Test

internal class IntReverserKtTest {

    @Test
    fun `reverseInt should return 0 when 0 is given`() {
        // Given
        val value = 0

        // When
        val result = value.reverseInt()

        // Then
        assertEquals(0, result)
    }

    @Test
    fun `reverseInt should return flips a positive number`() {
        assertEquals(5, 5.reverseInt())
        assertEquals(51, 15.reverseInt())
        assertEquals(9, 90.reverseInt())
        assertEquals(9532, 2359.reverseInt())
    }

    @Test
    fun `reverseInt should return flips a negative number`() {
        assertEquals(-5, (-5).reverseInt())
        assertEquals(-51, (-15).reverseInt())
        assertEquals(-9, (-90).reverseInt())
        assertEquals(-9532, (-2359).reverseInt())
    }
}