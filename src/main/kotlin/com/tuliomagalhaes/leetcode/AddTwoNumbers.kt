package com.tuliomagalhaes.leetcode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2
        var resultNode: ListNode? = null
        var nextNode: ListNode? = null
        var rest = 0

        while (node1 != null || node2 != null) {
            val node1Value = node1?.`val` ?: 0
            val node2Value = node2?.`val` ?: 0

            val sum = (node1Value + node2Value) + rest
            val result = if (sum >= 10) {
                val sumStr = sum.toString()
                rest = Character.getNumericValue(sumStr[0])
                Character.getNumericValue(sumStr[1])
            } else {
                sum
            }

            if (resultNode == null) {
                resultNode = ListNode(result)
                nextNode = resultNode
            } else {
                nextNode?.next = ListNode(result)
                nextNode = nextNode?.next
            }

            node1 = node1?.next
            node2 = node2?.next
        }

        return resultNode
    }
}

fun main() {
    val l1 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }
    val l2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }

    var result = Solution().addTwoNumbers(l1, l2)

    while (result != null) {
        print(result.`val`)
        result = result.next
    }
}