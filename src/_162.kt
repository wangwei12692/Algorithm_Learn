class _162 {
    companion object {
        fun findPeakElement(nums: IntArray): Int {
            for (i in 0 until nums.size) {
                if (nums[i] > nums[i + 1])
                    return i
            }
            return nums.size - 1
        }


        fun findPeakElement2(nums: IntArray): Int {
            var lo = 0
            var hi = nums.size - 1
            while (lo < hi) {
                val mid = (lo + hi) / 2
                if (nums[mid] > nums[mid + 1]) {
                    hi = mid
                } else {
                    lo = mid + 1
                }
            }
            return lo
        }
    }
}