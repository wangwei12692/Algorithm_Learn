class _64 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(minPathSum(arrayOf(
                intArrayOf(1,2,3),
                intArrayOf(4,5,6)
            )))
        }

        fun minPathSum(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid[0].size
            val dp = Array(m) { IntArray(n) }
            dp[0][0] = grid[0][0]
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (i == 0 && j == 0) {
                        continue
                    }
                    val minFromTop = if (i - 1 >= 0) dp[i - 1][j] else Int.MAX_VALUE
                    val minFromLeft = if (j - 1 >= 0) dp[i][j - 1] else Int.MAX_VALUE
                    dp[i][j] = Math.min(minFromLeft, minFromTop) + grid[i][j]
                }
            }
            return dp[m - 1][n - 1]
        }
    }
}