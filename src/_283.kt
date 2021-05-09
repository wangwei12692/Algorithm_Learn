import _189.Companion.swap

class _283 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(0, 1, 0, 3, 12)
            moveZeroes(nums)
            println(nums.joinToString())
        }

        fun moveZeroes(nums: IntArray): Unit {
            var idx = 0
            for (num in nums) {
                if (num == 0) continue
                nums[idx++] = num
            }
            for (i in idx until nums.size) {
                nums[i] = 0
            }
        }

        fun moveZeroes2(nums: IntArray): Unit {
            var left = 0
            var right = 0
            while (right < nums.size) {
                if (nums[right] != 0) {
                    nums.swap(left, right)
                    left++
                }
                right++
            }
        }

    }
}