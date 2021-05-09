class _50 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(myPow2(2.0000, -2))
        }

        fun myPow2(x: Double, n: Int): Double {
            if (n < 0) {
                return 1 / myPow2(x, -n)
            }
            var res = x
            var num = n
            var t = 1.0
            while (num > 1) {
                if (num % 2 == 1) {
                    t *= res
                }
                res *= res
                num /= 2
            }
            return res * t
        }

        fun myPow(x: Double, n: Int): Double {
            if (n < 0) return 1 / myPow(x, -n)
            if (n == 0) return 1.0
            if (n == 1) return x
            return if (n % 2 == 0) {
                val v = myPow(x, n / 2)
                v * v
            } else {
                val v = myPow(x, n / 2)
                v * v * x
            }
        }
    }
}