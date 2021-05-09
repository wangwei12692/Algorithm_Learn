class _9 {
    companion object {
        fun isPalindrome(x: Int): Boolean {
            if (x < 0 || x % 10 == 0 && x != 0) return false
            if (x < 10) return true
            var reversed = 0
            var n = x
            while (n > reversed) {
                reversed = reversed * 10 + n % 10
                n /= 10
            }
            return n == reversed || n == reversed / 10
        }
    }

}