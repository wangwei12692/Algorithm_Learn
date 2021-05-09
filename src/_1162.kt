import java.util.*
import kotlin.math.max

class _1162 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                maxDistance(
                    arrayOf(
                        intArrayOf(1, 0, 1),
                        intArrayOf(0, 0, 0),
                        intArrayOf(1, 0, 1),
                    )
                )
            )
        }

        data class Point(val x: Int, val y: Int)

        private val dirs = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
        )

        fun maxDistance(grid: Array<IntArray>): Int {
            val n = grid.size
            val q = LinkedList<Point>()
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (grid[i][j] == 1)
                        q.offer(Point(i, j))
                }
            }
            if (q.size == n * n)
                return -1
            var depth = 0
            while (q.isNotEmpty()) {
                depth++
                val size = q.size
                for (i in 0 until size) {
                    val (x, y) = q.poll()
                    for (dir in dirs) {
                        val nx = x + dir[0]
                        val ny = y + dir[1]
                        if (nx in 0 until n && ny in 0 until n && grid[nx][ny] == 0) {
                            grid[nx][ny] = 1
                            q.offer(Point(nx, ny))
                        }
                    }

                }
            }
            return depth - 1
        }
    }
}