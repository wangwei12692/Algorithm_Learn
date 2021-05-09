import java.util.*
import kotlin.math.max
import kotlin.math.min

class _42 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
            //                     0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3
            println(trap2(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
            println(trap4(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
        }

        fun trap4(height: IntArray): Int {
            var left = 0
            var right = height.size - 1
            var leftMax = 0
            var rightMax = 0
            var ans = 0
            while (left <= right) {
                if (leftMax < rightMax) {
                    ans += max(0, leftMax - height[left])
                    leftMax = max(leftMax, height[left])
                    left++
                } else {
                    ans += max(0, rightMax - height[right])
                    rightMax = max(rightMax, height[right])
                    right--
                }
            }
            return ans
        }

        fun trap3(height: IntArray): Int {
            var ans = 0
            var current = 0
            val stack = Stack<Int>()
            while (current < height.size) {
                while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                    val top = stack.pop()
                    if (stack.isEmpty())
                        break
                    val distance = current - stack.peek() - 1
                    val bound_height = min(height[current], height[stack.peek()]) - height[top]
                    ans += distance * bound_height
                }
                stack.push(current++)
            }
            return ans
        }

        fun trap2(height: IntArray): Int {
            var ans = 0
            val n = height.size
            val leftMax = IntArray(n)
            val rightMax = IntArray(n)
            leftMax[0] = height[0]
            for (i in 1 until n) {
                leftMax[i] = max(height[i], leftMax[i - 1])
            }
            rightMax[n - 1] = height[n - 1]
            for (i in n - 2 downTo 0) {
                rightMax[i] = max(height[i], rightMax[i + 1])
            }
            for (i in 1 until n) {
                ans += min(leftMax[i], rightMax[i]) - height[i]
            }
            return ans
        }

        fun trap(height: IntArray): Int {
            var ans = 0
            for (i in 1 until height.size) {
                var maxLeft = 0
                var maxRight = 0
                for (j in i downTo 0) {
                    maxLeft = max(maxLeft, height[j])
                }
                for (j in i until height.size) {
                    maxRight = max(maxRight, height[j])
                }
                ans += min(maxLeft, maxRight) - height[i]
            }
            return ans
        }
    }
}