class _338 {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(countBits(30).joinToString())
        }

        fun countBits(num: Int): IntArray {
            val ans = IntArray(num + 1)
            var highBit = 0
            for (i in 1..num) {
                if (i.and(i - 1) == 0) {
                    highBit = i
                }
                println("$i = ${i - highBit}")
                ans[i] = ans[i - highBit] + 1
            }
            return ans
        }

        private fun counts(n: Int): Int {
            var ans = 0
            var num = n
            while (num != 0) {
                num = num.and(num - 1)
                ans++
            }
            return ans
        }
    }
}