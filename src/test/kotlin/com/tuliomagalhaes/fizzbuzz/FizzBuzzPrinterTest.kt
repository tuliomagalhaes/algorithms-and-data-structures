package com.tuliomagalhaes.fizzbuzz

import io.mockk.*
import org.junit.Assert.assertEquals
import org.junit.Test

internal class FizzBuzzPrinterTest {

    @Test
    fun fizzBuzz() {
        // Given
        val printer = mockk<Printer>()
        val capturedValues = mutableListOf<String>()
        every { printer.print(capture(capturedValues)) } just Runs
        val fizzBuzzPrinter = FizzBuzzPrinter(printer)

        // When
        fizzBuzzPrinter.fizzBuzz(15)

        // Then
        assertEquals("1", capturedValues[0])
        assertEquals("2", capturedValues[1])
        assertEquals("fizz", capturedValues[2])
        assertEquals("4", capturedValues[3])
        assertEquals("buzz", capturedValues[4])
        assertEquals("fizzbuzz", capturedValues[14])
    }
}