import kotlin.math.cos
import kotlin.math.min

class _746 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
        }

        fun minCostClimbingStairs(cost: IntArray): Int {
            return min(dfs(cost, 0), dfs(cost, 1))
        }

        private fun dfs(cost: IntArray, k: Int): Int {
            if (k >= cost.size)
                return 0
            return min(dfs(cost, k + 1), dfs(cost, k + 2)) + cost[k]
        }

        fun minCostClimbingStairs2(cost: IntArray): Int {
            val n = cost.size
            val dp = IntArray(n + 1)
            dp[0] = 0
            dp[1] = 0
            for (i in 2..n) {
                dp[i] = Math.min(
                    dp[i - 1] + cost[i - 1],
                    dp[i - 2] + cost[i - 2]
                )
            }
            return dp[n]
        }
    }
}