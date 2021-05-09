class _8 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(myAtoi("-000000000000000001"))
        }
        fun myAtoi(s: String): Int {
            var state = 0 // 0 init 1 valid
            var ans = 0
            var isNeg = false
            for (c in s) {
                if (state == 0) {
                    if (c == '-' || c == '+') {
                        isNeg = c == '-'
                        state = 1
                    } else if (c - '0' in 0..9) {
                        ans = ans * 10 + (c - '0')
                        state = 1
                    }
                }else if (state == 1) {
                    if (c - '0' in 0..9) {
                        val prev = ans
                        ans = ans * 10 + (c - '0')
                        if (ans / 10 != prev) {
                            //overflow
                        }
                    } else {
                        break
                    }
                }
            }
            return if (isNeg) -ans  else ans
        }
    }
}