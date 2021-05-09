import kotlin.math.max

class _165 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(compareVersion("1.2", "1.10"))
        }


        fun compareVersion2(version1: String, version2: String): Int {
            val v1s = version1.split(".")
            val v2s = version2.split(".")
            val n = v1s.size
            val m = v2s.size

            for (idx in 0 until max(n, m)) {
                val lh = if (idx < n) v1s[idx].toInt() else 0
                val rh = if (idx < m) v2s[idx].toInt() else 0
                if (lh != rh) {
                    return lh - rh
                }
            }
            return 0
        }

        fun compareVersion(version1: String, version2: String): Int {
            val v1s = version1.split(".")
            val v2s = version2.split(".")
            return dfs(v1s, v2s, 0, 0)
        }

        fun dfs(v1s: List<String>, v2s: List<String>, i: Int, j: Int): Int {
            if (i == v1s.size && j == v2s.size)
                return 0
            if (i == v1s.size) {
                if (v2s[j].all { it == '0' })
                    return dfs(v1s, v2s, i, j + 1)
                return -1
            }

            if (j == v2s.size) {
                if (v1s[i].all { it == '0' })
                    return dfs(v1s, v2s, i + 1, j)
                return 1
            }

            val lh = v1s[i].trimStart { it == '0' }
            val rh = v2s[j].trimStart { it == '0' }
            if (lh.length == rh.length) {
                if (lh == rh) {
                    return dfs(v1s, v2s, i + 1, j + 1)
                }
                return if (lh > rh) 1 else -1
            } else if (lh.length > rh.length) {
                return 1
            } else
                return -1
        }
    }
}