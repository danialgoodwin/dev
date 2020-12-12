# Discuss: Syntax of String Interpolation

## Use case: Simple string variable
- Should there be a simple case that uses just one token VS always having a start and stop token? Ex: `$name` vs `{name}`
    - If so, then what should that prefix character be? It should be a common symbol on keyboards:
        - Symbols too common in regular text and would need escaping more often:
            - Common prefixes: `~` (about), `@`, `#`, `$`, `*` (edited/updated/bold), `!` (dev), `_` (dev)
            - Common postfixes: `!`, `$`, `%`, `-`, `*` (footnote), `.` (writer, dev), `?` (writer, dev)
            - Common infix: `&`, `,`, `/`, `+`
            - Not mentioned above: `^` 
        - Use of `$` as prefix is very common



## Existing syntax

- `'Hello, ' + name + '!'`
- `'Hello, ' name '!'`
- `'Hello, ${name}!'`
- `'Hello, $name!'`
- `f'Hello, {name}!'` (Python f-string)
- `$"Hello, {name}!"` (C#)
- `"Hello, #{name}!"` (Ruby)
- `s"Hello, $name!"` (Scala s-string)
- `printf("Hello, %s!", name)` (Java)


For no string interpolation of a variable:
- `'Hello, name!'`
- `'Hello, {name}!'` (Python f-string, without `f` prefix, aka regular string)
- `"Hello, $name!"` (Scala, without `s` prefix)
- `raw"Hello, $name!"` (Scala raw-string)


To interpolate an expression, the common syntax is using a start and stop token. Ex: `Hello, {a + b.c}!`


Special syntax for non-String data types (outputs `Count: 42.00`):
- `f"Count: $num%.2f"` (Scala f-string)
- `printf("Count: %d.2f", num)` (Java)


Additional formatting features:
- `$"Hello, {name, -8}!"` (C# will left-align and ensure 8 characters)
- `$"Count: {num, 10:F2}"` (C# will right-align and float to 2 decimal places)

Escaping braces:
- Use two braces: `$"Example: {{name}}"` (C#)



## Implementation ideas
single-quote for regular use cases with interpolation, double-quote for literal.
- Con: Hard to remember? Not intuitive for new users?
- Pro: Less syntax

single-quote for literal, double-quote for interpolation
- Perl

single-quote and double-quote for literal strings, back-tick for interpolated strings
- Perhaps slightly better than quotes because it isn't used as much in regular English

single-quote and double-quote for literal strings, nothing for interpolated strings
- Hmmm



## Multi-line strings
- 9 (or 63) ways in YAML: https://stackoverflow.com/questions/3790454/how-do-i-break-a-string-over-multiple-lines/21699210#21699210
