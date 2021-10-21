package com.tuliomagalhaes.datastructure.graph

import java.util.*

class GraphMatrix(
    private val size: Int
) {
    private val graph: Array<Array<Int>> = Array(size) { Array(size) {0} }

    fun connect(vertexA: Int, vertexB: Int) {
        graph[vertexA][vertexB] = 1
        graph[vertexB][vertexA] = 1
    }

    fun printDFSIterative(root: Int) {
        val visited = Array(size) { false }
        val stack = Stack<Int>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val vertex = stack.pop()

            if (visited[vertex]) {
                continue
            }

            print(vertex)
            visited[vertex] = true

            for (i in size - 1 downTo 0) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    stack.push(i)
                }
            }
        }
    }

    fun printDFSRecursive(root: Int) {
        val visited = Array(size) { false }
        visitDFSVerticesRecursive(root, visited)
    }

    private fun visitDFSVerticesRecursive(vertex: Int, visited: Array<Boolean>) {
        visited[vertex] = true
        print(vertex)

        for (i in 0 until size) {
            if (graph[vertex][i] == 1 && !visited[i]) {
                visitDFSVerticesRecursive(i, visited)
            }
        }
    }

    fun printBFSIterative(root: Int) {
        val visited = Array(size) { false }
        val queue = PriorityQueue<Int>()
        visited[root] = true
        queue.add(root)

        while (queue.isNotEmpty()) {
            val vertex = queue.remove()

            print(vertex)

            for (i in 0 until size) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true
                    queue.add(i)
                }
            }
        }
    }

    fun printBFSRecursive(root: Int) {
        val visited = Array(size) { false }
        val queue = PriorityQueue<Int>()
        queue.add(root)
        visitBFSVerticesRecursive(queue, visited)
    }

    private fun visitBFSVerticesRecursive(queue: PriorityQueue<Int>, visited: Array<Boolean>) {
        if (queue.isEmpty()) return

        val vertex = queue.remove()
        visited[vertex] = true

        print(vertex)

        for (i in 0 until size) {
            if (graph[vertex][i] == 1 && !visited[i]) {
                queue.add(i)
                visited[i] = true
            }
        }

        visitBFSVerticesRecursive(queue, visited)
    }
}

fun main() {
    val a = 0
    val b = 1
    val c = 2
    val d = 3
    val e = 4
    val f = 5
    val g = 6

    val graph = GraphMatrix(7)
    graph.connect(a, b)
    graph.connect(a, e)
    graph.connect(a, d)
    graph.connect(b, c)
    graph.connect(b, e)
    graph.connect(c, e)
    graph.connect(c, f)
    graph.connect(b, g)
    graph.connect(e, d)
    graph.connect(e, f)
    graph.connect(f, g)

    // ABCEDFG
    println("DFS:")
    graph.printDFSIterative(a)
    println()
    graph.printDFSRecursive(a)
    println()
    println()

    // ABCDEFG
    println("BFS:")
    graph.printBFSIterative(a)
    println()
    graph.printBFSRecursive(a)
}