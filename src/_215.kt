import sort.swap

class _215 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
        }

        fun findKthLargest(nums: IntArray, k: Int): Int {
            if (k >= nums.size)
                return -1
            quickSort(nums, 0, nums.size - 1)
            return nums[nums.size - k]
        }

        private fun quickSort(nums: IntArray, lo: Int, hi: Int) {
            if (lo >= hi) return
            val idx = part(nums, lo, hi)
            quickSort(nums, lo, idx - 1)
            quickSort(nums, idx + 1, hi)
        }

        private fun part(nums: IntArray, lo: Int, hi: Int): Int {
            var idx = lo + 1
            for (i in (lo + 1)..hi) {
                if (nums[i] < nums[lo]) {
                    nums.swap(i, idx)
                    idx++
                }
            }
            nums.swap(idx - 1, lo)
            return idx - 1
        }

        fun IntArray.swap(i: Int, j: Int) {
            val t = this[i]
            this[i] = this[j]
            this[j] = t
        }
    }
}