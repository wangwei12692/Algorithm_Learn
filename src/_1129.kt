import java.util.*
import kotlin.math.min

class _1129 {

    data class Node(val u: Int, val color: Int)

    fun shortestAlternatingPaths(n: Int, red_edges: Array<IntArray>, blue_edges: Array<IntArray>): IntArray {
        val red = Array(n) { mutableSetOf<Int>() }
        val blue = Array(n) { mutableSetOf<Int>() }
        for ((u, v) in red_edges) {
            red[u].add(v)
        }
        for ((u, v) in blue_edges) {
            blue[u].add(v)
        }
        val distTo = IntArray(n) { Int.MAX_VALUE }
        val seen = Array(n) { Array(n) { BooleanArray(2) } }
        val q: Queue<Node> = LinkedList()
        // 0
        q.offer(Node(0, 1)) //red
        q.offer(Node(0, 0)) //blue
        var depth = 0
        while (q.isNotEmpty()) {
            depth++
            val size = q.size
            for (i in 0 until size) {
                val (u, color) = q.poll()
                if (color == 1) {
                    for (v in blue[u]) {
                        if (!seen[u][v][0]) {
                            seen[u][v][0] = true
                            distTo[v] = min(distTo[v], depth)
                            q.offer(Node(v, 0))
                        }
                    }
                } else {
                    for (v in red[u]) {
                        if (!seen[u][v][1]) {
                            seen[u][v][1] = true
                            distTo[v] = min(distTo[v], depth)
                            q.offer(Node(v, 1))
                        }
                    }
                }
            }
        }
        distTo[0] = 0
        for ((idx, v) in distTo.withIndex()) {
            if (v == Int.MAX_VALUE)
                distTo[idx] = -1
        }
        return distTo
    }
}