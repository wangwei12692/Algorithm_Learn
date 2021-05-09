class _1480 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun runningSum(nums: IntArray): IntArray {
            val ans = IntArray(nums.size)
            ans[0] = nums[0]
            for (i in 1 until nums.size) {
                ans[i] = nums[i] + ans[i - 1]
            }
            return ans
        }
    }
}