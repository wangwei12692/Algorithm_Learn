class _657 {
    companion object {
        fun judgeCircle(moves: String): Boolean {
            val cs = moves.toCharArray()
            var x = 0
            var y = 0
            for (c in cs) {
                when (c) {
                    'U' -> y++
                    'D' -> y--
                    'L' -> x--
                    'R' -> x++
                }
            }
            return x == 0 && y == 0
        }
    }
}