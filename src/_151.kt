import java.lang.StringBuilder

class _151 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(reverseWords("  hello world!  "))
        }


        fun reverseWords(s: String): String {
            val ans = StringBuilder()
            var state = 0
            var len = 0
            for (i in s.length - 1 downTo 0) {
                if (state == 0) {
                    if (s[i] != ' ') {
                        state = 1
                        len++
                    }
                } else if (state == 1) {
                    if (s[i] != ' ') {
                        len++
                    } else {
                        state = 0
                        ans.append(s.substring(i + 1, i + len + 1)).append(" ")
                        len = 0
                    }
                }
            }
            if (len > 0) {
                ans.append(s.substring(0, len))
            }
            return ans.toString()
        }
    }
}