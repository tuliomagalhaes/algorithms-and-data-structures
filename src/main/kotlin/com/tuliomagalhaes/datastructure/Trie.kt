package com.tuliomagalhaes.datastructure

class Trie(
    words: List<String>
) {
    private val root: TrieNode = TrieNode()

    init {
        words.forEach {
            root.addWord(it)
        }
    }

    fun getWords(): List<String> {
        return findWordsByPrefix(root, "")
    }

    fun getWords(letter: Char): List<String> {
        return getWords(letter.toString())
    }

    fun getWords(prefix: String): List<String> {
        val prefixNode = findNodePrefix(root, 0, prefix) ?: return emptyList()
        return findWordsByPrefix(prefixNode, prefix)
    }

    private fun findWordsByPrefix(node: TrieNode, prefix: String): List<String> {
        val path = mutableListOf<String>()
        val selections = mutableListOf<String>()

        traverseNodes(node, prefix, path, selections)

        return selections
    }

    private fun traverseNodes(node: TrieNode, prefix: String, path: MutableList<String>, selections: MutableList<String>) {
        for (nextNode in node.getNodes()) {
            if (nextNode == null) {
                continue
            }

            path.add(nextNode.letter.toString())

            if (nextNode.terminated()) {
                selections.add(prefix + path.joinToString(separator = "") { it })
            } else {
                traverseNodes(nextNode, prefix, path, selections)
            }

            path.removeAt(path.size - 1)
        }
    }

    private fun findNodePrefix(node: TrieNode?, i: Int, prefix: String): TrieNode? {
        if (node == null) {
            return null
        }

        for (nextNode in node.getNodes()) {
            if (nextNode?.letter == prefix[i]) {
                return if (i < prefix.length - 1) {
                    findNodePrefix(nextNode, i + 1, prefix)
                } else {
                    nextNode
                }
            }
        }

        return null
    }

    fun contains(word: String): Boolean {
        var current: TrieNode? = root

        for (ch in word) {
            current = current?.getNodeByLetter(ch)
            if (current == null) {
                return false
            }
        }

        return current?.terminated() == true
    }
}

private class TrieNode(
    val letter: Char = ' '
) {
    private val children = arrayOfNulls<TrieNode>(26)
    private var terminated = true

    fun addWord(word: String) {
        if (word.isEmpty()) {
            return
        }

        val firstWordChar = word[0]
        var node: TrieNode? = children.getOrNull(firstWordChar)
        if (node == null) {
            node = TrieNode(firstWordChar)
            children.setNode(firstWordChar, node)
            terminated = false
        }

        if (word.length > 1) {
            node.addWord(word.substring(1))
        }
    }

    fun getNodes(): Array<TrieNode?> {
        return children
    }

    fun getNodeByLetter(letter: Char): TrieNode? {
        return children.getOrNull(letter)
    }

    fun terminated(): Boolean {
        return terminated
    }

    private fun Array<TrieNode?>.setNode(letter: Char, node: TrieNode) {
        this[letter.generateKeyHash()] = node
    }

    private fun Array<TrieNode?>.getOrNull(letter: Char): TrieNode? {
        return this.getOrNull(letter.generateKeyHash())
    }

    private fun Char.generateKeyHash(): Int {
        return this - 'a'
    }
}