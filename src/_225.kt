import java.util.*

class _225 {
    class MyStack() {
        private var queue1: Queue<Int> = LinkedList()
        private var queue2: Queue<Int> = LinkedList()

        fun push(x: Int) {
            queue2.offer(x)
            //把旧的全部倒过来
            while (queue1.isNotEmpty()) {
                queue2.offer(queue1.poll())
            }
            val tmp = queue1
            queue1 = queue2
            queue2 = tmp
        }


        fun pop(): Int {
            return queue1.poll()
        }


        fun top(): Int {
            return queue1.peek()
        }


        fun empty(): Boolean {
            return queue1.isEmpty()
        }

    }
}