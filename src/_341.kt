import java.util.*

class _341 {

    abstract class NestedInteger {
        constructor()
        constructor(value: Int)

        abstract fun isInteger(): Boolean

        abstract fun getInteger(): Int?

        abstract fun setInteger(value: Int): Unit

        abstract fun add(ni: NestedInteger): Unit

        abstract fun getList(): List<NestedInteger>?
    }

    class NestedIterator2(val nestedList: List<NestedInteger>) {
        val iter  = dfsSeq(nestedList).iterator()
        fun next(): Int {
            return iter.next()
        }

        fun hasNext(): Boolean {
            return iter.hasNext()
        }


        private fun dfsSeq(nestedList: List<NestedInteger>): Sequence<Int> {
            return sequence {
                for (nest in nestedList) {
                    if (nest.isInteger()) {
                        yield(nest.getInteger()!!)
                    } else {
                        yieldAll(dfsSeq(nest.getList()!!))
                    }
                }
            }
        }
    }

    class NestedIterator(val nestedList: List<NestedInteger>) {

        private val stack = Stack<Iterator<NestedInteger>>()

        init {
            stack.push(nestedList.iterator())
        }

        fun next(): Int {
            return stack.peek().next().getInteger()!!
        }

        fun hasNext(): Boolean {
            while (stack.isNotEmpty()) {
                val it: Iterator<NestedInteger> = stack.peek()
                if (!it.hasNext()) {
                    stack.pop()
                    continue
                }
                val next: NestedInteger = it.next()
                if (next.isInteger()) {
                    stack.push(listOf(next).iterator())
                    return true
                }
                stack.push(next.getList()!!.iterator())
            }
            return false
        }


    }
}