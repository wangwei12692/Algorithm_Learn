class ms0803 {
    companion object {
        fun findMagicIndex(nums: IntArray): Int {
            var i = 0
            while (i < nums.size) {
                when {
                    nums[i] < 0 -> i++
                    nums[i] == i -> return i
                    nums[i] > i -> i += nums[i] - i
                    else -> i++
                }
            }
            return -1
        }
    }
}