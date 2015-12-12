/**
You're given a string S, consisting only of lowercase Latin letters. Find whether it is possible to convert it into a palindrome by inserting only one character.

If it is possible, return the index (0-based Index) where the character should be inserted. If there is more than one, return the smallest one. If it is not possible, return -1.

Example

S("aa") = 0

[input] string S

A string of lowercase Latin letters, 1 ≤ |S| ≤ 100.
[output] integer


More info: https://codefights.com/challenge/EXG4oGKqzX4rXw2Gh
*/
// Note: this latest idea doesn't work, but something like it could.
int l, a = -1, z = 1, i = 0;
int MakePalindrome(String s) {
    l = s.length();

    for (; i <= l - z; i++) {
        if (s.charAt(i) != s.charAt(l - z - i)) {
            if (a == -1) {
                a = i;
                z = 2;
            } else {
                a = -1;
                break;
            }
        }
    }
    return a;
}





int a = -1, l;
int MakePalindrome(String s) {
    l = s.length();

    for (; a++ < l;) {
        StringBuffer t = new StringBuffer(s);

        if (a != l / 2 || l % 2 > 0) t.deleteCharAt(l - a - (a > l / 2 ? 0 : 1));

        if (t.toString().equals(t.reverse().toString())) return a;
    }
    return -1;
}



int MakePalindrome(String s) {
    int l = s.length();
    for (int a = 0; a <= l; a++) {
        StringBuilder sb = new StringBuilder(s);
        if (a < l / 2) {
            sb.deleteCharAt(l - 1 - a);
        } else if (a > l / 2) {
            sb.deleteCharAt(l - a);
        } else {
            if (l % 2 == 1) sb.deleteCharAt(a);
        }
        if (isPal(sb.toString())) {
            return a;
        }
    }
    return -1;
}

boolean isPal(String s) {
    int l = s.length();
    for (int i = 0; i < l / 2; i++) {
        if (s.charAt(i) != s.charAt(l - 1 - i)) {
            return false;
        }
    }
    return true;
}
