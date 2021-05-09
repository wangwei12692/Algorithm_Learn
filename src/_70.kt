class _70 {
    companion object {
        fun climbStairs(n: Int): Int {
            if (n <= 2) return n
            return climbStairs(n - 1) + climbStairs(n - 2)
        }
    }

}