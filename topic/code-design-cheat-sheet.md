# Code Design #

Code tends to be read more often than it is written.




## [Making wrong code look wrong](http://www.joelonsoftware.com/articles/Wrong.html) ##

Levels of 'code cleanliness' achievement for programmers:

1. You don't know 'clean' code from 'unclean' code. (It all looks the same, and don't know what the syntax errors are.)
2. You have superficial ideas of cleanliness, mostly at the level of conformance to coding conventions. (Let's do it this way because the code style says to.)
3. You start to smell subtle hints of uncleanliness beneath the surface. (Somebody's bound to make an easy accidental error here, let's make that error harder to happen.)
4. You deliberately architect your code in such a way that errors stands out more. Code is more robust with introduction of (non-arbitrary) newly invented conventions that fit the project. (All code is now harder to add accidental errors to. Beginners can easily be taught the project conventions.)



## [Norris Numbers](http://www.teamten.com/lawrence/writings/norris-numbers.html) ##

There are walls that every programmer hits. This is about the lines of code (LOC) necessary to create a project.

1. The novice programmer can brute-force about a 2,000 LOC program.
2. The beginner/intermediate level programmer can handle about 20k LOC program.
3. The intermediate/expert level programmer can architect a 200k LOC program.

The skills needed for each of these 'walls' is different. Each different magnitude of program can use a different thought process and code architecture to best achieve the goals. Metaphor is 'walking/running, then driving car, then flying plane'.

Also, it's worth explicitly saying, the architect suitable for a 200k LOC program is likely not the best option for a 2k and under LOC program.



## Productivity: Now vs Later ##
(A psychology thing says we tend to overestimate benefits of now, and underestimate benefits of later.)



## Technical Debt ##



## Design Patterns ##
(This may eventually get it's own article, then directory. Hmm, actually, maybe I'll just talk a quick snippet and point to the other better resources.)



## Further Resources ##
- [Stop More Bugs with our Code Review Checklist](http://blog.fogcreek.com/increase-defect-detection-with-our-code-review-checklist-example/)
