# JavaScript Cheat Sheet


## Basics

    // Variables
    let a = 1, b = 2, c = 3;
    
    // Numbers
    let a = 1e0; // 1
    let b = 1e6; // 1000000
    let c = 2**3; // Math.pow(2, 3) // 8
    let d = parseInt("100");
    let e = +"100";
    
    // Strings
    let a = 'asdf';
    a[0]; // Returns 'a'. Same as `'asdf'[0]` and `'asdf'.chartAt(0)`
    
    let url = 'https://' + host + ':' + port + '/' + path;
    let url = `https://${host}:${port}/${path}`; // Note the backticks for string interpolation
    
    let multiLine = `asdf
        asdf
        asdf`;
    let multiLine = 'asdf\n\t' + 
        'asdf\n\t' +
        'asdf';
    
    // Operators
    let a = 0;
    a++; // Same as `a = a + 1`
    a--; // Same as `a = a - 1`
    a *= 10; // Same as `a = a * 10`
    a %= 2; // Same as `a = a % 2`
    
    // Array
    let a = ['a', 'b', 'c'];
    
    let odd = [1, 3, 5];
    let nums = [2, 4, 6].concat(odd);
    let nums = [2, 4, 6, ...odd]; // Using the 'spread' operator
    
    let a1 = [1, 2, 3, 4];
    let a2 = a1.slice(); // Clone array
    let a2 = [...a1]; // Cloning using the 'spread' operator
    
    // Object
    let a = 1, b = 2;
    let c = { a, b }; // Long-hand: `let c = { a: a, b: b };`
    
    let first = { firstName: 'John' };
    let last = { lastName: 'Doe' };
    let fullName = Object.assign(first, last); // Create a new object: { firstName: 'John', lastName: 'Doe' }
    let fullName = { ...first, ...last }; // Using destructuring syntax from ES8
    
    // Conditionals
    if (truthy) { ... }
    
    // Ternary
    let a = x == 42 ? 'good' : 'not good';
    
    // Loops
    let letters = ['a', 'b', 'c'];
    for (let letter of letters) { ... } // Long-hand: `for (let i = 0; i < letters.length; i++) { ... }`
    for (let index in letters) { ... }
    
    function f(element, index, array) { ... }
    letters.forEach(f);
    letters.forEach({ ... });
    
    let things = { a: '1', b: '2', c: '3' }
    for (let key in things) { console.log(key); } // Output: a, b, c
    
    // Functions
    function f(param) { console.log('Hello, ', param); }
    f = param => console.log('Hello, ', param);
    
    delay(function() { console.log('Hi!'); }, 2000);
    delay(() => console.log('Hi!'), 2000);
    
    // Destructuring assignment
    let { a, b, c } = [a, b, c];
    import { a, b, c } from 'asdf';
    
    let { a, b, ...z } = { a: 1, b: 2, c: 3, d: 4 };
    console.log(a); // 1
    console.log(b); // 2
    console.log(z); // { c: 4, d: 4 }
    

Difference between `var`, `let`, `const`:
- `var`: 
- `let`: 
- `const`: 

## Tips

Provide a default value for variable if it is null/unknown/empty:

    let a;
    let a2 = null;
    let b = a || 42; // b = 42
    let b2 = a2 || 42; // b2 = 42
    // Long-hand: if (a !== null || a !== undefined || a !== '') { let b = a; } else { let b = 42; }

Provide a default value for function parameters:

    def sum(a, b, c = 0) {
        if (a === undefined) { throw new Error('Missing parameter!'); } // Require parameter
        b = b || 0;
        return a + b + c;
    }
    sum(42, null); // a = 42, b = 0, c = 0

Short-hand mandatory parameter:

    mandatory = () => { throw new Error('Missing parameter!'); }
    foo = (bar = mandatory()) => { return bar; }

Short-hand function calling:

    function f() { ... }
    function g() { ... }
    let a = 42;
    (a == 42 ? f : g)(); // Same as `if (a == 42) { f(); } else { g(); }`

Short-hand Array.find:

    let pets = [
        { type: 'Dog', name: 'Foo' },
        { type: 'Cat', name: 'Foo' },
        { type: 'Dog', name: 'Bar' }
    ];
    pet = pets.find(pet => pet.type === 'Dog'); // { type: 'Dog', name: 'Foo' }

## Snippets

### Reusable validator

    // Object validation rules
    const schema = {
      first: { required:true },
      last: { required:true }
    }
    
    // Universal validation function
    const validate = (schema, values) => {
      for (field in schema) {
        if (schema[field].required) {
          if (!values[field]) {
            return false;
          }
        }
      }
      return true;
    }
    
    console.log(validate(schema, { first: 'Dan' })); // false
    console.log(validate(schema, { first: 'Dan', last: 'Goodwin' })); // true



