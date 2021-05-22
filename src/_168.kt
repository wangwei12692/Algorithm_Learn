import java.lang.StringBuilder

class _168 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(convertToTitle(112))
        }

        // 10 进制 -> 26 进制
        fun convertToTitle(columnNumber: Int): String {
            var num = columnNumber
            val sb = StringBuilder()
            while (num >= 26) {
                var n = num % 26
                if (n == 0) {
                    n = 26
                    num -= 1
                }
                sb.insert(0, ('A'.toInt() + n - 1).toChar())
                num /= 26
            }
            return sb.toString()
        }
    }
}