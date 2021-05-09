import java.util.*
import kotlin.math.max
import kotlin.math.min

class _121 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val prices = intArrayOf(7, 1, 5, 3, 6, 4)
            println(maxProfit(prices))
            println(maxProfit2(prices))
        }

        fun maxProfit2(prices: IntArray): Int {
            val dp = IntArray(prices.size)
            dp[0] = 0
            for (i in 1 until prices.size - 1) {
                dp[i] = max(dp[i - 1] + prices[i] - prices[i - 1], prices[i] - prices[i - 1])
            }
            return dp.max()!!
        }

        fun maxProfit(prices: IntArray): Int {
            var max = 0
            val minStack = Stack<Int>()
            for (price in prices) {
                if (minStack.isEmpty()) {
                    minStack.push(price)
                } else {
                    if (minStack.peek() < price) {
                        max = Math.max(price - minStack.peek(), max)
                    } else {
                        minStack.pop()
                        minStack.push(price)
                    }
                }
            }
            return max
        }
    }
}