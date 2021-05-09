class ms1001 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val A = intArrayOf(1, 2, 3, 0, 0, 0)
            merge(A, 3, intArrayOf(2, 5, 6), 3)
            println(A.joinToString())
        }

        fun merge(A: IntArray, m: Int, B: IntArray, n: Int): Unit {
            var p0 = m - 1
            var p1 = n - 1
            var i = m + n - 1
            while (p0 >= 0 || p1 >= 0) {
                if (p0 < 0) {
                    A[i--] = B[p1--]
                } else if (p1 < 0) {
                    A[i--] = A[p0--]
                } else if (A[p0] > B[p1]) {
                    A[i--] = A[p0--]
                } else {
                    A[i--] = B[p1--]
                }
            }
        }
    }
}