# GGP: General Game Playing #

## Developing My Strategy (Not Finalized) ##
1. Check if I can make a move.
2. Calculate my current "score".
3. Calculate my max possible "score" for next move. Go ahead and win if possible. Have a list of my top moves.
4. Calculate current "score" for other players.
5. Calculate max possible "score" for other player's next move (this is be slow, need alpha-beta pruning and more). Have a list of their top moves.
6. Figure out what maximizes my score and limits opponents (one who could win) next move. Eventually, figure out if a different player can stop opponent instead so that I can make a better move.


### Idea for adding to above strategy ###
- Figure out my worst move, and opponents' worst move. Try to avoid other players forcing my worst move. Try to force opponents' worst move.
- AI will need to be recursive-like because my best may create a much better move for opponent, which may create an even better move for me... Also, a really good move for me may suddenly lead for a bad position.


## My Notes ##
- When first pre-loading game, should check all moves from beginning of empty board rather than randomly assigning pieces to save on some computation.
- If possible, try to save as many states as possible.
- Try to solve the simple problem first. (Sidenote: Think about caching that strategy if it will be useful)
- Prefer deep (uncalculated) trees to making a bad move for self, or creating a good move for opponent.
- Even if there is only one move available (meaning, only one that can't lose). Don't make the move. Yet. Use the extra time to calculate further down the trees for subsequent moves. (Sidenote: Hmmm, unless caching isn't allowed, then there wouldn't be a use to calculate moves that will be forgotten?)
- Favor more opportunities for play when all else is equal. Something may be good in those deep trees may be discovered later.
- Try to limit opponents' moves.
- Alpha-beta pruning may be too restrictive?
- Could graphs be helpful in some cases? Moreso than trees?


## Questions ##
- Can my player do not play when required instead of allowing opponent to win?


## More Info ##
- [http://games.stanford.edu/](http://games.stanford.edu/)


## Sources I've seen so far ##
- [Tic-Tac-Chess-Checkers-4](http://games.stanford.edu/index.php/2-uncategorised/23-tic-tac-chess-checkers-4)
- [GGP Coursera: Grand Finals](http://www.twitch.tv/ggp_coursera/c/3344077)
- [GGP Coursera: A Game With 4 Players](http://www.twitch.tv/ggp_coursera/c/3344105)
- [GGP Coursera: How Good Are GGP Players?](http://www.twitch.tv/ggp_coursera/c/3344167)
