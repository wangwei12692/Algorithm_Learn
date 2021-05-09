import kotlin.math.max

class _1449 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                largestNumber(
                    intArrayOf(
                        4, 3, 2, 5, 6, 7, 2, 5, 5
                    ), 9
                )
            )
        }

        fun largestNumber(cost: IntArray, target: Int): String {
            val m = cost.size
            //恰好
            val dp = Array<String?>(target + 1) { null }
            dp[0] = ""
            for (i in 1..m) {
                val c = cost[i - 1]
                for (v in c..target) {
                    val last = dp[v - c]
                    if (last == null) {
                        continue
                    } else {
                        //价值从低到高
                        dp[v] = (dp[v] ?: "") selectMax (last + i)
                    }
                }
            }
            println(dp.joinToString())
            return dp[target]?.reversed() ?: "0"
        }
    }
}

private infix fun String.selectMax(rh: String): String {
    return if (this.length != rh.length) {
        if (this.length > rh.length) this else rh
    } else {
        var selectLeft = true
        for (i in this.length - 1 downTo 0) {
            if (this[i] != rh[i]) {
                selectLeft = this[i] > rh[i]
                break
            }
        }
        if (selectLeft) this else rh
    }
}
