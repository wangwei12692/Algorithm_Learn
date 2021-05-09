class _349 {
    companion object {
        fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
            val set1 = nums1.toSet()
            val set2 = nums2.toSet()
            val ans = mutableListOf<Int>()
            for (n in set1) {
                if (set2.contains(n))
                    ans.add(n)
            }
            return ans.toIntArray()
        }
    }
}