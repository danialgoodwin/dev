/**
You have a fair N-sided die, but you want a fair K-sided die, so you try simulating a fair K-sided die by rolling the N-sided die some number of times.

Given N and K, return the minimum number of times you have to roll the N-sided die to get a K-sided die. Return -1 if you can't simulate it no matter how many times you roll.

You can simulate a K-sided die if you can compose the outcomes of the N-sided die rolls so that these compositions are equally likely.

Equally likely events are events that have the same theoretical probability (or likelihood) of occurring.

Example:

NumberOfRolls(4,2)=1
To simulate a 4-sided die with a 2-sided die, roll the 2-sided die twice. If the first roll is A (either 0 or 1) and the second roll is B, then 2 * A + B will equally likely be 0, 1, 2 or 3. So 2 * A + B is a fair 4-sided die.

NumberOfRolls(2,4)=2
To simulate a 2-sided die with a 4-sided die, roll the 4-sided die once. If the roll is A (0, 1, 2 or 3), then A % 2 will equally likely be 0 or 1. So A % 2 is a fair 2-sided die.

NumberOfRolls(4,3)=-1
You cannot simulate a 3 sided die with a 4 sided die.

NumberOfRolls(6,9)=2

NumberOfRolls(9,6)=-1

[input] integer N

The number of sides on the die you have, 2 ≤ N ≤ 500.
[input] integer K

The number of sides on the die you want, 2 ≤ K ≤ 500.
[output] integer

The number of rolls of the N-die you need to simulate a K-die. -1 if the simulation is not possible.

More info: https://codefights.com/challenge/5D2GH32fRawcH5LHm
*/
int NumberOfRolls(int n, int k) {
    for (int i = 0, a = n; ++i <= 9; a *= n)
        if (a % k == 0) return i;
    return -1;
}

int NumberOfRolls(int n, int k) {
    for (int i = 0; ++i <= 9;)
        if (Math.pow(n, i) % k == 0) return i;
    return -1;
}

int NumberOfRolls(int n, int k) {
    for (int i = 0; ++i <= 9;) {
        if (Math.pow(n, i) % k == 0) return i;
    }
    return -1;
}

int NumberOfRolls(int n, int k) {
    int g = g(n, k), m = Math.min(n, k), x = Math.max(n, k);
    return g(x / g, m) != 1 ? (g == m ? Math.log(g, x) : m / g) : -1;
}

int NumberOfRolls(int n, int k) {
    int g = g(n, k), m = Math.min(n, k), x = Math.max(n, k);
    int g2 = g(x / g, m);
    return g2 != 1 ? (g == m ? x : m) / g : -1;
}

int g(int a, int b) {
    return b == 0 ? a : g(b, a%b);
}

int NumberOfRolls(int n, int k) {
    int a = -1;
    int g = gcd(n, k);
    int g2 = gcd(Math.max(n, k) / g, Math.min(n, k));
    a = g2 == 1 ? -1 : ((g == Math.min(n, k) ? Math.max(n, k) : Math.min(n, k)) / g);
    return a;
}

int NumberOfRolls(int N, int K) {
    int a = -1;
    if (N == K) a=1;
    else if (N < K) {
        a = power(K, N);
    } else {
        a = N % K == 0 ? N / K : a;
    }
    if (a == -1) {
        int g = gcd(N, K);
        if (g != N && g != K) {
            a = Math.min(N, K) / g;
        }
    }
    return a;
}

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a%b);
}

int power(int a, int b) {
    int p = -1;
    for (int i = 0; ++i <= 9;) if (a == Math.pow(b, i)) p = i;
    return p;
}
