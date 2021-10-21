package com.tuliomagalhaes.datastructure.tree

import org.junit.Assert.assertEquals
import org.junit.Test

class BinarySearchTreeTest  {

    @Test
    fun insert_should_add_new_nodes_balanced() {
        // Given

        // When

        // Then
    }

    @Test
    fun lookup_should_return_root_value() {
        // Given
        val binarySearchTree = createBinaryTree()

        // When
        val result = binarySearchTree.lookup(9)

        // Then
        assertEquals(9, result?.value)
    }

    @Test
    fun lookup_should_return_most_right_value() {
        // Given
        val binarySearchTree = createBinaryTree()

        // When
        val result = binarySearchTree.lookup(170)

        // Then
        assertEquals(170, result?.value)
    }

    @Test
    fun lookup_should_return_most_left_value() {
        // Given
        val binarySearchTree = createBinaryTree()

        // When
        val result = binarySearchTree.lookup(1)

        // Then
        assertEquals(1, result?.value)
    }
}