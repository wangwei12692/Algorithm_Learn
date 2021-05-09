class _74 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(searchMatrix(arrayOf(),3))
        }
        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            val m = matrix.size
            val n = matrix[0].size
            var i = m - 1
            var j = 0
            while (i >= 0 && j < n) {
                val cmp = matrix[i][j].compareTo(target)
                if (cmp == 0) {
                    return true
                }else if (cmp < 0) {
                    j++
                } else {
                    i--
                }
            }
            return false
        }
    }
}