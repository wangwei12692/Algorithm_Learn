import java.util.*


class _204 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(countPrimes(499979))
        }

        fun countPrimes(n: Int): Int {
            val isPrime = IntArray(n) { 1 }
            //当前的质数集合
            val primes = mutableListOf<Int>()
            for (i in 2 until n) {
                if (isPrime[i] == 1) {
                    primes.add(i)
                }
                var j = 0
                while (j < primes.size && i * primes[j] < n) {
                    isPrime[i * primes[j]] = 0
                    if (i % primes[j] == 0)
                        break
                    j++
                }

            }
            return primes.size
        }
    }
}