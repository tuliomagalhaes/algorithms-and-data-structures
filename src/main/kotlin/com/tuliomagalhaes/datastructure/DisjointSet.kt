package com.tuliomagalhaes.datastructure

class DisjointSet(
    size: Int
) {
    private val parent = IntArray(size)
    private val sizes = IntArray(size)

    init {
        for(i in parent.indices) {
            parent[i] = i
        }
    }

    fun isConnected(i: Int, j: Int): Boolean {
        return find(i) == find(j)
    }

    fun connect(i: Int, j: Int) {
        union(i, j)
    }

    private fun find(i: Int): Int {
        if (parent[i] == i) {
            return i
        }

        val result = find(parent[i])
        parent[result] = i
        return result
    }

    private fun union(i: Int, j: Int) {
        val iValue = find(i)
        val jValue = find(j)

        if (iValue == jValue) {
            return
        }

        if (sizes[i] < sizes[j]) {
            sizes[j] += sizes[i]
            parent[i] = j
        } else {
            sizes[i] += sizes[j]
            parent[j] = i
        }
    }
}