class _231 {
    companion object {
        fun isPowerOfTwo(n: Int): Boolean {
            if (n <= 0) return false
            return n.and(n - 1) == 0
        }

        fun isPowerOfTwo2(n: Int): Boolean {
            if (n <= 0) return false
            if (n == 1) return true
            return isPowerOfTwo2(n / 2)
        }

        fun isPowerOfTwo3(n: Int): Boolean {
            if (n <= 0) return false
            return n.and(-n) == n
        }
    }
}