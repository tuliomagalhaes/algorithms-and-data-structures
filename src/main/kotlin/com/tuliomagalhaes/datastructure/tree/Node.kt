package com.tuliomagalhaes.datastructure.tree

data class Node<T>(
    val value: T
) {
    var left: Node<T>? = null
    var right: Node<T>? = null
}