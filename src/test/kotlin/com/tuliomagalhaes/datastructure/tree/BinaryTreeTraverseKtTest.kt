package com.tuliomagalhaes.datastructure.tree

import org.junit.Test

internal class BinaryTreeTraverseKtTest {

    @Test
    fun postOrder_should_print_all_tree() {
        // Given
        val binaryTree = createBinaryTree()

        // When
        binaryTree.postOrder()

        // Then
    }

    @Test
    fun inOrder_should_print_all_tree() {
        // Given
        val binaryTree = createBinaryTree()

        // When
        binaryTree.inOrder()

        // Then
    }

    @Test
    fun preOrder_should_print_all_tree() {
        // Given
        val binaryTree = createBinaryTree()

        // When
        binaryTree.preOrder()

        // Then
    }

    @Test
    fun dfs_should_print_all_tree() {
        // Given
        val binaryTree = createBinaryTree()

        // When
        binaryTree.dfs()

        // Then
    }

    @Test
    fun bfs_should_print_all_tree() {
        // Given
        val binaryTree = createBinaryTree()

        // When
        binaryTree.bfs()

        // Then
    }
}