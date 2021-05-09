class _892 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(surfaceArea(arrayOf(
                intArrayOf(1,0),
                intArrayOf(0,2)
            )))
        }
        private val dirs = arrayOf(
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        fun surfaceArea(grid: Array<IntArray>): Int {
            val n = grid.size
            var sum = 0
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (grid[i][j] > 0) {
                        sum += grid[i][j] * 4 + 2
                        for ((dx, dy) in dirs) {
                            val nx = i + dx
                            val ny = j + dy
                            if (nx in 0 until n && ny in 0 until n && grid[nx][ny] > 0) {
                                val r = Math.min(grid[i][j], grid[nx][ny])
                                sum -= r * 2
                            }
                        }
                    }
                }
            }
            return sum
        }
    }
}