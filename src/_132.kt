import kotlin.math.min

class _132 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(minCut("aab"))
        }

        fun minCut(s: String): Int {
            val n = s.length
            val dp = Array(n) { BooleanArray(n) }
            for (len in 0 until n) {
                for (i in 0 until n - len) {
                    val j = i + len
                    if (len == 0) {
                        dp[i][j] = true
                    } else if (len == 1) {
                        dp[i][j] = s[i] == s[j]
                    } else {
                        dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1]
                    }
                }
            }
            //f[i] = 0
            // f[i] = min(f[i], check(0..i-1) + 1)
            val f = IntArray(n) { Int.MAX_VALUE }
            for (i in 0 until n) {
                if (dp[0][i]) {
                    f[i] = 0
                } else {
                    for (j in 0 until i) {
                        if (dp[j + 1][i]) {
                            f[i] = min(f[i], f[j] + 1)
                        }
                    }
                }
            }
            return f[n - 1]
        }


    }
}