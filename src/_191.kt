class _191 {
    //n & (n-1) 消除最低为的1
    // n & (~n +1) == n & (-n)获取最低位的1
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            for (n in 1..10) {
                println(n.and(-n))
                println(n.and(n.inv() + 1))
                println(">>>")
            }
        }

        fun hammingWeight(n: Int): Int {
            var num = n
            var ans = 0
            while (num > 0) {
                num = num.and(num - 1)
                ans++
            }
            num.takeLowestOneBit()
            return ans
        }
    }
}