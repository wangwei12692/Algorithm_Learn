class _221 {


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val matrix = arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('1', '0', '0', '1', '0')
            )
            val m = arrayOf(
                charArrayOf('1', '0', '1', '0', '0', '1', '1', '1', '0'),
                charArrayOf('1', '1', '1', '0', '0', '0', '0', '0', '1'),
                charArrayOf('0', '0', '1', '1', '0', '0', '0', '1', '1'),
                charArrayOf('0', '1', '1', '0', '0', '1', '0', '0', '1'),
                charArrayOf('1', '1', '0', '1', '1', '0', '0', '1', '0'),
                charArrayOf('0', '1', '1', '1', '1', '1', '1', '0', '1'),
                charArrayOf('1', '0', '1', '1', '1', '0', '0', '1', '0'),
                charArrayOf('1', '1', '1', '0', '1', '0', '0', '0', '1'),
                charArrayOf('0', '1', '1', '1', '1', '0', '0', '1', '0'),
                charArrayOf('1', '0', '0', '1', '1', '1', '0', '0', '0')
            )

            val m2 = arrayOf(
                charArrayOf('1', '0', '1', '0', '0', '1', '1', '1', '0'),
                charArrayOf('1', '1', '1', '0', '0', '0', '0', '0', '1'),
                charArrayOf('0', '0', '1', '1', '0', '0', '0', '1', '1'),
                charArrayOf('0', '1', '1', '0', '0', '1', '0', '0', '1'),
                charArrayOf('1', '1', '0', '1', '1', '0', '0', '1', '0'),
                charArrayOf('0', '1', '1', '1', '1', '1', '1', '0', '1'),
                charArrayOf('1', '0', '1', '1', '1', '0', '0', '1', '0'),
                charArrayOf('1', '1', '1', '0', '1', '0', '0', '0', '1'),
                charArrayOf('0', '1', '1', '1', '1', '0', '0', '1', '0'),
                charArrayOf('1', '0', '0', '1', '1', '1', '0', '0', '0')
            )
            //[[1, 0, 1, 0, 0, 1, 1, 1, 0],
            // [1, 1, 1, 0, 0, 0, 0, 0, 1],
            // [0, 0, 1, 1, 0, 0, 0, 1, 1],
            // [0, 1, 1, 0, 0, 1, 0, 0, 1],
            // [1, 1, 0, 1, 1, 0, 0, 1, 0],
            // [0, 1, 1, 1, 2, 1, 1, 0, 1],
            // [1, 0, 1, 2, 3, 0, 0, 1, 0],
            // [1, 1, 1, 0, 1, 0, 0, 0, 1],
            // [0, 1, 2, 1, 1, 0, 0, 1, 0],
            // [1, 0, 0, 1, 2, 1, 0, 0, 0]]
//            println(maximalSquare(matrix))
            println(maximalSquare2(m))
            println(maximalSquare3(m))
        }

        fun maximalSquare3(matrix: Array<CharArray>): Int {
            val m = matrix.size
            val n = matrix[0].size
            val dp = Array(m) { IntArray(n) }
            var maxSide = 0
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (matrix[i][j] == '1') {
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1
                        } else {
                            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1
                        }
                        maxSide = Math.max(maxSide, dp[i][j])
                    }
                }
            }
            println(dp.contentDeepToString())
            return maxSide * maxSide
        }

        fun maximalSquare2(matrix: Array<CharArray>): Int {
            val m = matrix.size
            val n = matrix[0].size
            val dp = Array(m) { i -> IntArray(n) { j -> if (matrix[i][j] == '1') 1 else 0 } }
            var maxSide = 0
            for (i in 1 until m) {
                for (j in 1 until n) {
                    if (matrix[i][j] == '1' && dp[i - 1][j - 1] >= 1) {
                        val threshold = Math.max(Math.min(m - i, n - j), dp[i - 1][j - 1] + 1)
                        var checked = true
                        for (k in 1 until threshold) {
                            if (matrix[i][j - k] == '0' || matrix[i - k][j] == '0') {
                                checked = false
                                break
                            }
                        }
                        if (checked) {
                            dp[i][j] = dp[i - 1][j - 1] + 1
                            maxSide = Math.max(maxSide, dp[i][j])
                        }
                    }
                }
            }
            return maxSide * maxSide
        }

        fun maximalSquare(matrix: Array<CharArray>): Int {
            val m = matrix.size
            val n = matrix[0].size
            var maxSide = 0
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (matrix[i][j] == '1') {
                        val threshold = Math.min(m - i, n - j)
                        if (threshold < maxSide) {
                            break
                        }
                        for (k in 1 until threshold) {
                            var success = true
                            if (matrix[i + k][j + k] == '0') {
                                break
                            }
                            for (count in 0 until k) {
                                if (matrix[i + count][j + k] == '0' || matrix[i + k][j + count] == '0') {
                                    success = false
                                    break
                                }
                            }
                            if (success) {
                                maxSide = Math.max(maxSide, k + 1)
                            } else {
                                break
                            }
                        }
                    }
                }
            }
            return maxSide * maxSide
        }
    }
}