class _208 {
    private class Trie() {

        private class TrieNode() {
            var isEnd = false
            private val next = Array<TrieNode?>(26) { null }
            operator fun get(key: Char) = next[key - 'a']
            operator fun set(key: Char, node: TrieNode) {
                next[key - 'a'] = node
            }
        }

        private val root = TrieNode()

        fun insert(word: String) {
            var node = root
            for (c in word) {
                if (node[c] == null) {
                    node[c] = TrieNode()
                }
                node = node[c]!!
            }
            node.isEnd = true
        }

        /** Returns if the word is in the trie. */
        fun search(word: String): Boolean {
            val node = searchPrefix(word)
            return node?.isEnd == true
        }

        private fun searchPrefix(word: String): TrieNode? {
            var node = root
            for (c in word) {
                if (node[c] != null) {
                    node = node[c]!!
                } else {
                    return null
                }
            }
            return node
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        fun startsWith(prefix: String): Boolean {
            return searchPrefix(prefix) != null
        }

    }

    /**
     * Your Trie object will be instantiated and called as such:
     * var obj = Trie()
     * obj.insert(word)
     * var param_2 = obj.search(word)
     * var param_3 = obj.startsWith(prefix)
     */
}