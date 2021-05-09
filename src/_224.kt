import java.util.*

class _224 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(calculate("-(3 + (4+5))"))
        }

        fun calculate(s: String): Int {
            val stack = Stack<Int>()
            var i = 0
            var ans = 0
            var operator = 1
            while (i < s.length) {
                val c = s[i]
                if (c == '(') {
                    stack.push(ans)
                    stack.push(operator)
                    ans = 0
                    operator = 1
                } else if (c == ')') {
                    ans = ans * stack.pop() + stack.pop()
                } else if (c == ' ') {

                } else if (c == '+' || c == '-') {
                    operator = if (c == '+') 1 else -1
                } else {
                    val lo = i
                    while (i + 1 < s.length && s[i + 1].isDigit()) {
                        i++
                    }
                    ans += operator * s.substring(lo, i + 1).toInt()
                }
                i++
            }
            return ans
        }
    }
}