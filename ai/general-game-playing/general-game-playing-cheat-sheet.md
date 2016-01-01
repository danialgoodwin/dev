# General Game Playing Cheat Sheet#

"General Game Players are system able to play arbitrary games effectively based solely on formal descriptions supplied at runtime. Translation: They don't know the rules until the game starts. They must figure out for themselves the legal moves and winning strategy in the face of uncertainty and resource bounds."

- Finite Synchronous Games: With these limitations, it's possible in principle to communicate game info in for the form state graphs.
  - Environment
    - Finitely many states
    - One initial state and one or more terminal states
    - Each state has a unique goal value for each player
  - Players
    - Fixed, finite number of players
    - Each with finitely many moves
  - Dynamics
    - Finitely many steps
    - All players move on all steps (some no ops)
    - Environment changes only in response to moves
-



- Game Description Language (GDL) is a formal language for encoding the rules of games. Game rules written as sentences in Symbolic Logic.
  - GDL extensions are application in real-world applications such as Enterprise Management and Computational Law.



- Game Management is the process of administering a game in General Game Playing.
  - Match = instance of a game.
  - Components:
    - Game Manager
    - Game Playing Protocol

## Game Description ##

A logic program is a collection of sentences that define relations either directly by enumeration or indirectly in the form of logical rules.

- Components: (variables must start with upper case, constants must start with lower case.)
  - Object constants: a, b, c
  - Function constants: f, g, h
  - Relation constants: p, q, r
  - Variables: X, Y, Z
- Terms:
  - Object constants: a, b
  - Variables, X, Y, Z
  - Functional terms: f(a), g(X, b)

The arity of a function constant or relation constant is the number of arguments that can be associated with the function constant or relation constant in writing complex expressions in the language.

role(a) means that a is a role in the game.
base(p) means that p is a base proposition in the game.
input(r,a) means that a is a feasible action for role r.
init(p) means that the proposition p is true in the initial state.
true(p) means that the proposition p is true in the current state.
does(r,a) means that role r performs action a in the current state.
next(p) means that the proposition p is true in the next state.
legal(r,a) means it is legal for role r to play action a in the current state.
goal(r,n) means that player the current state has utility n for player r.
terminal means that the current state is a terminal state.



## Game Management ##

- The Game Manager can send the following messages to players
  - info() to make sure player is available
  - start(id,role,description,startclock,playclock) to load datastructures
  - play(id, move)
  - stop(id, move) if game has terminated.
  - about(id) if something goes wrong


## (Game Playing)[http://logic.stanford.edu/ggp/chapters/chapter_04.html] ##



## Propnets (Propositional Nets) ##
A propnet is a directed, bipartite graph consisting of propositions alternating with connectives.



## For the Stanford course ##

### Test the Gamer ###
Run `gradlew kiosk`, then choose the Gamer file from the top-left, then choose the game below that, then click "Run!". When it's started, select a move and play it.

### Play the Gamer over network ###
Run `gradlew player`,


## More Info ##
- (A quick guide to GDL terminology)[http://alloyggp.blogspot.com/2013/02/a-quick-guide-to-gdl-terminology.html]


Funders:

- DARPA
- SAP
