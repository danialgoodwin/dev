# Naming Conventions and The Art Of Naming #
(In-Progress)

People are biased. And, that's why your naming sucks.

There are two correct ways to read that:
1. Other people suck at reading.
2. You suck at writing.

So, if the goal is to have everybody understand the code better, then two main ways of solving that:
1. Teach everybody on the team present and future about your code.
2. Write your code to be more understandable by more people.

I don't care which method you choose for your team. But, I don't want to be interrupted by another dev to explain how the code works when that could have just been put into the comments. And, I don't want to have to repeat myself to multiple devs to explain my code. So, I'm going to choose the second method of making my code more understandable to more people. I will write it once, the best I can, and with all the comments and reasons possible so that I wouldn't have anything extra to say to somebody else asking about that piece of code.

Wouldn't it be nice if everybody else on your team just knew that you knew? Then, this whole complicated mess of bad communication with the variable names can be dismissed.

Unfortunately, even with the same information, people will interpret things differently.

Basically, everybody has their own experiences and thus finds different things intuitive.


Naming things is hard.




Naming shouldn't be hard.




Some reasons why naming things is hard:
- Devs tend to be more logical, and naming things may require a little creativity
- 

Contrary reasons why naming things should be easy:
- Because devs are logical, uses for methods and variables should have logical uses
- 


Code smells:
- Short names
  - Possibly not descriptive enough
- Very long names
  - Maybe you need a class for them instead. Example: getUserName() and getUserNotes() can be changed to something like User.getName() and User.getNotes(). This was just a simple example that can be extracted out to much longer names.


General naming ideas:
- Warning: Naming conventions are different for different languages and paradigms! Use the language conventions.
- Spend a few extra seconds thinking of good names. This will save you minutes, hours, and days in the future. (Also, it'll lower your stress and cholesterol)
- Make it so that the when reading the call later it would sound like a natural sentence and require less thinking.
- Make wrong code look wrong
- The names of the code should be self-documenting for what it is used for and what it does. That leaves comments to be used for why a particular method is used if there are any limitations
- Avoid superlatives. You are probably going to create more of them and forget which does what. Example: bigObject, largeObject, biggerObject...
- Along with that, avoid appending numbers to the end of your names. Example: `InstrumentTestCase` and `InstrumentTestCase2`.
- Assume that you are creating code for somebody new. What names would be the easiest and most intuitive for them to start moving fastest?
- Avoid abbreviations.
- Avoid "slang" terms. Assume that a dev of different culture and different first-language is going to be reading your code. In fact, go ahead an assume that the most naive and ignorant developer is going be reading your code; spell things out.
- Don't use in a name: "my", 
- Don't be afraid to rename. As you learn more about the program you are creating, you may see things in a better light. Exception, don't change the public APIs! Work extra hard at gettings those right and make the proper encapsulations are in place.

General ideas to get started:
- verbNounAdjective
- boolean is________
- Object get________
- void set, refresh, update...
- Other naming conventions




I'd like to hear your thoughts about this.


Just a few of the resource that I went through when writing this article: (basically, the first few pages from online results for "programming naming things is hard")
- Great
  - http://chrismdp.com/2012/09/the-power-of-good-naming/
  - http://petdance.com/2012/04/the-worlds-two-worst-variable-names/
  - http://blog.codinghorror.com/i-shall-call-it-somethingmanager/
  - http://www.quora.com/Computer-Science/Why-is-naming-things-hard-in-computer-science-and-how-can-it-can-be-made-easier
  - http://faculty.nps.edu/ncrowe/naming.html (Keep in mind this is a paper from 1985)
- Good
  - http://stackoverflow.com/questions/421965/anyone-else-find-naming-classes-and-methods-one-of-the-most-difficult-part-in-pr
  - http://www.jbrains.ca/permalink/the-four-elements-of-simple-design
  - http://www.yacoset.com/Home/naming-tips
  - http://crazycoders.net/the-confusion-of-indescriptive-naming-stupid-series/
  - http://www.codesimplicity.com/post/readability-and-naming-things/
  - http://www.kalzumeus.com/2010/06/17/falsehoods-programmers-believe-about-names/
  - https://www.quora.com/Software-Engineering/What-is-the-hardest-thing-you-do-as-a-software-engineer
- Meh
  - http://ubuntuforums.org/showthread.php?t=690304
  - http://www.10pines.com/blog/posts/the-art-of-naming
  - http://rossduggan.ie/blog/programming/naming-things/
  - http://pbdj.sys-con.com/node/2456281
  - http://www.itworld.com/cloud-computing/379566/don-t-go-programming-if-you-don-t-have-good-thesaurus
  - https://github.com/php-fig/fig-standards/blob/master/accepted/PSR-2-coding-style-guide.md
- Nah
  - http://www.namingthingsishard.com/
  - http://manypies.paulmorriss.com/2013/02/naming-things-is-hard.html
  - http://naminghard.blogspot.com/2011/07/programming-metaphors-you-need-part-1.html

