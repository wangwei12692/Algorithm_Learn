class _374 : GuessGame() {
    override fun guessNumber(n: Int): Int {
        return guessHelper(1, n)
    }

    private fun guessHelper(low: Int, hi: Int): Int {
        val mid = low + (hi - low) / 2
        val cmp = guess(mid)
        if (cmp == 0)
            return mid
        else if (cmp < 0)
            return guessHelper(low, mid - 1)
        else
            return guessHelper(mid + 1, hi)
    }
}

open class GuessGame {
    fun guess(int: Int): Int = 0
    open fun guessNumber(n: Int): Int = 0
}