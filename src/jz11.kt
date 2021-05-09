class jz11 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(minArray(intArrayOf(3,1,3)))
        }

        fun minArray(numbers: IntArray): Int {
            var lo = 0
            var hi = numbers.size - 1
            while (lo < hi) {
                val mid = lo + (hi - lo) / 2
                println("$lo..$mid..$hi")
                if (numbers[mid] < numbers[hi]) {
                    hi = mid
                } else if (numbers[mid] > numbers[hi]) {
                    lo = mid + 1
                } else {
                    hi -= 1
                }
            }
            return numbers[lo]
        }
    }

}