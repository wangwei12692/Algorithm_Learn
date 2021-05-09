class _498 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                findDiagonalOrder(
                    arrayOf(
                        intArrayOf(1, 2, 3),
                        intArrayOf(4, 5, 6),
                        intArrayOf(7, 8, 9),
                    )
                ).joinToString()
            )
        }

        fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
            val n = mat.size
            val ans = IntArray(n * n)
            var idx = 0
            var rev = false
            for (sum in 0..(n - 1) * 2) {
                if (rev) {
                    for (i in 0..sum) {
                        if (i < n && sum - i in 0 until n) {
                            ans[idx++] = mat[i][sum - i]
                        }
                    }
                } else {
                    for (i in sum downTo 0) {
                        if (i < n && sum - i in 0 until n) {
                            ans[idx++] = mat[i][sum - i]
                        }
                    }
                }
                rev = !rev

            }
            return ans
        }
    }

}