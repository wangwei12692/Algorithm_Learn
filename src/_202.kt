class _202 {
    companion object {
        fun isHappy(n: Int): Boolean {
            if (n == 1) return true
            val mark = mutableSetOf<Int>()
            var next = n
            while (n != 1) {
                next = next(next)
                if (!mark.add(n))
                    return false
            }
            return true
        }

        private fun next(next: Int): Int {
            var sum = 0
            var n = next
            while (n != 0) {
                sum += (n % 10) * (n % 10)
                n /= 10
            }
            return sum
        }
    }
}