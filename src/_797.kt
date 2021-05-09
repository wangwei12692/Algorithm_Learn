class _797 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                allPathsSourceTarget(
                    arrayOf(
                        intArrayOf(4,3,1),
                        intArrayOf(3,2,4),
                        intArrayOf(3),
                        intArrayOf(4),
                        intArrayOf()
                    )
                )
            )
        }

        fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
            val ans = mutableListOf<List<Int>>()
            dfs(graph, 0, ans, mutableListOf<Int>(0))
            return ans
        }

        private fun dfs(graph: Array<IntArray>, k: Int, ans: MutableList<List<Int>>, line: MutableList<Int>) {
            if (k == graph.size - 1) {
                ans.add(line.toList())
                return
            }
            for (next in graph[k]) {
                line.add(next)
                dfs(graph, next, ans, line)
                line.removeLast()
            }
        }
    }
}