class _977 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).joinToString())
        }

        fun sortedSquares(nums: IntArray): IntArray {
            var lo = 0
            var hi = nums.size - 1
            val result = IntArray(nums.size)

            var idx = nums.size - 1
            while (lo <= hi) {
                val t = when {
                    nums[lo] > 0 -> {
                        nums[hi] * nums[hi--]
                    }
                    -nums[lo] > nums[hi] -> {
                        nums[lo] * nums[lo++]
                    }
                    else -> {
                        nums[hi] * nums[hi--]
                    }
                }
                result[idx--] = t
            }

            return result
        }
    }
}