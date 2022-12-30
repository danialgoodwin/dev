import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/*
Reversible prime squares
Problem 808

Both 169 and 961 are the square of a prime. 169 is the reverse of 961.

We call a number a reversible prime square if:

It is not a palindrome, and
It is the square of a prime, and
Its reverse is also the square of a prime.
169 and 961 are not palindromes, so both are reversible prime squares.

Find the sum of the first 50 reversible prime squares.

Source: https://projecteuler.net/problem=808

Solved: 2022-12-29. "You are the 1132nd person to have solved this problem."
Note: Runs in about 21 seconds, and I haven't tried to improve it much yet.
 */

object Q808_ReversiblePrimeSquares {

    @OptIn(ExperimentalTime::class)
    fun main() {
        println("main()")
        val time = measureTime {
            solve(100_000_000)
        }
        println("time: $time")
    }

    private fun solve(n: Int) {
        PrimeNumbers.calculatePrimes(n)
        val primesArray = PrimeNumbers.array
        val primesList = PrimeNumbers.list
        //    println("primesArray: ${primesArray.contentToString()}")
        //    println("primesList: $primesList")
        println("primesList.size: ${primesList.size}")
        val primeSquares = primesList.map { it * it }
        //    println("primeSquares: $primeSquares")
        val primesSquaresSet = primeSquares.toSet()
        val reversiblePrimeSquarePrimes = mutableListOf<Long>()
        for (prime in primesList) {
            val reversedPrimeSquare = (prime * prime).toString().reversed().toLong()
            if (reversedPrimeSquare == prime * prime) continue
            if (primesSquaresSet.contains(reversedPrimeSquare)) reversiblePrimeSquarePrimes.add(prime)
        }
        println("reversiblePrimeSquaresPrimes: $reversiblePrimeSquarePrimes")
        val reversiblePrimeSquares = reversiblePrimeSquarePrimes.map { it * it }
        //    println("reversiblePrimeSquares: $reversiblePrimeSquares")
        println("reversiblePrimeSquares.size: ${reversiblePrimeSquares.size}")
        println("reversiblePrimeSquares.sum: " + reversiblePrimeSquares.sum())
    }

}
