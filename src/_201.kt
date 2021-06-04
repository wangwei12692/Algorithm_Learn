class _201 {
    companion object{
        fun rangeBitwiseAnd(left: Int, right: Int): Int {
            var lo =  left
            var hi = right
            var shift = 0
            while(lo < hi){
                lo = lo.shr(1)
                hi = hi.shr(1)
                shift++
            }

            return lo.shl(shift)
        }
    }
}