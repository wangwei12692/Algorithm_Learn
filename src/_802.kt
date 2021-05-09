class _802 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(eventualSafeNodes2(arrayOf(
                intArrayOf(1,2),
                intArrayOf(2,3),
                intArrayOf(5),
                intArrayOf(0),
                intArrayOf(5),
                intArrayOf(),
                intArrayOf(),
            )))
        }
        fun eventualSafeNodes2(graph: Array<IntArray>): List<Int> {
            val colors = IntArray(graph.size)
            val ans = mutableListOf<Int>()
            for (i in graph.indices) {
                if (dfs(graph, i, colors))
                    ans.add(i)
            }
            return ans
        }

        private fun dfs(graph: Array<IntArray>, k: Int, colors: IntArray): Boolean {
            if (colors[k] >= 1) {
                return colors[k] == 2
            }
            colors[k] = 1
            for (v in graph[k]) {
                if (colors[v] == 1 || !dfs(graph, v, colors))
                    return false
            }
            colors[k] = 2
            return true
        }
    }
}