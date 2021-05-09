class _10 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(isMatchDp("aa", "a"))
            println(isMatchDp("aa", "a*"))
            println(isMatchDp("ab", ".*"))
            println(isMatchDp("aab", "c*a*b"))
        }

        fun isMatch(s: String, p: String): Boolean {
            return dfs(s, 0, p, 0)
        }

        private fun dfs(s: String, i: Int, p: String, j: Int): Boolean {
            if (i == s.length && j == p.length) {
                return true
            }
            if (i == s.length) {
                if (p[j] == '*') {
                    return dfs(s, i, p, j + 1)
                }
                return false
            }
            if (j == p.length)
                return false
            if (s[i] == p[j] || p[j] == '.') {
                return dfs(s, i + 1, p, j + 1)
            } else if (j + 1 < p.length && p[j + 1] == '*') {
                return dfs(s, i, p, j + 2)
            } else if (p[j] == '*' && i - 1 >= 0) {
                if (dfs(s, i, p, j + 1)) {
                    // 0
                    return true
                }
                //one+
                var cur = i
                while (cur <= s.length && (s[cur] == s[i - 1] || p[i - 1] == '.')) {
                    if (dfs(s, cur + 1, p, j)) {
                        return true
                    }
                    cur++
                }
            }
            return false
        }

        fun isMatchDp(s: String, p: String): Boolean {
            val m = s.length
            val n = p.length
            val dp = Array(m + 1) { BooleanArray(n + 1) }
            //dp[0 .. i][0..j] is match
            dp[0][0] = true
            for (i in 0..m) {
                for (j in 1..n) {
                    if (i > 0 && (s[i - 1] == p[j - 1] || p[j - 1] == '.')) {
                        dp[i][j] = dp[i - 1][j - 1]
                    } else if (p[j - 1] == '*') {
                        val matchZero = dp[i][j - 2]
                        val matchOnePlus = i - 1 >= 0 && (s[i - 1] == p[j - 2] || p[j-2] == '.') && dp[i - 1][j]
                        dp[i][j] = matchZero || matchOnePlus
                    }
                }
            }
            println(dp.contentDeepToString())
            return dp[m][n]
        }
    }
}