class _39 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(combinationSum(intArrayOf(2, 3, 5), 8))
        }

        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val ans = mutableListOf<List<Int>>()
            dfs(candidates, 0, target, ans, mutableListOf<Int>())
            return ans
        }

        private fun dfs(
            candidates: IntArray,
            k: Int,
            target: Int,
            ans: MutableList<List<Int>>,
            line: MutableList<Int>
        ) {
            if (k >= candidates.size || target < 0) {
                return
            }
            if (target == 0) {
                ans.add(line.toList())
                return
            }

            for (i in k until candidates.size) {
                line.add(candidates[i])
                dfs(candidates, i, target - candidates[i], ans, line)
                line.removeAt(line.size - 1)
            }
        }
    }
}