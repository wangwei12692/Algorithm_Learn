class _27 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                removeElement(intArrayOf(0,1,2,2,3,0,4,2),2)
            )
        }

        fun removeElement(nums: IntArray, `val`: Int): Int {
            var idx = 0
            var i = 0
            while (i < nums.size) {
                if (nums[i] != `val`) {
                    nums[idx++] = nums[i++]
                } else
                    i++
            }
            return idx
        }

    }
}