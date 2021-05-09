class jz53 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(missingNumber2(intArrayOf(0,1,2,4,5)))
        }

        fun missingNumber(nums: IntArray): Int {
            if (nums[0] != 0)
                return 0
            for (i in 1 until nums.size) {
                if (nums[i] - nums[i - 1] > 1) {
                    return nums[i - 1] + 1
                }
            }
            return -1
        }

        fun missingNumber2(nums: IntArray): Int {
            var lo = 0
            var hi = nums.size - 1
            while (lo <= hi) {
                val mid = (hi - lo) / 2 + lo
                if (nums[mid] == mid)
                    lo = mid + 1
                else
                    hi = mid - 1
            }
            return lo
        }

    }
}