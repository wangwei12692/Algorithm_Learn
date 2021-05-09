import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class _97 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
        fun isInterleave(s1: String, s2: String, s3: String): Boolean {
            val m = s1.length
            val n = s2.length
            if (m + n != s3.length)
                return false
            val dp = Array(m + 1) { BooleanArray(n + 1) }
            dp[0][0] = true
            for (i in 0..m) {
                for (j in 0..n) {
                    val p = i + j - 1
                    if (i > 0) {
                        dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1[i - 1] == s3[p])
                    }
                    if (j > 0) {
                        dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2[j - 1] == s3[p])
                    }
                }
            }
            return dp[m][n]
        }
    }
}