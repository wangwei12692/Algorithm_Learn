class _1470 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun shuffle(nums: IntArray, n: Int): IntArray {
            val ans = IntArray(n * 2)
            var i = 0
            var idx = 0
            while (i < n) {
                ans[idx++] = nums[i]
                ans[idx++] = nums[n + i]
                i++
            }
            return ans
        }
    }
}