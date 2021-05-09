class _88 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
            merge(nums1, 3, intArrayOf(2, 5, 6), 3)
            println(nums1.joinToString())
        }

        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
            var p0 = m - 1
            var p1 = n - 1
            var i = m + n - 1
            while (i >= 0) {
                if (p0 < 0) {
                    nums1[i--] = nums2[p1--]
                } else if (p1 < 0) {
                    nums1[i--] = nums1[p0--]
                } else {
                    if (nums1[p0] > nums2[p1]) {
                        nums1[i--] = nums1[p0--]
                    } else {
                        nums1[i--] = nums2[p1--]
                    }
                }
            }
        }
    }
}