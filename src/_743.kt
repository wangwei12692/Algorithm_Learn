import java.util.*
import kotlin.math.cos

class _743 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                networkDelayTime(
                    arrayOf(
                        intArrayOf(2,1,1),
                        intArrayOf(2,3,1),
                        intArrayOf(3,4,1)
                    ), 4, 2
                )
            )
        }


        data class Edge(val from: Int, val to: Int, val cost: Int)
        data class Cost(val node: Int, val cost: Int)

        //Dijkstra's
        fun networkDelayTime2(times: Array<IntArray>, n: Int, k: Int): Int {
            val graph = Array(n + 1) { mutableSetOf<Edge>() }
            for ((u, v, w) in times) {
                val edge = Edge(u, v, w)
                graph[u].add(edge)
            }

            val distTo = IntArray(n + 1) { if (it == k || it == 0) 0 else Int.MAX_VALUE }

            val pq = PriorityQueue<Cost>(compareBy { it.cost })
            pq.offer(Cost(k, 0))
            while (pq.isNotEmpty()) {
                val (node, cost) = pq.poll()
                for ((nfrom, nto, ncost) in graph[node]) {
                    if (distTo[nto] > distTo[node] + ncost) {
                        distTo[nto] = distTo[node] + ncost
                        pq.offer(Cost(nto, distTo[nto]))
                    }
                }
            }

            val max = distTo.max()!!
            return if (max == Int.MAX_VALUE) -1 else max
        }

        fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
            val graph = Array(n + 1) { mutableSetOf<Edge>() }
            for ((u, v, w) in times) {
                graph[u].add(Edge(u, v, w))
            }

            val distTo = IntArray(n + 1) { if (it == 0) 0 else Int.MAX_VALUE }
            dfs(graph, k, 0, distTo)
            return if (distTo.any { it == Int.MAX_VALUE }) -1 else distTo.max()!!
        }

        private fun dfs(graph: Array<MutableSet<Edge>>, k: Int, elapsed: Int, distTo: IntArray) {
            if (distTo[k] <= elapsed) return
            distTo[k] = elapsed
            for ((from, to, cost) in graph[k]) {
                dfs(graph, to, cost + elapsed, distTo)
            }
        }
    }
}