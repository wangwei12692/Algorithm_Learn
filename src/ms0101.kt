class ms0101 {
    companion object{
        fun isUnique(astr: String): Boolean {
            var mark = 0
            for (c in astr) {
                val offset = c - 'a'
                if (mark.and(1.shl(offset)) != 0) {
                    return false
                }
                mark = mark.or(1.shl(offset))
            }
            return false
        }
    }
}