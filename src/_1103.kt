class _1103 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(distributeCandies(10,3).joinToString())
        }
        fun distributeCandies(candies: Int, num_people: Int): IntArray {
            val ans = IntArray(num_people)
            var cand = candies
            var id = 0
            var cur = 1
            while (cand > 0) {
                if (cand - cur >= 0) {
                    ans[id] += cur
                } else {
                    ans[id] += cand
                    break
                }
                cand -= cur
                cur++
                id = (id + 1) % num_people
            }

            return ans
        }
    }
}