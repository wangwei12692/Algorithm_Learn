class _1342 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(numberOfSteps(14))
        }
        fun numberOfSteps(num: Int): Int {
            if (num == 0) return 0
            if (num % 2 == 1)
                return numberOfSteps(num - 1) + 1
            return numberOfSteps(num / 2) + 1
        }
    }
}