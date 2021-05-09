import kotlin.math.max

class _474 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(findMaxForm(arrayOf("10", "0001", "111001", "1", "0"), 5, 3))
            println(findMaxForm2(arrayOf("10", "0001", "111001", "1", "0"), 5, 3))
        }

        fun findMaxForm2(strs: Array<String>, m: Int, n: Int): Int {
            val counts = strs.map { it.count01() }
            return dfs(strs, counts, 0, m, n)
        }

        private fun dfs(strs: Array<String>, counts: List<Pair<Int, Int>>, k: Int, m: Int, n: Int): Int {
            if (m < 0 || n < 0 || k >= strs.size)
                return 0
            val c0 = counts[k].first
            val c1 = counts[k].second
            val take = if (m - c0 >= 0 && n - c1 >= 0) {
                dfs(strs, counts, k + 1, m - c0, n - c1) + 1
            } else
                Int.MIN_VALUE

            val no_take = dfs(strs, counts, k + 1, m, n)
            return max(no_take, take)
        }

        fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
            val size = strs.size
            val dp = Array(size + 1) { Array(m + 1) { IntArray(n + 1) } }
            //dp[i][m][n] = max(dp[i-1][m][n],dp[i-1][m-cm][n-cn]+1)


            val counts = strs.map { it.count01() }
            for (i in 1..size) {
                val count0 = counts[i - 1].first
                val count1 = counts[i - 1].second
                //m || n 不等与 0 是有可能的
                for (j in 0..m) {
                    for (k in 0..n) {
                        val rh = if (j - count0 >= 0 && k - count1 >= 0)
                            dp[i - 1][j - count0][k - count1] + 1
                        else Int.MIN_VALUE

                        dp[i][j][k] = max(dp[i - 1][j][k], rh)
                    }
                }
            }
            return dp[size][m][n]
        }
    }
}

private fun String.count01(): Pair<Int, Int> {
    val count0 = this.count { it == '0' }
    return Pair(count0, length - count0)
}
