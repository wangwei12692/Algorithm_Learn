import kotlin.math.max

class _198 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(rob(intArrayOf(1,2,3,1)))
            println(rob(intArrayOf(2,7,9,3,1)))
        }
        fun rob(nums: IntArray): Int {
            if (nums.isEmpty())
                return 0
            val n = nums.size
            val dp = Array(n) { IntArray(2) }
            dp[0][0] = 0
            dp[0][1] = nums[0]
            //dp[i][0] 不偷
            //dp[i][1] 偷
            for (i in 1 until n) {
                dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
                dp[i][1] = dp[i - 1][0] + nums[i]
            }
            return max(dp[n - 1][0], dp[n - 1][1])
        }
    }
}