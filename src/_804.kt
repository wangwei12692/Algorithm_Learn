class _804 {
    companion object {
        private val map = arrayOf(
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--.."
        )

        fun uniqueMorseRepresentations(words: Array<String>): Int {
            val set = mutableSetOf<String>()
            val sb = StringBuilder()
            for (word in words) {
                sb.clear()
                for (c in word) {
                    sb.append(map[c - 'a'])
                }
                set.add(sb.toString())
            }
            return set.size
        }
    }
}