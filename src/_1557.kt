class _1557 {
    companion object {
        fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
            val deg = IntArray(n)
            for ((u, v) in edges) {
                deg[v]++
            }
            return deg.foldIndexed(mutableListOf<Int>()) { index, acc, v ->
                if (v == 0) acc.add(index)
                acc
            }
        }
    }
}