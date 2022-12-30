object PrimeNumbers {

    var array = Array(0) { true }
    var list = listOf<Long>()

    fun calculatePrimes(n: Int) {
        val primes = Array(n) { true }
        primes[0] = false
        primes[1] = false
        var i = 2
        while (i < primes.size - 1) {
            // If the index is a prime, then mark multiples as not-prime.
            if (primes[i]) {
                var multiple = i * 2
                while (multiple < primes.size - 1) {
                    primes[multiple] = false
                    multiple += i
                }
            }
            i++
        }
        array = primes

        // Create list of primes from the array.
        val primesList = mutableListOf<Long>()
        primes.forEachIndexed { index, isPrime ->
            if (isPrime) primesList.add(index.toLong())
        }
        list = primesList
    }

}
