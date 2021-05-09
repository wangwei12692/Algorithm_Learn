import java.util.*

class _20 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(isValid("()"))
            println(isValid("()[]{}"))
            println(isValid("([)]"))
            println(isValid("{[]}"))
        }

        fun isValid(s: String): Boolean {
            val stack = Stack<Char>()
            for (c in s) {
                when (c) {
                    '(', '[', '{' -> stack.push(c)
                    ')' -> {
                        if (stack.peek() == '(')
                            stack.pop()
                    }
                    ']' -> {
                        if (stack.peek() == '[')
                            stack.pop()
                    }
                    '}' -> {
                        if (stack.peek() == '{')
                            stack.pop()
                    }
                }
            }
            return stack.isEmpty()
        }
    }
}