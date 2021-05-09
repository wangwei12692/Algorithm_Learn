import java.util.*
import kotlin.math.min

class _155 {

    class MinStack() {
        private val stack = Stack<Int>()
        private val minStack = Stack<Int>()

        fun push(`val`: Int) {
            stack.push(`val`)
            if (minStack.isEmpty()) {
                minStack.push(`val`)
            } else {
                minStack.push(min(minStack.peek(), `val`))
            }
        }

        fun pop() {
            stack.pop()
            minStack.pop()
        }

        fun top(): Int {
            return stack.peek()
        }

        fun getMin(): Int {
            return minStack.peek()
        }

    }
}