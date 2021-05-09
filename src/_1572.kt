class _1572 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(diagonalSum(arrayOf(
                intArrayOf(1,1,1,1),
                intArrayOf(1,1,1,1),
                intArrayOf(1,1,1,1),
                intArrayOf(1,1,1,1),
            )))
        }

        fun diagonalSum(mat: Array<IntArray>): Int {
            val n = mat.size
            var ans = 0
            for (i in 0 until n) {
                ans += mat[i][i] + mat[i][n - 1 - i]
            }
            return if (n%2 == 0)
                ans
            else
                ans - mat[n / 2][n / 2]
        }
    }
}