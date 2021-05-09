class _91 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(numDecodings2("12"))
        }


        fun numDecodings2(s: String): Int {
            val dp = IntArray(s.length + 1)
            dp[0] = 1
            for (i in 1..s.length) {
                val lo = if (s[i - 1] == '0') 0 else dp[i - 1]
                val hi =
                    if (i - 2 >= 0 && s[i - 2] != '0' && ((s[i - 2] - '0') * 10 + (s[i - 1] - '0')) <= 26) dp[i - 2] else 0
                dp[i] = lo + hi
            }
            return dp[s.length]
        }


        var ans = 0
        fun numDecodings(s: String): Int {
            dfs(s, 0)
            return ans
        }

        private fun dfs(s: String, k: Int) {
            if (k >= s.length) {
                ans++
                return
            }
            if (s[k] != '0') {
                dfs(s, k + 1)
            }
            if (k + 1 < s.length && s[k] != '0' && ((s[k] - '0') * 10 + (s[k + 1] - '0')) <= 26) {
                dfs(s, k + 2)
            }
        }
    }
}