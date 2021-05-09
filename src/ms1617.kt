class ms1617 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                maxSubArray2(
                    intArrayOf(
                        -2, 1, -3, 4, -1, 2, 1, -5, 4
                    )
                )
            )
        }

        fun maxSubArrayDp(nums: IntArray): Int {
            if (nums.size == 0) {
                return 0
            }
            val dp = IntArray(nums.size)
            dp[0] = nums[0]
            for (i in nums.indices) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i])
            }
            return dp.max()!!
        }

        fun maxSubArray(nums: IntArray): Int {
            var max = 0
            var preMax = 0
            for (i in nums.indices) {
                if (nums[i] >= max + nums[i]) {
                    max = nums[i]
                } else {
                    max += nums[i]
                }
                preMax = Math.max(max, preMax)
            }
            return preMax
        }

        //分治
        data class Status(val lSum: Int, val rSum: Int, val mSum: Int, val iSum: Int)


        fun maxSubArray2(nums: IntArray): Int {
            return split(nums, 0, nums.size - 1).mSum
        }

        private fun split(nums: IntArray, from: Int, to: Int): Status {
            if (from == to) {
                return Status(nums[from], nums[from], nums[from], nums[from])
            }
            val mid = (from + to) / 2
            val left = split(nums, from, mid)
            val right = split(nums, mid+1, to)
            return merge(left,right)
        }

        private fun merge(left: Status, right: Status): Status {
            val iSum = left.iSum + right.iSum
            val lSum = Math.max(left.lSum, left.iSum + right.lSum)
            val rSum = Math.max(right.rSum, right.iSum + left.rSum)
            val mSum = Math.max(Math.max(left.mSum, right.mSum), left.rSum + right.lSum)
            return Status(lSum, rSum, mSum, iSum)
        }
    }
}