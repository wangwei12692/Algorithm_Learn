class _69 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(mySqrt(4))
        }

        fun mySqrt(x: Int): Int {
            var lo = 1
            var hi = x
            while (lo <= hi) {
                val mid = lo + (hi - lo) / 2
                if (mid * mid == x) {
                    return mid
                } else if (mid * mid < x) {
                    lo = mid + 1
                } else {
                    hi = mid - 1
                }
            }
            return hi
        }
    }
}