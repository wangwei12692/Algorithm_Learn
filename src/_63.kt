class _63 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
            val m = obstacleGrid.size
            val n = obstacleGrid[0].size
            val dp = Array(m + 1) { IntArray(n + 1) }
            dp[1][1] = if (obstacleGrid[0][0] == 1) 0 else 1
            for (i in 1..m) {
                for (j in 1..n) {
                    if (i == 1 && j == 1)
                        continue
                    val steps: () -> Int = {
                        if (obstacleGrid[i - 1][j - 1] == 1)
                            0
                        else {
                            val top = dp[i - 1][j]
                            val left = dp[i][j - 1]
                            top + left
                        }
                    }
                    dp[i][j] = steps()
                }
            }
            return dp[m][n]
        }
    }
}