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

    fun solve() {
        println("0: " + '0'.code)
        println("9: " + '9'.code)
        println("A: " + 'A'.code)
        println("Z: " + 'Z'.code)
        println("a: " + 'a'.code)
        println("z: " + 'z'.code)
        println("a(0): " + a(0))
        println("a(1): " + a(1))
        println("b(0): " + b(0))
        println("b(1): " + b(1))
        println("b(2): " + b(2))
        println("b(3): " + b(3))
        println("bChar(0): " + bChar(0))
        println("bChar(1): " + bChar(1))
        println("bChar(2): " + bChar(2))
        println("bChar(3): " + bChar(3))
    }

    private fun a(n: Long): Double {
        if (n == 0L) return 123456.0
        return (25214903917 * a(n - 1) + 11) % 2.0.pow(48.0)
    }

    private fun b(n: Long): Int {
        return (a(n) / 2.0.pow(16) % 52.0).toInt()
    }

    private fun bChar(n: Long): Char {
        return translate(b(n))
    }

    fun translate(n: Int): Char {
        return when (n) {
            in 0..25 -> (n + 'a'.code).toChar()
            in 26..51 -> (n - 26 + 'A'.code).toChar()
            else -> '?'
        }
    }

}