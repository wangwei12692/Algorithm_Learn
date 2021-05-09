class _7 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(reverse(123))
        }

        fun reverse(x: Int): Int {
            var res = 0
            var n = x
            while (n != 0) {
                val pop = n % 10
                n /= 10
//                if (res > Int.MAX_VALUE / 10 || (res == Int.MAX_VALUE / 10 && pop > 7)) {
//                    return 0
//                }
//                if (res < Int.MIN_VALUE / 10 || (res == Int.MIN_VALUE / 10 && pop < -8)) {
//                    return 0
//                }
                res = res * 10 + pop
                if (res % 10 != pop) {
                    return 0
                }
            }
            return res
        }
    }
}