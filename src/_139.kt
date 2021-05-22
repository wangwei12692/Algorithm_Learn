class _139 {
    companion object {
        class Trie {
            class TrieNode() {
                var isEnd = false
                val next = Array<TrieNode?>(26) { null }
                operator fun get(char: Char): TrieNode? {
                    return next[char - 'a']
                }

                operator fun set(char: Char, node: TrieNode) {
                    next[char - 'a'] = node
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

            fun searchPrefix(prefix: String): TrieNode? {
                var node = root
                for (c in prefix) {
                    if (node[c] == null)
                        return null
                    node = node[c]!!
                }
                return node
            }
        }


        fun wordBreak(s: String, wordDict: List<String>): Boolean {
            val trie = Trie()
            for (word in wordDict) {
                trie.insert(word)
            }
            val dp = BooleanArray(s.length + 1)
            dp[0] = true
            //dp[i] = dp[j] && check(s[j ..i-1])
            for (i in 0..s.length) {
                for (j in 0 until i) {
                    if (dp[j] && trie.searchPrefix(s.substring(j, i))?.isEnd == true) {
                        dp[i] = true
                        break
                    }
                }
            }
            return dp[s.length]
        }
    }
}