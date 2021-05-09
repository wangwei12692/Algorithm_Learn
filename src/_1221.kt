import java.util.*

class _1221 {
    companion object {
        fun balancedStringSplit(s: String): Int {
            var cnt = 0
            val stack = Stack<Char>()
            for (c in s) {
                if (stack.isEmpty())
                    stack.push(c)
                else if (stack.peek() == c) {
                    stack.push(c)
                } else {
                    stack.pop()
                    if (stack.isEmpty())
                        cnt++
                }
            }
            return cnt
        }
    }
}