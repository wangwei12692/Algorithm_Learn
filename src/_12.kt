class _12 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(intToRoman(58))
            println(intToRoman(1994))
        }

        private val thousands = arrayOf("", "M", "MM", "MMM")
        private val hundreds = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
        private val tens = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
        private val ones = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")

        fun intToRoman(num: Int): String {
            return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10]
        }
    }
}