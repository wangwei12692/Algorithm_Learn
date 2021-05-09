import java.lang.StringBuilder

class _67 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(addBinary("11","1"))
        }

        fun addBinary(a: String, b: String): String {
            var m = a.length - 1
            var n = b.length - 1
            var curry = 0
            val sb = StringBuilder()
            while (m >= 0 || n >= 0 || curry != 0) {
                val x = if (m >= 0) a[m] - '0' else 0
                val y = if (n >= 0) b[n] - '0' else 0
                val v = x + y + curry
                sb.append(v % 2)
                curry = v / 2
                m--
                n--
            }
            return sb.reverse().toString()
        }

    }
}