class _166 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(fractionToDecimal(-50, 8))
        }

        fun fractionToDecimal(numerator: Int, denominator: Int): String {
            if (numerator == 0)
                return "0"
            val fraction = StringBuilder()
            if ((numerator < 0).xor(denominator < 0)) {
                fraction.append("-")
            }
            val dividend = Math.abs(numerator.toLong())
            val divisor = Math.abs(denominator.toLong())
            fraction.append(dividend / divisor)
            var remainder = dividend % divisor
            if (remainder == 0L)
                return fraction.toString()
            fraction.append(".")
            val map = mutableMapOf<Long, Int>()
            while (remainder != 0L) {
                if (map.containsKey(remainder)) {
                    fraction.insert(map.get(remainder)!!, "(")
                    fraction.append(")")
                    break
                }
                map[remainder] = fraction.length
                remainder *= 10L
                fraction.append(remainder / divisor)
                remainder %= divisor
            }
            return fraction.toString()
        }
    }
}