class _40 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
        }

        fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
            candidates.sort()
            val ans = mutableListOf<List<Int>>()
            dfs(candidates, target, 0, 0, mutableListOf<Int>(), ans)
            return ans
        }

        private fun dfs(
            candidates: IntArray,
            target: Int,
            k: Int,
            current: Int,
            line: MutableList<Int>,
            ans: MutableList<List<Int>>
        ) {
            if (current > target) {
                return
            }
            if (current == target) {
                ans.add(line.toList())
                return
            }
            if (k >= candidates.size) {
                return
            }
            var i = k
            while (i < candidates.size) {
                line.add(candidates[i])
                dfs(candidates, target, i + 1, current + candidates[i], line, ans)
                line.removeLast()
                while (i + 1 < candidates.size && candidates[i + 1] == candidates[i]) {
                    i++
                }
                i++
            }
        }
    }
}