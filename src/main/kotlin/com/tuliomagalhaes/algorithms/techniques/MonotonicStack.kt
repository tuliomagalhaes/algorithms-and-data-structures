package com.tuliomagalhaes.algorithms.techniques

import java.util.*

fun main() {
    println(nextGreaterElement(intArrayOf(1,2,3,4,6),intArrayOf(1,3,4,2,6)).contentEquals(intArrayOf(3,6,4,6,-1)))
    println(nextGreaterElement(intArrayOf(1,2,3,4),intArrayOf(1,3,4,2)).contentEquals(intArrayOf(3,-1,4,-1)))
    print(nextWarmerTemperaturesDays(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).contentEquals(intArrayOf(1, 1, 4, 2, 1, 1, 0, 0)))
}

/*
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 */

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    val stack = Stack<Int>()

    for (i in nums2.indices) {
        while (stack.isNotEmpty() && stack.peek() <= nums2[i]) {
            map[stack.pop()] = nums2[i]
        }
        stack.add(nums2[i])
    }

    while (stack.isNotEmpty()) {
        map[stack.pop()] = -1
    }

    val result = IntArray(nums1.size)
    for (i in nums1.indices) {
        result[i] = map.getOrDefault(nums1[i], -1)
    }

    return result
}

/*
Give you an array T = [73, 74, 75, 71, 69, 72, 76, 73], which stores the weather temperature in recent days.
You return an array to calculate: for each day, how many days do you have to wait for a warmer temperature;
and if you can't wait for that day, fill in 0.
 */

fun nextWarmerTemperaturesDays(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    val stack = Stack<Int>()

    for (i in nums.indices) {
        while (stack.isNotEmpty() && nums[stack.peek()] <= nums[i]) {
            val lastIndex = stack.pop()
            result[lastIndex] = i - lastIndex
        }
        stack.add(i)
    }

    return result
}