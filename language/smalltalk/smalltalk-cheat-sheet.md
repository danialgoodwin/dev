# Smalltalk Cheat Sheet

History:

Smalltalk was the beginning of full object-oriented design.


Many variations of Smalltalk:

- Smalltalk-80
- [GNU Smalltalk](http://smalltalk.gnu.org/): A free implementation of Smalltalk-80 ([learn](https://www.gnu.org/software/smalltalk/manual/html_node/Tutorial.html))
- Pharo
- [Squeak](http://squeak.org/): More of an academic language now ([learn](http://www.squeakbyexample.org/))
- Dolphin


## Quickstart / How to get started

### Pharo

1. Download executable program from [http://pharo.org/download](http://pharo.org/download)
2. Run the executable
3. In the 'image' (aka, program), close the welcome prompt, left-click on the background to show a menu, then go to Tools->Transcript
4. In the console that pops up, type `Transcript cr; show: 'Hello, World!'`. (The `cr` means 'carriage return', )
5. Highlight the line, right-click, then select 'Do it' to run the command

You should see the output in the same transcript window to know that it works.



## Snippet

### FizzBuzz

    (1 to: 100) do:
    	[:n |
        ((n \\ 3) * (n \\ 5)) isZero
          ifFalse: [Transcript show: n].
    		(n \\ 3) isZero
    			ifTrue: [Transcript show: 'Fizz'].
    		(n \\ 5) isZero
    			ifTrue: [Transcript show: 'Buzz'].
    		Transcript cr.]



## More Info
- TODO: https://www.youtube.com/watch?v=WLoXXFxU8lw
- TODO: [http://web.cecs.pdx.edu/~harry/musings/SmalltalkOverview.html](http://web.cecs.pdx.edu/~harry/musings/SmalltalkOverview.html)


- Meh:
  - The meta-discussion on Reddit: https://www.reddit.com/r/programming/comments/1ym59q/smalltalk_getting_started_with_the_language/
  - YouTube: 'RailsConf 09: Robert Martin, "What Killed Smalltalk Could Kill Ruby, Too' https://www.youtube.com/watch?v=YX3iRjKj7C0
- Nah:
  - Stack Overflow 'Best way to start with Smalltalk in a Windows environment (closed)' http://stackoverflow.com/questions/3448383/best-way-to-start-with-smalltalk-in-a-windows-environment-win-7
