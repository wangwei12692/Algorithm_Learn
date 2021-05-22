class _179 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(largestNumber(intArrayOf(1, 4, 5, 2)))
        }

        fun largestNumber(nums: IntArray): String {
            val sortedList =
                nums.map { it.toString() }.sortedWith(Comparator { lh, rh -> (rh + lh).compareTo(lh + rh) })
            if (sortedList[0] == "0")
                return "0"
            return sortedList.joinToString("")
        }
    }
}