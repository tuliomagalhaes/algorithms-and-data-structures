package com.tuliomagalhaes.algorithms.sorting

fun IntArray.quickSort() {
    sort(this, 0, this.size - 1)
}

private fun sort(array: IntArray, start: Int, end: Int) {
    if (start >= end) {
        return
    }
    val lastPivotIndex = partition(array, start, end)
    sort(array, start, lastPivotIndex - 1)
    sort(array, lastPivotIndex + 1, end)
}

private fun partition(array: IntArray, start: Int, end: Int): Int {
    val pivot = array[end]
    var i = (start - 1)

    for (j in start until end) {
        if (array[j] < pivot) {
            i++
            swapArray(array, i, j)
        }
    }

    i++

    swapArray(array, i, end)

    return i
}

private fun swapArray(array: IntArray, i: Int, j: Int) {
    val array1 = array[i]
    val array2 = array[j]
    array[i] = array2
    array[j] = array1
}