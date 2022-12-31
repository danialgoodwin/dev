@file:Suppress("ClassName")

import extensions.log
import java.math.BigInteger
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/*
A list initially contains the numbers .
At each round, the smallest number in the list is replaced by its square. If there is more than one such number, then only one of them is replaced.

For example, below are the first three rounds for :



Let  be the sum of all numbers in the list after  rounds.

For example, . Also .

Find . Give your answer modulo .

Source: https://projecteuler.net/problem=822

Solved:
Note:

 */

@OptIn(ExperimentalTime::class)
fun main() {
    log("main()")
    val time = measureTime {
//        val sum = Q822_SquareTheSmallest.solve(5, 3) // 17ms
//        log("sum: $sum") // 34
        val sum = Q822_SquareTheSmallest.solve(10, 100) // 32ms
        log("sum: $sum") // 845339386
//        val sum = Q822_SquareTheSmallest.solve(10E4.toInt(), 10E16.toLong()) // Exception: Java heap space
//        log("sum: $sum")
    }
    log("time: $time")
}

object Q822_SquareTheSmallest {

    private val mod = 1_234_567_891.toBigInteger()
    private val intermediateMod = mod * mod

    fun solve(n: Int, rounds: Long) : Long {
        val sortedList = Array(n - 1) { BigInteger((it + 2).toString()) }
        log("sortedList: ${sortedList.contentToString()}")
        for (i in 1..rounds) {
            val first = sortedList.first()
            sortedList[0] = first * first
//            sortedList[0] = (first * first).mod(intermediateMod)
            sortedList.sort()
        }
        log("sortedList: ${sortedList.contentToString()}")
        return (sortedList.reduce { acc, b -> acc + b }.mod(mod)).toLong()
//        return (sortedList.sum() % mod).toLong()
    }

}
