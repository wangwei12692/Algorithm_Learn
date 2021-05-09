import java.util.*

class _210 {
    companion object {

        fun findOrder2(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
            val edges = Array(numCourses) { mutableSetOf<Int>() }
            val inDeg = IntArray(numCourses)
            for ((to, from) in prerequisites) {
                edges[from].add(to)
                inDeg[to]++
            }
            val ans = mutableListOf<Int>()
            val color = IntArray(numCourses)
            for (i in 0 until numCourses) {
                if (!dfs(edges, i, color, ans)) {
                    return intArrayOf()
                }
            }
            return ans.reversed().toIntArray()
        }

        private fun dfs(edges: Array<MutableSet<Int>>, u: Int, color: IntArray, ans: MutableList<Int>): Boolean {
            if (color[u] > 0) {
                return color[u] == 2
            }
            color[u] = 1
            for (v in edges[u]) {
                if (!dfs(edges, v, color, ans)) {
                    return false
                }
            }
            ans.add(u)
            color[u] = 2
            return true
        }

        fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
            val edges = Array(numCourses) { mutableSetOf<Int>() }
            val inDeg = IntArray(numCourses)
            for ((to, from) in prerequisites) {
                edges[from].add(to)
                inDeg[to]++
            }
            val ans = mutableListOf<Int>()
            val q: Queue<Int> = LinkedList<Int>()
            for (i in 0 until numCourses) {
                if (inDeg[i] == 0) {
                    q.offer(i)
                }
            }
            while (q.isNotEmpty()) {
                val u = q.poll()
                ans.add(u)
                for (v in edges[u]) {
                    inDeg[v]--
                    if (inDeg[v] == 0) {
                        q.offer(v)
                    }
                }
            }
            return if (ans.size == numCourses) ans.toIntArray() else intArrayOf()
        }
    }
}