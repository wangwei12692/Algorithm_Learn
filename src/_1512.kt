class _1512 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun numIdenticalPairs(nums: IntArray): Int {
            val count = IntArray(101)
            for (i in nums) {
                count[i]++
            }
            var ans = 0
            for (i in count) {
                ans += (i - 1) * i / 2
            }
            return ans
        }
    }
}