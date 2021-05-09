class _1200 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
            arr.sort()
            var minDiff = Int.MAX_VALUE
            for (i in 1 until arr.size) {
                minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[i - 1]))
            }

            val ans = mutableListOf<List<Int>>()
            for (i in 1 until arr.size) {
                if (Math.abs(arr[i] - arr[i - 1]) == minDiff) {
                    ans.add(listOf(arr[i - 1], arr[i]))
                }
            }
            return ans
        }
    }
}