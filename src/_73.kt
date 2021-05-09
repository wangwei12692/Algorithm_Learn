class _73 {

    fun setZeroes2(matrix: Array<IntArray>): Unit {
        val m = matrix.size
        val n = matrix[0].size
        var row_flag = false
        var column_flag = false
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][0] == 0) {
                    column_flag = true
                    break
                }
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[0][j] == 0) {
                    row_flag = true
                    break
                }
            }
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }

        if (column_flag) {
            for (i in 0 until m) {
                for (j in 0 until n) {
                    matrix[i][0] =0
                }
            }
        }

        if (row_flag) {
            for (i in 0 until m) {
                for (j in 0 until n) {
                    matrix[0][j] =0
                }
            }
        }
    }

    fun setZeroes(matrix: Array<IntArray>): Unit {
        val rows = BooleanArray(matrix.size)
        val colums = BooleanArray(matrix[0].size)
        for (i in 0..matrix.size - 1) {
            for (j in 0 until matrix[i].size) {
                if (matrix[i][j] == 0) {
                    rows[i] = true
                    colums[j] = true
                }
            }
        }

        for (i in 0..matrix.size - 1) {
            for (j in 0 until matrix[i].size) {
                if (rows[i] || colums[j]) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}