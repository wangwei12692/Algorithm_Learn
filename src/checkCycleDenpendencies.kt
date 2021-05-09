import java.util.*

class Check {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                checkCycleDependencies(
                    arrayOf(
                        intArrayOf(0, 2),
                        intArrayOf(1, 2),
                        intArrayOf(2, 3),
                        intArrayOf(2, 4),
                    ), 5
                )
            )

            println(
                checkCycleDependencies2(
                    arrayOf(
                        intArrayOf(0, 2),
                        intArrayOf(1, 2),
                        intArrayOf(2, 3),
                        intArrayOf(2, 4),
                    ), 5
                )
            )
        }


        fun checkCycleDependencies2(tasks: Array<IntArray>, n: Int): List<Int> {
            val graph = Array(n) { mutableSetOf<Int>() }
            val inDeg = IntArray(n)
            for ((v, u) in tasks) {
                graph[v].add(u)
                inDeg[u]++
            }
            val queue = LinkedList<Int>()
            for ((u,deg) in inDeg.withIndex()) {
                if (deg == 0) {
                    queue.offer(u)
                }
            }

            val ans = mutableListOf<Int>()
            val mark = BooleanArray(n)
            while (queue.isNotEmpty()) {
                val size = queue.size
                for (i in 0 until size) {
                    val v = queue.poll()
                    mark[v] = true
                    ans.add(v)
                    for (u in graph[v]) {
                        if (mark[u])
                            return emptyList()
                        inDeg[u]--
                        if (inDeg[u] == 0)
                            queue.offer(u)
                    }
                }
            }

            return ans
        }

        fun checkCycleDependencies(tasks: Array<IntArray>, n: Int): List<Int> {
            val graph = Array(n) { mutableSetOf<Int>() }
            for ((v, u) in tasks) {
                graph[v].add(u)
            }
            val ans = mutableListOf<Int>()
            val color = IntArray(n)
            for (v in 0 until n) {
                if (!dfs(graph, v, ans, color)) {
                    return emptyList()
                }
            }
            return ans.reversed()
        }

        fun dfs(graph: Array<MutableSet<Int>>, v: Int, ans: MutableList<Int>, color: IntArray): Boolean {
            if (color[v] > 0)
                return color[v] == 2
            color[v] = 1
            for (u in graph[v]) {
                if (!dfs(graph, u, ans, color))
                    return false
            }
            color[v] = 2
            ans.add(v)
            return true
        }
    }
}
