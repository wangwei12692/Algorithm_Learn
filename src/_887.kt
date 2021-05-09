import kotlin.math.max

class _887 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(superEggDrop(3, 14))
//            println(superEggDrop2(3, 14))
            println(superEggDrop3(3, 100))
        }


        fun superEggDrop3(k: Int, n: Int): Int {
            val memo = Array(k + 1) { IntArray(n + 1) { -1 } }
            return dfs2(k, n, memo)
        }

        private fun dfs2(k: Int, n: Int, memo: Array<IntArray>): Int {
            if (n == 0) return 0
            if (k == 1) return n
            if (memo[k][n] != -1)
                return memo[k][n]
            var lo = 1
            var hi = n
            while (lo + 1 < hi) {
                val mid = (lo + hi) / 2
                val loVal = dfs2(k - 1, mid - 1, memo)
                val hiVal = dfs2(k, n - mid, memo)
                if (loVal < hiVal) {
                    lo = mid
                } else if (loVal > hiVal) {
                    hi = mid
                } else {
                    lo = mid
                    hi = mid
                }
            }
            println("$lo .. $hi")
//            val ans = (lo..hi).map { max(dfs2(k - 1, it - 1, memo), dfs2(k, n - it, memo)) }.min()

            val res = 1 + Math.min(
                max(dfs2(k - 1, lo - 1, memo), dfs2(k, n - lo, memo)),
                max(dfs2(k - 1, hi - 1, memo), dfs2(k, n - hi, memo))
            )
            memo[k][n] = res
            return res
        }


        fun superEggDrop2(k: Int, n: Int): Int {
            val memo = Array(k + 1) { IntArray(n + 1) { -1 } }
            return dfs(k, n, memo)
        }

        private fun dfs(k: Int, n: Int, memo: Array<IntArray>): Int {
            if (n == 0 || n == 1 || k == 1) {
                return n
            }
            if (memo[k][n] != -1) {
                return memo[k][n]
            }
            var res = n
            for (i in 1..n) {
                val tmp = max(dfs(k - 1, i - 1, memo), dfs(k, n - i, memo))
                res = Math.min(res, tmp + 1)
            }
            memo[k][n] = res
            return res
        }

        //dp[k][n] = 1+ for x in 1..n min(max(dp[k-1][x-1],dp[k][n-x]))
        fun superEggDrop(k: Int, n: Int): Int {
            val dp = Array(k + 1) { IntArray(n + 1) }
            for (i in 1..n) {
                dp[1][i] = i //one egg
                dp[0][i] = 0 //zero egg
            }
            for (i in 1..k) {
                dp[i][0] = 0 //zero floor
                dp[i][1] = 1 //one floor
            }
            for (kk in 2..k) {
                for (nn in 2..n) {
                    var res = Int.MAX_VALUE
                    for (x in 1..nn) {
                        val tmp = 1 + Math.max(dp[kk - 1][x - 1], dp[kk][nn - x])
                        res = Math.min(res, tmp)
                    }
                    dp[kk][nn] = res
                }
            }
            return dp[k][n]
        }

    }

}