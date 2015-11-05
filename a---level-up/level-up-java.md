# Level Up - Java #


## Vocabulary ##
In order to be fluent in a language, you must learn the vocabulary. Also, after learning the vocabulary, the future concepts built on top will be much easier.

### Basic ###

- encapsulation:
- refactoring:
- parameter:
- argument:
- function:
- method:
- instantiation:
- mutable:
- immutable:
- accessor:
- mutator:
- synchronous:
- asynchronous:


### Advanced ###



## Built-in Data Structures ##

### Primitives ###
Java primitive types are faster and lighter than their wrapper (Object) versions, but have less features.

- `boolean`: 1 byte, true or false
- `byte`: 1 byte, aka 8 bits. Range: -128 to 127
- `short`: 2 bytes. Range: -32,768 to 32,767
- `char`: 2 bytes. Range: \u0000 to \uFFFF. Note: The wrapper type is `Character`. Unicode characters > U+FFFF require two char values.
- `int`: 4 bytes. Range: -2,147,483,648 to 2,147,483,647. Note: The wrapper type is `Integer`. Use `BigInteger` for arbitrary precision integers.
- `long`: 8 bytes. Range: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807. Note: Literals end with L (e.g. `long myLong = 1L`).
- `float`: 4 bytes. Range: approximately +-3.40282347E+38F (6-7 significant decimal digits). Note: Literals end with F (e.g. 0.5F). (IEEE754 single-precision format: 1 bit sign, 8 bit exponent, 23 bit fraction/mantissa)
- `double`: 8 bytes. Range: approximately +-1.79769313486231570E+308 (15 significant decimal digits). Note: Use `BigDecimal` for arbitrary precision floating-point numbers. (IEEE754 double-precision format: 1 bit sign, 11 bit exponent, 52 bit fraction/mantissa [http://en.wikipedia.org/wiki/Double_precision])

You can only 'legally' convert to something with more bytes. Other conversions may result in loss of precision, for example: 'int to float', 'long to float', 'long to double'.

More info: [Refcardz](http://refcardz.dzone.com/refcardz/core-java)


### Primitive Wrappers ###


### Non-Primitive ###

- `String`: Immutable array of char.
- array: Shown as square brackets `[]`, though can be created with curly braces `{}`. Ex: `int[] myArray = {1, 2, 3}`


### Collections ###
Just a small selection is shown here. Each `Set` also has a `Map` version.

- `ArrayList`: An index sequence that grows and shrinks dynamically.
- `LinkedList`: An ordered sequence that allows efficient insertions and removals at any location.
- `HashSet`: An unordered collection that rejects duplicates. Pro: Insertion and retrieval are O(1). Con: Requires extra space.
- `TreeSet`: A sorted set. Insertion and retrieval are O(lg n).


- `ArrayDeque`: A double-ended queue that is implemented as a circular array
- `EnumSet`: A set of enums
- `LinkedHashSet`: A set that remembers the order in which elements were inserted
- `PriorityQueue`: A collection that allows efficient removal of the smallest element
- `WeakHashMap`: A map with values that can be reclaimed by the garbage collector if they are not used elsewhere
- `IdentityHashMap`: A map with keys that are compared by ==, not equals

More info: [Refcardz](http://refcardz.dzone.com/refcardz/core-java)
























## Further Resources ##
