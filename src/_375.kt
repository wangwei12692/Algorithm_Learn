import kotlin.math.max
import kotlin.math.min

class _375 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(getMoneyAmount(5))
            println(getMoneyAmount2(5))
        }

        fun getMoneyAmount(n: Int): Int {
            return dfs(1, n)
        }

        //计算每次都猜错的总体最大花销
        //在最大花销中找最小值
        private fun dfs(lo: Int, hi: Int): Int {
            if (lo >= hi) return 0
            var res = Int.MAX_VALUE
            for (cost in ((lo + hi) / 2)..hi) {
                val tmp = cost + max(dfs(cost + 1, hi), dfs(lo, cost - 1))
                res = min(res, tmp)
            }
            return res
        }

        //dp[i][j] = pivot + max(cost(i,pivot-1),cost(pivot+1,n)
        fun getMoneyAmount2(n: Int): Int {
            val dp = Array(n + 1) { IntArray(n + 1) }
            for (len in 1..n) {
                for (start in 1..n - len) {
                    var res = Int.MAX_VALUE
                    for (piv in start until start + len) {
                        val tmp = piv + max(dp[start][piv - 1], dp[piv + 1][start + len])
                        res = min(res, tmp)
                    }
                    dp[start][start + len] = res
                }
            }
            return dp[1][n]
        }
    }
}