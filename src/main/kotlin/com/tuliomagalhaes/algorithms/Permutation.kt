package com.tuliomagalhaes.algorithms

fun main(){
    printPermutations(intArrayOf(1,2,3))
}

fun printPermutations(array: IntArray) {
    permute(array, 0, array.size - 1)
}

private fun permute(array: IntArray, start: Int, end: Int) {
    if (start == end) {
        println(array.joinToString())
        return
    }

    for (i in start..end) {
        swap(array, start, i)
        permute(array, start + 1, end)
        swap(array, start, i)
    }
}

private fun swap(array: IntArray, i: Int, j: Int) {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}

/*
Test #1:
start = 1
array = [3,2,1]
             i

[1,2,3]
[1,3,2]
[3,1,2]
 */