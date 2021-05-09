class _648 {
    companion object {
        class TrieNode(
            var word: String? = null
        ) {
            private val nodes = Array<TrieNode?>(26) { null }
            operator fun get(key: Char) = nodes[key - 'a']
            operator fun set(key: Char, node: TrieNode) {
                nodes[key - 'a'] = node
            }
        }

        fun replaceWords(dictionary: List<String>, sentence: String): String {
            val trie = TrieNode()
            fun insert(word: String) {
                var node = trie
                for (c in word) {
                    if (node[c] == null) {
                        node[c] = TrieNode()
                    }
                    node = node[c]!!
                }
                node.word = word
            }

            val words = sentence.split(" ")
            dictionary.forEach { insert(it) }
            val sb = mutableListOf<String>()
            for (word in words) {
                var cur = trie
                for (c in word) {
                    if (cur[c] == null || cur.word != null) {
                        break
                    }
                    cur = cur[c]!!
                }
                sb.add(cur.word ?: word)
            }
            return sb.joinToString(" ")
        }
    }
}