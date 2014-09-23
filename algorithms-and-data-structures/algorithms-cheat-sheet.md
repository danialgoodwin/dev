# Algorithms Cheat Sheet #
Last updated: 2014-01-07

## Big-O ##
Extra Resources:

- [1] Video lectures: [https://class.coursera.org/algo-004/lecture](https://class.coursera.org/algo-004/lecture "Coursea")
- [2] Big-O cheat sheet: [http://bigocheatsheet.com/](http://bigocheatsheet.com/ "Big-O Cheat Sheet")
- [3] More info: [http://stackoverflow.com/questions/487258/plain-english-explanation-of-big-o](http://stackoverflow.com/questions/487258/plain-english-explanation-of-big-o "StackOverflow")

Basically, Big-O represents the complexity of an algorithm.
Basically, Big-O is the upper-bound representation of the complexity of an algorithm. Big-O notation, also called "asymptotic growth" notation, is what functions "look like" when you ignore constant factors and stuff near the origin. Used to talk about how things scale.


### Notes ###

- Complexity of algorithms is usually compared at when running a lot of numbers, typically 10,000 or more.
- When algorithm involves multiple complexities, then we only care about the most significant portion (the longest-running portion).
- There is a best case, expected case, and worst case scenario when running an algorithm. Sometimes they are the same. [1]
- This does NOT represent how _fast_ algorithms will run.


### Order of magnitudes ###
Let _c_ be a constant and _n_ be number of items.

    Complexity              Name                               Example
    O(1)                    constant
    O(log log n)            double logarithmic
    O(log n)                logarithmic                        binary search
    O(n^c), 0<c<1           fractional power
    O(n)                    linear
    O(n log n) = O(log n!)  loglinear (sometimes superlinear)  quicksort, mergesort
    O(n^2)                  quadratic                          insertion sort, selection sort
    O(n^3)                  cubic
    O(n^c), c>1             polynomial, or algebraic
    O(c^n), c>1             exponential
    O(n!)                   factorial                          permutations of n items
    O(n^n)                  

    log * n -> log star n -> iterative logarithmic: as many logs it takes to get result < 1. (For Furer multiplication, 2007)


### Simple Examples ###

    O(1)
    n=1:    1 second
    n=10:   1 second
    n=100:  1 second

    O(n)
    n=1:    1 second
    n=10:   10 seconds
    n=100:  100 seconds

    O(n^2)
    n=1:    1 second
    n=10:   100 seconds
    n=100:  10000 seconds


### Notations for asymptotic growth ###
    Algorithm   Pronounced  Performance Bound                       Growth                  Basically
    o(n)        small-oh    < n         upper, not tight            less than
    O(n)        big-oh      ≤ n         upper, tightness unknown    less than or equal      Worst-case
    Θ(n)        theta       = n         upper and lower, tight      equal                   Always
    Ω(n)        big-omega   ≥ n         lower, tightness unknown    greater than or equal   Best-case
    ω(n)        small-omega > n         lower, not tight            greater than


## Logarithms Refresher ##
 - More info: [http://mathrefresher.blogspot.com/2006/03/logarithms.html](http://mathrefresher.blogspot.com/2006/03/logarithms.html)
 - More info: [http://www.purplemath.com/modules/graphlog.htm](http://www.purplemath.com/modules/graphlog.htm)

    log(x, y) = n    same as    x^n=y
    log(e, x)        same as    ln(x), "natural log"


### Logarithmic Properties ###
    Let a,b be any two real, nonzero numbers. "logx" means log of base x.
    logx a + logx b = logx (ab)
    logx a - logx b = logx (a/b)
    b*logx a = logx (a^b)
    logx a = log(a) / log(x)

## P vs NP ##
- Algorithms with polynomial running times (O(n^c)) are considered to be efficient, in that we could implement and run them for reasonable large inputs.
- Exponential (O(c^n), c>1)complexity classes are not efficient.


