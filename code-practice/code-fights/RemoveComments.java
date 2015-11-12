/**
S is a string with some comments inside it. Each comment looks like `/*A*/` where A is a string that doesn't have `*/` as a substring.

Remove all comments in S and return the result.

It is guaranteed that for every `/*` that begins a comment there is a `*/` that matches it. Note that a `/*` inside a comment isn't considered as a start of another comment.

Examples:

RemoveComments("ab/*c/*d*/ef")="abef"
RemoveComments("3+4*5/2*3/*3*4+6/2=15*/")="3+4*5/2*3"
RemoveComments("/*A/*B*/C*/")="C*/"
"/*A/*B*/" is a comment and "/*A/*B*/C*/"is not.
So "/*A/*B*/" is removed.
RemoveComments("/*/*/*A*/*/*/")="*A*"
RemoveComments("/*A*//*B*//*/C*/")=""
RemoveComments("ab/**/cd/*/*/ef")="abcdef"
RemoveComments("*/*~!@#$%^&*()-+*/*")="**"
RemoveComments("/** /* /*/")=""
[input] string S

A string of characters with ASCII codes from 32 to 126 inclusive.
[output] string

S without any comments.

More info: https://codefights.com/challenge/rrsq6RmFWw6uZpWme
*/
String RemoveComments(String S) {
    if (S == null || S.isEmpty()) { return ""; }
    StringBuilder sb = new StringBuilder();
    boolean isInComment = false;
    int start = 0;
    for (int i = 0, length = S.length(); i < length - 1; i++) {
        if (isInComment) {
            if (S.charAt(i) == '*') {
                if (S.charAt(i + 1) == '/') { isInComment = false; i+= 1; start = i + 1; }
            }
        } else {
            if (S.charAt(i) == '/') {
                if (S.charAt(i + 1) == '*') {
                    isInComment = true;
                    sb.append(S.substring(start, i));
                    i+= 1;
                }
            }
        }
    }
    return sb.append(S.substring(start, S.length())).toString();
}
