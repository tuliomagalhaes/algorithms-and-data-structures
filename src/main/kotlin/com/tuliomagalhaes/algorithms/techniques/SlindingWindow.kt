package com.tuliomagalhaes.algorithms.techniques

/*
Given an array of integers ‘arr’. Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.

Input  : arr[] = {100, 200, 300, 400}
         k = 2
Output : 700
 */

fun maxSum(arr: IntArray, k: Int): Int {
    var maxSum = 0

    for (i in 0 until k) {
        maxSum += arr[i]
    }

    var currentSum = maxSum
    for (i in k until arr.size) {
        currentSum += arr[i] - arr[i - k]
        maxSum = Math.max(currentSum, maxSum)
    }

    return maxSum
}