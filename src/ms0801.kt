class ms0801 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(waysToStep(3))
        }

        fun waysToStep(n: Int): Int {
            val dp = IntArray(n)
            dp[0] = 1
            dp[1] = 2
            dp[2] = 4
            val base = 1000000007
            for (i in 3 until n) {
                dp[i] = dp[i - 1] % base + dp[i - 2] % base + dp[i - 3] % base
            }
            return dp[n - 1]
        }
    }
}