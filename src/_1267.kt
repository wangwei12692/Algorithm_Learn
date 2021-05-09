class _1267 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                countServers(
                    arrayOf(
                        intArrayOf(1, 1, 0, 0),
                        intArrayOf(0, 0, 1, 0),
                        intArrayOf(0, 0, 1, 0),
                        intArrayOf(0, 0, 0, 1)
                    )
                )
            )
        }

        data class Node(val i: Int, val j: Int, var degree: Int)

        fun countServers(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid[0].size

            val rowMap = mutableMapOf<Int, MutableList<Node>>()
            val columnMap = mutableMapOf<Int, MutableList<Node>>()
            val nodes = mutableListOf<Node>()

            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (grid[i][j] == 1) {
                        val server = Node(i, j, 0)
                        nodes.add(server)
                        val rows = rowMap.getOrPut(i, { mutableListOf() })
                        for (s in rows) {
                            s.degree++
                            server.degree++
                        }
                        val columns = columnMap.getOrPut(j, { mutableListOf() })
                        for (s in columns) {
                            s.degree++
                            server.degree++
                        }
                        rows.add(server)
                        columns.add(server)
                    }
                }
            }
            return nodes.filter { it.degree > 0 }.size
        }

        fun countServersSimple(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid[0].size

            var count = 0
            val rowDegree = IntArray(m)
            val columnDegree = IntArray(n)

            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (grid[i][j] == 1) {
                        count++
                        rowDegree[i]++
                        columnDegree[i]++
                    }
                }
            }

            for (i in 0 until m)
                for (j in 0 until n)
                    if (grid[i][j] == 1 && rowDegree[i] == 1 && columnDegree[j] == 1)
                        count--
            return count
        }
    }
}