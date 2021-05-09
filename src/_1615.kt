class _1615 {
    companion object {
        fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
            val edges = Array(n) { IntArray(n) }
            val deg = IntArray(n)
            for ((u, v) in roads) {
                edges[u][v]++
                edges[v][u]++
                deg[v]++
                deg[u]++
            }
            var ans = Int.MAX_VALUE
            for (i in 0 until n) {
                for (j in i + 1 until n) {
                    ans = Math.max(ans, deg[i] + deg[j] - edges[i][j])
                }
            }
            return ans
        }
    }
}