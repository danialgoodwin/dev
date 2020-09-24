# Software Design Cheat Sheet



## Resources
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

