import java.lang.StringBuilder

class _6 {
    companion object {
        private val dirs = intArrayOf(1, -1)
        fun convert(s: String, numRows: Int): String {
            if (numRows == 1) return s
            val builders = Array(numRows) { StringBuilder() }
            var row = 0
            var dirIdx = 0
            for (c in s) {
                builders[row].append(c)
                val nextRow = row + dirs[dirIdx]
                if (nextRow < 0 || nextRow >= numRows) {
                    dirIdx = (dirIdx + 1) % 2
                }
                row += dirs[dirIdx]
            }

            return builders.fold(StringBuilder()) { acc, line ->
                acc.append(line.toString())
                acc
            }.toString()
        }
    }
}