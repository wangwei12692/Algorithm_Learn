class _238 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        /**
         * 输入: [1,2,3,4]
        输出: [24,12,8,6]
         */
        fun productExceptSelf(nums: IntArray): IntArray {
            val n = nums.size
            val l = IntArray(n)
            val r = IntArray(n)

            val ans = IntArray(n)
            l[0] = 1
            for (i in 1 until n) {
                l[i] = l[i - 1] * nums[i - 1]
            }
            r[n - 1] = 1
            for (i in n - 2 downTo 0) {
                r[i] = nums[i + 1] * r[i + 1]
            }

            for (i in 0..n) {
                ans[i] = l[i] * r[i]
            }
            return ans
        }


        fun productExceptSelf2(nums: IntArray): IntArray {
            val n = nums.size
            val ans = IntArray(n)
            ans[0] = 1
            for (i in 1 until n) {
                ans[i] = ans[i - 1] * nums[i - 1]
            }
            var r = 1
            for (i in n - 1 downTo 0) {
                ans[i] = ans[i] * r
                r *= nums[i]
            }
            return ans
        }
    }
}