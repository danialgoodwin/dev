@file:Suppress("ClassName")

import extensions.log
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
    log("main()")
    val time = measureTime {
//        Q803_PseudorandomSequence.test2()
        Q803_PseudorandomSequence.test()
        Q803_PseudorandomSequence.solve()
    }
    log("time: $time")
}

object Q803_PseudorandomSequence {

    fun test2() {
        var c = c(A(2686975L), 0, 8)
        log("c: $c")
        c = c(A(2686976L), 0, 8)
        log("c: $c")
        c = c(A(2686977L), 0, 8)
        log("c: $c")
    }

    fun test() {
        val a0_1 = 78580612777175L
        val c = c(A(a0_1), 0, 8)
        log("c: $c")
        assert(c == "EULERcats")

        val a0_2 = 123456L
        val c2 = c(A(a0_2), 0, 8)
        log("c2: $c2")
        val c3 = c(A(a0_2), 100, 108)
        log("c3: $c3")
        assert(c2 == "bQYicNGCY")
        assert(c3 == "RxqLBfWzv")
        log("PASS")
    }

    fun solve() {
        val a = findA0("Puzzl")  // 2.5s, a0: 57_237_103. 240ms when adding nextA0(...)
//        val a = findA0("Puzzle")  // 840s = 14m, a0: 16813736630. 64s when adding nextA0(...)
//        val a = findA0("PuzzleO") // 30+ minutes on 2022-12-30
//        val a = findA0("PuzzleOne")
        log("a0: ${a.a0}")
        log("c: " + c(a, 0, 9))

        // Find index of 'LuckyText' using a0
//        val index = findIndex(a, "Luck") // 1.5s at index 5_171_493
//        val index = findIndex(a, "Lucky") // 13.4s at index 58_722_414
        val index = findIndex(a, "LuckyT") // 7m at index 1_763_494_524
//        val index = findIndex(a, "LuckyText")
        log("index: $index")
    }

    private fun findA0(textToFind: String) : A {
        val textSize = textToFind.count()
        var a0 = nextA0(-1L, textToFind)
        val b = B(A(a0))
        while (true) {
            val a = A(a0)
            for (i in 0..textSize) { // Could start with 1 because 0 will already be the first letter because of nextA0(...)
                if (i == textSize) return a
                if (i == textSize - 2) log("Checking a0: $a0")
                val bChar = b.get(a, i.toLong())
                if (bChar != textToFind[i]) {
                    if (i == 0) {
                        a0 = nextA0(a0, textToFind)
                    }
                    break
                }
            }
            a0++
        }
    }

    private fun nextA0(previousA0: Long, textToFind: String) : Long {
        val offset = puzzleCode(textToFind[0]) *  2.0.pow(16).toLong()
        val wrapMultiplier = 52 * 2.0.pow(16.0).toLong()
        if (previousA0 == -1L) return offset
        return ((previousA0 / wrapMultiplier) + 1) * wrapMultiplier + offset
    }

    // TODO: Improve code by only checking each index once
    private fun findIndex(a: A, textToFind: String) : Long {
        log("findIndex(\"$textToFind\")")
        var index = 0L
        val b = B(a)
        while (true) {
            if (b.get(a, index) == textToFind[0]) {
                if (c(a, index, index + textToFind.count() - 1) == textToFind) {
                    return index
                }
            }
            index++
        }
    }

    private fun c(a: A, start: Long, stopInclusive: Long) : String {
        val sb = StringBuilder()
        val b = B(a)
        for (i in start..stopInclusive) {
            sb.append(b.get(a, i))
        }
        return sb.toString()
    }

    private fun puzzleCode(c: Char) : Int {
        return when (c) {
            in 'a'..'z' -> c.code - 'a'.code
            in 'A'..'Z' -> c.code - 'A'.code + 26
            else -> 0
        }
    }

    class A(val a0: Long) {

        private val aCache = LruCache<Long, Long>(100)
        private var previousN = 0L
        private var previousNResult = a0

        fun get(n: Long) : Long {
            if (n == 0L) return a0
//            if (n == previousN + 1) {
//                val newA = (25214903917 * previousNResult + 11).mod(2.0.pow(48.0).toLong())
//                previousN = n
//                previousNResult = newA
//                return newA
//            }
            return aCache.getOrPut(n) {
                (25214903917 * get(n - 1) + 11).mod(2.0.pow(48.0).toLong())
            }
        }

        override fun toString(): String {
            return "A(a0=$a0)"
        }

    }

    class B(initialA: A) {

        private var previousA0 = initialA
        private var previousA0Result = translate((initialA.get(0) / 2.0.pow(16) % 52).toInt())

        fun get(a: A, n: Long) : Char {
            if (a.a0 == previousA0.a0 && n == 0L) return previousA0Result
//            if (a.a0 == previousA0.a0 + 1 && n == 0L) {
//                val newB = nextChar(previousA0Result)
//                previousA0 = a
//                previousA0Result = newB
//                return newB
//            }
            val b = (a.get(n) / 2.0.pow(16) % 52).toInt()
            val c = translate(b)
            return c
        }

        private fun translate(n: Int): Char {
            return when (val validN = n % 52) {
                26 -> 'A'
                27 -> 'B'
                28 -> 'C'
                29 -> 'D'
                30 -> 'E'
                31 -> 'F'
                32 -> 'G'
                33 -> 'H'
                34 -> 'I'
                35 -> 'J'
                36 -> 'K'
                37 -> 'L'
                38 -> 'M'
                39 -> 'N'
                40 -> 'O'
                41 -> 'P'
                42 -> 'Q'
                43 -> 'R'
                44 -> 'S'
                45 -> 'T'
                46 -> 'U'
                47 -> 'V'
                48 -> 'W'
                49 -> 'X'
                50 -> 'Y'
                51 -> 'Z'
                in 0..25 -> (validN + 'a'.code).toChar()
                else -> '?'
            }
        }

        private fun nextChar(c: Char) : Char {
            val puzzleCode = when (c) {
                in 'a'..'z' -> c.code - 'a'.code
                in 'A'..'Z' -> c.code - 'A'.code + 26
                else -> 0
            }
            return translate(puzzleCode + 1)
        }

    }

}
