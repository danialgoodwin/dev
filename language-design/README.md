# Simple Language Designs



## Simple UI Language
Sample:
```
Column(
  theme: Theme.Material.Dark,
  isScrollable: true,
  Card(
    title: Text(content: 'Hello, World!'),
    content: Button(content: 'Click Me!', onClick: handleClick)
  ),
  Text(content: 'Footer content', align: Center)
)

```

More:
```
View(background: {Color, Image, Media}, border: {Color, Image, Media}, cornerRadius, margin, padding)
- Breadcrumb
- Button(text, onClick, onGesture)
  - Dropdown(options, optionsStyle)
- Canvas
- Chart
- Chat
- InputView (open question: When should `View` in the name be required, if at all?)
  - ColorInputView
  - DateInputView
  - LinkView(to)
  - NumberInputView(textStyle: NumberTextStyle)
  - PasswordInputView(textStyle: PasswordTextStyle)
  - SearchInputView(icon)
  - TextInputView(text, textStyle, hint, hintStyle, label, labelMode, labelStyle, inputType: {email, number, phoneNumber, pin}, minCharacters, maxCharacters, filter, allowedCharactersView)
  - TimeInputView
- FileView
  - AudioExplorer
  - AudioView
  - TextFileView
  - ImageExplorer
  - ImageView
  - PdfView
  - VideoExplorer
  - VideoView
- OptionView(maxSelection: {PositiveNumber, "all"}) (aka, radio or checkboxes)
- Prompt(onPositiveClick, onNegativeClick, onInfoClick, onOutsideClick, isAllowOutsideClick)
- QuoteView
- SecurityView
  - BioSecurityView
    - FaceSecurityView
    - FingerprintSecurityView
  - PasswordSecurityView
  - PatternSecurityView
  - PinSecurityView
- TabView
- TextView(textStyle)
ViewContainer
- Card
- Column
- Frame
- Grid
- List (can make bullet list)
- Row
- Table

Style: {Flat, Material, Fluent, Cupertino}
```

Google Ngrams:
- ['exit' over 'quit'](https://books.google.com/ngrams/graph?content=exit%2Cquit&corpus=26&year_end=2019&year_start=1800&smoothing=3&direct_url=t1%3B%2Cexit%3B%2Cc0%3B.t1%3B%2Cquit%3B%2Cc0#t1%3B%2Cexit%3B%2Cc0%3B.t1%3B%2Cquit%3B%2Cc0)



## Simple Grammer Language
Sample:
```
file: expression+
expression: ...
NUMBER: ...
TEXT: ...
```



## Simple Audio Langauage
...



## Simple Database Langauage
Sample:
```
show Tables
show Columns
myTable.filter(...)
```



## Generally
If I had to choose one language to use, then it would meet the following criteria:
- Few/none boilerplate/extra-syntax
- Types optional
- Garbage collected (allow for hints?)
- Configurable at compiler level? Fast vs Memory. isEncrypt. 
- Simple vast multi-thread/coroutines to split processing between computers
- Easy to lazy-load, deep copy, 
- The language should be able to grow
- Primitives should include: max, min, interval (a..b), list, map/dict, set
- Programming language that is a pattern for creating other languages ('Growing a Language by Guy Steele', https://youtu.be/lw6TaiXzHAE?t=2534)
- [Principle of least astonishment](https://en.wikipedia.org/wiki/Principle_of_least_astonishment)

Ideas:
- Hardware and programming language designed togetherhttps://www.youtube.com/watch?v=_ahvzDzKdB0
- "UNIX built for programmers to be highly productive"
- Should there be syntactic sugar for common use cases? Ex: single-line if-statement, ternary-if
- Compiler-specific contructs?
- Visibility options: global/public, module/inner, package, sub-packages, open/closed/sub-classes, private
- Modifier options: constant/const, open (sub-class anywhere), closed (limited sub-classing), lazy

How many languages should there be? Is this the answer to how many contexts are there?
- Controlling traffic lights? Elevators? Cars? AI? Smart homes?
- Setting text for a display... being able to program each dot... 
- Creating macros
- GUIs, animation, audio
- Contexts where a GUI program is perhaps better than a written/1D language: programming keyboards, automated point-of-sales, libraries/catalogs(?), many more
- Is general programming a thing? Perhaps only to create the domain-specific languages. (language name idea: desol or delsol, meaning 'of/from the sun' because it includes the letters 'DSL')



## Language-Design Trade-offs
- **Variable-centric** (no special syntax for variable referencing) vs **text-centric** (no need for quotes). Reference examples to display 'Hello, World!':
    - Variable-centric: `'Hello, ' + name + '!'`
    - Text-centric: `Hello, $name!`
    - JavaScript template literal: `` `Hello, ${name}!` ``
    - Python f-string: `f'Hello, {name}!'`
- switch-expressions either **break-by-default** or **continue-by-default**
    - Should future language have them (or a similar construct)? Seems quite useful to write the compared variable only once.
    - Most usages want to 'break-by-default'? Though, there are times that continue-by-default is useful.
    - continue-by-default can be achieved with multiple if-conditions
    - break-by-default can be achieved with multiple if-else-conditions



## Language comparisons

    filteredThings: list()
    myService.getNextThing().each -> filteredThings.add(each)

vs

    var filteredThings = list()
    var thing = null
    do {
        thing = myService.getNextThing()
        if (thing != null) {
            filteredThings.add(thing)
        }
    } while (thing != null)



## Work-in-progress

How to define a graph (with optional weights):
```
myGraph:
    a b 1
    b c 2
    a c 2
    a d 1
    b d 2
    a e 5

tspGraph:
    a1 a2 1
    a1 a3 2
    a1 a4 3
    a1 a5 4
    a2 a3 1
    a2 a4 2
    a2 a5 3
    a3 a4 1
    a3 a5 2
    a4 a5 1
    b1 b2 1
    b2 b3 1
    b3 b4 1
    b4 b5 1
    ...
    a1 b1 0.9
    a2 b2 0.9
    a3 b3 0.9
    a4 b4 0.9
    a5 b5 0.9
    ...

tspGraph2:  # postfix?
    a1 a2 1 a3 1 a4 1 a5 1 as Graph

tspGraph3:  # infix?
    a1 1 a2 1 a3 1 a4 1 a5 as Line  # Or, `as Graph.Line`?

tspGraph4:  # default to 1?
    a1 a2 a3 a4 a5 as Polygon  # not sure about `as Circle`...
```

Game design
```
os.getPressedKeys().if -> {
  's': save()
  'esc': exit()
  'p': pause()
  'm': menu()
}
```

Simple class
```
class MyClass:
    var x, y, z

    new: (val a) -> {
        new(a, 'default-b')
    }
    
    new: (val a, val b) -> {
        new(a, b, 'default-c')
    }
    
    new: (val a, val b, val c) -> {
        x: a as X
        y: b.convertToY()
        z: c
    }
    
    isEqual: (MyClass other) -> return .a == other.a && .b == other.b && .c == other.c
    
data class MyQuaternion(val w, val x, val y, val z)
    
```



