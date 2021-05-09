class _1304 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(sumZero(5).joinToString())
        }

        fun sumZero(n: Int): IntArray {
            val ans = IntArray(n)
            for (i in 0 until n / 2) {
                ans[i] = i + 1
                ans[n - i - 1] = -(i + 1)
            }
            return ans
        }
    }
}