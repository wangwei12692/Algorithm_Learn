class _77 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(combine(4, 2))
        }

        fun combine(n: Int, k: Int): List<List<Int>> {
            val ans = mutableListOf<List<Int>>()
            val nums = IntArray(n) { it + 1 }
            dfs(nums, 0, k, mutableListOf<Int>(), ans)
            return ans
        }

        private fun dfs(nums: IntArray, i: Int, k: Int, line: MutableList<Int>, ans: MutableList<List<Int>>) {
            if (line.size == k) {
                ans.add(line.toList())
                return
            }
            if (i >= nums.size) {
                return
            }
            for (j in i until nums.size) {
                line.add(nums[j])
                dfs(nums, j + 1, k, line, ans)
                line.removeAt(line.size - 1)
            }
        }
    }
}