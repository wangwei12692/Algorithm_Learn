class _33 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(search(intArrayOf(3, 1), 1))
        }

        fun search(nums: IntArray, target: Int): Int {
            var lo = 0
            var hi = nums.size - 1
            while (lo <= hi) {
                val mid = lo + (hi - lo) / 2
                println("$lo .$mid. $hi")
                if (nums[mid] == target)
                    return mid
                else if (nums[mid] >= nums[0]) {
                    // mid 在左半段
                    if (target >= nums[0] && target < nums[mid]) {
                        // 判断target 的位置
                        hi = mid - 1
                    } else {
                        lo = mid + 1
                    }
                } else {
                    // mid 在右半段
                    // 判断target 的位置
                    if (target > nums[mid] && target <= nums[nums.size - 1]) {
                        lo = mid + 1
                    } else {
                        hi = mid - 1
                    }
                }
            }
            return -1
        }

    }
}