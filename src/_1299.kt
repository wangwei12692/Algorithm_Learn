import kotlin.math.max

class _1299 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(replaceElements(intArrayOf(17, 18, 5, 4, 6, 1)).joinToString())
        }

        fun replaceElements(arr: IntArray): IntArray {
            val ans = IntArray(arr.size)
            for (i in 1 until arr.size) {
                for (j in i - 1 downTo 0) {
                    if (arr[i] > ans[j]) {
                        ans[j] = arr[i]
                    }
                }
            }
            ans[arr.size - 1] = -1
            return ans
        }

        fun replaceElements2(arr: IntArray): IntArray {
            var preMax = -1
            for (i in arr.size - 1 downTo 0) {
                val e = arr[i]
                arr[i] = preMax
                preMax = max(preMax, e)
            }
            return arr
        }
    }
}