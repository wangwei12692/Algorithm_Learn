class _58 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(lengthOfLastWord("hello"))
        }
        fun lengthOfLastWord(s: String): Int {
            var state = 0
            var end = -1
            for (i in s.length - 1 downTo 0) {
                if (state == 0) {
                    if (s[i] != ' ') {
                        state = 1
                        end = i
                    }
                } else if (state == 1) {
                    if (s[i] == ' ') {
                        return end - i
                    }
                }
            }

            return if (state == 0) 0 else s.length
        }
    }
}