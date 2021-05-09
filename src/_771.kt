class _771 {
    companion object {
        fun numJewelsInStones(jewels: String, stones: String): Int {
            val set = jewels.toSet()
            return stones.count { set.contains(it) }
        }
    }
}