class _1365 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                smallerNumbersThanCurrent(
                    intArrayOf(
                        8, 1, 2, 2, 3
                    )
                ).joinToString()
            )
        }

        fun smallerNumbersThanCurrent2(nums: IntArray): IntArray {
            val cnt = IntArray(101)
            val n = nums.size
            for (i in 0 until n) {
                cnt[nums[i]]++
            }
            for (i in 1..100) {
                cnt[i] += cnt[i - 1]
            }
            val ans = IntArray(n)
            for (i in 0 until n) {
                ans[i] = if (nums[i] == 0) 0 else cnt[nums[i] - 1]
            }
            return ans
        }

        fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
            val n = nums.size
            val data = Array(n) { IntArray(2) }
            for ((i, v) in nums.withIndex()) {
                data[i][0] = i
                data[i][1] = v
            }
            data.sortBy { it[1] }
            var pre = -1
            val ans = IntArray(n)
            for (i in 0 until n) {
                if (pre == -1 || data[i][1] != data[i - 1][1]) {
                    pre = i
                }
                ans[data[i][0]] = pre
            }
            return ans
        }
    }
}