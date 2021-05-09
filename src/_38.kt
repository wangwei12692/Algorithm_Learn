import java.lang.StringBuilder

class _38 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun countAndSay(n: Int): String {
            if (n == 1) return "1"
            val num = countAndSay(n - 1)
            val sb = StringBuilder()
            var i = 0
            while (i < num.length) {
                var cnt = 1
                while (i+1 < num.length && num[i] == num[i + 1]) {
                    cnt++
                    i++
                }
                sb.append(cnt).append(num[i])
                i++
            }
            return sb.toString()
        }
    }
}