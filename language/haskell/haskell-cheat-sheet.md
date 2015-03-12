# Haskell Cheat Sheet #

These are my notes for getting started with Haskell for the first time. My only knowledge so far is that Haskell is a functional language.

## Quickstart First Time ##
1. Download the compiler and package/dependency manager for Haskell at [https://www.haskell.org/downloads/](https://www.haskell.org/downloads/).
2. Run `cabal update`

Now, you are ready to build Haskell projects!


## Quickstart - Making Your First Haskell Project ##
(See "Further Resources" section for more notes.)



## Gotchas I ran into ##
- When manually modifying the auto-configured *.cabal file, I didn't realize the double-dash `--` in front of the `hs-source-dirs` had to be removed before the compiler recognized that my source files were in the `src` directory. So, now I know about at least one type of Haskell comment.



## Further Resources ##
- [http://howistart.org/posts/haskell/](http://howistart.org/posts/haskell/): This was my first long article I read about Haskell for getting started. It's good and I got my first Haskell project up and running quickly. This article will make the code that's in the `BassBull` directory.
- Haven't read all of yet: http://stackoverflow.com/questions/1012573/getting-started-with-haskell
