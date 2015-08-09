# Regex Cheat Sheet #

## Basics ##

### At a glance ###

    ^PATTERN            mark beginning of line
    PATTERN$            mark end of line
    [PATTERN]           set of acceptable characters, ex: `[a-z0-9]` to including all lowercase letters and numbers 0 through 9
    PATTERN{X,Y}        min of X, max of Y of PATTERN (both inclusive)
    PATTERN?            zero or one of PATTERN
    PATTERN+            one or more of PATTERN
    \d                  any digit/number
    \w                  any word, which includes letters, numbers, TODO

### Simple Examples ###

    PATTERN                         Match
    ^[a-z0-9_-]{3,16}$              my-us3r_n4m3

## Snippets ##

### Match a username ###

    ^[a-z0-9_-]{3,16}$

### Match a hex value ###
From the beginning of string[1], has zero or one[2] number sign[3], then exactly six[4] letters or numbers[5], OR[6] exactly three[7] letters or numbers[8], and then the end[9].

    132 5       4  68       7   9         
    ^#?([a-f0-9]{6}|[a-f0-9]{3})$

### Match an email address ###
From the beginning of string, text, then `@` sign[1], then text, followed by `.`[2] and 2-10 letters or periods.

                    1             2              
    ^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,10})$

- Note: There could be a `.photograph` email address, or even longer top-level domains (TLD).
- Note: TLD could be something like `.co.uk`.

### Match a URL ###

    ^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$

### Match an IP address ###

    ^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$


## Further Resources ##
- [8 Regular Expressions You Should Know](http://code.tutsplus.com/tutorials/8-regular-expressions-you-should-know--net-6149): Great explanations for the snippets.
