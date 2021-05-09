import kotlin.math.max

class _53 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println(maxSubArray(intArrayOf(1)))
        }

        fun maxSubArray(nums: IntArray): Int {
            var max = nums[0]
            var curr = nums[0]
            for (i in 1 until nums.size) {
                if (nums[i] >= curr + nums[i]) {
                    curr = nums[i]
                } else {
                    curr += nums[i]
                }
                max = Math.max(max, curr)
            }
            return max
        }
    }
}