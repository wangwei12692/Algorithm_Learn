class _557 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(reverseWords("Let's take LeetCode contest"))
        }
        fun reverseWords(s: String): String {
            var state = 0
            var len = 0
            val cs = s.toCharArray()
            for (i in cs.indices) {
                if (state == 0) {
                    if (cs[i] != ' ') {
                        state = 1
                        len++
                    }
                } else {
                    if (cs[i] == ' ') {
                        cs.reverse(i - len, i)
                        state = 0
                        len = 0
                    } else {
                        len++
                    }
                }
            }
            if (len > 0) {
                cs.reverse(s.length - len, s.length)
            }
            return String(cs)
        }
    }
}