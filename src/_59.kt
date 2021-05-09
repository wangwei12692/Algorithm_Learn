class _59 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun generateMatrix(n: Int): Array<IntArray> {
            val dirs = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 0),
                intArrayOf(0, -1),
                intArrayOf(-1, 0)
            )
            var dirIdx = 0
            val ans = Array(n) { IntArray(n) }
            var i = 1

            var row = 0
            var column = 0
            while (i <= n * n) {
                ans[row][column] = i++
                val nextRow = row + dirs[dirIdx][0]
                val nextColumn = column + dirs[dirIdx][1]
                if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || ans[nextRow][nextColumn] > 0) {
                    dirIdx = (dirIdx + 1) % 4
                }
                row += dirs[dirIdx][0]
                column += dirs[dirIdx][1]
            }

            return ans
        }
    }
}