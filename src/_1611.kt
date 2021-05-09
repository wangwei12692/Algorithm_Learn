class _1611 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(divingBoard(1, 2, 3).joinToString())
        }

        fun divingBoard(shorter: Int, longer: Int, k: Int): IntArray {
            val ans = mutableSetOf<Int>()
            dfs(intArrayOf(shorter, longer), 0, 3, ans, 0)
            return ans.toIntArray()
        }

        private fun dfs(nums: IntArray, k: Int, n: Int, ans: MutableSet<Int>, sum: Int) {
            if (n == 0) {
                ans.add(sum)
                return
            }
            for (i in k until nums.size) {
                dfs(nums, k, n - 1, ans, sum + nums[i])
            }
        }
    }
}