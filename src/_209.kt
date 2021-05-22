class _209 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))

        }

        fun minSubArrayLen(target: Int, nums: IntArray): Int {
            if (nums.size == 0)
                return 0
            var lo = 0
            var hi = 0
            var ans = Int.MAX_VALUE
            var sum = 0
            while (hi < nums.size) {
                sum += nums[hi]
                while (sum >= target) {
                    ans = Math.min(ans, hi - lo + 1)
                    sum -= nums[lo]
                    lo++
                }
                hi++
            }
            return if (ans == Int.MAX_VALUE) 0 else ans
        }
    }
}