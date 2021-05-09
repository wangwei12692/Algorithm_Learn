import kotlin.random.Random

class _470 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(11 % 10)
        }
    }

    private class SolBase() {

        fun rand102(): Int {
            while (true) {
                val a = (rand7() - 1) * 7
                val b = rand7()
                val c = a + b
                if (c > 40) continue
                return c % 10 + 1
            }
        }

        fun rand10(): Int {
            while (true) {
                val res = rand7() * rand7()
                if (res >= 40) {
                    continue
                }
                return res % 10 + 1
            }
        }

        fun rand7(): Int {
            //1..7
            return Random.nextInt(7)
        }
    }
}