import kotlin.math.max

class _978 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(maxTurbulenceSize(intArrayOf(9, 4, 2, 10, 7, 8, 8, 1, 9)))
        }

        fun maxTurbulenceSize2(arr: IntArray): Int {
            val n = arr.size
            var left = 0
            var right = 0
            var max = 0
            while (right < n - 1) {
                if (left == right) {
                    if (arr[left] == arr[left + 1]) {
                        left++
                    }
                    right++
                } else {
                    if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                        right++
                    } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                        right++
                    } else {
                        left = right
                    }
                }
                max = max(max, right - left + 1)
            }
            return max
        }

        fun maxTurbulenceSize(arr: IntArray): Int {
            val n = arr.size
            val dp = Array(n) { IntArray(2) { 1 } }
            for (i in 1 until n) {
                if (arr[i - 1] > arr[i]) {
                    dp[i][0] = dp[i - 1][1] + 1
                } else if (arr[i - 1] < arr[i]) {
                    dp[i][1] = dp[i - 1][0] + 1
                }
            }
            return dp.maxOf { max(it[0], it[1]) }
        }

    }
}