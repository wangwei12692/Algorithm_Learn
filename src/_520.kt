class _520 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun detectCapitalUse(word: String): Boolean {
            if (word.length <=1)
                return true
            var targetPattern = if (word[0].isLowerCase()) 0 else 1 // 0 low ; 1 upper
            for (i in 1 until word.length) {
                if (targetPattern == 0) {
                    if (!word[i].isLowerCase())
                        return false
                } else {
                    if (i == 1 && word[i].isLowerCase()) {
                        targetPattern = 0
                    }else if (word[i].isLowerCase()) {
                        return false
                    }
                }
            }
            return true
        }
    }
}