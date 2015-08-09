# Haskell Cheat Sheet #

These are my notes for getting started with Haskell for the first time. My only knowledge so far is that Haskell is a functional language.

## Quick Refresher ##
- Functional programming language, everything immutable
- No for-loop or while-loop
- Lazy


## Quickstart First Time ##
1. Download the compiler and package/dependency manager for Haskell at [https://www.haskell.org/downloads/](https://www.haskell.org/downloads/).
2. Run `cabal update`

Now, you are ready to build Haskell projects!


## Quickstart - Making Your First Haskell Project ##

1. Create a file called "my-haskell-practice.hs" and add the following contents

    main = do
        putStrln "What's your name?"
        name <- getLine
        putStrln ("Hello " ++ name)

2. Compile this program with `ghc --make my-haskell-practice.hs`.
3. Run the program with `./my-haskell-practice`.



## Gotchas I ran into ##
- When manually modifying the auto-configured `*.cabal` file, I didn't realize the double-dash `--` in front of the `hs-source-dirs` had to be removed before the compiler recognized that my source files were in the `src` directory. So, now I know about at least one type of Haskell comment.


## Datatypes ##

- Bool: True False, can use with `&&`, `||`, and `not(True)`
- Char: ''
- Tuple:
- Int: -2^63 to 2^63 - 1, check with `maxInt = maxBount :: Int`
- Integer: Unbounded size, like `BigInteger` in Java
- Float: Single-precision decimal
- Double: 11-point precision for decimals

### Aliasing ###

    always5 :: Int
    always5 = 5

## Math ##

    sumEx = 5 + 4
    subEx = 5 - 4
    multEx = 5 * 4
    divEx = 5 / 4
    negNumEx = 5 + (-4)
    modEx = mod 5 4
    modEx2 = 5 `mod` 4
    sumOfNums = sum [1..1000]
    sqrtOf9 = sqrt (fromIntegral 9) -- `sqrt` takes Float
    piVal = pi
    ePow9 = exp 9
    logOf9 = log 9
    squared9 = 9 ** 2
    truncateVal = truncate 9.999 -- Also round, ceiling, floor
    -- Also sin, cos, tan, asin, atan, acos, sinh, tanh, cosh, asinh, atanh, acosh

## Data structure ##

### List ###
Each item must contain the same type.

    primeNumbers = [3,5,7,11]
    morePrimes = primeNumbers ++ [13,17,19, 23, 29]
    favNums = 2 : 7 : 21 : 66 : [] -- Another way to create list of nums
    lenPrime = length morePrimes
    revPrime = reverse morePrimes
    isListEmpty = null morePrimes
    secondPrime = primeNumbers !! 1
    firstPrime = head primeNumbers
    lastPrime = last primeNumbers
    allButLastPrime = init primeNumbers
    first3Primes = take 3 primeNumbers
    notFirst3Primes = drop 3 primeNumbers
    is7InList = 7 `elem` primeNumbers
    maxPrime = maximum primeNumbers
    minPrime = minimum primeNumbers
    prodPrimes = product primeNumbers

    zeroToTen = [0..10]
    evenList = [2,4..20]
    letterList = ['A', 'C'..'Z'] -- every other letter
    infiniteList = [10, 20..] -- lazily created
    many2s = take 10 (repeat 2)
    many3s = replicate 10 3
    cycleList = take 10 (cycle [1,2,3,4,5])
    listTimes2 = [x * 2 | x <- [1..10]]
    listTimes3 = [x * 3 | x <- [1..20], x * 3 <= 50] -- last argument is filter
    divisBy9And13 = [x | x <- [1..500], x `mod` 9 == 0, x `mod` 13 == 0]
    sortedList = sort [3,1,4,5,2,3]
    sumOfLists = zipWith (+) [1,2,3,4,5][6,7,8,9,10]
    primesBiggerThan5 = filter (>5) primeNumbers
    evensUpTo20 = takeWhile (<=20) [2,4..]
    multOfList = foldl (*) 1 [2,3,4,5] -- left to right
    multOfList2 = foldr (*) 1 [2,3,4,5] -- right to left
    pow3List = [3^n | n <- [1..10]]
    multTable = [[x * y | y <- [1..10] | x <- [1..10]]]


### Tuple ###
Each item can contain the different type.

    randTuple = (1, "Random Tuple")
    bobSmith = ("Bob Smith", 52)
    bobName = fst bobSmith
    bobAge = snd bobSmith
    names = ["","",""]
    addresses = ["","",""]
    namesAndAddresses = zip names addresses -- Creates list of tuple pairs


## Funtions ##
In the form of `functionName param1 param2 = operations (retutrned value)`

Functions can't begin with uppercase letter.

    let num7 = 7
    let getTriple x = x * 3
    getTriple num7

    addMe :: Int -> Int -> Int -- define type declaration (optional)
    addMe x y = x + y
    sumMe x y = x + y -- This would accept any type, not just Int

    addTuples :: (Int, Int) -> (Int, Int) -> (Int, Int)
    addTuples (x, y) (x2, y2) = (x + x2, y + y2)

    whatAge :: Int -> String
    whatAge 16 = "You can drive"
    whatAge 18 = "You can vote"
    whatAge 21 = "You're an adult"
    whatAge x = "Nothing important"
    whatAge _ = "Nothing important"

    factorial :: Int -> Int
    factorial 0 = 1
    factorial n = n * factorial (n - 1)

    isOdd :: Int -> Bool
    isOdd n
        | n `mod` 2 == 0 = False
        | otherwise = True

    isEven n = n `mod` 2 == 0

    batAvgRating :: Double -> Double -> String
    batAvgRating hits atBats
        | avg <= 0.200 = "Terrible bat average"
        | avg <= 0.250 = "Average player"
        | avg <= 0.280 = "Pretty good"
        | otherwise = "Superstar"
        where avg = hits / atBats

    getListItems :: [Int] -> String
    getListItems [] = "Your list is empty"
    getListItems (x:[]) = "Your list starts with " ++ show x
    getListItems (x:y:[]) = "Your list contains " ++ show x ++ " and " ++ show y
    getListItems (x:xs) = "The list items (not first) are " ++ show xs

    getFirstItem :: String -> String
    getFirstItem [] = "Empty String"
    getFirstItem all@(x:xs) = "The first letter in " ++ all ++ " is " ++ show [x]

### Higher-order functions ###

    times4 :: Int -> Int
    times4 x = x * 4
    listTimes4 = map times4 [1,2,3,4,5]

    doMult :: (Int -> Int) -> Int
    doMult func = func 3
    num3Times4 = doMult times4

    getAddFunc :: Int -> (Int -> Int)
    getAddFun x y = x + y
    adds3 = getAddFunc 3
    fourPlus3 = adds3 4
    threePlusList = map adds3 [1,2,3,4,5]

    multBy4 :: [Int] -> [Int]
    multBy4 [] = []
    multBy4 (x:xs) = times4 x : multBy4 xs

    areStringsEq :: [Char] -> [Char] -> Bool
    areStringsEq [] [] = True
    areStringsEg (x:xs) (y:ys) = x == y && areStringsEq xs ys
    areStringsEeq _ _ = False

### Lambda ###
Functions with names

    double1To10 = map (\x -> x * 2)[1..10]

## Conditional ##

    < <= == /= >= >
    && || not

    -- if-conditions require else in Haskell
    doubleEvenNumber y =
        if (y `mod` 2 /= 0)
            then y
        else y * 2


## Module ##

    -- List of functions
    module SampleFunctions (getClass, anotherFunc) where
        getClass :: <something>

        anotherFunc :: <Something>

Then, import with `import SampleFunctions`


## Emumeration ##

    data BaseballPlayer = Pitcher
        | Catcher
        | Infielder
        | Outfield
        deriving Show
    barryBonds :: BaseballPlayer -> Bool
    barryBonds Outfield = True

    data Customer = Customer String String Double
        deriving Show
    tomSmith :: Customer
    tomSmith = Customer "Tome Smith" "123 Main" 20.50
    getBalance :: Customer -> Double
    getBalance (Customer _ _ b) = b

    data RPS = Rock | Paper | Scissors
    shoot :: RPS -> RPS -> String
    shoot Paper Rock = "Paper beats Rock"
    shoot Rock Scissors = "Rock beats Scissors"
    shoot Rock Paper = "Rock loses to Paper"
    shoot _ _ = "Error"

    data Shape = Circle Float FLoat Float | Rectangle Float Float Float Float
    area :: Shape -> Float
    area (Circle _ _ r) = pi * r ^ 2
    area (Rectange x y x2 y2) = (abs (x2 - x)) * (abs $ y2 - y) -- $ gets rid of parenths

    sumValue = putStrLn (show (1 + 2))
    sumValue2 = putStrLn . show $ 1 + 2


## Type class ##

    data Employee = Employee { name :: String,
        position :: String,
        idNum :: Int
      } deriving (Eq, Show) -- Allows equality to be done, and to show as string.
    samSmith = ...
    pamMarx = ...

    data ShirtSize S | M | L
    instance Eq ShirtSize where
        S == S = True
        M == M = True
        L == L = True
        _ == _ = False
    instance Show ShirtSize where
        show S = "Small"
        show M = "Medium"
        show L = "Large"

    class MyEq a where
        areEqual :: a -> a -> Bool
    instance MyEq ShirtSize where
        areEqual S S = True
        areEqual M M = True
        areEqual L L = True
        areEqual _ _ = False


## File IO ##

    writeToFile = do
        theFile <- openFile "test.txt" WriteMode
        hPutStrLn theFile ("Random line of text")
        hClose theFile

    readFromFile = do
        theFile2 <- openFile "test.txt" ReadMode
        contents <- hGetContents theFile2
        putStr contents
        hClose theFile2


## GHCI ##
Haskell REPL

    ghci -- start the REPL
    :l MY_FILE_NAME -- load a file to be active during the REPL
    :r -- reload the file
    :q -- quit the REPL


## Snippet ##

    fib = 1 : 1 : [a + b | (a, b) <- zip fib (tail fib)]
    fib300 = fib !! 300 -- Get 300th Fibonacci value


## Further Resources ##
- [http://howistart.org/posts/haskell/](http://howistart.org/posts/haskell/): This was my first long article I read about Haskell for getting started. It's good and I got my first Haskell project up and running quickly. This article will make the code that's in the `BassBull` directory.
- Haven't read all of yet: http://stackoverflow.com/questions/1012573/getting-started-with-haskell
- Great: [Haskell Tutorial](https://www.youtube.com/watch?v=02_H3LjqMr8)
