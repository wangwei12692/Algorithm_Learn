import java.util.*

class _739 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }


        //单调栈
        fun dailyTemperatures(T: IntArray): IntArray {
            val ans = IntArray(T.size)
            val stack = Stack<Int>()
            for (i in T.indices) {
                val num = T[i]
                while (!stack.isEmpty() && num > T[stack.peek()]) {
                    val last = stack.pop()
                    ans[last] = i - last
                }
                stack.push(i)
            }
            return ans
        }
    }
}