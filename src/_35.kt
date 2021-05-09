class _35 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(searchInsert(intArrayOf(1, 3, 5, 6), 7))
        }

        fun searchInsert(nums: IntArray, target: Int): Int {
            var lo = 0
            var hi = nums.size - 1
            while (lo <= hi) {
                val mid = lo + (hi - lo) / 2
                if (nums[mid] == target) {
                    return mid
                } else if (nums[mid] < target) {
                    lo = mid + 1
                } else {
                    hi = mid - 1
                }
            }

            return lo
        }
    }
}