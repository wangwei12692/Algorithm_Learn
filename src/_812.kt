import kotlin.math.abs
import kotlin.math.max

class _812 {
    companion object {
        fun largestTriangleArea(points: Array<IntArray>): Double {
            val n = points.size
            var ans = 0.0
            for (i in 0 until n) {
                for (j in i + 1 until n) {
                    for (k in j + 1 until n) {
                        ans = max(ans, areaOf(points[i], points[j], points[k]))
                    }
                }
            }
            return ans
        }

        fun areaOf(p: IntArray, q: IntArray, r: IntArray): Double {
            return 0.5 * abs(p[0] * q[1] - +q[0] * r[1] + r[0] * p[1] - p[1] * q[0] - q[1] * r[0] - r[1] * p[0])
        }
    }
}