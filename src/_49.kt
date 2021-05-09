import java.util.*

class _49 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                groupAnagrams(
                    arrayOf(
                        "eat", "tea", "tan", "ate", "nat", "bat"
                    )
                )
            )
        }

        class Bean(val str: String, val mark: IntArray = IntArray(26)) {
            init {
                for (c in str) {
                    mark[c - 'a']++
                }
            }

            operator override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false
                other as Bean
                if (str.length != other.str.length)
                    return false
                if (!mark.contentEquals(other.mark))
                    return false
                return true
            }

            override fun hashCode(): Int {
                return mark.contentHashCode()
            }

        }

        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val beans = strs.map { Bean(it) }
            val map = mutableMapOf<Int, MutableList<String>>()
            for (bean in beans) {
                map.getOrPut(bean.hashCode(), { mutableListOf() }).add(bean.str)
            }
            val ans = mutableListOf<List<String>>()
            for (value in map.values) {
                ans.add(value)
            }
            return ans
        }
    }
}