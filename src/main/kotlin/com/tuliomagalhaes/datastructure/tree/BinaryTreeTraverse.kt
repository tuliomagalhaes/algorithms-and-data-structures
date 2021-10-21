package com.tuliomagalhaes.datastructure.tree

import java.util.*

fun <T : Comparable<T>> BinarySearchTree<T>.postOrder() {
    printPostOrder(this.root)
}

fun <T : Comparable<T>> BinarySearchTree<T>.inOrder() {
    printInOrder(this.root)
}

fun <T : Comparable<T>> BinarySearchTree<T>.preOrder() {
    printPreOrder(this.root)
}

fun <T : Comparable<T>> BinarySearchTree<T>.dfs() {
    dfs(this.root)
}

fun <T : Comparable<T>> BinarySearchTree<T>.bfs() {
    val queue = PriorityQueue<Node<T>>()
    queue.add(this.root)
    bfs(queue)
}

private fun <T> printPostOrder(node: Node<T>?) {
    if (node != null) {
        printPostOrder(node.left)
        printPostOrder(node.right)
        printNode(node)
    }
}

private fun <T> printInOrder(node: Node<T>?) {
    if (node != null) {
        printInOrder(node.left)
        printNode(node)
        printInOrder(node.right)
    }
}

private fun <T> printPreOrder(node: Node<T>?) {
    if (node != null) {
        printNode(node)
        printPreOrder(node.left)
        printPreOrder(node.right)
    }
}

private fun <T> dfs(node: Node<T>?) {
    if (node != null) {
        printPreOrder(node.left)
        printPreOrder(node.right)
        printNode(node)
    }
}

private fun <T> bfs(queue: PriorityQueue<Node<T>>) {
    if (queue.isEmpty()) return

    val node = queue.remove()

    printNode(node)

    if (node.left != null) {
        queue.add(node.left)
    }
    if (node.right != null) {
        queue.add(node.left)
    }

    bfs(queue)
}

private fun <T> printNode(node: Node<T>) {
    print(node.value)
}