import kotlin.math.min

class _72 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(minDistance("a", "ab"))
        }

        fun minDistance(word1: String, word2: String): Int {
            val m = word1.length
            val n = word2.length
            val dp = Array(m + 1) { i ->
                IntArray(n + 1) { j ->
                    when {
                        i == 0 -> j
                        j == 0 -> i
                        else -> 0
                    }
                }
            }
            //m .. n 的最小编辑距离
            for (i in 1..m) {
                for (j in 1..n) {
                    if (word1[i - 1] == word2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1]
                    } else {
                        val last = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1])
                        dp[i][j] = last + 1
                    }
                }
            }
            return dp[m][n]
        }
    }
}