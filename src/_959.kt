class _959 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                regionsBySlashes(
                    arrayOf(
                        "\\/",
                        "/\\"
                    )
                )
            )
        }

        fun regionsBySlashes(grid: Array<String>): Int {
            val n = grid.size
            val uf = UnionFind(n * n * 4)
            for (i in 0 until n) {
                for (j in 0 until n) {
                    val key = 4 * (i * n + j)
                    when (grid[i][j]) {
                        '/' -> {
                            uf.union(key, key + 1)
                            uf.union(key + 2, key + 3)
                        }
                        '\\' -> {
                            uf.union(key, key + 3)
                            uf.union(key + 1, key + 2)
                        }
                        else -> {
                            uf.union(key, key + 1)
                            uf.union(key + 2, key + 1)
                            uf.union(key + 2, key + 3)
                        }
                    }
                    //union left
                    if (j - 1 >= 0) {
                        uf.union(key, i * n + j - 1 + 2)
                    }
                    //union top
                    if (i - 1 >= 0) {
                        uf.union(key + 1, (i - 1) * n + j + 3)
                    }
                }
            }

            return uf.count
        }
    }
}