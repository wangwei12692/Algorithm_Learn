class _5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(longestPalindrome("cbbd"))
            println(longestPalindrome2("cbbd"))
        }

        //P(i,j)=P(i+1,j−1)∧(Si == Sj)
        fun longestPalindrome(s: String): String {
            val n = s.length
            val dp = Array(n) { BooleanArray(n) }
            var ans = ""
            for (len in s.indices) {
                for (i in 0 until n - len) {
                    val j = i + len
                    if (len == 0) {
                        dp[i][j] = true
                    } else if (len == 1) {
                        dp[i][j] = s[i] == s[j]
                    } else {
                        //长度短的上层循环处理了
                        dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1]
                    }
                    if (dp[i][j] && len + 1 > ans.length) {
                        ans = s.substring(i, j + 1)
                    }
                }
            }
            return ans
        }

        fun longestPalindrome2(s: String): String {
            var ans = ""
            for (i in 0 until s.length - 1) {
                val odd = centerSpeard(s, i, i)
                val even = centerSpeard(s, i, i + 1)
                val max = if (odd.length > even.length) odd else even
                if (max.length > ans.length) {
                    ans = max
                }
            }
            return ans
        }

        private fun centerSpeard(s: String, i: Int, j: Int): String {
            var lo = i
            var hi = j
//            while (lo >= 0 && hi < s.length) {
//                if (s[lo] != s[hi]) {
//                    break
//                }
//                lo--
//                hi++
//            }
            while (lo >= 0 && hi < s.length && s[lo] == s[hi]) {
                lo--
                hi++
            }
            return s.substring(lo + 1, hi)
        }
    }

}