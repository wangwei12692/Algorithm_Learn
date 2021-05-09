class _1431 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
            val max = candies.max()!!
            return candies.map { it + extraCandies >= max }.toBooleanArray()
        }
    }
}