import kotlin.math.max

class ms1716 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(massage(intArrayOf(2,1,4,5,3,1,1,3)))
        }

        fun massage(nums: IntArray): Int {
            val dp = IntArray(nums.size)
            dp[0] = nums[0]
            for (i in 1..nums.size - 1) {
                dp[i] = max(if (i - 2 >= 0) dp[i - 2] + nums[i] else 0, dp[i - 1])
            }
            return dp[nums.size - 1]
        }
    }

}