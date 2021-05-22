class _137 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(singleNumber(intArrayOf(1, 1, 1, 2)))
        }

        fun singleNumber(nums: IntArray): Int {
            var ans = 0
            for (i in 0..31) {
                var total = 0
                for (n in nums) {
                    total += n.shr(i).and(1)
                }
                if (total % 3 != 0) {
                    ans = ans.or(1.shl(i))
                }
            }
            return ans
        }
    }
}