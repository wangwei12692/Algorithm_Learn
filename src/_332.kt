class _332 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                findItinerary(
                    listOf(
                        listOf("MUC", "LHR"),
                        listOf("JFK", "MUC"),
                        listOf("SFO", "SJC"),
                        listOf("LHR", "SFO")
                    )
                )
            )
        }

        private data class Ticket(val city: String, var used: Boolean = false)

        fun findItinerary(tickets: List<List<String>>): List<String> {
            val edges = mutableMapOf<String, MutableList<Ticket>>()
            for ((from, to) in tickets)
                edges.getOrPut(from, { mutableListOf() }).add(Ticket(to))
            edges.forEach { it.value.sortBy { it.city } }
            val marked = mutableMapOf<String, Boolean>()
            //城市的数量 = ticket + 1
            return dfs(edges, "JFK", tickets.size + 1, marked, mutableListOf())
        }

        private fun dfs(
            edges: MutableMap<String, MutableList<Ticket>>,
            from: String,
            count: Int,
            marked: MutableMap<String, Boolean>,
            travel: MutableList<String>
        ): List<String> {
            if (travel.size == count)
                return travel
            for (to in edges[from]!!) {
                if (to.used) continue
                to.used = true
                travel.add(to.city)
                val result = dfs(edges, to.city, count, marked, travel)
                if (result.isNotEmpty()) {
                    return result
                }
                travel.removeLast()
                to.used = false
            }
            return emptyList()
        }
    }

}