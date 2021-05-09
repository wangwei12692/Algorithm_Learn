class _1550 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun threeConsecutiveOdds(arr: IntArray): Boolean {
            var count = 0
            for (n in arr) {
                if (n % 2 != 0) {
                    count++
                    if (count == 3) {
                        break
                    }
                } else {
                    count = 0
                }
            }
            return count == 3
        }
    }
}