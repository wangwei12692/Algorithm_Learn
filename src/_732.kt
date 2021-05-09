import java.util.*

class _732 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val three = MyCalendarThree()
            three.book(10,20)
            three.book(50,60)
            three.book(10,40)
            three.book(5,15)
            three.book(5,10)
            three.book(25,55)
        }
    }
    class MyCalendarThree() {
        private val delta = TreeMap<Int, Int>()

        fun book(start: Int, end: Int): Int {
            delta[start] = delta.getOrDefault(start, 0) + 1
            delta[end] = delta.getOrDefault(end, 0) - 1
            var active = 0
            var ans = 0
            for (d in delta.values) {
                active += d
                if (active > ans)
                    ans = active
            }
            return ans
        }

    }
}