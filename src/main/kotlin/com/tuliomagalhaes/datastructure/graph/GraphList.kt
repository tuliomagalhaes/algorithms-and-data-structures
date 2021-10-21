package com.tuliomagalhaes.datastructure.graph

import java.util.*

class GraphList<T> {
    private val graph: MutableMap<T, MutableSet<T>> = mutableMapOf()

    fun connect(vertexA: T, vertexB: T) {
        if (graph[vertexA] == null) {
            graph[vertexA] = mutableSetOf()
        }
        if (graph[vertexB] == null) {
            graph[vertexB] = mutableSetOf()
        }

        graph[vertexA]?.add(vertexB)
        graph[vertexB]?.add(vertexA)
    }

    fun printDFSIterative(root: T) {
        val visited = mutableSetOf<T>()
        val stack = Stack<T>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val vertex = stack.pop()

            if (visited.contains(vertex)) {
                continue
            }

            print(vertex)
            visited.add(vertex)

            val graph = graph[vertex] ?: emptySet<T>()
            for (adjacentVertex in graph.reversed()) {
                if (!visited.contains(adjacentVertex)) {
                    stack.push(adjacentVertex)
                }
            }
        }
    }

    // Visit all unseen vertex until visited all vertices
    fun printDFSRecursive(root: T) {
        val visited = mutableSetOf<T>()
        val unvisited = Stack<T>()
        unvisited.push(root)

        visitDFSAdjacentVertices(root, visited)
    }

    private fun visitDFSAdjacentVertices(vertex: T, visited: MutableSet<T>) {
        visited.add(vertex)
        print(vertex)
        val graph = graph[vertex] ?: emptySet<T>()

        for (adjacentVertex in graph) {
            if (!visited.contains(adjacentVertex)) {
                visitDFSAdjacentVertices(adjacentVertex, visited)
            }
        }
    }

    // Visit all connected vertices first and them all connected vertices from the first visited vertice
    fun printBFSIterative(root: T) {
        val visited = mutableSetOf<T>()
        val queue = PriorityQueue<T>()
        queue.add(root)
        visited.add(root)

        while (queue.isNotEmpty()) {
            val vertex = queue.remove()
            val graph = graph[vertex] ?: emptySet<T>()

            print(vertex)

            for (adjacentVertex in graph) {
                if (!visited.contains(adjacentVertex)) {
                    visited.add(adjacentVertex)
                    queue.add(adjacentVertex)
                }
            }
        }
    }

    fun printBFSRecursive(root: T) {
        val visited = mutableSetOf<T>()
        val queue = PriorityQueue<T>()
        visited.add(root)
        queue.add(root)
        visitBFSAdjacentVertices(queue, visited)
    }

    private fun visitBFSAdjacentVertices(queue: PriorityQueue<T>, visited: MutableSet<T>) {
        if (queue.isEmpty()) return

        val vertex = queue.remove()
        val graph = graph[vertex] ?: emptySet<T>()
        print(vertex)

        for (adjacentVertex in graph) {
            if (!visited.contains(adjacentVertex)) {
                queue.add(adjacentVertex)
                visited.add(adjacentVertex)
            }
        }

        visitBFSAdjacentVertices(queue, visited)
    }
}

fun main() {
    val a = "A"
    val b = "B"
    val c = "C"
    val d = "D"
    val e = "E"
    val f = "F"
    val g = "G"

    val graph = GraphList<String>()
    graph.connect(a, b)
    graph.connect(a, e)
    graph.connect(a, d)
    graph.connect(b, c)
    graph.connect(b, e)
    graph.connect(c, e)
    graph.connect(c, f)
    graph.connect(c, g)
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