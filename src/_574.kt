class _574 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
        fun distributeCandies(candyType: IntArray): Int {
            val set = candyType.toSet()
            return if (set.size > candyType.size / 2) candyType.size / 2 else set.size
        }
    }
}