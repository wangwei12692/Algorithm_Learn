import kotlin.math.max
import kotlin.math.min

class _322 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(coinChange(intArrayOf(1, 2, 5), 11))
            println(coinChange(intArrayOf(1, 2, 5), 11))
            println(coinChange3(intArrayOf(1, 2, 5), 11))
        }

        fun coinChange(coins: IntArray, amount: Int): Int {
            val dp = IntArray(amount + 1) { amount + 1 }
//            for (coin in coins) {
//                dp[coin] = 1
//            }
            dp[0] = 0
            for (cur in 1..amount) {
                for (coin in coins) {
                    if (cur - coin >= 0) {
                        dp[cur] = min(dp[cur], dp[cur - coin] + 1)
                    }
                }
            }
            return if (dp[amount] > amount) -1 else dp[amount]
        }

        fun coinChange2(coins: IntArray, amount: Int): Int {
            val m = coins.size
            val n = amount
            val dp = Array(m + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
            dp[0][0] = 0
            for (i in 1..m) {
                for (j in 1..n) {
                    for (k in 0..j / coins[i - 1]) {
                        val pre = dp[i - 1][j - k * coins[i - 1]]
                        dp[i][j] = min(dp[i - 1][j], if (pre == Int.MAX_VALUE) Int.MAX_VALUE else pre + k)
                    }
                }
            }
            return if (dp[m][n] > amount) -1 else dp[m][n]
        }

        fun coinChange3(coins: IntArray, amount: Int): Int {
            val dp = IntArray(amount + 1) { Int.MAX_VALUE }
            dp[0] = 0
            for (coin in coins) {
                for (v in coin..amount) {
                    //加选一件
                    dp[v] = min(dp[v], if (dp[v - coin] == Int.MAX_VALUE) Int.MAX_VALUE else dp[v - coin] + 1)
                }
            }
            return if (dp[amount] == Int.MAX_VALUE) -1 else dp[amount]
        }
    }
}