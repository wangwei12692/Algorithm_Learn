package sort

import java.lang.StringBuilder

class _443 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')))
        }

        fun compress(chars: CharArray): Int {
            if (chars.size < 2) return chars.size
            var last = 0
            var idx = 0
            for (i in chars.indices) {
                if (i + 1 < chars.size && chars[i] != chars[i + 1] || i == chars.size - 1) {
                    val char = chars[i]
                    val count = i - last + 1
                    chars[idx++] = char
                    if (count != 1) {
                        for(nc in count.toString())
                            chars[idx++] = nc
                    }
                    last = i + 1
                }
            }

            return idx
        }
    }
}