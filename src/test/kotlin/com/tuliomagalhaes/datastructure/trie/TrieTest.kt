package com.tuliomagalhaes.datastructure.trie

import com.tuliomagalhaes.datastructure.Trie
import org.junit.Before
import org.junit.Test

internal class TrieTest {

    private val trie = Trie(listOf("banana", "babaco", "abacaxi", "abacate", "abiu", "acai"))

/*                                 root
                                   /  \
                                  b    a
                                 /      \
                                a        b
                               / \        \
                              n   b        a
                             /     \      / \
                            a       a    c   c
                           /         \        \
                          n           c        a
                         /             \        \
                        a               o        x
                                                  \
                                                   i
*/
    @Before
    fun setUp() {
    }

    @Test
    fun contains_should_match_one_word_in_the_trie() {
        assert(trie.contains("banana"))
    }

    @Test
    fun contains_should_not_match_word_that_does_not_exist() {
        assert(!trie.contains("laranja"))
    }

    @Test
    fun contains_should_not_match_partially_words() {
        assert(!trie.contains("baba"))
    }

    @Test
    fun getWords_should_return_banana_and_babaco() {
        val prefix = "ba"

        val result = trie.getWords(prefix)

        assert(result == listOf("babaco", "banana"))
    }

    @Test
    fun getWords_should_return_banana() {
        val prefix = "ban"

        val result = trie.getWords(prefix)

        assert(result == listOf("banana"))
    }

    @Test
    fun getWords_should_return_everything_that_matches_with_ab() {
        val prefix = "ab"

        val result = trie.getWords(prefix)

        assert(result == listOf("abacate", "abacaxi", "abiu"))
    }

    @Test
    fun getWords_should_return_everything_ordered_lexicology() {
        val result = trie.getWords()
        assert(result == listOf("abacate", "abacaxi", "abiu", "acai", "babaco", "banana"))
    }
}