class _695 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                maxAreaOfIsland(
                    arrayOf(
                        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
                        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
                        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
                        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
                        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
                        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
                    )
                )
            )
        }

        fun maxAreaOfIsland(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid[0].size
            var ans = 0
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (grid[i][j] == 1)
                        ans = Math.max(ans, dfs(grid, i, j))
                }
            }
            return ans
        }

        private fun dfs(grid: Array<IntArray>, i: Int, j: Int): Int {
            if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == 0)
                return 0
            grid[i][j] = 0
            return 1 + dfs(grid, i + 1, j) + dfs(grid, i, j + 1) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1)
        }
    }
}