import java.util.*
import kotlin.math.max

class _994 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                orangesRotting2(
                    arrayOf(
                        intArrayOf(2, 1, 1),
                        intArrayOf(1, 1, 0),
                        intArrayOf(0, 1, 1),
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

        fun orangesRotting(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid[0].size
            var ans = 0
            val queue = LinkedList<Int>()
            var fresh = 0
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (grid[i][j] == 2) {
                        queue.offer(i * n + j)
                    } else if (grid[i][j] == 1) {
                        fresh++
                    }
                }
            }
            while (queue.isNotEmpty()) {
                ans++
                val size = queue.size
                for (i in 0 until size) {
                    val coor = queue.poll()
                    val x = coor / n
                    val y = coor % n
                    grid[x][y] = 0
                    for ((dx, dy) in dirs) {
                        val nx = x + dx
                        val ny = y + dy
                        if (nx in 0 until m && ny in 0 until n && grid[nx][ny] == 1) {
                            fresh--
                            grid[nx][ny] = 2
                            queue.offer(nx * n + ny)
                        }
                    }
                }
            }
            return if (fresh == 0) ans - 1 else -1
        }


        fun orangesRotting2(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid[0].size

            fun dfs(i: Int, j: Int, k: Int) {
                if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || grid[i][j] != 1 && grid[j][j] < k) {
                    return
                }
                grid[i][j] = k
                for ((dx, dy) in dirs) {
                    val nx = i + dx
                    val ny = j + dy
                    dfs(nx, ny, k + 1)
                }
            }

            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (grid[i][j] == 2) {
                        dfs(i, j, 2)
                    }
                }
            }
            var time = 2
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (grid[i][j] == 1)
                        return -1
                    else
                        time = max(time, grid[i][j])
                }
            }
            return time - 2
        }

//        private fun dfs(grid: Array<IntArray>, i: Int, j: Int) {
//            if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == 0) {
//                return
//            }
//
//        }

    }
}