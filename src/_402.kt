import java.lang.StringBuilder

class _402 {
    companion object {
        fun removeKdigits(num: String, k: Int): String {
            val str = StringBuilder(num)
            var idx = 0
            while (idx < k && str.isNotEmpty()) {
                var i = 0
                for (j in 1 until str.length) {
                    if (str[j] >= str[j - 1]) {
                        i= j
                        break
                    }
                }
                str.deleteCharAt(i)
                while (str.length > 1 && str[0] == '0') {
                    str.deleteCharAt(0)
                }
                idx++
            }
            return str.toString()
        }

    }
}