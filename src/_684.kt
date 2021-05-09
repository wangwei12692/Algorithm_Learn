import java.util.*

class _684 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                findRedundantConnection2(
                    arrayOf(
                        intArrayOf(1, 2),
                        intArrayOf(2, 3),
                        intArrayOf(3, 4),
                        intArrayOf(1, 4),
                        intArrayOf(1, 5)
                    )
                ).joinToString(",")
            )
        }

        fun findRedundantConnection2(edges: Array<IntArray>): IntArray {
            val n = edges.size
            val uf = UnionFind(n + 1)
            for (i in 0 until n) {
                val (u, v) = edges[i]
                if (!uf.union(u, v)) {
                    return intArrayOf(u, v)
                }
            }
            return intArrayOf()
        }

        fun findRedundantConnection(edges: Array<IntArray>): IntArray {
            val n = edges.size
            val graph = Array(n + 1) { mutableListOf<Int>() }
            val flag = Array(n + 1) { IntArray(n + 1) }
            val deg = IntArray(n + 1)
            for ((v, u) in edges) {
                graph[v].add(u)
                graph[u].add(v)
                deg[v]++
                deg[u]++
                flag[v][u] = 1
                flag[u][v] = 1
            }
            val q: Queue<Int> = LinkedList()
            for (i in deg.indices) {
                if (deg[i] == 1)
                    q.offer(i)
            }
            while (q.isNotEmpty()) {
                val u = q.poll()
                for (w in graph[u]) {
                    deg[w]--
                    if (deg[w] == 1)
                        q.offer(w)
                    flag[u][w] = 0
                    flag[w][u] = 0
                }
            }
            for (i in n - 1 downTo 0) {
                val (v, w) = edges[i]
                if (flag[v][w] == 1)
                    return intArrayOf(v, w)
            }
            return intArrayOf()
        }

    }
}