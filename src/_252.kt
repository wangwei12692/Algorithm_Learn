import java.util.*

class _252 {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(canAttendMeetings(listOf(
                listOf(0,30),
                listOf(5,10),
                listOf(15,20),
            )))

            println(canAttendMeetings(listOf(
                listOf(7,10),
                listOf(2,4),
            )))
        }


        fun canAttendMeetings(intervals: List<List<Int>>): Boolean {
            val sorted = intervals.sortedBy { it[0] }
            for(i in 1 until sorted.size)
                if (sorted[i-1][1] > sorted[i][0])
                    return false
            return true
        }



    }
}