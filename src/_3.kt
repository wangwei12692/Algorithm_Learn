class   _3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(lengthOfLongestSubstring("abba"))
        }

        fun lengthOfLongestSubstring(s: String): Int {
            var max = 0
            var last = -1
            val loc = IntArray(128) { -1 }
            for (i in s.indices) {
                val c = s[i]
                if (loc[c.toInt()] >= 0) {
                    last = Math.max(loc[c.toInt()],last)
                }
                max = Math.max(max, i - last)
                loc[c.toInt()] = i
            }
            return max
        }
    }
}