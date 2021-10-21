package com.tuliomagalhaes.algorithms.chunk

import com.tuliomagalhaes.algorithms.chunk
import com.tuliomagalhaes.algorithms.chunkList
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class ArrayChunkTest {

    @Test
    fun chunk_should_divides_an_array_of_10_elements_with_chunk_size_2() {
        // Given
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        // When
        val chunked = chunk(array, 2)

        // Then
        val expected = arrayOf(
            arrayOf(1, 2),
            arrayOf(3, 4),
            arrayOf(5, 6),
            arrayOf(7, 8),
            arrayOf(9, 10)
        )
        assertArrayEquals(expected, chunked)
    }

    @Test
    fun chunk_should_divides_an_array_of_3_elements_with_chunk_size_1() {
        // Given
        val array = arrayOf(1, 2, 3)

        // When
        val chunked = chunk(array, 1)

        // Then
        val expected = arrayOf(
            arrayOf(1),
            arrayOf(2),
            arrayOf(3)
        )
        assertArrayEquals(expected, chunked)
    }

    @Test
    fun chunk_should_divides_an_array_of_5_elements_with_chunk_size_3() {
        // Given
        val array = arrayOf(1, 2, 3, 4, 5)

        // When
        val chunked = chunk(array, 3)

        // Then
        val expected = arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5)
        )
        assertArrayEquals(expected, chunked)
    }

    @Test
    fun chunk_should_divides_an_array_of_13_elements_with_chunk_size_5() {
        // Given
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)

        // When
        val chunked = chunk(array, 5)

        // Then
        val expected = arrayOf(
            arrayOf(1, 2, 3, 4, 5),
            arrayOf(6, 7, 8, 9, 10),
            arrayOf(11, 12, 13)
        )
        assertArrayEquals(expected, chunked)
    }

    @Test
    fun chunkList_should_divides_an_array_of_10_elements_with_chunk_size_2() {
        // Given
        val array = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        // When
        val chunked = chunkList(array, 2)

        // Then
        val expected = listOf(
                listOf(1, 2),
                listOf(3, 4),
                listOf(5, 6),
                listOf(7, 8),
                listOf(9, 10)
        )
        assertEquals(expected, chunked)
    }

    @Test
    fun chunkList_should_divides_an_array_of_3_elements_with_chunk_size_1() {
        // Given
        val array = listOf(1, 2, 3)

        // When
        val chunked = chunkList(array, 1)

        // Then
        val expected = listOf(
                listOf(1),
                listOf(2),
                listOf(3)
        )
        assertEquals(expected, chunked)
    }

    @Test
    fun chunkList_should_divides_an_array_of_5_elements_with_chunk_size_3() {
        // Given
        val array = listOf(1, 2, 3, 4, 5)

        // When
        val chunked = chunkList(array, 3)

        // Then
        val expected = listOf(
                listOf(1, 2, 3),
                listOf(4, 5)
        )
        assertEquals(expected, chunked)
    }

    @Test
    fun chunkList_should_divides_an_array_of_13_elements_with_chunk_size_5() {
        // Given
        val array = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)

        // When
        val chunked = chunkList(array, 5)

        // Then
        val expected = listOf(
                listOf(1, 2, 3, 4, 5),
                listOf(6, 7, 8, 9, 10),
                listOf(11, 12, 13)
        )
        assertEquals(expected, chunked)
    }
}