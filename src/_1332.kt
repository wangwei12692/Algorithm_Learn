class _1332 {
    companion object {
        fun removePalindromeSub(s: String): Int {
            if (s.length <= 1)
                return s.length
            return if (s.reversed() == s) 1 else 2
        }
    }
}