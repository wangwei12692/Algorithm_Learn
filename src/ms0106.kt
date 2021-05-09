import java.lang.StringBuilder

class ms0106 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(compressString("abbccd"))
        }

        fun compressString(S: String): String {
            var len = 1
            val sb = StringBuilder()
            for (i in 0 until S.length - 1) {
                if (S[i] == S[i + 1]) {
                    len++
                } else {
                    sb.append(S[i]).append(len)
                    len = 1
                }
            }
            if (len > 0) {
                sb.append(S.last()).append(len)
            }
            return if (sb.length > S.length) S else sb.toString()
        }
    }
}