import kotlin.math.pow
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/*
Pseudorandom sequence
Problem 803

Rand48 is a pseudorandom number generator used by some programming languages. It generates a sequence from any given integer  using the rule .

Let . The sequence  is translated to an infinite string  via the rule:
 a,  b, ,  z,  A,  B, ,  Z.

For example, if we choose , then the string  starts with: "bQYicNGCY".
Moreover, starting from index , we encounter the substring "RxqLBfWzv" for the first time.

Alternatively, if  starts with "EULERcats", then  must be .

Now suppose that the string  starts with "PuzzleOne".
Find the starting index of the first occurrence of the substring "LuckyText" in .

Source: https://projecteuler.net/problem=803

Solved:
Note:

 */

@OptIn(ExperimentalTime::class)
fun main() {
    println("main()")
    val time = measureTime {
        Q803_PseudorandomSequence.solve()
    }
    println("time: $time")
}

object Q803_PseudorandomSequence {

    // Sample a0 from question
//    private const val A0 = 78580612777175L
//    private const val A0 = 123456L

    fun solve() {
        val a = findA0("Puzzle")
//        val a0 = findA0("PuzzleOne")
        println("a0: ${a.a0}")
        println("c: " + c(a, 0, 9))

        // Find index of 'LuckyText' using a0
        // TODO
    }

    private fun findA0(text: String) : A {
        val textSize = text.count()
        var a0 = 0L
        while (true) {
            val a = A(a0)
            for (i in 0..textSize) {
                if (i == textSize) return a
                val bChar = bChar(a, i.toLong())
                if (bChar != text[i]) break
            }
            a0++
        }
    }

    private fun findIndex(a0: Long, text: String) : Long {
        var index = 0L



        return index
    }

    private fun b(a: A, n: Long): Int {
        return (a.get(n) / 2.0.pow(16) % 52.0).toInt()
    }

    private fun bChar(a: A, n: Long): Char {
        return translate(b(a, n))
    }

    private fun c(a: A, start: Long, stop: Long) : String {
        val sb = StringBuilder()
        for (i in start..stop) {
            sb.append(bChar(a, i))
        }
        return sb.toString()
    }

    fun translate(n: Int): Char {
        return when (n) {
            in 0..25 -> (n + 'a'.code).toChar()
            in 26..51 -> (n - 26 + 'A'.code).toChar()
            else -> '?'
        }
    }

    class A(val a0: Long) {

        private val aCache = mutableMapOf<Long, Long>()

        fun get(n: Long) : Long {
            if (n == 0L) return a0
            return aCache.getOrPut(n) {
                (25214903917 * get(n - 1) + 11).mod(2.0.pow(48.0).toLong())
            }
        }

    }

}