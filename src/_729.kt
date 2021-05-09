import java.util.*

class _729 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            book(10, 20)
            book(15, 25)
            book(20, 30)
        }

        private val delta = TreeMap<Int, Int>()

        fun book(start: Int, end: Int): Boolean {
            val prev = delta.floorKey(start)
            val next = delta.ceilingKey(start)
            if ((prev == null || delta[prev]!! <= start) && (next == null || end <= next)) {
                delta[start] = end
                return true
            }
            return false
        }
    }
}