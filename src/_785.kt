class _785 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val graph = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(0, 2),
                intArrayOf(0, 1, 3),
                intArrayOf(0, 2),
            )
            val graph2 = arrayOf(
                intArrayOf(1,3),
                intArrayOf(0, 2),
                intArrayOf(1, 3),
                intArrayOf(0, 2),
            )
            println(isBipartite(graph2))
        }

        fun isBipartite(graph: Array<IntArray>): Boolean {
            val color = IntArray(graph.size) { -1 }
            for (i in graph.indices) {
                if (color[i] == -1 && !dfs(graph, i, 0, color))
                    return false
            }
            return true
        }

        private fun dfs(graph: Array<IntArray>, k: Int, color: Int, colors: IntArray): Boolean {
            if (colors[k] >= 0) {
                return colors[k] == color
            }
            colors[k] = color
            for (v in graph[k]) {
                if (!dfs(graph, v, (color + 1) % 2, colors)) {
                    return false
                }
            }
            return true
        }
    }
}