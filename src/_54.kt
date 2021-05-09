class _54 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val matrix =  arrayOf(
                intArrayOf(1,2,3),
                intArrayOf(4,5,6),
                intArrayOf(7,8,9)
            )
            println(spiralOrder(matrix).joinToString())
        }


        fun spiralOrder(matrix: Array<IntArray>): List<Int> {
            val dir = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 0),
                intArrayOf(0,-1),
                intArrayOf(-1,0),
            )

            val m = matrix.size
            val n = matrix[0].size
            val out = mutableListOf<Int>()

            var row = 0
            var column = 0
            var dirIdx = 0
            val marked = hashSetOf<Int>()
            while (out.size < m * n) {
                val v = matrix[row][column]
                out.add(v)
                marked.add(v)

                val nextRow = dir[dirIdx][0] + row
                val nextColumn = dir[dirIdx][1] + column

                if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n || marked.contains(matrix[nextRow][nextColumn])) {
                    dirIdx = (dirIdx + 1) % 4
                }

                row += dir[dirIdx][0]
                column += dir[dirIdx][1]
            }

            return out
        }
    }
}