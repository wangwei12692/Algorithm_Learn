import _75.Companion.swap

class _905 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                sortArrayByParity(
                    intArrayOf(
                        3, 1, 2, 4
                    )
                ).joinToString()
            )
        }

        fun sortArrayByParity(A: IntArray): IntArray {
            var lo = 0
            var hi = A.size - 1
            while (lo < hi) {
                if (A[lo] % 2 == 0) {
                    lo++
                }else if (A[hi] % 2 == 1) {
                    hi--
                } else {
                    A.swap(lo,hi)
                }
            }
            return A
        }
    }
}