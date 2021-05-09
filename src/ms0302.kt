import java.util.*
import kotlin.math.min

class ms0302 {
    data class Node(val num: Int, val min: Int)
    class MinStack() {
        private val stack = Stack<Node>()

        fun push(x: Int) {
            if (stack.isEmpty()) {
                stack.push(Node(x, x))
            } else {
                stack.push(Node(x, min(stack.peek().min, x)))
            }
        }

        fun pop() {
            stack.pop()
        }

        fun top(): Int {
            return stack.peek().num
        }

        fun getMin(): Int {
            return stack.peek().min
        }

    }
}