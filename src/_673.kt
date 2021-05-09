import java.util.*
import kotlin.math.max

class _673 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(findNumberOfLIS(intArrayOf(2, 2, 2, 2, 2)))
        }

        fun findNumberOfLIS(nums: IntArray): Int {
            val n = nums.size
            val dp = IntArray(n) { 1 }
            val count = IntArray(n) { 1 }
            var maxLen = 1
            for (i in 0 until n) {
                for (j in 0 until i) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1
                            count[i] = count[j]
                        } else if (dp[j] + 1 == dp[i]) {
                            count[i] += count[j]
                        }
                        maxLen = max(maxLen, dp[i])
                    }
                }
            }
            var ans = 0
            for ((i, v) in count.withIndex()) {
                if (dp[i] == maxLen) {
                    ans += v
                }
            }
            return ans
        }
    }
}