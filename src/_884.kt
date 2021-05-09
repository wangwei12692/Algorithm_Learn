class _884 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun uncommonFromSentences(A: String, B: String): Array<String> {
            val ac = A.split(" ")
            val bc = B.split(" ")
            val map = mutableMapOf<String, Int>()
            for (s in ac) {
                map[s] = map.getOrDefault(s, 0) + 1
            }
            for (s in bc) {
                map[s] = map.getOrDefault(s, 0) + 1
            }
            return map.filter { it.value == 1 }.map { it.key }.toTypedArray()
        }
    }
}