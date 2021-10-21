package com.tuliomagalhaes.algorithms
import com.tuliomagalhaes.algorithms.sorting.mergeSort
import org.junit.Test

class MergeSortKtTest {

    @Test
    fun mergeSort() {
        val array = intArrayOf(9,1,5,6,10,4,2)

        array.mergeSort()

        assert(array.contentEquals(intArrayOf(1,2,4,5,6,9,10)))
    }
}