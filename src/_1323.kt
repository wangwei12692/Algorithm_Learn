class _1323 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(maximum69Number(9669))
        }
        fun maximum69Number(num: Int): Int {
            var n = num
            var last = -1
            var idx = 0
            while (n != 0) {
                if (n % 10 == 6) {
                    last = idx
                }
                idx++
                n /= 10
            }
            if (last != -1) {
                return num + 3 * Math.pow(10.0, last.toDouble()).toInt()
            }
            return num
        }
    }
}