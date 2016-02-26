# Compiler Cheat Sheet
(Including 'compiler compilers').



## Compiler Implementation

1. Lexical analysis (aka lexing, tokenize, scan): Convert input to tokens.
2. Syntactical analysis (aka parsing): Check grammar of tokens sequence.
3. Semantic analysis: Provide some meaning to tokens.
4. Optimization
5. Code generation



## Types of compilers

- LALR
  - Prefers left-recursion because it results in lower stack usage than right-recursion.
  - Ex: Yacc (LALR(1)),
- LR
  - Pro: Supports left and right recursion.
  - Menhir (LR(1) for OCaml)
- LL
  - Con: Can't parse left-recursion.
  - Ex: JavaCC, Jacc
- Recursive Decent
  - Pro: Easiest to implement (but may be harder to maintain?).
- Hand-written
- [Recursive Ascent](https://en.wikipedia.org/wiki/Recursive_ascent_parser): Similar to LR with output easier to edit.

Note: The first 'L' means left-to-right parsing. The second letter of 'L' means top-down parsing finds the left-most derivation (always expands left-most non-terminal). The second letter of 'R' means bottom-up parsing finds the right-most derivation (always expands right-most non-terminal).

Right-recursive grammars can be used for right-associative operators, and left-recursive grammars can be used for left-associative operators. [more info](http://www.cs.man.ac.uk/~pjj/cs212/ho/node5.html#SECTION00052000000000000000)


### [JavaCC](https://javacc.java.net/)
[Download](https://java.net/projects/javacc/downloads)

    java -cp ../bin/lib/javacc.jar javacc Simple1.jj
    javac * .java
    java Simple1


- Okay: [Looking for lex and yacc for Java? You don't know Jack](http://www.javaworld.com/article/2077315/java-app-dev/looking-for-lex-and-yacc-for-java--you-don-t-know-jack.html)



## More Topics
- [Parser combinator](https://en.wikipedia.org/wiki/Parser_combinator): Combine parsers to a new more complex parser.



## More Info
-


### Already read and took notes

- Meh:
  - [How to build an interpreter in Java, Part 2: The structure](http://www.javaworld.com/article/2076954/core-java/how-to-build-an-interpreter-in-java--part-2--the-structure.html)
  - [Build your own languages with JavaCC](http://www.javaworld.com/article/2076269/learn-java/build-your-own-languages-with-javacc.html): Build a minimal calculator with JavaCC.
  - [The JavaCC FAQ](http://www.engr.mun.ca/~theo/JavaCC-FAQ/javacc-faq-moz.htm)
  - [DCCC: DooMeeR's Compiler Compiler Compiler](http://www.doomeer.com/dccc.html)

- Nah:
  - http://stackoverflow.com/questions/11016556/grammar-compiler-compiler-for-java
