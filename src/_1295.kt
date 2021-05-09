class _1295 {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(findNumbers(intArrayOf(12, 345, 2, 6, 7896)))
        }

        fun findNumbers(nums: IntArray): Int {
            return nums.filter { it.nums() % 2 == 0 }.size
        }

        fun Int.nums(): Int {
            if (this == 0)
                return 1
            var count = 0
            var num = this
            while (num % 10 != 0) {
                num /= 10
                count++
            }
            return count
        }

    }


}