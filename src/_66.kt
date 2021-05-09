class _66 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(plusOne(intArrayOf(4, 3, 2, 1)).joinToString())
        }

        fun plusOne(digits: IntArray): IntArray {
            val n = digits.size
            val result = IntArray(n + 1)
            var curry = 1
            for (i in n - 1 downTo 0) {
                val d = digits[i]
                result[i + 1] = (d + curry) % 10
                curry = (d + curry) / 10
            }
            if (curry != 0) {
                result[0] = curry
                return result
            }
            return result.copyOfRange(1, 1 + n)
        }
    }
}