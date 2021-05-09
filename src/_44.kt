class _44 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(isMatchDp("aa", "a"))
            println(isMatchDp("aa", "*"))
            println(isMatchDp("cb", "?a"))
            println(isMatchDp("adceb", "*a*b"))
        }

        fun isMatchDp(s: String, p: String): Boolean {
            val m = s.length
            val n = p.length
            val dp = Array(m + 1) { BooleanArray(n + 1) }
            dp[0][0] = true

            for (i in 0 .. m) {
                for (j in 1 .. n) {
                    if (i - 1 >= 0 && (s[i - 1] == p[j - 1] || p[j - 1] == '?')) {
                        dp[i][j] = dp[i - 1][j - 1]
                    } else if (p[j - 1] == '*') {
                        //zero
                        val zero = dp[i][j - 1]
                        //onePlus
                        val onePlus = i - 1 >= 0 && dp[i - 1][j]
                        dp[i][j] = zero || onePlus
                    }
                }
            }
            return dp[m][n]
        }


        fun isMatch(s: String, p: String): Boolean {
            return dfs(s, 0, p, 0)
        }

        private fun dfs(s: String, i: Int, p: String, j: Int): Boolean {
            if (i == s.length && j == p.length)
                return true
            if (i == s.length) {
                if (p[j] == '*')
                    return dfs(s, i, p, j + 1)
                return false
            }
            if (j == p.length)
                return false
            if (s[i] == p[j] || p[j] == '?') {
                return dfs(s, i + 1, p, j + 1)
            } else if (p[j] == '*') {
                //zero
                if (dfs(s, i, p, j + 1)) {
                    return true
                }
                //one
                var c = i + 1
                while (c <= s.length) {
                    if (dfs(s, c, p, j)) {
                        return true
                    }
                    c++
                }
            }
            return false
        }
    }
}