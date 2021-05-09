import java.util.*
import kotlin.math.abs

class _1631 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                minimumEffortPath(
                    arrayOf(
                        intArrayOf(1, 2, 3),
                        intArrayOf(3, 8, 4),
                        intArrayOf(5, 3, 5)
                    )
                )
            )
        }

        private val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        private data class Cost(val x: Int, val y: Int, val cost: Int)

        fun minimumEffortPath(heights: Array<IntArray>): Int {
            val n = heights.size
            val m = heights[0].size
            val distTo = Array(n) { IntArray(m) { Int.MAX_VALUE } }
            distTo[0][0] = 0
            val pq = PriorityQueue<Cost>(compareBy { it.cost })
            pq.offer(Cost(0, 0, 0))
            while (pq.isNotEmpty()) {
                val (x, y, cost) = pq.poll()
                for ((xd, yd) in dirs) {
                    val nx = x + xd
                    val ny = y + yd
                    if (nx in 0 until n && ny in 0 until m) {
                        if (distTo[nx][ny] > abs(heights[x][y] - heights[nx][ny])) {
                            distTo[nx][ny] = abs(heights[x][y] - heights[nx][ny])
                            pq.offer(Cost(nx, ny, distTo[nx][ny]))
                        }
                    }
                }
            }
            return distTo[n - 1][m - 1]
        }

        data class Edge(val u: Int, val v: Int, val weight: Int)

        fun minimumEffortPathUnionFind(heights: Array<IntArray>): Int {
            val m = heights.size
            val n = heights[0].size
            val edges = mutableListOf<Edge>()
            for (i in 0 until m) {
                for (j in 0 until n) {
                    val id = i * n + j
                    if (i > 0) {
                        edges.add(Edge(id, id - n, abs(heights[i][j] - heights[i - 1][j])))
                    }
                    if (j > 0) {
                        edges.add(Edge(id, id - 1, abs(heights[i][j] - heights[i][j - 1])))
                    }
                }
            }
            edges.sortBy { it.weight }

            val uf = UnionFind(m * n)
            var ans = 0
            for ((u, v, weight) in edges) {
                uf.union(u, v)
                if (uf.find(0) == uf.find(m * n - 1)) {
                    ans = weight
                    break
                }
            }
            return ans
        }
    }
}