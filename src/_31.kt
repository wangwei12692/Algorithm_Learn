class _31 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(1,5,1)
            nextPermutation(nums)
            println(nums.joinToString())
        }

        fun nextPermutation(nums: IntArray): Unit {
            var t = -1
            for (i in nums.size - 1 downTo 0) {
                if (i + 1 < nums.size && nums[i] < nums[i + 1]) {
                    t = i
                    break
                }
            }

            if (t == -1) {
                return nums.sort()
            }
            val l = nums[t]
            nums[t] = nums[t + 1]
            nums[t + 1] = l
            nums.sort(t + 1)
        }
    }
}