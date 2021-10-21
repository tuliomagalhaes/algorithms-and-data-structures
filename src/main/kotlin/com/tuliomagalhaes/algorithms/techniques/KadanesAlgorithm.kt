package com.tuliomagalhaes.algorithms.techniques

/*
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.

Input: nums = [-2,-3,4,-1,-2,1,5,-3]
Output: 7
Explanation: 4 + (-1) + (-2) + 1 + 5 = 7
 */

fun subArraySum(nums: IntArray): Int {
    var localSum = 0
    var globalSum = 0

    for (i in nums.indices) {
        localSum = Math.max(nums[i], localSum + nums[i])
        globalSum = Math.max(globalSum, localSum)
    }

    return globalSum
}