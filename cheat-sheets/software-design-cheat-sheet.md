# Software Design Cheat Sheet

Code tends to be read more often than it is written.

Any code architecture pattern that defines a strict number of layers is wrong. Different sizes and complexities require different layers to stay flexible.



## [Making wrong code look wrong](http://www.joelonsoftware.com/articles/Wrong.html)

Levels of 'code cleanliness' achievement for programmers:

1. You don't know 'clean' code from 'unclean' code. (It all looks the same, and don't know what the syntax errors are.)
2. You have superficial ideas of cleanliness, mostly at the level of conformance to coding conventions. (Let's do it this way because the code style says to.)
3. You start to smell subtle hints of uncleanliness beneath the surface. (Somebody's bound to make an easy accidental error here, let's make that error harder to happen.)
4. You deliberately architect your code in such a way that errors stands out more. Code is more robust with introduction of (non-arbitrary) newly invented conventions that fit the project. (All code is now harder to add accidental errors to. Beginners can easily be taught the project conventions.)



## API Design

### [How To Design A Good API and Why it Matters - Joshua Bloch](https://www.youtube.com/watch?v=heh4OeB9A-c)

- Everybody is an API designer.

- Public APIs are forever - one chance to get it right.
- Good APIs get reused.
- Thinking in API design tends to improve quality of programs.

- Characteristics of a good API
  - Easy to learn
  - Easy to use, even without documentation
  - Hard to misuse
  - Easy to read and maintain code that uses it
  - Sufficiently powerful to satisfy requirements
  - Easy to evolve
  - Appropriate to audience

- Start with a short spec - 1 page is ideal
  - Bounce spec off as many people as possible

- API examples get heavily referenced. Thus, they should be well done.

- Most API designs are over-constrained
  - You won't be able to please everyone
  - Aim to displease everyone equally
- Expect to make mistakes
  - A few years of real-world use will flush them out
  - Expect to evolve API
- API should do one thing and do it well
  - Functionality should be easy to explain
  - If it's hard to name, that's generally a bad sign
  - Good names drive development
- API should be as small as possible, but no smaller
  - When in doubt, leave it out. You can always add, but you can never remove.
  - Conceptual weight more important than bulk
  - Look for a good power-to-weight ratio
- Names matter
  - Names should be self-explanatory
  - Be consistent, regular. Same word means same thing throughout API [and ideally, across APIs on the platform]
- Document religiously. Document every class, interface, method, constructor, parameter, exception.
  - Need to mention side-effects, include units, ownership, mutability, state space
- Consider performance consequences of API design decisions
  - Bad decisions can limit performance
  - Do not warp API to gain performance
- API must coexist peacefully with platform
- Minimize mutability
  - Pro: simple, thread-safe, reuseable
  - Con: separate object for each value
- Subclass only where it makes sense. Likcov-substitution. is-a relationship
- Design and document for inheritance or else prohibit it. Document self-use
  - Fragile-base problem
- Don't make the client do anything the module could do
  - Reduce need for boilerplate code
- Don't violate the principle of least astonishment
  - It's worth extra implementation effort
  - It's even worth reduced performance
- Fail fast
- Provide programmatic access to all data available in string form.
  - Otherwise, clients will parse strings
- Overload with care. Avoid ambiguous overloadings
- Don't use string if a better type exists
- Use consistent parameter ordering across methods
- Avoid long parameter lists. Three or less is ideal.
- Avoid return values the demand exceptional processing

### [Building First-Class Android SDKs](https://vimeo.com/album/3645585/video/144696375)
- Great SDKs:
  - easy to use: intuitive, consistent, hard to misuse, feels native to platform
  - stable: no bugs, make it testable and mockable
  - lightweight: including for battery and data from network
  - flexible: build-tools support,
  - well-supported

- Considerations
  - What need are you serving?
  - Open or closed source?
  - Packaging? (jar vs aar vs bin)
  - Host? ()



## [Norris Numbers](http://www.teamten.com/lawrence/writings/norris-numbers.html) ##
There are walls that every programmer hits. This is about the lines of code (LOC) necessary to create a project.

1. The novice programmer can brute-force about a 2,000 LOC program.
2. The beginner/intermediate level programmer can handle about 20k LOC program.
3. The intermediate/expert level programmer can architect a 200k LOC program.

The skills needed for each of these 'walls' is different. Each different magnitude of program can use a different thought process and code architecture to best achieve the goals. Metaphor is 'walking/running, then driving car, then flying plane'.

Also, it's worth explicitly saying, the architect suitable for a 200k LOC program is likely not the best option for a 2k and under LOC program.



## Resources
- Great: [Refactoring](https://sourcemaking.com/refactoring)
- [Stop More Bugs with our Code Review Checklist](http://blog.fogcreek.com/increase-defect-detection-with-our-code-review-checklist-example/)
- [The Principles of OOD](http://butunclebob.com/ArticleS.UncleBob.PrinciplesOfOod)
     - Class Design (SOLID):
         - Single Responsibility Principle: A class should have one, and only one, reason to change
         - Open Closed Principle: You should be able to extend a class's behavior, without modifying it
         - Liskov Substitution Principle: Derived classes must be substitutable for their base classes
         - Interface Segregation Principle: Make fine grained interfaces that are client specific
         - Dependency Inversion Principle: Depend on abstractions, not on concretions
     - Package Design (Cohesion): 
         - Release Reuse Equivalency Principle: The granule of reuse is the granule of release
         - Common Closure Principle: Classes that change together are packaged together
         - Common Reuse Principle: Classes that are used together are packaged together
     - Package Design (Coupling):
         - Acyclic Dependencies Principle: The dependency graph of packages must have no cycles
         - Stable Dependencies Principle: Depend in the direction of stability
         - The Stable Abstractions Principle: Abstractness increases with stability

