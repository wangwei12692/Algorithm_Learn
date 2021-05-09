import java.util.*

class _207 {
    companion object {

        fun canFinish2(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val edges = Array(numCourses){ mutableSetOf<Int>()}
            val inDeg = IntArray(numCourses)
            for ((to, from) in prerequisites) {
                edges[from].add(to)
                inDeg[to]++
            }
            val q = LinkedList<Int>()
            for (i in 0 until numCourses) {
                if (inDeg[i] == 0) {
                    q.offer(i)
                }
            }
            var visited = 0
            while (q.isNotEmpty()) {
                visited++
                val u = q.poll()
                for (v in edges[u]) {
                    inDeg[v]--
                    if (inDeg[v] == 0)
                        q.offer(v)
                }
            }
            return visited == numCourses
        }

        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val edges = Array(numCourses) { mutableSetOf<Int>() }
            for ((to, from) in prerequisites) {
                edges[from].add(to)
            }
            val color = IntArray(numCourses)
            for (i in 0 until numCourses) {
                if (!dfs(edges, i, color)) {
                    return false
                }
            }
            return true
        }

        //判断是否无环
        private fun dfs(edges: Array<MutableSet<Int>>, from: Int, color: IntArray): Boolean {
            if (color[from] > 0)
                return color[from] == 2
            color[from] = 1
            for (cur in edges[from]) {
                if (!dfs(edges, from, color)) {
                    return false
                }
            }
            color[from] = 2
            return true
        }
    }
}