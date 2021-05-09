class _409 {
    companion object {
        fun longestPalindrome(s: String): Int {
            val mark = IntArray(128)
            for (c in s) {
                mark[c - 'a']++
            }
            var haveOdd = false
            var len = 0
            for (n in mark) {
                if (n % 2 == 0) {
                    len++
                }else {
                    haveOdd = true
                }
            }
            return len * 2 + if (haveOdd) 1 else 0
        }
    }
}