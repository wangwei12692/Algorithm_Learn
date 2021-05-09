class _90 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(subsetsWithDup(intArrayOf(1, 2, 2)))
        }

        fun subsetsWithDup(nums: IntArray): List<List<Int>> {
            nums.sort()
            val ans = mutableListOf<List<Int>>()
            dfs(nums, 0, mutableListOf<Int>(), ans)
            return ans
        }

        private fun dfs(nums: IntArray, k: Int, line: MutableList<Int>, ans: MutableList<List<Int>>) {
            ans.add(line.toList())

            var i = k
            while (i < nums.size) {
                line.add(nums[i])
                dfs(nums, i + 1, line, ans)
                line.removeLast()
                while (i + 1 < nums.size && nums[i + 1] == nums[i])
                    i++
                i++
            }
        }
    }
}