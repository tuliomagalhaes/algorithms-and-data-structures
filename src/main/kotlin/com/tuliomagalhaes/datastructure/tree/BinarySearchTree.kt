package com.tuliomagalhaes.datastructure.tree

class BinarySearchTree<T : Comparable<T>> {
    var root: Node<T>? = null
        private set

    fun insert(value: T) {
        val newNode = Node(value)
        if (root == null) {
            root = newNode
        } else {
            var currentNode = root!!
            var inserted = false
            while (!inserted) {
                if (value < currentNode.value) {
                    val leftNode = currentNode.left
                    inserted = if (leftNode == null) {
                        currentNode.left = newNode
                        true
                    } else {
                        currentNode = leftNode
                        false
                    }
                } else {
                    val rightNode = currentNode.right
                    inserted = if (rightNode == null) {
                        currentNode.right = newNode
                        true
                    } else {
                        currentNode = rightNode
                        false
                    }
                }
            }
        }
    }

    fun lookup(value: T): Node<T>? {
        if (root == null) {
            return null
        }

        var currentNode = root
        while (currentNode != null) {
            val leftNode = currentNode.left
            val rightNode = currentNode.right
            currentNode = if (value == currentNode.value) {
                return currentNode
            } else if (leftNode != null && value <= leftNode.value) {
                leftNode
            } else if (rightNode != null && value >= rightNode.value) {
                rightNode
            } else {
                null
            }
        }

        return null
    }
}