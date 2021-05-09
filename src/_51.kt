class _51 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(solveNQueens(4))
        }

        fun solveNQueens(n: Int): List<List<String>> {
            if (n == 0) return emptyList()
            if (n == 1) return listOf(listOf("Q"))
            val ans = mutableListOf<List<String>>()
            val columns = hashSetOf<Int>()
            val diag1 = hashSetOf<Int>()
            val diag2 = hashSetOf<Int>()
            val grid = Array(n) { CharArray(n) }
            dfs(ans, grid, n, 0, columns, diag1, diag2)
            return ans
        }



        private fun dfs(
            solutions: MutableList<List<String>>,
            grid: Array<CharArray>,
            n: Int,
            k: Int, /*第几行*/
            columns: HashSet<Int>,
            diagonals1: HashSet<Int>,
            diagonals2: HashSet<Int>
        ) {

            if (k == n) {
                val element = grid.map { it.joinToString("") { if (it == 'Q') it.toString() else "." } }
                solutions.add(element)
                return
            }
            //dfs 遍历行 ，里面的loop 遍历列
            for (j in 0 until n) {
                if (columns.contains(j)) {
                    continue
                }
                val diagonal1 = k - j
                if (diagonals1.contains(diagonal1)) {
                    continue
                }
                val diagonal2 = k + j
                if (diagonals2.contains(diagonal2)) {
                    continue
                }
                columns.add(j)
                diagonals1.add(diagonal1)
                diagonals2.add(diagonal2)
                grid[k][j] = 'Q' //行 列
                dfs(solutions, grid, n, k + 1, columns, diagonals1, diagonals2)
                grid[k][j] = '.'
                columns.remove(j)
                diagonals1.remove(diagonal1)
                diagonals2.remove(diagonal2)
            }
        }
    }
}