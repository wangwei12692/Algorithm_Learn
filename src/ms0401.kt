class ms0401 {
    companion object {
        fun findWhetherExistsPath(n: Int, edges: Array<IntArray>, start: Int, target: Int): Boolean {
            val graph = Array(n) { mutableListOf<Int>() }
            for ((u, v) in edges) {
                graph[u].add(v)
            }
            val marked = BooleanArray(n)
            return dfs(graph, start, target, marked)
        }

        private fun dfs(graph: Array<MutableList<Int>>, start: Int, target: Int, marked: BooleanArray): Boolean {
            if (start == target)
                return true
            marked[start] = true
            for (v in graph[start]) {
                if (marked[v]) continue
                if (dfs(graph, v, target, marked)) {
                    return true
                }
            }
            marked[start] = false
            return false
        }
    }
}