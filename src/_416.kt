import java.util.*

class _416 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(canPartition(intArrayOf(1, 5, 11, 5)))
            println(canPartition3(intArrayOf(1, 5, 11, 5)))
        }

        fun canPartition(nums: IntArray): Boolean {
            val sum = nums.sum()
            if (sum % 2 == 1) return false
            return dfs(nums, 0, sum / 2)
        }

        private fun dfs(nums: IntArray, k: Int, curr: Int): Boolean {
            if (curr == 0)
                return true
            if (k >= nums.size)
                return false
            if (curr < 0)
                return false
            for (i in k until nums.size) {
                if (dfs(nums, i + 1, curr - nums[i]))
                    return true
            }
            return false
        }

        private fun dfs2(nums: IntArray, k: Int, curr: Int): Boolean {
            if (curr == 0)
                return true
            if (k >= nums.size)
                return false
            val take = dfs2(nums, k + 1, curr - nums[k])
            val no_take = dfs2(nums, k + 1, curr)
            return take || no_take
        }

        fun canPartition2(nums: IntArray): Boolean {
            if (nums.size <= 1)
                return false
            val sum = nums.sum()
            if (sum % 2 == 1)
                return false
            //转换成 0 1 背包问题
            val target = sum / 2
            val dp = BooleanArray(target + 1)
            dp[0] = true
            for (n in nums) {
                for (v in target downTo 0) {
                    dp[v] = dp[v] || v - n >= 0 && dp[v - n]
                }
            }

            return dp[sum / 2]
        }


        /**
         *      0  1  2  3  4  5  6  7  8  9  10 11
            0  [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
            1  [1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
            5  [1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0]
            11 [1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1]
            5  [1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1]
         */
        fun canPartition3(nums: IntArray): Boolean {
            if (nums.size <= 1) return false
            val sum = Arrays.stream(nums).sum()
            if (sum and 1 == 1) {
                return false
            }
            val dp = Array(nums.size + 1) { BooleanArray(sum / 2 + 1) }
            dp[0][0] = true

            for (i in 1..nums.size) {
                for (j in 0..sum / 2) {
                    //dp[i][j] =  dp[i-1][j] or  dp[i-1][j - c[i]]
                    dp[i][j] = dp[i - 1][j] || j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]]
                }
            }
            println(dp.map { it.map { if (it) 1 else 0 } }.joinToString())
            return dp[nums.size][sum / 2]
        }
    }
}