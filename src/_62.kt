class _62 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(uniquePathsDFS2(3, 7))
        }

        fun uniquePaths(m: Int, n: Int): Int {
            val dp = Array(m + 1) { IntArray(n + 1) }
            dp[1][1] = 1
            for (i in 1..m) {
                for (j in 1..n) {
                    if (i != 1 || j != 1)
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
            return dp[m][n]
        }

        var ans = 0
        fun uniquePathsDFS(m: Int, n: Int): Int {
            dfs(m - 1, n - 1)
            return ans
        }

        private fun dfs(m: Int, n: Int) {
            if (m == 0 && n == 0) {
                ans++
                return
            }
            if (m > 0) {
                dfs(m - 1, n)
            }
            if (n > 0) {
                dfs(m, n - 1)
            }
        }


        fun uniquePathsDFS2(m: Int, n: Int): Int {
            return dfs2(m - 1, n - 1)
        }

        private fun dfs2(m: Int, n: Int): Int {
            if (m == 0 && n == 0) {
                return 1
            }
            var ans = 0
            if (m > 0) {
                ans += dfs2(m - 1, n)
            }
            if (n > 0) {
                ans += dfs2(m, n - 1)
            }
            return ans
        }
    }
}