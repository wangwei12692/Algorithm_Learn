import java.util.*

class _200 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                numIslands(
                    arrayOf(
                        charArrayOf('1', '1', '0', '0', '0'),
                        charArrayOf('1', '1', '0', '0', '0'),
                        charArrayOf('0', '0', '1', '0', '0'),
                        charArrayOf('0', '0', '0', '1', '1')
                    )
                )
            )
            println(
                numIslands2(
                    arrayOf(
                        charArrayOf('1', '1', '0', '0', '0'),
                        charArrayOf('1', '1', '0', '0', '0'),
                        charArrayOf('0', '0', '1', '0', '0'),
                        charArrayOf('0', '0', '0', '1', '1')
                    )
                )
            )
        }

        fun numIslands2(grid: Array<CharArray>): Int {
            val m = grid.size
            val n = grid[0].size
            val uf = UnionFind(m * n)
            var cnt = 0
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (grid[i][j] == '1') {
                        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                            uf.union(i * n + j, (i - 1) * n + j)
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                            uf.union(i * n + j, (i) * n + j - 1)
                        }
                    } else {
                       cnt++
                    }
                }
            }
            return uf.count - cnt
        }

        fun numIslands(grid: Array<CharArray>): Int {
            val m = grid.size
            val n = grid[0].size
            var ans = 0
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j)
                        ans++
                    }
                }
            }
            return ans
        }

        private fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
            if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == '0')
                return
            grid[i][j] = '0'
            dfs(grid, i - 1, j)
            dfs(grid, i + 1, j)
            dfs(grid, i, j - 1)
            dfs(grid, i, j + 1)
        }
    }
}