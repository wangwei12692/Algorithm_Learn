class _13 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(romanToInt("III"))
            println(romanToInt("IV"))
            println(romanToInt("IX"))
            println(romanToInt("LVIII"))
            println(romanToInt("MCMXCIV"))
        }
        private val map = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000,
        )

        fun romanToInt(s: String): Int {
            var ans = 0
            for (i in 1 until s.length) {
                if (map[s[i]]!! > map[s[i - 1]]!!) {
                    ans += - map[s[i - 1]]!!
                } else {
                    ans += map[s[i - 1]]!!
                }
            }
            ans += map[s.last()]!!
            return ans
        }
    }
}