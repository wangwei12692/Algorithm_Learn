class _463 {
    companion object {
        fun islandPerimeter(grid: Array<IntArray>): Int {
            var len = 0
            val m = grid.size
            val n = grid[0].size
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (grid[i][j] == 1) {
                        len += 4
                        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                            len -= 2
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                            len -= 2
                        }
                    }

                }
            }
            return len
        }
    }
}