import java.lang.IllegalArgumentException
import java.util.*

class _150 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
        }

        fun evalRPN(tokens: Array<String>): Int {
            val stack = Stack<Int>()
            for (token in tokens) {
                if (token in arrayOf("+", "-", "*", "/")) {
                    val rh = stack.pop()
                    val lh = stack.pop()
                    stack.push(
                        when (token) {
                            "+" -> {
                                lh + rh
                            }
                            "-" -> {
                                lh - rh
                            }
                            "*" -> {
                                lh * rh
                            }
                            "/" -> {
                                lh / rh
                            }
                            else -> throw IllegalArgumentException("token : $token")
                        }
                    )
                } else {
                    stack.push(token.toInt())
                }
            }
            return stack.pop()
        }
    }
}