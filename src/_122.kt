class _122 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(maxProfit(intArrayOf(7,1,5,3,6,4)))
            println(maxProfit2(intArrayOf(7,1,5,3,6,4)))
        }

        fun maxProfit(prices: IntArray): Int {
            var total = 0
            for (i in prices.indices) {
                if (i - 1 >= 0 && prices[i] > prices[i - 1]) {
                    total += (prices[i] - prices[i - 1])
                }
            }
            return total
        }

        fun maxProfit2(prices: IntArray): Int {
            val n = prices.size
            val dp = Array(n) { IntArray(2) }
            dp[0][0] = 0
            dp[0][1] = -prices[0]
            for (i in 1 until n) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])
            }
            return dp[n - 1][0]
        }
    }
}