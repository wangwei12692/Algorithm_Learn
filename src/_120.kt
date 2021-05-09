class  _120 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val triangle = listOf(
                listOf(-10)
            )
            val total = minimumTotal(triangle)
            println(total)
        }

        fun minimumTotal(triangle: List<List<Int>>): Int {
            val n = triangle.size
            val dp = Array(n) { IntArray(n) }
            for ((i, v) in triangle.last().withIndex()) {
                dp[n - 1][i] = v
            }
            for (i in n - 2 downTo 0) {
                val current = triangle[i]
                for (j in current.indices) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + current[j]
                }
            }
            return dp[0][0]
        }
    }
}