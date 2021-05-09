class _11 {
    companion object {
        fun maxArea(height: IntArray): Int {
            if (height.size <= 1)
                return 0
            var max = 0
            for ((i, v) in height.withIndex()) {
                for (j in i + 1 until height.size) {
                    val area = (j - i) * Math.min(v, height[j])
                    max = Math.max(max, area)
                }
            }
            return max
        }

        fun maxArea2(height: IntArray): Int {
            if (height.size <= 1) return 0
            var lh = 0
            var rh = height.size - 1
            var ans = 0
            while (lh < rh) {
                ans = Math.max(ans,(rh -lh) * Math.min(height[lh],height[rh]))
                if (height[lh] > height[rh]) {
                    rh--
                } else {
                    lh++
                }
            }

            return ans
        }

    }
}