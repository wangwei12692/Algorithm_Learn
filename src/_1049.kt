import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sign

class _1049 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(lastStoneWeightII(intArrayOf(2, 7, 4, 1, 8, 1)))
//            println(lastStoneWeightII2(intArrayOf(2, 7, 4, 1, 8, 1)))
            println(lastStoneWeightII3(intArrayOf(2, 7, 4, 1, 8, 1)))
        }

        fun lastStoneWeightII(stones: IntArray): Int {
            if (stones.size <= 1) {
                return if (stones.isEmpty()) 0 else stones[0]
            }
            return dfs(stones, 0, 0)
        }

        // = - 赋值给每个元素得到的最小绝对值
        private fun dfs(stones: IntArray, k: Int, res: Int): Int {
            if (k == stones.size)
                return abs(res)
            return min(dfs(stones, k + 1, res - stones[k]), dfs(stones, k + 1, res + stones[k]))
        }

        fun lastStoneWeightII2(stones: IntArray): Int {
            if (stones.size <= 1) {
                return if (stones.isEmpty()) 0 else stones[0]
            }
            val sum = stones.sum()
            val amount = sum / 2
            val dp = IntArray(amount + 1)
            //接近amout 的最大值
            for (stone in stones) {
                for (v in amount downTo 0) {
                    val rh = if (v - stone >= 0) dp[v - stone] + stone else 0
                    dp[v] = max(dp[v], rh)
                }
            }

            return sum - dp[amount] * 2
        }

        fun lastStoneWeightII3(stones: IntArray): Int {
            if (stones.size <= 1) {
                return if (stones.isEmpty()) 0 else stones[0]
            }
            val sum = stones.sum()
            val amount = sum / 2
            val dp = Array(stones.size + 1) { IntArray(amount + 1) }
            //接近amout 的最大值
            for (i in 1..stones.size) {
                for (v in 0..amount) {
                    val rh = if (v - stones[i - 1] >= 0) dp[i - 1][v - stones[i - 1]] + stones[i - 1] else 0
                    dp[i][v] = max(dp[i - 1][v], rh)
                }
            }
            println(dp.contentDeepToString())
            return sum - dp[stones.size][amount] * 2
        }

    }
}