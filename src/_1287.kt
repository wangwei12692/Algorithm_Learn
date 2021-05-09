class _1287 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                findSpecialInteger(
                    intArrayOf(1, 2, 2, 6, 6, 6, 6, 7, 10)
                )
            )
        }

        fun findSpecialInteger(arr: IntArray): Int {
            val step = arr.size / 4
            for (i in arr.indices) {
                if (arr[i] == arr[i + step])
                    return arr[i]
            }
            return -1
        }
    }
}