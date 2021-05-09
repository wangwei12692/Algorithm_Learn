import kotlin.math.max

class js42 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
            println(maxSubArray2(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
        }

        fun maxSubArray2(nums: IntArray): Int {
            val dp = IntArray(nums.size)
            dp[0] = nums[0]
            for (i in 1..nums.size - 1) {
                dp[i] = max(dp[i - 1] + nums[i], nums[i])
            }
            return dp.max()!!
        }

        fun maxSubArray(nums: IntArray): Int {
            var pre = 0
            var ans = 0
            for (i in 0..nums.size - 1) {
                if (nums[i] > nums[i] + pre) {
                    pre = nums[i]
                } else {
                    pre = nums[i] + pre
                }
                ans = max(ans, pre)
            }
            return ans
        }
    }
}