import javax.sound.midi.Soundbank

class _55 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(canJump2(intArrayOf(2, 3, 1, 1, 4)))
        }

        fun canJump(nums: IntArray): Boolean {
            val n = nums.size
            val dp = BooleanArray(n)
            dp[0] = true
            var maxJump = nums[0]
            for (i in 1 until nums.size) {
                dp[i] = dp[i - 1] && maxJump > 0
                maxJump = Math.max(nums[i], maxJump - 1)
            }
            return dp[n - 1]
        }


        fun canJump2(nums: IntArray): Boolean {
            //从 0 能挑到的最大长度
            var maxJump = nums[0]
            for (i in 1 until nums.size) {
                if (i <= maxJump) {
                    maxJump = Math.max(nums[i] + i, maxJump)
                }
            }
            return maxJump >= nums.size - 1
        }

        fun canJump3(nums: IntArray): Boolean {
            var last = nums.size - 1
            for (i in nums.size - 2 downTo 0) {
                if (nums[i] + i >= last)
                    last = i
            }
            return last == 0
        }
    }
}