# Dev Interview Cheat Sheet #
(Background: This was created so that I could have a single quick place to look as a refresher for most of the basic stuff related to interviews for developers and software engineers.)


One of my biggest assets in interview may have been asking 'Do you have any questions on what I have so far?' (or similar).



## Soft Skills ##
- Be enthusiastic and curious.
- Be prepared to talk about any point on your resume for at least 5-15 minutes.
- Have three things you want the interviewer to know about you to distinguish you from other candidates. Make sure those things get mentioned and emphasized. A good time can be when they ask you to talk about yourself.
  - I'm comfortable jumping into large code bases, like AOSP, to figure out how they work.
  - I like to share new things I learn, (and blog about it), especially if any available documentation could be better. Leading question: How often do you write engineering blog posts about the work you do?
  - I'm a computer engineer. Started working in Android about four years ago, and previous to that I was working in web development.
  - I like to structure my life for productivity and efficiency. In order to make sure I keep learning new things, everyday I dedicate time for reading a book. And every week I dedicate time to exploring a new technology, which typically includes creating a sample project and writing a blog post.
  - Maybe: I'm a veteran and have been deployed overseas to Iraq/Kuwait.
- Have questions to ask about the company, like environment, technology, recent news, though not salary at this point.
  - Does your company actively support contributing to open source projects and creating new ones?
- Research recent company news for talking points.
- Know the company's products, features, what you like about it, and ways to improve it.


### Questions to prepare for ###
- `Why do you want to come to <company>?` I love a good challenge. Solve bigger problems, help more people, work on tough projects that will challenge me so that I'm still always learning. I also like how innovative and open the company is.
- `Why are you looking for a job?` I gave myself a specific timeframe to hit it big in the startup, otherwise I would pursue more 'traditional' career methods. The startup hasn't hit it big yet.
- `What challenging problems have you solved in the past?` 1. Creating an app that detects people's vital signals without touching them. 2. Building Android apps that work well on all devices despite the large fragmentation.
- `What project of yours are you most proud of?` Contactless Vital Signs app and LTE Discovery. And, in the future it will be the new programming language that I'm working on because it really analyzes everything and questions all assumptions.
- `What do you do currently?` I work in a startup, creating and supporting multiple apps. I work on the front-end, back-end, working on better tooling, and customer support. My goals are to work on something I'm interested in, make users happy, and make money for the company.
- `Why should we hire you?` I can guarantee that I will be a great fit. My biggest attributes are self-motivation and love of learning. I'm a team player and prefer open communication.
- `What would you like to do at <company>?`
- `What features would you improve at <company>?`

- What's the hardest bug you've faced?
  - Android fragmentation for telecom, mainly the broken APIs.
  -

`What's your favorite programming language?` As a simple answer.. the one that is most productive and has the least maintenance and new-feature costs. But, I also do have a more specific answer... Ceylon, Haxe, D (not Anonlang yet).

#### [Interview Cake: Coding interview Tips](https://www.interviewcake.com/article/coding-interview-tips) ####
Before diving into code, most interviewers like to chitchat about your background. They're looking for:

Metacognition about coding. Do you think about how to code well?
Ownership/leadership. Do you see your work through to completion? Do you fix things that aren't quite right, even if you don't have to?
Communication. Would chatting with you about a technical problem be useful or painful?
You should have at least one:

example of an interesting technical problem you solved
example of an interpersonal conflict you overcame
example of leadership or ownership
story about what you should have done differently in a past project
piece of trivia about your favorite language, and something you do and don't like about said language
question about the company's product/business
question about the company's engineering strategy (testing, Scrum, etc)
Nerd out about stuff. Show you're proud of what you've done, you're amped about what they're doing, and you have opinions about languages and workflows.

Communicate.

Once you get into the coding questions, communication is key. A candidate who needed some help along the way but communicated clearly can be even better than a candidate who breezed through the question.
Understand what kind of problem it is. There are two types of problems:

Coding. The interviewer wants to see you write clean, efficient code for a problem.
Chitchat. The interviewer just wants you to talk about something. These questions are often either (1) high-level system design ("How would you build a Twitter clone?") or (2) trivia ("What is hoisting in Javascript?"). Sometimes the trivia is a lead-in for a "real" question e.g., "How quickly can we sort an array of integers? Good, now suppose instead of integers we had . . ."
If you start writing code and the interviewer just wanted a quick chitchat answer before moving on to the "real" question, she'll get frustrated. Just ask, "Should we write code for this?"

Think out loud. Seriously. Say, "Let's try doing it this way—not sure yet if it'll work." If you're stuck, just say what you're thinking. Say what might work. Say what you thought could work and why it doesn't work. This also goes for trivial chitchat questions. When asked to explain Javascript closures, "It's something to do with scope and putting stuff in a function" will probably get you 90% credit.

Say you don't know. If you're touching on a fact (e.g., language-specific trivia, a hairy bit of runtime analysis), don't try to appear to know something you don't. Instead, say "I'm not sure, but I'd guess $thing, because..." The because can involve ruling out other options by showing they have nonsensical implications, or pulling examples from other languages or other problems.

Slow down. Don't confidently blurt out an answer right away. If it's right you'll still have to explain it, and if it's wrong you'll seem reckless. You don't win anything for speed and you're more likely to annoy your interviewer by cutting her off or appearing to jump to conclusions.

#### Behavior questions ####
More great questions: http://www.careercup.com/page?pid=behavioral-interview-questions



### Questions to ask interviewer ###

- What are your current and foreseeable challenges?

- Can you describe a project that you worked on and it's workflow?
- What are the greatest challenges in this position?
- What is a typical work day or week like?
* Is there anything you wish you knew before you joined? (Are there are negatives about this job that I might encounter?)
- If I was hired today, then what would I be working on?

- Do you have any recommended reading for employees?

- Maybe: How would you describe the culture here?
- Maybe: What qualities are you looking for in the person who fills this position? What traits are best suited for your company?
- Maybe: How many projects do people typically concurrently work on?

- What do you do for fun? (Good question or not?)



## Programming Skills ##

### Data Types ###

#### Java ####
- boolean: 1 byte
- byte: 1 byte, aka 8 bits
- short: 2 bytes
- char: 2 bytes
- int: 4 bytes
- float: 4 bytes
- long: 8 bytes
- double: 8 bytes
- Object: 8 bytes (for flags, methods)
- array: 16 bytes (8 for Object, 4 for int length, 4 to round to multiple of 8) + content size
- String: 40 bytes (8 for Object, 16 for array, 4 for int start/offset, 4 for int end/count, 4 for int hash, 4 to round to multiple of 8) + content size
- Integer: 16 bytes (8 for Object, 4 for int, 4 to round to multiple of 8)
- Long: 16 bytes (8 for Object, 8 for long)

### Data Structure ###
There are always trade-offs, know them.

#### Graph ####

- Representation
  - Edge list: Just a simple list of edges.
  - Adjacency list: A list of lists. Each top-level list has a list that contains each vertex that it connects to. Memory used O(|V|+|E|). Less memory than matrix, but slower O(n) time. Use when many nodes and sparse connections.
  - Adjacency matrix: A 2D boolean array of all possible connections between all vertex. Pro: Checking for existence of an edge is O(1). Con: Memory space is O(V^2). Use when fewer nodes and dense connections.
  - Comparison
    - Depth-first search: Running time is O(|V|+|E|) with adjacency list. Runs in O(|V|^2) time w/adjacency matrix.

#### Tree ####
A graph without cycles (acyclic).



### P vs NP ###
- P is for problems that can be solved in polynomial time.
- NP is for problems that are non-deterministic polynomial time.


### Algorithm ###

Note: For the 'tree' algorithms, make sure to check for visited when applying to graphs, which may be cyclic.

    dfs-tree-r(Node n) {
      if (n == null) return
      visit(n)
      dfs-r(n.left)
      dfs-r(n.right)
    }

    dfs-tree-i(Node n) {
      if (n == null) return
      Stack s = new Stack()
      s.push(n)
      while (s.isNotEmpty) {
        Node temp = s.pop
        visit(temp)
        for c in temp.children {
          s.add(c)
        }
      }
    }

    bfs-tree(Node root) {
      if (root == null) return
      Queue q = new Queue()
      q.queue(root)
      while (q.isNotEmpty) {
        Node n = q.deque
        visit(n)
        for (c in n.children) {
          q.queue(c)
        }
      }
    }

    preorder-tree(Node root) {
      if (root == null) return
      visit(root)
      preorder-tree(root.left)
      preorder-tree(root.right)
    }

    inorder-tree(Node root) {
      if (root == null) return
      inorder-tree(root.left)
      visit(root)
      inorder-tree(root.right)
    }

    postorder-tree(Node root) {
      if (root == null) return
      postorder-tree(root.left)
      postorder-tree(root.right)
      visit(root)
    }



### Meta ###

- Object-oriented design principles
  - APIE
    - Abstraction: Encapsulating technical details to make them easier to work with. Representing a complex idea with a simpler similar idea. Ex: When driving a car you don't have to think about all the gears and such because all those technical details have been 'abstracted' to a simpler interface.
    - Polymorphism: The ability for objects of similar-but-different types to have the same method to interact with it, but different implementations. Polymorphism is when there is a single type of action that may have different behaviors when applied to different types of objects. Ex: The action 'open' has a different behavior when applied to a can or bottle.
    - Inheritance: Re-using code with the 'is-a' principle.
    - Encapsulation: Data hiding. Hide implementation details. Allows for easier changing of implementation code without affecting other places. Also, prevents outside code from messing with internals so that the class's contract would be broken.
  - SOLID (by Robert Martin, aka 'Uncle Bob')
    - Single Responsibility: An object should have one reason to exist. An object should be responsible for itself.
    - Open / Close: Open for extension, but closed to modification. When requirements change, don't change code that already works.
    - Liskov Substitution: Derived classes must be substitutable for their base classes.
    - Interface Segregation: Multiple specific interfaces are better than one general purpose interface.
    - Dependency Inversion: Depend on abstractions (a more general object), not on concretions. This allows substitutions easier, but don't do it too much or you'll violate YAGNI.


## Phone Interview ##


More info:

- Great: [The Five Essential Phone-Screen Questions](https://sites.google.com/site/steveyegge2/five-essential-phone-screen-questions)
  - Need to know five main areas:
    - Coding: Simple functions should be quick, and should be able to do recursion and loops.
    - OO design: Know when to subclass or interface, and know the terminology. Examples to design for: arbitrary card games, animal kingdom, parking garage, social media site.
    - Scripting and regexes: grep, sed. Using your main language isn't always the right way to go, even though all the other questions may be about it.
    - Data structures: Know the trade-offs and basic implementations.
    - Bits and bytes: Know the bitwise operators and how to use them.



## Further Resources ##

### Recommended from companies to study before on-site interview ###
- http://www.careercup.com/page
- http://www.glassdoor.com/facebook
- http://codekata.pragprog.com/2007/01/code_kata_backg.html#more
- http://topcoder.com

### Others I've found ###
- [Epic list of software interview questions](http://katemats.com/interview-questions/)
- [Java Revisited](http://javarevisited.blogspot.com/): Many good questions and answers, though it it starting to feel a bit old.

### Official Company Resource ###
- [Google: How we hire](https://www.google.com/about/careers/lifeatgoogle/hiringprocess/)
