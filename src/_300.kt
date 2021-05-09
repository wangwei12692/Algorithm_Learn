import java.util.*
import kotlin.math.max

class _300 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
        }

        fun lengthOfLIS2(nums: IntArray): Int {
            val res = IntArray(nums.size)
            var len = 0
            for (n in nums) {
                var idx = nums.binarySearch(n, 0, len)
                idx = if (idx < 0) -idx - 1 else idx
                res[idx] = n
                if (idx == len) {
                    len++
                }
            }

            return len
        }

        fun lengthOfLIS(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            val dp = IntArray(nums.size) { 1 }
            for (i in nums.indices) {
                for (j in 0 until i) {
                    if (nums[i] > nums[j])
                    //考虑后面所有的元素
                        dp[i] = max(dp[i], dp[j] + 1)
                }
            }
            return dp.max()!!
        }
    }
}