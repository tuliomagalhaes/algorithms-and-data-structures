package com.tuliomagalhaes.algorithms.techniques

/*
Given an array arr[], its prefix sum array is another array prefixSum[] of the same size,
such that the value of prefixSum[i] is arr[0] + arr[1] + arr[2] … arr[i].

Input  : arr[] = {10, 20, 10, 5, 15}
Output : prefixSum[] = {10, 30, 40, 45, 60}
 */

fun prefixSum(arr: IntArray): IntArray {
    val prefixSum = IntArray(arr.size) { 0 }
    prefixSum[0] = arr[0]

    for (i in 1 until arr.size) {
        prefixSum[i] = prefixSum[i - 1] + arr[i]
    }

    return prefixSum
}

/*
Given an array of n positive integers and a positive integer k,
the task is to find the maximum sub-array size such that all sub-arrays
of that size have the sum of elements less than or equals to k.

 Input :  arr[] = {1, 2, 3, 4} and k = 8.
Output : 2
Sum of subarrays of size 1: 1, 2, 3, 4.
Sum of subarrays of size 2: 3, 5, 7.
Sum of subarrays of size 3: 6, 9.
Sum of subarrays of size 4: 10.
So, maximum subarray size such that all subarrays of that size have the sum of elements less than 8 is 2.
 */

fun subArraySum(nums: IntArray, k: Int): Int {
    val prevSum = mutableMapOf(0 to 1)
    var result = 0
    var currentSum = 0

    for (i in nums.indices) {
        currentSum += nums[i]
        result += prevSum.getOrDefault(currentSum - k, 0)
        prevSum[currentSum] = prevSum.getOrDefault(currentSum, 0) + 1
    }

    return result
}