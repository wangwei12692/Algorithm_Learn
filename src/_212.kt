class _212 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                findWords(
                    arrayOf(
                        charArrayOf('o', 'a', 'a', 'n'),
                        charArrayOf('e', 't', 'a', 'e'),
                        charArrayOf('i', 'h', 'k', 'r'),
                        charArrayOf('i', 'f', 'l', 'v'),
                    ),
                    arrayOf("oath", "pea", "eat", "rain")
                )
            )
        }

        fun findWords2(board: Array<CharArray>, words: Array<String>): List<String> {
            val trie = Trie()
            for (word in words) trie.insert(word)
            val ans = mutableListOf<String>()
            val mark = Array(board.size) { BooleanArray(board[0].size) }
            for (i in board.indices) {
                for (j in board[0].indices) {
                    dfs2(board, trie.root, i, j, ans, mark)
                }
            }
            return ans
        }

        private fun dfs2(
            board: Array<CharArray>,
            trie: Trie.TrieNode,
            i: Int,
            j: Int,
            ans: MutableList<String>,
            mark: Array<BooleanArray>
        ) {
            if (i !in board.indices || j !in board[0].indices || trie[board[i][j]] == null || mark[i][j])
                return
            if (trie[board[i][j]]!!.isEnd) {
                ans.add(trie.word)
                trie[board[i][j]]!!.isEnd = false
            }
            mark[i][j] = true
            dfs2(board, trie[board[i][j]]!!, i + 1, j, ans, mark)
            dfs2(board, trie[board[i][j]]!!, i - 1, j, ans, mark)
            dfs2(board, trie[board[i][j]]!!, i, j + 1, ans, mark)
            dfs2(board, trie[board[i][j]]!!, i, j - 1, ans, mark)
            mark[i][j] = false
        }

        fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
            val m = board.size
            val n = board[0].size
            val ans = mutableListOf<String>()
            val mark = Array(m) { BooleanArray(n) }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    for (word in words) {
                        if (ans.contains(word))
                            continue
                        if (dfs(board, i, j, word, 0, mark)) {
                            ans.add(word)
                        }
                    }
                }
            }
            return ans
        }


        private fun dfs(
            board: Array<CharArray>,
            i: Int,
            j: Int,
            word: String,
            k: Int,
            mark: Array<BooleanArray>
        ): Boolean {
            if (k == word.length) {
                return true
            }
            if (i !in board.indices || j !in board[0].indices || board[i][j] != word[k] || mark[i][j])
                return false

            mark[i][j] = true

            if (dfs(board, i - 1, j, word, k + 1, mark) ||
                dfs(board, i, j - 1, word, k + 1, mark) ||
                dfs(board, i + 1, j, word, k + 1, mark) ||
                dfs(board, i, j + 1, word, k + 1, mark)
            ) {
                mark[i][j] = false
                return true
            }
            mark[i][j] = false
            return false
        }
    }
}