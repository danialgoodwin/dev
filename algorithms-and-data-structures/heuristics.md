# Heuristics #
When the problem is too big for precise calculations, or an accuracy-time tradeoff is acceptable.



## Random sampling ##
Useful method when there are a high proportion of acceptable solutions. Or, when there is no coherence in the solution space and no other method would get you "closer" to a solution.

### Monte Carlo ###
Repeatedly try random solutions, evaluate them, and stop when there is a good enough solution or when tired of waiting.



## Genetic Algorithms ##
Simulates evolution and natural selection. Random mutations occur. If helpful, children are more likely to survive and reproduce. If harmful, children are much less likely to survive and reproduce.

Note: The Algorithm Design Manual recommends not using this.



## Neural Networks ##
Simulate a brain, introduce artificial intelligence.


## Ant Colony Optimization ##


## Parallel Algorithms ##

- Any speedup is only scalar. It may be better to create a better algorithm with asympotic speedup instead.
- Parallel algorithms are tough to debug and profiling tools don't work as well.
- The different processors may be doing redundant work (already done by another machine).



## Further Resources ##
- The Algorithm Design Manual by Skiena (Note: Most of words/sentences on this page have come directly from this great book. I recommend it as a great read.)
