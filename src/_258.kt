class _258 {
    companion object {
        fun addDigits(num: Int): Int {
            var n = num
            var sum = 0
            while (n != 0) {
                sum += n % 10
                n /= 10
            }
            return sum
        }
    }
}