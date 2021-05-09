import java.lang.StringBuilder
import java.util.*

class _1021 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(removeOuterParentheses("()()"))
        }

        fun removeOuterParentheses(S: String): String {
            val ans = StringBuilder()
            val stack = Stack<Int>()
            for (i in S.indices) {
                if (S[i] == '(') {
                    stack.push(i)
                } else {
                    val last = stack.pop()
                    if (stack.isEmpty()) {
                        ans.append(S.substring(last + 1, i))
                    }
                }
            }
            return ans.toString()
        }
    }
}