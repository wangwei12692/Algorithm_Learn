class _30 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                findSubstring(
                    "wordgoodgoodgoodbestword",
                    arrayOf("word", "good", "best", "good")
                )
            )
        }

        fun findSubstring(s: String, words: Array<String>): List<Int> {
            if (words.isEmpty())
                return emptyList()
            val wordsMap = hashMapOf<String, Int>()
            val wordLen = words[0].length
            for (word in words) {
                wordsMap[word] = wordsMap.getOrDefault(word, 0) + 1
                if (wordLen != word.length)
                    return emptyList()
            }
            val ans = mutableListOf<Int>()
            for (i in 0..s.length - wordLen) {
                val mark = hashMapOf<String, Int>()
                var idx = 0
                while (i + idx * wordLen + wordLen <= s.length) {
                    val w = s.substring(i + idx * wordLen, i + idx * wordLen + wordLen)
                    if (wordsMap[w] == null) {
                        break
                    } else {
                        mark[w] = mark.getOrDefault(w, 0) + 1
                        if (mark[w]!! > wordsMap[w]!!) {
                            break
                        }
                        idx++
                        if (idx == words.size) {
                            ans.add(i)
                            break
                        }
                    }
                }
            }
            return ans
        }
    }
}