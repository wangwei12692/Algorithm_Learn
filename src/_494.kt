import kotlin.math.max

class _494 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), -1))
            println(findTargetSumWays2(intArrayOf(1, 1, 1, 1, 1), -1))
            println(findTargetSumWays3(intArrayOf(1, 1, 1, 1, 1), -1))
        }

        fun findTargetSumWays(nums: IntArray, S: Int): Int {
            return dfs(nums, 0, 0, S)
        }

        private fun dfs(nums: IntArray, k: Int, cur: Int, S: Int): Int {
            if (k == nums.size)
                return if (cur == S) 1 else 0
            val plus = dfs(nums, k + 1, cur + nums[k], S)
            val minus = dfs(nums, k + 1, cur - nums[k], S)
            return plus + minus
        }

        fun findTargetSumWays2(nums: IntArray, S: Int): Int {
            val sum = nums.sum()
            if ((sum + S) % 2 == 1 || sum < S) return 0
            val amount = (sum + S) / 2
            val dp = IntArray(amount + 1)
            dp[0] = 1
            for (n in nums) {
                for (v in amount downTo 0) {
                    dp[v] = dp[v] + if (v - n < 0) 0 else dp[v - n]
                }
            }
            return dp[amount]
        }

        fun findTargetSumWays3(nums: IntArray, S: Int): Int {
            val amount = (nums.sum() + S) / 2
            val dp = Array(nums.size + 1) { IntArray(amount + 1) }
            dp[0][0] = 1
            for (i in 1..nums.size) {
                val num = nums[i - 1]
                for (v in 0..amount) {
                    val rh = if (v - num >= 0) dp[i - 1][v - num] else 0
                    dp[i][v] = dp[i - 1][v] + rh
                }
            }
            return dp[nums.size][amount]
        }
    }
}