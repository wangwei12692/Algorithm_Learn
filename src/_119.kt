class _119 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(getRow(3))
        }
        fun getRow(rowIndex: Int): List<Int> {
            var ans = IntArray(rowIndex + 1)
            var last = IntArray(rowIndex + 1)
            ans[0] = 1
            last[0] = 1
            var idx = 1
            while (idx++ <= rowIndex) {
                for (i in 0 until idx) {
                    val left = if (i - 1 in 0 until idx) last[i - 1] else 0
                    val right = if (i in 0 until idx) last[i] else 0
                    ans[i] = left + right
                }
                val tmp = ans
                ans = last
                last = tmp
            }
            return last.toList()
        }
    }
}