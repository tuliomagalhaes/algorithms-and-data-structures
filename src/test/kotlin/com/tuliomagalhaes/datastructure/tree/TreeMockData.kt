package com.tuliomagalhaes.datastructure.tree

fun createBinaryTree(): BinarySearchTree<Int> {
    return BinarySearchTree<Int>().apply {
        insert(9)
        insert(4)
        insert(6)
        insert(20)
        insert(170)
        insert(15)
        insert(1)
    }
}