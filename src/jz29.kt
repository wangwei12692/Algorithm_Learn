class jz29 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        private val dirs = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        fun spiralOrder(matrix: Array<IntArray>): IntArray {
            val m = matrix.size
            val n = matrix[0].size
            val ans = IntArray(m * n)
            var i = 0
            var dirIdx = 0
            var row = 0
            var column = 0
            while (i < m * n) {
                ans[i++] = matrix[row][column]
                matrix[row][column] = -1
                val nextRow = row + dirs[dirIdx][0]
                val nextColumn = column + dirs[dirIdx][1]
                if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n || matrix[row][column] == -1) {
                    dirIdx = (dirIdx + 1) % 4
                }
                row += dirs[dirIdx][0]
                column += dirs[dirIdx][1]
            }
            return ans
        }
    }
}