class _1446 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(maxPower("abbcccddddeeeeedcba"))
        }
        fun maxPower(s: String): Int {
            var cnt = 0
            var max = 1
            for (i in 0 until s.length - 2) {
                if (s[i] == s[i + 1]) {
                    cnt++
                } else {
                    max = Math.max(max, cnt)
                    cnt = 1
                }
            }
            max = Math.max(max, cnt)
            return max
        }
    }
}