class _214 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(shortestPalindrome("aacecaaa"))
        }

        //todo
        fun shortestPalindrome(s: String): String {
            val vs = s.reversed()
            for (i in s.length downTo 0) {
                if (s.substring(0, i) == vs.substring(s.length - i)) {
                    return vs.substring(0, s.length - i) + s
                }
            }
            return s
        }
    }
}