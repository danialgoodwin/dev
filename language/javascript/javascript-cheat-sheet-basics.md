# JavaScript Cheat Sheet - Basics #
(This document is about the language itself and not about interacting with the browser, nor using DOM.)

- Dynamically-typed language


## Simple Examples ##
You can run these in the JavaScript Console available in some browsers. In Chrome, use `ctrl+shift+j`.

    1 + 1
    "Hello" + " World!"
    alert(12) // Returns undefined
    alert("Hello World!") // Returns undefined
    prompt("What is your name?") // Returns user input at string
    
    alert("Hi, " + prompt("What is your name?") + "!")


## Variables ##

- Can start with [a-zA-Z_$], then continue with [a-zA-Z0-9_$]
- Convention is 
- Variable values can also be `undefined` or `null`.

        var color = 1; // Store a number
        color = "red"; // Store a string
        color = "It's red"; // Store a string with single quote inside
        color = 'He said "Awesome!"'; // Store a string with double quite inside
        // Or, just use backslash to escape the quote.
        color = 'It\'s red';
        
        // Get type of variable
        var type = typeof color;
        
        1 == "1"; // true
        1 === "1"; // false because type must also be the same
        1 != "1"; // false
        1 !== "1"; // true

### Undefined ###

    var myvar;
    if (typeof myVar === "undefined") {} // true
    myVar == undefined; // true
    
    undefined = true;
    if (typeof myVar === "undefined") {} // true
    myVar == undefined; // false

- Be careful of trollers setting `undefined = true`

- Also, it is okay to compare undefined variables to null.

        var myVar;
        if (myVar == null) {} // true
        if (myVar === null) {} // false

### String ###

    var myString = "fefifo";
    myString.length; // Returns 6
    myString.indexOf("fe"); // Returns 0
    myString.indexOf("FE"); // Returns -1
    
    if (myString.indexOf("fa") !== -1) {
        console.log("string exists");
    }
    
    myString.charAt(0); Returns f
    var fo = myString.substr(4, 2); // Returns "fo"

    myString.toLowerCase(); // Returns new string "fefilo"

    // Compare strings
    var a = "Hello";
    var b = "hello";
    boolean double = a == b; // Returns true if same letters/numbers, regardless of type (mostly). Not commonly used.
    boolean triple = a === b; // Returns true if exact letters, case-sensitive, and same type.
    boolean cap = a < b; // Returns true because capital letters come before lowercase in the ascii table
    
To output special characters:

    \n              newline
    \t              tab character
    \\              backslash character
    \'              single quote
    \"              double quote

###  Numbers ###

All numbers are floating point. The whole numbers have an invisible ".0" after it. So, "integer" division will have the fractional point returned also, unlike some other languages.

    var a = 11,
        b = -42,
        c = 2.3;
    
    // Large numbers
    var d = 1000000;
    var e = 1E6;
    
    // Other bases
    var octal = 012; // Returns 10
    var octal_exception = 019; // Returns 19 because "9" is illegal octal character, thus JavaScript uses base 10. No error unfortunately.
    var hex = 0x12; // Returns 18
    
    // From string. For best practice use second argument for radix to be sure of what is being parsed.
    var i = parseInt("42"); // Returns 42
    var i = parseInt("012"); // Returns 10
    var i = parseInt("019"); // Returns 1
    var i = parseInt("019", 10); // Returns 19
    var i = parseInt("111", 2); // Returns 7
    var i = parseInt("23 people", 10); // Returns 23
    var i = parseInt("People: 23", 10); // Returns NaN
    var j = parseFloat("012.34"); // Returns 12.34

Can't compare NaN to itself, it would be false. So, use `isNan(myVar)`

#### Math Operations ####

    ()              grouping
    *               multiply
    /               divide (does float divide, which doesn't cut off fractional part)
    %               modulo
    +               add
    -               subtract

#### Math Object ####
Type `Math` into JavaScript console to see all the methods and constants available.

    var r = Math.random(); // Returns a value between 0-1
    var r = Math.round(Math.random() * 10); // Round up from 0.5 and above. Round down for less than 0.5
    Math.floor(r); // round downa always
    Math.ceil(r); // round up always
    Math.pow(2, 5); // power/exponent. Returns 2 to power of 5
    Math.abs(myVar); // absolute value
    Math.max(a, b, ...); // Returns max value of at least two variables
    

### Hoisting ###
Variables have "functional" scope. The only time there is a new scope is where is is a new function. So, best practice for variables is to declare them at the start of the function.

And, a global variable can be created anywhere by just leaving off the `var` keyword when first using it.

    // Regardless of the second `var` for `color`, there is only one `color`
    // variable and console will output "red" if `doit==true`.
    function doSomething(doit) {
      var color = "blue;
      if(doit) {
        var color = "red";
        var number = 10; // This variable is accessible in entire function.
        globalVar = 42; // This variable is accessible everywhere global now.
      }
      console.log("Color after if(){}", color);
      console.log("Number: " + number)'
    }

## Conditionals ##

- Depends on `true` and `false
- True-thy values: true, non-0 number, non-empty string
- False-y values: false, empty string, 0, null, undefined

        if (42) {
          console.log("If block");
        } else {
          console.log("Else block");
        }

## Loops ##

    var counter = 10;
    while (counter) {
      console.log("Hello World!");
      counter -= 1;
    }
    
    for (var counter = 10; counter; counter -= 1) {
      console.log("Hello World!");
    }

## Data Structures ##

### Array ###
Represents a list of objects, even functions and other arrays.

- Automatically resizes.

        var emptyArray = [];
        var emptyArray = new Array(); // Pretty much never done because it is longer, unless you want to pass a length as argument.
        var names = ["Dan", 42, "Pizza", true, null, [true, 1, null], function(a,b){return a+b;}];
        console.log(names);
        names.length; // Returns number of elements
        names[0]; // Returns first element
        names[100]; // Trying to get a value that doesn't exist returns `undefined`
        var answer = names[1]; // Copies value. Changing array doesn't change this variable
        names[100] = "Dan2"; // This would succeed, and put lots of `undefined` in all the places to 99.

Methods (that change the array)

    var nums = [2, 3, 4];
    nums.push(5); // Adds value to end of array
    nums.pop(); // Returns and removes last value in array
    nums.unshift(1); // Adds values to front of array // One way to help remember this is that both "unshift" and "push" have a "u", so both add a value
    nums.shift(); // Returns and removes first value in array
    nums.reverse(); // Reverses method it is called on.
    delete my_array[1]; // Changes second element to `undefined`
    my_array.splice(2,1); // Removes the second element
    my_array.splice(2,0,"two", ...); // Removes no elements, inserts `"two", ...` to the second index and moves other indexes

Methods (that return a new array, aka no side effects)

    var x = [1,2,3];
    var y = [4,5,6];
    var z = x.concat(y); // Returns a new array [1,2,3,4,5,6] and leaves `x` and `y` alone
    var z = x.concat(4,5,6); // Same as above
    var myArray = [5,6,7,8,9];
    var m = x.slice(1,3); // Returns new array [6,7]. If end is past length of array, then it will work, but no extra values will be returned
    var words = ["these", "are", "some", "words"]; // Could also put numbers and functions, which will have `toString()` called on them
    var result = myArray.join(' '); // Returns a new string "these are some words"
    var result = myArray.join('HA'); // Returns a new string "theseHAareHAsomeHAwords"

Sort

    var nums = [10, 2, 40, 35, 0, 4, 100]
    nums.sort(); // Sort in-place, but as a "string" sort. So, [0,10,100,2,35,4,40]
    // This sorts numbers properly, by providing an anonymous function
    nums.sort(function(a, b) {
      return a - b;
    });
    nums.sort(function(a, b) {
      return Math.random() - 0.5; // Randomly shuffle array
    });

### Object ###
In JavaScript, an object is a datatype that associates keys with values.

In Ruby, these would be referred to as a "hash". In Python, these would be referred to as a "dictionary".

    var me = {
      first_name: "Dan",
      last_name: "Goodwin",
      "Employee Number": 1,
      skills: ["sports", "logic", "questions"]
    };
    
    me.first_name; // Returns "Dan"
    me["first_name"]; // Same as above
    me["Employee Number"] // Returns 1
    me.first_name = "Danial"; // Set a different value
    me["first_name"] = "Danial"; // Same as above
    
    // The dot is shorthand for the subscript
    console.log("Hello");
    console["log"]("Hello");
    
    me.first_name = "Danial";
    me["first_name"] = "Danial";
    
    // Store functions as values in objects, then call them "methods"
    var me = {
      name: "Dan";
      greet: function(){console.log("Hello, I'm " + me.name);}
      greet2: function(person){console.log("Hello, I'm " + person.name);}
      greet3: function(){console.log("Hello, I'm " + this.name);}
    };
    me.greet(); // Calls the method
    
    // Gotcha/danger of `this`
    var meGreet = me.greet; // Trying to get reference to method
    meGreet(); // This loses the `this` me context here, so outputs "Hello, I'm "

Actually, there is a `this` context when `meGreet()` is called above. In the browser, it would be the `DOMWindow`. You can test this by `(function(){consolt.log(this);})();`. And, the `window` does have a `name` property, which by default may be an empty string.

All JavaScript functions have a special method `call(...)` and `apply(...)`. They are both mostly the same. The first argument for both is what should be used as the `this` value. For `call()`, multiple other arguments can be passed in for the function. For `apply()`, only one other argument can be passed in, an array of zero or more elements, which can be an array of multiple arguments for the function.

    // `apply()` can be switched with `call()` for each of these and do the same thing
    meGreet.call(myThis); // Runs `meGreet()` function using `myThis` as the `this` context
    meGreet.call(me);
    meGreet.call({name: "Danial"});
    me.greet.call({name: "Danial"}); // Same as above
    
    // `apply()` would be used when there will be an unknown amount of arguments
    meGreet.call(me, "Anon", "Maybe");
    meGreet.apply(me, ["Anon", "Maybe")];


### Prototypes ###
Useful for OOP (Object-Oriented Programming).

Need a constructor function. An important convention is to capitalize the fist letter of prototype constructor functions so that any developer looking at that code knows that a `new` keyword should go in front of any constructor function called. Thus, preventing the wrong `this` context from being used.

    var personPrototype = {
      name: 'Anonymous',
      greet: function (name, mood) {
        console.log("this.name: " + this.name + ", name: " + name + ", mood: " + mood);
      },
      species: 'Homo Sapien'
    };
    
    function Person (name) {
      this.name = name;
      // return this; // Done automaticallly, so this line isn't needed
    }
    Person.prototype = personPrototype; // Set the __proto__ (aka, superclass like in other "class" languages)
    
    var diana = new Person("Diana"); // Inherits all the features of personPrototype
    
    // Change prototype programmatically
    Person.prototype.species = 'Human'; // Updates all "sub-classes" of Person and its prototype
    
    Person.prototype.favoriteColor = 'Green'; // Adds the attribute for all "subclasses" of Person and its prototype



## Function ##

- Naming rules are same as for variables.
- If too few arguments are passed in, then they will be `undefined` in function.
- If too many arguments are passed in, then they will be ignored. But, it is possible to still access them.
- All functions return something. If not defined, then returns `undefined`.
- Code after `return` doesn't get called.

        // No parameter function
        function sayHello() {
          console.log("Hello");
        }
        sayHello();
        
        // One parameter function
        var debug = function(message) {
          console.log("Debug", message);
        }
        debug("This is a test");
        
        // Function returning double a number
        var doubleNumber = function(num) {
          if (typeof num === 'undefined') {
            return 0;
          }
          return num * 2;
        }
        debug(doubleNumber(7));
        
        // Pass function as argument
        var callTwice = function (targetFunction) {
          targetFunction();
          targetFunction();
        }
        callTwice(function(){console.log("Hello");});
        
        // Optional arguments
        function(name, mood){
          name = name || "You";
          mood = mood || "good";
          console.log("Hello, I'm " + name + " and " + mood);
        }
        
        // Self-executing anonymous function. Typically used to create a scope for variables.
        // Long way
        function tempFunction() {
          ...
        }
        tempFunction();
        // Short way
        (function (a, b) {
          ...
        })("abc", 123)

### Function inside a Function ###

    function sayHello() {
      console.log("Hello");
      
      function inner() {
        var extra = "There is more!";
        console.log(extra);
      }
      inner();
    }
    sayHello();
