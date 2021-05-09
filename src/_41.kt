class _41 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(firstMissingPositive(intArrayOf(1, 3, 4, 5)))
        }

        fun firstMissingPositive(nums: IntArray): Int {
            val n = nums.size
            for ((i, v) in nums.withIndex()) {
                if (v <= 0) {
                    nums[i] = n + 1
                }
            }
            for ((i, v) in nums.withIndex()) {
                val num = Math.abs(v)
                if (num <= n) {
                    nums[num - 1] = -Math.abs(nums[num - 1])
                }
            }
            for ((i, v) in nums.withIndex()) {
                if (nums[i] > 0) {
                    return i + 1
                }
            }
            return n + 1
        }
    }
}