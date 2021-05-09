class _34 {
    companion object {
        fun searchRange(nums: IntArray, target: Int): IntArray {
            val ans = intArrayOf(-1, -1)
            var lo = 0
            var hi = nums.size - 1
            while (lo <= hi) {
                val mid = (hi - lo) / 2 + lo
                if (target - nums[mid] == 0) {
                    while (hi > lo && nums[hi] == nums[hi - 1]) {
                        hi--
                    }
                    while (hi > lo && nums[lo] == nums[lo + 1]) {
                        lo++
                    }
                    ans[0] = lo
                    ans[1] = hi
                    break
                } else if (target < nums[mid]) {
                    hi = mid - 1
                } else {
                    lo = mid + 1
                }
            }

            return ans
        }

        fun searchRange2(nums: IntArray, target: Int): IntArray {
            val ans = intArrayOf(-1, -1)
            ans[0] = findBarrier(nums, target, true)
            ans[1] = findBarrier(nums, target, false)
            return ans
        }

        private fun findBarrier(nums: IntArray, target: Int, left: Boolean): Int {
            var lo = 0
            var hi = nums.size - 1
            var ans = -1
            while (lo <= hi) {
                val mid = lo + (hi - lo) / 2
                if (nums[mid] == target) {
                    hi = mid - 1
                } else if (nums[mid] < target) {
                    lo = mid + 1
                } else {
                    ans = mid
                    if (left)
                        hi = mid - 1
                    else
                        lo = mid + 1
                }
            }
            return ans
        }

    }
}