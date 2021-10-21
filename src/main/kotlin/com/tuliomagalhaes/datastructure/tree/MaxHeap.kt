package com.tuliomagalhaes.datastructure.tree

class MaxHeap<T : Comparable<T>>() {
    val data = mutableListOf<T>()

    constructor(initialList: List<T>) : this() {
        initialList.forEach {
            insert(it)
        }
    }

    fun insert(value: T) {
        data.add(value)
        bubbleUp()
    }

    fun extractMax(): T {
        val max = prepareNewRoot()
        var parentIndex = 0

        while (parentIndex < data.size) {
            val parent = data[parentIndex]
            val leftIndex = (parentIndex * 2) + 1
            val rightIndex = (parentIndex * 2) + 2
            val left = data.getOrNull(leftIndex)
            val right = data.getOrNull(rightIndex)
            var swapIndex: Int? = null

            if (left != null && left > parent) {
                swapIndex = leftIndex
            } else if (right != null &&
                    ((swapIndex == null && right > parent) ||
                    (swapIndex != null && left != null && right > left))) {
                swapIndex = rightIndex
            }

            if (swapIndex != null) {
                data[parentIndex] = data[swapIndex]
                data[swapIndex] = parent
                parentIndex = swapIndex
            } else {
                break
            }
        }

        return max
    }

    private fun prepareNewRoot(): T {
        val oldRoot = data[0]
        data[0] = data.removeAt(data.lastIndex)
        return oldRoot
    }

    private fun bubbleUp() {
        var index = data.size - 1
        val element = data[index]

        while (index > 0) {
            val parentIndex = (index - 1) / 2
            val parent = data[parentIndex]
            if (element <= parent) {
                break
            } else {
                data[parentIndex] = element
                data[index] = parent
            }
            index = parentIndex
        }
    }
}