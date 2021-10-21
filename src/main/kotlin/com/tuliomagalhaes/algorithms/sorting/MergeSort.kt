package com.tuliomagalhaes.algorithms.sorting

fun IntArray.mergeSort() {
    sort(this, 0, this.size - 1)
}

private fun sort(array: IntArray, left: Int, right: Int) {
    if (left >= right) {
        return
    }

    val mid = left + ((right - left) / 2)
    sort(array, left, mid)
    sort(array, mid + 1, right)
    merge(array, left, mid, right)
}

/*
array = [8,9,2,7,10,15]


array = [2,7,8,9,10,15]
left = 0
right = 5
mid = 2

leftArray [2,7]
rightArray
 */

private fun merge(array: IntArray, left: Int, mid: Int, right: Int) {
    val leftArray = array.copyOfRange(left, mid + 1)
    val rightArray = array.copyOfRange(mid + 1, right + 1)

    var i = 0
    var j = 0
    var k = left
    while (i < leftArray.size && j < rightArray.size) {
        if (leftArray[i] <= rightArray[j]) {
            array[k] = leftArray[i]
            i++
        } else {
            array[k] = rightArray[j]
            j++
        }
        k++
    }

    while (i < leftArray.size) {
        array[k] = leftArray[i]
        i++
        k++
    }

    while (j < rightArray.size) {
        array[k] = rightArray[j]
        j++
        k++
    }
}