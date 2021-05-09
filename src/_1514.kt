import java.util.*

class _1514 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                maxProbability(
                    3,
                    arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 2)),
                    doubleArrayOf(0.5, 0.5, 0.2),
                    0,
                    2
                )
            )
            println(
                maxProbability2(
                    3,
                    arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 2)),
                    doubleArrayOf(0.5, 0.5, 0.2),
                    0,
                    2
                )
            )
        }

        data class Cost(val u: Int, val prob: Double)

        fun maxProbability2(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
            val graph = Array(n) { mutableSetOf<Int>() }
            val prob = Array(n) { DoubleArray(n) }
            for ((idx, edge) in edges.withIndex()) {
                val (u, v) = edge
                graph[v].add(u)
                graph[u].add(v)
                prob[u][v] = succProb[idx]
                prob[v][u] = succProb[idx]
            }
            val distTo = DoubleArray(n)
            distTo[start] = 1.0
            val q = PriorityQueue<Cost>(compareBy { 1 - it.prob })
            q.offer(Cost(start, 1.0))
            while (q.isNotEmpty()) {
                val (u, cost) = q.poll()
                for (v in graph[u]) {
                    if (distTo[v] < distTo[u] * prob[u][v]) {
                        distTo[v] = distTo[u] * prob[u][v]
                        q.offer(Cost(v, distTo[v]))
                    }
                }
            }
            return distTo[end]
        }

        fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
            val graph = Array(n) { mutableSetOf<Int>() }
            val prob = Array(n) { DoubleArray(n) }
            for ((idx, edge) in edges.withIndex()) {
                val (u, v) = edge
                graph[v].add(u)
                graph[u].add(v)
                prob[u][v] = succProb[idx]
                prob[v][u] = succProb[idx]
            }
            val marked = BooleanArray(n)
            return dfs(graph, prob, start, end, 1.0, marked)
        }

        private fun dfs(
            graph: Array<MutableSet<Int>>,
            prob: Array<DoubleArray>,
            start: Int,
            to: Any,
            res: Double,
            marked: BooleanArray
        ): Double {
            if (start == to)
                return res
            marked[start] = true
            var ans = Double.MIN_VALUE
            for (u in graph[start]) {
                if (marked[u]) continue
                val t = dfs(graph, prob, u, to, res * prob[start][u], marked)
                if (t != Double.MIN_VALUE) {
                    ans = Math.max(ans, t)
                }
            }
            marked[start] = false
            return ans
        }
    }
}