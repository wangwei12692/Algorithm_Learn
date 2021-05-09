class _344 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun reverseString(s: CharArray): Unit {
            var lo = 0
            var hi = s.size - 1
            while (lo < hi) {
                val t = s[lo]
                s[lo] = s[hi]
                s[hi] = t
                lo++
                hi--
            }
        }
    }
}