class _1387{
    companion object{
        fun getKth(lo: Int, hi: Int, k: Int): Int {
            val memo = mutableMapOf<Int, Int>()
            memo[1] = 0
            val ans = (lo..hi).map { it to calcWeight(it, memo) }
                .sortedWith { lh, rh ->
                    if (lh.second - rh.second == 0) {
                        lh.first - rh.first
                    } else {
                        lh.second - rh.second
                    }

                }
            return ans[k - 1].first
        }

        fun calcWeight(num: Int, memo: MutableMap<Int, Int>): Int {
            if (num == 1) return 0
            val cache = memo[num]
            if (cache != null && cache != 0) {
                return cache
            }
            var res = 0
            if (num % 2 == 0) {
                res = calcWeight(num / 2, memo) + 1
            } else {
                res = calcWeight(num * 3 + 1, memo) + 1
            }
            memo[num] = res
            return res
        }
    }
}