import java.util.*

class _1614 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(maxDepth("(1+(2*3)+((8)/4))+1"))
        }

        fun maxDepth(s: String): Int {
            var max = 0
            var deepth = 0
            for (c in s) {
                if (c == '(') {
                    deepth++
                } else if (c == ')') {
                    max = Math.max(deepth, max)
                    deepth--
                }
            }
            return max
        }
    }
}