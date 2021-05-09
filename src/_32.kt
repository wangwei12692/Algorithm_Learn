class _32 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(longestValidParentheses(")()())"))
        }

        fun longestValidParentheses(s: String): Int {
            if (s.isEmpty()) return 0
            val dp = IntArray(s.length)
            dp[0] = 0
            //dp[i] = dp[i-1] + 2 + {dp[i - dp[i-1]]}
            for (i in 1 until s.length) {
                val current = s[i]
                if (current == ')' && s[i - 1] == '(') {
                    dp[i] = dp[i - 2] + 2
                } else if (current == ')' && dp[i - 1] > 0) {
                    if (s[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
                    }
                }
            }
            return dp.max()!!
        }
    }
}