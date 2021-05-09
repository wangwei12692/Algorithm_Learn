import java.lang.StringBuilder
import java.util.*

class _394 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(decodeString2("3[a2[c]]"))
        }


        fun decodeString2(s: String): String {
            val stack = Stack<String>()
            var i = 0
            while (i < s.length) {
                val c = s[i]
                if (c.isLetter() || c == '[') {
                    stack.push(c.toString())
                    i++
                } else if (c.isDigit()) {
                    var lo = i
                    while (s[lo].isDigit()) {
                        lo++
                    }
                    stack.push(s.substring(i, lo))
                    i = lo
                } else {
                    val strBuilder = mutableListOf<String>()
                    while ("[" != stack.peek()) {
                        strBuilder.add(stack.pop())
                    }
                    strBuilder.reverse()
                    val str = strBuilder.joinToString("")
                    stack.pop()
                    var count = stack.pop().toInt()
                    val sb = StringBuilder()
                    while (count-- > 0) {
                        sb.append(str)
                    }
                    stack.push(sb.toString())
                    i++
                }
            }
            return stack.joinToString("")
        }

        fun decodeString(s: String): String {
            return dfs(s)
        }

        private fun dfs(s: String): String {
            if (s.isEmpty()) return ""
            if (s[0].isLetter()) {
                val range = s.nextString()
                return s.substring(range.first, range.last) + dfs(s.substring(range.last))
            }
            val ans = StringBuilder()
            if (s[0].isDigit()) {
                val count = s.nextNum()
                val group = s.nextPattern()
                val sub = s.substring(group.first + 1, group.last)
                val cnt = s.substring(count.first, count.last).toInt()
                for (i in 0 until cnt) {
                    ans.append(dfs(sub))
                }
                ans.append(dfs(s.substring(group.last + 1)))
            }
            return ans.toString()
        }

        private fun String.nextString(): IntRange {
            var hi = length
            for (i in 0 until length) {
                if (!this[i].isLetter()) {
                    hi = i
                    break
                }
            }
            return 0..hi
        }

        private fun String.nextPattern(): IntRange {
            val stack = Stack<Char>()
            var lo = 0
            var hi = 1
            for (i in this.indices) {
                if (this[i] == '[') {
                    if (stack.isEmpty()) {
                        lo = i
                    }
                    stack.push('[')
                } else if (this[i] == ']') {
                    stack.pop()
                    if (stack.isEmpty()) {
                        hi = i
                        break
                    }
                }
            }
            return lo..hi
        }

        private fun String.nextNum(): IntRange {
            var hi = 1
            for (i in 0 until length) {
                if (!this[i].isDigit()) {
                    hi = i
                    break
                }
            }
            return 0..hi
        }
    }
}