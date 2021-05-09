class _118 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(generate(5))
        }

        fun generate(numRows: Int): List<List<Int>> {
            if (numRows == 0)
                return emptyList()
            val ans = mutableListOf<List<Int>>()
            ans.add(listOf(1))
            var idx = 1
            while (idx++ < numRows) {
                val lastLine = ans.last()
                val line = mutableListOf<Int>()
                ans.add(line)
                for (i in 0 until idx) {
                    val left = if (i - 1 in 0 until idx - 1) lastLine[i - 1] else 0
                    val right = if (i < idx - 1) lastLine[i] else 0
                    line.add(left + right)
                }
            }
            return ans
        }
    }
}