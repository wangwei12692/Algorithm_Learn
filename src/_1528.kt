class _1528 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(restoreString("codeleet".toCharArray(), intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)))
        }


        fun restoreString(s: CharArray, indices: IntArray): String {
            for (i in indices.indices) {
                if (indices[i] != i) {
                    println("$i: ${String(s)}")
                    var c = s[i]
                    var idx = indices[i]
                    while (idx != i) {
                        val t = s[idx]
                        s[idx] = c
                        c = t

                        val idt = indices[idx]
                        indices[idx] = idx
                        idx = idt
                    }
                    s[i] = c
                    indices[i] = i
                }

            }
            return String(s)
        }

        fun restoreString(s: String, indices: IntArray): String {
            val ans = CharArray(s.length)
            for (i in indices.indices) {
                ans[indices[i]] = s[i]
            }
            return String(ans)
        }
    }
}