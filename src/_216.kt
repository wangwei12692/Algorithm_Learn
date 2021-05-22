class _216 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(combinationSum3(3, 9))
        }

        fun combinationSum3(k: Int, n: Int): List<List<Int>> {
            val nums = IntArray(n) { it + 1 }
            val ans = mutableListOf<List<Int>>()
            dfs(nums,k, 0, 0, n, mutableListOf<Int>(), ans)
            return ans
        }

        private fun dfs(
            nums: IntArray,
            count:Int,
            k: Int,
            sum: Int,
            target: Int,
            line: MutableList<Int>,
            ans: MutableList<List<Int>>
        ) {
            if (line.size > count || sum > target) {
                return
            }
            if (sum == target) {
                if (line.size == count) {
                    ans.add(line.toList())
                }
                return
            }
            if (k >= nums.size)
                return
            for (i in k until nums.size) {
                line.add(nums[i])
                dfs(nums, count,i + 1, sum + nums[i], target, line, ans)
                line.removeAt(line.lastIndex)
            }
        }
    }
}