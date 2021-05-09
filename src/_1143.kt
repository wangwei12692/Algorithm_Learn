import kotlin.math.max

class _1143 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(longestCommonSubsequence("abcde", "ace"))
            println(longestCommonSubsequence2("abcde", "ace"))
        }

        fun longestCommonSubsequence2(text1: String, text2: String): Int {
            return dfs(text1, text2, text1.length - 1, text2.length - 1)
        }

        private fun dfs(text1: String, text2: String, i: Int, j: Int): Int {
            if (i < 0 || j < 0)
                return 0
            if (text1[i] == text2[j]) {
                return dfs(text1, text2, i - 1, j - 1) + 1
            }
            return max(dfs(text1, text2, i - 1, j), dfs(text1, text2, i, j - 1))
        }

        fun longestCommonSubsequence(text1: String, text2: String): Int {
            val m = text1.length
            val n = text2.length
            val dp = Array(m + 1) { IntArray(n + 1) }
            for (i in 1..m) {
                for (j in 1..n) {
                    if (text1[i - 1] == text2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1
                    } else {
                        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
                    }
                }
            }
            return dp[m][n]
        }
    }
}