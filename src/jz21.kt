import sort.swap

class jz21 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(exchange(intArrayOf(1,2,3,4)).joinToString())
        }
        fun exchange(nums: IntArray): IntArray {
            var lo = 0
            var hi = nums.size - 1
            while (lo < hi) {
                if (nums[lo] % 2 == 1) {
                    lo++
                } else if (nums[hi] % 2 == 0) {
                    hi--
                } else {
                    nums.swap(lo++, hi--)
                }
            }
            return nums
        }

        fun IntArray.swap(i: Int, j: Int) {
            val t = this[i]
            this[i] = this[j]
            this[j] = t
        }
    }
}