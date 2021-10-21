package com.tuliomagalhaes.algorithms

import org.junit.Before
import org.junit.Test

internal class MatrixBinarySearchKtTest {

    @Before
    fun setUp() {
    }

    @Test
    fun binarySearch1() {
        val matrix = arrayOf(
            intArrayOf(1,2,3,4,5),
            intArrayOf(6,7,8,9,10),
            intArrayOf(11,12,13,14,15),
            intArrayOf(16,17,18,19,20),
            intArrayOf(21,22,23,24,25)
        )

        val result = matrix.binarySearch(6)

        assert(result?.first == 1)
        assert(result?.second == 0)
    }

    @Test
    fun binarySearch2() {
        val matrix = arrayOf(
            intArrayOf(1,2,3,4,5),
            intArrayOf(6,7,8,9,10),
            intArrayOf(11,12,13,14,15),
            intArrayOf(16,17,18,19,20),
            intArrayOf(21,22,23,24,25)
        )

        val result = matrix.binarySearch(50)

        assert(result == null)
    }

    @Test
    fun binarySearch3() {
        val matrix = arrayOf(
            intArrayOf(1,2,3,4,5),
            intArrayOf(6,7,8,9,10),
            intArrayOf(11,12,13,14,15),
            intArrayOf(16,17,18,19,20),
            intArrayOf(21,22,23,24,25)
        )

        val result = matrix.binarySearch(-1)

        assert(result == null)
    }
}