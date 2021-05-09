import java.util.*

class _71 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(simplifyPath("/a/../../b/../c//.//"))
        }

        fun simplifyPath(path: String): String {
            val stack = Stack<String>()
            val ps = path.split("/").filter { it != "" }
            if (ps.size > 0 && ps[0] != "." && ps[0] != "..") {
                stack.add(ps[0])
            }
            for (i in 1 until ps.size) {
                if (ps[i] == ".") {
                    continue
                } else if (ps[i] == "..") {
                    if (stack.size > 0) {
                        stack.pop()
                    }
                } else {
                    stack.push(ps[i])
                }
            }
            return stack.joinToString( "/", "/")
        }
    }
}