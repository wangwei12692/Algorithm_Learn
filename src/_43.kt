import _189.Companion.swap
import java.lang.StringBuilder

class _43 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            multiply2("123","456")
        }


        fun multiply2(num1: String, num2: String): String {
            if (num1 == "0" || num2 == "0")
                return "0"
            val m = num1.length
            val n = num2.length
            val ans = IntArray(m + n)
            for (i in m - 1 downTo 0) {
                val x = num1[i] - '0'
                for (j in n - 1 downTo 0) {
                    val y = num2[j] - '0'
                    ans[i + j + 1] += x * y
                }
            }
            for (i in m + n - 1 downTo 1) {
                ans[i - 1] += ans[i] / 10
                ans[i] %= 10
            }
            var idx = if (ans[0] == 0) 1 else 0
            val sb = StringBuilder()
            while (idx < m + n) {
                sb.append(ans[idx])
                idx++
            }
            return sb.toString()
        }

        fun multiply(num1: String, num2: String): String {
            if (num1 == "0" || num2 == "0")
                return "0"
            var ans = "0"
            val m = num1.length
            val n = num2.length
            for (i in n - 1 downTo 0) {
                val result = StringBuilder()
                for (j in n - 1 downTo i) {
                    result.append(0)
                }
                var curry = 0
                val y = num2[i] - '0'
                for (j in m - 1 downTo 0) {
                    val x = num1[j] - '0'
                    val v = x * y + curry
                    curry = v / 10
                    result.append(v % 10)
                }
                if (curry != 0) {
                    result.append(curry)
                }
                ans = addString(ans, result.reversed().toString())

            }

            return ans
        }

        private fun addString(num1: String, num2: String): String {
            var m = num1.length
            var n = num2.length
            var curry = 0
            val result = StringBuilder()
            while (m >= 0 || n >= 0 || curry != 0) {
                val x = if (m >= 0) num1[m] - '0' else 0
                val y = if (n >= 0) num2[n] - '0' else 0
                val v = x + y + curry
                curry = v / 10
                result.append(v % 10)
                m--
                n--
            }
            return result.reversed().toString()
        }
    }
}