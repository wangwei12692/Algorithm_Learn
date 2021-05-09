import java.util.*
import kotlin.collections.HashMap
import kotlin.reflect.jvm.internal.impl.utils.DFS

class  _310 {
    companion object {

        //计算树的高度
        //广度搜索需要扩散几层
        private fun calcHeightBFS(graph: Array<MutableSet<Int>>, root: Int): Int {
            val q: Queue<Int> = LinkedList()
            q.offer(root)
            var depth = 0
            val seen = BooleanArray(graph.size)
            while (q.isNotEmpty()) {
                depth++
                val size = q.size
                for (i in 0 until size) {
                    val v = q.poll()
                    for (u in graph[v]) {
                        if (seen[u]) continue
                        seen[u] = true
                        q.offer(u)
                    }
                }
            }
            return depth
        }

        //求最长路径
        private fun calcHeightDFS(graph: Array<MutableSet<Int>>, root: Int, pre: Int, memo: HashMap<Int, Int>): Int {
            val key = (root * 1e5 + pre).toInt()
            if (memo[key] != null) {
                return memo[key]!!
            }
            var height = 0
            for (u in graph[root]) {
                //防止环状遍历
                if (u == pre) continue
                height = Math.max(calcHeightDFS(graph, u, root, memo) + 1, height)
            }
            memo[key] = height
            return height
        }

        //保留最后的枝干
        fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
            if (edges.isEmpty()) return listOf(0)
            val graph = Array(n) { mutableSetOf<Int>() }
            val deg = IntArray(n)
            for ((u, v) in edges) {
                graph[u].add(v)
                graph[v].add(u)
                deg[v]++
                deg[u]++
            }
            val q: Queue<Int> = LinkedList()
            for (i in 0 until n) {
                //leaf
                if (deg[i] == 1)
                    q.offer(i)
            }
            val ans = mutableListOf<Int>()
            while (q.isNotEmpty()) {
                ans.clear()
                val size = q.size
                for (i in 0 until size) {
                    val u = q.poll()
                    ans.add(u)
                    for (v in graph[u]) {
                        deg[v]--
                        if (deg[v] == 1)
                            q.offer(v)
                    }
                }
            }
            return ans
        }
    }

}