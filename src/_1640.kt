class _1640 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
            val num = IntArray(101)
            for (i in arr) {
                num[i]++
            }
            for (p in pieces) {
                for (n in p) {
                    if (num[n]-- <= 0) {
                        return false
                    }
                }
            }
            return true
        }
    }
}