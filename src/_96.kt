import kotlin.math.max

class _96 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(numTrees(4))
            println(numTreesDp(4))
        }

        fun numTrees(n: Int): Int {
            if (n <= 2) return n
            var ans = 0

            for (i in 1..n) {
                val left = max(i - 1, 1)
                val right = max(n - i, 1)
                ans += numTrees(left) * numTrees(right)
            }
            return ans
        }

        fun numTreesDp(n: Int): Int {
            val dp = IntArray(n + 1)
            dp[0] = 1
            dp[1] = 1
            for (i in 2..n) {
                for (j in 1..i) {
                    dp[i] += dp[j - 1] * dp[i - j]
                }
            }
            return dp[n]
        }
    }
}