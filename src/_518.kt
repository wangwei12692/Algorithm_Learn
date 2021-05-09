class _518 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(change(5, intArrayOf(1, 2, 5)))
            println(change2(5, intArrayOf(1, 2, 5)))
        }

        fun change2(amount: Int, coins: IntArray): Int {
            return dfs(amount, coins, 0)
        }

        private fun dfs(amount: Int, coins: IntArray, k: Int): Int {
            if (amount == 0) {
                return 1
            }
            if (k >= coins.size || amount < 0) {
                return 0
            }
            val take = dfs(amount - coins[k], coins, k)
            val noTake = dfs(amount, coins, k + 1)
            return take + noTake
        }

        fun change(amount: Int, coins: IntArray): Int {
            val m = coins.size
            val dp = IntArray(amount + 1)
            dp[0] = 1
            for (i in 1..m) {
                for (v in coins[i - 1]..amount) {
                    dp[v] = dp[v] + dp[v - coins[i - 1]]
                }
            }
            return dp[amount]
        }
    }
}