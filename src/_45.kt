import kotlin.math.min

class _45 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(jump(intArrayOf(1,2,1,1,1)))
        }

        fun jump(nums: IntArray): Int {
            val dp = IntArray(nums.size) { nums.size + 1 }
            dp[0] = 0
            for (i in 1 until dp.size) {
                for (j in 0 until i) {
                    if (j + nums[j] >= i) {
                        dp[i] = min(dp[i], dp[j] + 1)
                    }
                }
            }
            return dp.last()
        }
    }
}