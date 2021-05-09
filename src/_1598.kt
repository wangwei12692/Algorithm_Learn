import java.util.*

class _1598 {
    companion object {
        fun minOperations(logs: Array<String>): Int {
            val stack = Stack<String>()
            for (op in logs) {
                if (op == "../") {
                    var steps = Math.min(stack.size, 1)
                    while (steps-- > 0) {
                        stack.pop()
                    }
                } else if (op == "./") {
                    continue
                } else {
                    stack.push(op)
                }
            }
            return stack.size
        }
    }
}