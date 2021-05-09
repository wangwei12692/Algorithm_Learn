class _1462 {
    companion object {
        fun checkIfPrerequisite(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
            val graph = Array(n) { mutableListOf<Int>() }
            for ((u, v) in prerequisites) {
                graph[u].add(v)
            }
            return queries.map { dfs(graph, it[0], it[1]) }
        }

        private fun dfs(graph: Array<MutableList<Int>>, start: Int, to: Int): Boolean {
            if (start == to) {
                return true
            }
            for (u in graph[start]) {
                if (dfs(graph, u, to)) {
                    return true
                }
            }
            return false
        }

        //弗洛伊德
        fun checkIfPrerequisite2(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
            val dp = Array(n) { BooleanArray(n) }
            for ((u, v) in prerequisites) {
                dp[u][v] = true
            }
            for (k in 0 until n) {
                for (i in 0 until n) {
                    for (j in 0 until n) {
                        if (dp[i][j]) continue
                        if (dp[i][k] && dp[k][j])
                            dp[i][j] = true
                    }
                }
            }
            return queries.map { dp[it[0]][it[1]] }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            checkIfPrerequisite2(
                3, arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 0),
                    intArrayOf(2, 0),
                ), arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                )
            )
        }
    }
}