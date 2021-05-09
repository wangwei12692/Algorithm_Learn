import java.util.*

class jz09 {
    class CQueue() {
        private val stack1 = Stack<Int>()
        private val stack2 = Stack<Int>()

        fun appendTail(value: Int) {
            stack1.push(value)
        }

        fun deleteHead(): Int {
            if (stack2.isNotEmpty()) {
                return stack2.pop()
            }
            while (stack1.isNotEmpty()) {
                stack2.push(stack1.pop())
            }
            return if (stack2.isEmpty()) -1 else stack2.pop()
        }

    }
}