# TypeScript Cheat Sheet

## Basic

```
interface Person {
    firstName: string;
    lastName: string;
}

class Student {
    fullName: string;
    constructor(public firstName: string, public middleInitial: string, public lastName: string) {
        this.fullName = firstName + " " + middleInitial + " " + lastName;
    }
}

function greeter(person: Person) {
    return 'Hello, ' + person.firstName;
}

let user = new Student('Jane', 'M'.', 'User');

document.body.textContent = greeter(user);

type Shape =
    { kind: 'circle', radius: number } |
    { kind: 'rectangle', w: number, h: number } |
    { kind: 'square', size: number }

function assertNever(obj: never) {
    throw new Error('Unexpected object');
}

function getArea(shape: Shape) {
    switch (shape.kind) {
        case 'circle':
           return Math.PI * shape.radius ** 2;
        case 'rectangle':
           return shape.w * shape.h;
        case 'square':
           return shape.radius ** 2;
    }
    assertNever(shape); // IDE will complain if all shapes aren't handled
}

const shape: Shape = { kind: 'circle', radius: 10 };
const area = getArea(shape);
```

## Advanced



# Resources

