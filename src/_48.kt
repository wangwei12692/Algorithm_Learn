class _48 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val matrix = arrayOf(
//                intArrayOf(5, 1, 9, 11),
//                intArrayOf(2, 4, 8, 10),
//                intArrayOf(13, 3, 6, 7),
//                intArrayOf(15, 14, 12, 16)
//            )
            val matrix = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9),
            )
            rotate(matrix)
            println(
                matrix.contentDeepToString()
            )
        }

        fun rotate(matrix: Array<IntArray>): Unit {
            val n = matrix.size
            for (i in 0 until n) {
                for (j in 0 until i) {
                    val t = matrix[i][j]
                    matrix[i][j] = matrix[j][i]
                    matrix[j][i] = t
                }
            }

            for (i in 0 until n) {
                for (j in 0..n / 2) {
                    val t = matrix[i][j]
                    matrix[i][j] = matrix[i][n - j - 1]
                    matrix[i][n - j - 1] = t
                }
            }
        }

    }
}