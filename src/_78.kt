class _78 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val ans = subsets(intArrayOf(1, 2, 3))
            println(ans.joinToString())
        }

        fun subsets(nums: IntArray): List<List<Int>> {
            val ans = mutableListOf<List<Int>>()
            dfs(nums, 0, ans, mutableListOf<Int>())
            return ans
        }

        private fun dfs(nums: IntArray, k: Int, ans: MutableList<List<Int>>, line: MutableList<Int>) {
            ans.add(line.toList())
            if (k >= nums.size)
                return
            for (i in k until nums.size) {
                line.add(nums[i])
                dfs(nums, i + 1, ans, line)
                line.removeLast()
            }
        }


        fun subsets2(nums: IntArray): List<List<Int>> {
            val ans = mutableListOf<List<Int>>()
            val line = mutableListOf<Int>()
            val size = 1.shl(nums.size) - 1
            for (mask in 0..size) {
                for (i in nums.indices) {
                    if (mask.and(1.shl(i)) == 1) {
                        line.add(nums[i])
                    }
                }
                ans.add(line.toList())
                line.clear()
            }
            return ans
        }

    }
}