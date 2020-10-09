# Simple Language Designs



## Simple UI Language
Sample:
```
Column(
  theme=Theme.Material.Dark,
  isScrollable=true,
  Card(
    title=Text(content='Hello, World!'),
    content=Button(content='Click Me!', onClick=handleClick)
  ),
  Text(content='Footer content', align=Center)
)

```

More:
```
View(background={Color, Image, Media}, border={Color, Image, Media}, cornerRadius, margin, padding)
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
  - NumberInputView(textStyle=NumberTextStyle)
  - PasswordInputView(textStyle=PasswordTextStyle)
  - SearchInputView(icon)
  - TextInputView(text, textStyle, hint, hintStyle, label, labelMode, labelStyle, inputType={email, number, phoneNumber, pin}, minCharacters, maxCharacters, filter, allowedCharactersView)
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
- OptionView(maxSelection={PositiveNumber, "all"}) (aka, radio or checkboxes)
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

Style={Flat, Material, Fluent, Cupertino}
```

Google Ngrams:
- ['exit' over 'quit'](https://books.google.com/ngrams/graph?content=exit%2Cquit&corpus=26&year_end=2019&year_start=1800&smoothing=3&direct_url=t1%3B%2Cexit%3B%2Cc0%3B.t1%3B%2Cquit%3B%2Cc0#t1%3B%2Cexit%3B%2Cc0%3B.t1%3B%2Cquit%3B%2Cc0)



## Simple Grammer Language
Sample:
```
file = expression+
expression = ...
NUMBER = ...
TEXT = ...
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

Ideas:
- Hardware and programming language designed togetherhttps://www.youtube.com/watch?v=_ahvzDzKdB0
