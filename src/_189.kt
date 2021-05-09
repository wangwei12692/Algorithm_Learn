class _189 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
            rotate(nums, 3)
//            println(nums.joinToString())
        }

        fun rotate(nums: IntArray, k: Int): Unit {
            val n = nums.size
            val offset = k % nums.size
            nums.revert(0, n - offset - 1)
            nums.revert(n - offset, n - 1)
            nums.revert(0, n - 1)
        }

        fun IntArray.revert(lh: Int, rh: Int) {
            var lo = lh
            var hi = rh
            while (lo < hi) {
                swap(lo++, hi--)
            }
        }

        fun IntArray.swap(i: Int, j: Int) {
            val tmp = this[i]
            this[i] = this[j]
            this[j] = tmp
        }
    }
}