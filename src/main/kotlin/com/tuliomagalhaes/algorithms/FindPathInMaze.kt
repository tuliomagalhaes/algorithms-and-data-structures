package com.tuliomagalhaes.algorithms

import java.util.*

fun main() {
    val maze = arrayOf(
        intArrayOf(1,1,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,0,1),
        intArrayOf(1,0,0,0,0,0,1),
        intArrayOf(1,1,1,1,1,0,1),
        intArrayOf(1,0,0,0,0,0,1),
        intArrayOf(1,1,1,0,1,1,1)
    )

    val result = findPathInAMaze(maze, 5 to 3)

    print(result)
}

fun findPathInAMaze(maze: Array<IntArray>, initialPath: Pair<Int, Int>): Boolean {
    val visited = Array(maze.size) { BooleanArray(maze[0].size) }
    val stack = Stack<Pair<Int, Int>>().apply {
        add(initialPath)
    }
    visited[initialPath.first][initialPath.second] = true

    while (stack.isNotEmpty()) {
        val nextPath = stack.pop()
        val i = nextPath.first
        val j = nextPath.second

        if ((i != initialPath.first || j != initialPath.second) && maze.isExit(i, j)) {
            return true
        }

        maze.addPathIfPossible(i - 1, j - 1, visited, stack)
        maze.addPathIfPossible(i + 1, j - 1, visited, stack)
        maze.addPathIfPossible(i + 1, j + 1, visited, stack)
        maze.addPathIfPossible(i - 1, j + 1, visited, stack)
        maze.addPathIfPossible(i + 1, j, visited, stack)
        maze.addPathIfPossible(i - 1, j, visited, stack)
        maze.addPathIfPossible(i, j - 1, visited, stack)
        maze.addPathIfPossible(i, j + 1, visited, stack)
    }

    return false
}

private fun Array<IntArray>.addPathIfPossible(
    i: Int,
    j: Int,
    visited: Array<BooleanArray>,
    stack: Stack<Pair<Int, Int>>
) {
    if (this.getOrNull(i)?.getOrElse(j) { 1 } == 0 && !visited[i][j]) {
        stack.add(i to j)
        visited[i][j] = true
    }
}

private fun Array<IntArray>.isExit(i: Int, j: Int): Boolean {
    val rowsSize = this.size
    val columnsSize = this[0].size
    return i - 1 == -1 || i + 1 == rowsSize || j - 1 == -1 || j + 1 == columnsSize
}