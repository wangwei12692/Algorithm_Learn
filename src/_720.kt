class _720 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                longestWord(arrayOf(
                    "ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"
                ))
            )
        }

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

            fun startsWith(prefix: String): Boolean {
                return searchPrefix(prefix) != null
            }

            fun getEndNodeCount(word: String): Int {
                var node = root
                var cnt = 0
                for (c in word) {
                    if (node[c] == null) {
                        return -1
                    }
                    if (!node[c]!!.isEnd)
                        return -1

                    cnt++
                    node = node[c]!!
                }
                return cnt
            }
        }

        fun longestWord(words: Array<String>): String {
            val trie = Trie()
            words.forEach { trie.insert(it) }
            var max = 0
            var ans = ""
            words.sort()
            for (word in words) {
                val cnt = trie.getEndNodeCount(word)
                if (cnt > max) {
                    max = cnt
                    ans = word
                }
            }
            return ans
        }
    }
}