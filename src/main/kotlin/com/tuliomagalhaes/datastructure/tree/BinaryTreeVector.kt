package com.tuliomagalhaes.datastructure.tree
/*
            5
          /  \
         4    7
        / \   / \
       3   2  8   1

[5, 4, 7, 3, 2, 7, 8, 1]
 ^
5
 */

fun printTree(tree: Array<Int>) {
    fun traverse(i: Int) {
        val offset = i * 2

        if (i >= tree.size - 1 || offset + 1 >= tree.size - 1 || offset + 2 >= tree.size - 1) return

        print(tree[i]) // root
        print(tree[offset + 1]) // left
        print(tree[offset + 2]) // right
    }

    traverse(0)
}

fun main() {
    printTree(arrayOf(5, 4, 7, 4, 3, 2, 7, 8, 1))
}