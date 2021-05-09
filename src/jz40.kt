class jz40 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(getLeastNumbers(intArrayOf(3, 2, 1), 2).joinToString())
        }

        fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
            sort.quickSort(arr)
            return arr.copyOfRange(0, k)
        }
    }
}