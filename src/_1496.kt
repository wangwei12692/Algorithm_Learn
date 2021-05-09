class _1496 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun isPathCrossing(path: String): Boolean {
            val set = mutableSetOf<Int>()
            var x = 0
            var y = 0
            for (c in path) {
                if (c == 'N') {
                    x++
                } else if (c == 'E') {
                    y++
                } else if (c == 'S') {
                    x--
                } else if (c == 'W') {
                    y--
                }
                val v = x * 1000 + y
                if (set.contains(v))
                    return false
                set.add(v)
            }
            return false
        }
    }
}