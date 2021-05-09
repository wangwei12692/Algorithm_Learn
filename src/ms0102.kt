class ms0102 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun CheckPermutation(s1: String, s2: String): Boolean {
            if (s1.length!=s2.length)
                return false
            val mark = IntArray(s1.length)
            for (i in s1.indices) {
                mark[s1[i] -'a']++
                mark[s2[i] -'a']--
            }
            return mark.all { it == 0 }
        }
    }
}