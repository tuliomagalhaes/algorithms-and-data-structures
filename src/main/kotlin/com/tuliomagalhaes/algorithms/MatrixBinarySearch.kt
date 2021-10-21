package com.tuliomagalhaes.algorithms

fun Array<IntArray>.binarySearch(target: Int): Pair<Int, Int>? {
    var rowStart = 0
    var rowEnd = this.size - 1

    while(rowStart <= rowEnd) {
        val matrixMid = rowStart + (rowEnd - rowStart) / 2
        val rowLastIndex = this[matrixMid].size - 1

        if (target >= this[matrixMid][0] && target <= this[matrixMid][rowLastIndex]) {
            val index = this[matrixMid].binarySearch(target)
            return if (index != -1) {
                (matrixMid to index)
            } else {
                null
            }
        } else if (target < this[matrixMid][0]) {
            rowEnd = matrixMid - 1
        } else {
            rowStart = matrixMid + 1
        }
    }

    return null
}