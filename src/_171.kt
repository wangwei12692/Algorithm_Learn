class _171 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(titleToNumber("ZY"))
        }

        fun titleToNumber3(columnTitle: String): Int {
            var result = 0
            for (i in columnTitle.indices) {
                val num = (columnTitle[i] - 'A') + 1
                result = result * 26 + num
            }
            return result
        }

        fun titleToNumber(columnTitle: String): Int {
            var result = 0
            val len = columnTitle.length
            for (i in columnTitle.indices) {
                val num = (columnTitle[i] - 'A') + 1
                result += num * Math.pow(26.toDouble(), (len - i - 1).toDouble()).toInt()
            }
            return result
        }
    }
}