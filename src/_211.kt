class _211 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val dir = WordDictionary()
            dir.addWord("a")
            dir.addWord("a")
            println(dir.search("."))
            println(dir.search("a"))
            println(dir.search("aa"))
            println(dir.search("a"))
            println(dir.search(".a"))
            println(dir.search("a."))
        }
    }

    class WordDictionary() {

        /** Initialize your data structure here. */


        private val trie = DotTrie()

        fun addWord(word: String) {
            trie.insert(word)
        }

        fun search(word: String): Boolean {
            return trie.searchWord(word)?.isEnd == true
        }

    }

    private class DotTrie {

        class TrieNode {
            val next = Array<TrieNode?>(128) { null }
            var isEnd = false
            operator fun get(char: Char): TrieNode? {
                return next[char.toInt()]
            }

            operator fun set(char: Char, node: TrieNode) {
                next[char.toInt()] = node
            }
        }

        private val root = TrieNode()

        fun insert(word: String) {
            var node: TrieNode = root
            for (c in word) {
                if (node[c] == null) {
                    node[c] = TrieNode()
                }
                node = node[c]!!
            }
            node.isEnd = true
        }

        fun searchWord(word: String): TrieNode? {
            return searchWordFromNode(word, 0, root)
        }

        private fun searchWordFromNode(word: String, k: Int, root: TrieNode): TrieNode? {
            if (k == word.length)
                return root
            var node = root
            for (i in k until word.length) {
                val c = word[i]
                if (c == '.') {
                    for (next in 0..127) {
                        if (node[next.toChar()] != null) {
                            val res = searchWordFromNode(word, i + 1, node[next.toChar()]!!)
                            if (res != null && res.isEnd) {
                                return res
                            }
                        }
                    }
                    return null
                } else if (node[c] != null) {
                    node = node[c]!!
                } else {
                    return null
                }
            }

            return node
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * var obj = WordDictionary()
     * obj.addWord(word)
     * var param_2 = obj.search(word)
     */
}