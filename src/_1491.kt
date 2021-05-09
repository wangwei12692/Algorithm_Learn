class _1491 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun average(salary: IntArray): Double {
            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE
            var sum = 0
            for (s in salary) {
                min = Math.min(min, s)
                max = Math.max(max, s)
                sum += s
            }
            return (sum - min - max).toDouble() / (salary.size - 2)
        }
    }
}