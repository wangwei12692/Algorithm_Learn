class jz04 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
            val m = matrix.size
            val n = matrix[0].size
            var i = m - 1
            var j = 0
            while (i >= 0 && j < n) {
                if (matrix[i][j] == target) {
                    return true
                } else if (matrix[i][j] < target) {
                    j++
                } else {
                    i--
                }
            }
            return false
        }
    }
}