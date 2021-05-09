class _1588 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            sumOddLengthSubarrays2(intArrayOf(1,2,3,4,5))
        }

        fun sumOddLengthSubarrays(arr: IntArray): Int {
            val n = arr.size
            var ans = 0
            val pre = IntArray(n + 1)
            for (i in 0 until n) {
                pre[i + 1] = pre[i] + arr[i]
            }

            for (i in 1..n step 2) {
                for (j in 1..n) {
                    if (j - i >= 0) {
                        ans += (pre[j] - pre[j - i])
                    }
                }
            }
            return ans
        }

        fun sumOddLengthSubarrays2(arr: IntArray): Int {
            val n = arr.size
            var ans = 0
            for (i in 0 until n) {
                val leftOdd = (i + 1) / 2
                val leftEven = (i) / 2 + 1
                val rightOdd = (n - i) / 2
                val rightEven = (n - 1 - i) / 2 + 1
                ans += arr[i] * (leftOdd * rightOdd + leftEven * rightEven)
            }
            return ans
        }
    }
}