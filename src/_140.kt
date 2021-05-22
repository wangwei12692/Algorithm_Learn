class _140 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val ans = wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat"))
            println(ans.joinToString())
        }

        fun wordBreak(s: String, wordDict: List<String>): List<String> {
            val trie = Trie()
            for (word in wordDict) {
                trie.insert(word)
            }
            val dp = BooleanArray(s.length + 1)
            dp[0] = true
            for (i in 0..s.length) {
                for (j in 0 until i) {
                    if (dp[j] && trie.searchPrefix(s.substring(j, i))?.isEnd == true) {
                        dp[i] = true
                        break
                    }
                }
            }

            val ans = mutableListOf<String>()
            dfs(s, dp, trie, 0, mutableListOf<String>(), ans)
            return ans
        }

        private fun dfs(
            s: String,
            dp: BooleanArray,
            trie: Trie,
            i: Int,
            line: MutableList<String>,
            ans: MutableList<String>
        ) {
            if (i >= s.length) {
                ans.add(line.joinToString(" "))
                return
            }
            for (j in i until s.length) {
                val element = s.substring(i, j + 1)
                if (dp[j + 1] && trie.searchPrefix(element)?.isEnd == true) {
                    line.add(element)
                    dfs(s, dp, trie, j + 1, line, ans)
                    line.removeAt(line.lastIndex)
                }
            }
        }
    }
}