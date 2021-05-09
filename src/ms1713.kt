class ms1713 {
    companion object {
        private class TrieNode {
            private val children = Array<TrieNode?>(26) { null }
            operator fun set(char: Char, node: TrieNode) {
                children[char - 'a'] = node
            }

            operator fun get(char: Char): TrieNode? {
                return children[char - 'a']
            }

            var word: String? = null
        }

        private fun TrieNode.insert(dic: String) {
            var node = this
            for (c in dic) {
                if (node[c] == null)
                    node[c] = TrieNode()
                node = node[c]!!
            }
            node.word = dic
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(
                respace(
                    arrayOf("vprkj","sqvuzjz","ptkrqrkussszzprkqrjrtzzvrkrrrskkrrursqdqpp","spqzqtrqs","rkktkruzsjkrzqq","rk","k","zkvdzqrzpkrukdqrqjzkrqrzzkkrr","pzpstvqzrzprqkkkd","jvutvjtktqvvdkzujkq","r","pspkr","tdkkktdsrkzpzpuzvszzzzdjj","zk","pqkjkzpvdpktzskdkvzjkkj","sr","zqjkzksvkvvrsjrjkkjkztrpuzrqrqvvpkutqkrrqpzu"),
                    "rkktkruzsjkrzqqzkvdzqrzpkrukdqrqjzkrqrzzkkrr"
                )
            )
            TODO()
        }

        fun respace(dictionary: Array<String>, sentence: String): Int {
            val trie = TrieNode()
            for (dic in dictionary) {
                trie.insert(dic)
            }
            var cnt = 0
            var node = trie
            for (i in sentence.indices) {
                val c = sentence[i]
                if (node[c] == null) {
                    if (trie[c] != null)
                        node = trie[c]!!
                    else
                        node = trie
                } else {
                    node = node[c]!!
                }
                if (node.word != null) {
                    cnt += node.word!!.length
                    node = trie
                }
            }
            return sentence.length - cnt
        }
    }
}


