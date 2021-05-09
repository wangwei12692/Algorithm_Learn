class _79 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val board = arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            )
            println(exist(board, "ABCCED"))
            println(exist(board, "SEE"))
            println(exist(board, "ABCB"))
        }

        fun exist(board: Array<CharArray>, word: String): Boolean {
            val m = board.size
            val n = board[0].size
            val marked = Array(m) { BooleanArray(n) }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (dfs(board, word.toCharArray(), i, j, 0, marked))
                        return true
                }
            }
            return false
        }

        val dirs = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
        )

        private fun dfs(
            board: Array<CharArray>, word: CharArray,
            i: Int, j: Int, k: Int, marked: Array<BooleanArray>
        ): Boolean {

            if (k == word.size) {
                return true
            }

            if (i < 0 || j < 0 || i >= board.size || j >= board[0].size || board[i][j] != word[k] || marked[i][j]) {
                return false
            }
            marked[i][j] = true
            for ((r, c) in dirs) {
                if (dfs(board, word, i + r, j + c, k + 1, marked))
                    return true
            }
            marked[i][j] = false
            return false
        }
    }
}