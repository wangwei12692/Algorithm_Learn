class jz58_2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(reverseLeftWords("abcdefg",2))
        }
        fun reverseLeftWords(s: String, n: Int): String {
            val str = s + s
            return str.substring(n, n + s.length)
        }
    }
}