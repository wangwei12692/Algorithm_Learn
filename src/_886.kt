class _886 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                possibleBipartition(
                    5, arrayOf(
                        intArrayOf(1, 2),
                        intArrayOf(2, 3),
                        intArrayOf(3, 4),
                        intArrayOf(4, 5),
                        intArrayOf(1, 5),
                    )
                )
            )
        }
        fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
            val graph = Array(N + 1) { mutableSetOf<Int>() }
            for ((u, v) in dislikes) {
                graph[u].add(v)
                graph[v].add(u)
            }
            val colors = IntArray(N + 1) { -1 }
            for (i in 1..N) {
                if (colors[i] == -1 && !dfs(graph, i, 0, colors)) {
                    return false
                }
            }
            return true
        }

        private fun dfs(graph: Array<MutableSet<Int>>, u: Int, color: Int, colors: IntArray): Boolean {
            if (colors[u] >= 0) {
                return colors[u] == color
            }
            colors[u] = color
            for (v in graph[u]) {
                if (!dfs(graph, v, (color + 1) % 2, colors)) {
                    return false
                }
            }
            return true
        }
    }
}