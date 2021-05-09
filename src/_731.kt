import java.util.*
import kotlin.math.max

class _731 {
    companion object {
        val delta = TreeMap<Int, Int>()

        fun book(start: Int, end: Int): Boolean {
            delta[start] = delta.getOrDefault(start, 0) + 1
            delta[end] = delta.getOrDefault(end, 0) - 1
            var active = 0
            var ans = 0
            for (d in delta.values) {
                active += d
                ans = Math.max(ans, active)
            }
            if (ans <= 3) {
                return true
            }
            delta[start] = delta[start]!! - 1
            delta[end] = delta[end]!! + 1
            return false
        }

    }
}