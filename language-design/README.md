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




## Simple Cloud Langauage
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

Ideas:
- Hardware and programming language designed together
