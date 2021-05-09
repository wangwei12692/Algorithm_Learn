import java.util.*

class _227 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(calculate("3 + 2 * 5"))
        }

        fun calculate(s: String): Int {
            val n = s.length
            val stack = Stack<Int>()
            var num = 0
            var i = 0
            var preOperator = '+'
            while (i < n) {
                if (s[i].isDigit()) {
                    num = num * 10 + (s[i] - '0')
                }

                if (!s[i].isDigit() && s[i] != ' ' || i == n - 1) {
                    when (preOperator) {
                        '+' -> stack.push(num)
                        '-' -> stack.push(-num)
                        '*' -> stack.push(stack.pop() * num)
                        '/' -> stack.push(stack.pop() / num)
                    }
                    preOperator = s[i]
                    num = 0
                }
                i++
            }
            var ans = 0
            while (stack.isNotEmpty()) {
                ans += stack.pop()
            }
            return ans
        }
    }
}