# JavaScript Cheat Sheet


## Basics

    // Variables
    let a = 1, b = 2, c = 3;
    
    // Array
    let a = ['a', 'b', 'c'];
    
    // Ternary
    let a = x == 42 ? 'good' : 'not good';

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
    // long-hand: if (a == null || a == undefined || a == '') { let b = a; }

Provide a default value for function parameters:

    def sum(a, b, c = 0) {
        b = b || 0;
        return a + b + c;
    }
    sum(42, null); // a = 42, b = 0, c = 0

## 



