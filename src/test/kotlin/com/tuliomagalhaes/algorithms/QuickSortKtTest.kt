package com.tuliomagalhaes.algorithms

import com.tuliomagalhaes.algorithms.sorting.quickSort
import org.junit.Before
import org.junit.Test

internal class QuickSortKtTest {

    @Before
    fun setUp() {
    }

    @Test
    fun quickSort() {
        val array = intArrayOf(10,1,6,3,8,2)

        array.quickSort()

        assert(array.contentEquals(intArrayOf(1,2,3,6,8,10)))
    }
}