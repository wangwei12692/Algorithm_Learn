class _240 {
    companion object {

        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            val m = matrix.size
            val n = matrix[0].size
            var i = m - 1
            var j = 0
            while (i >= 0 && j < n) {
                val cmp = matrix[i][j] - target
                if (cmp == 0) {
                    return true
                } else if (cmp < 0) {
                    j++
                } else {
                    i--
                }
            }
            return false
        }
    }
}