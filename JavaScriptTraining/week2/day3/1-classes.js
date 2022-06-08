/*
    Classes in JavaScript are just "syntactic sugar" for constructor functions
    It is an abstraction over constructor functions for ease of use
    They add no new functionality, they just mask the dense code of constructor functions
*/

// Classes will automatically extend Object if not specified
class Animal extends Object {
    #name;
    #age;

    constructor(name, age) {
        super(); // This is the first line of the constructor
        this.#name = name;
        this.#age = age;
    }

    get name() {
        return this.#name;
    }

    // Will be invoked upon obj.age
    get age() {
        return this.#age;
    }

    // Will be invoked upon obj.age = something
    set age(newAge) {
        this.#age = newAge;
    }

    static feet = 4;

    static sleep() { // Animal.sleep = function() {}
        console.log('Sleeping');
    }
}

// Animal.sleep = function() {
//     console.log('Sleeping');
// }

const animal = new Animal('Doug', 4);
console.log(Animal.sleep());

class Dolphin extends Animal {}

class Zebra extends Animal {
    #home;

    constructor(name, age, home) {
        super(name, age);
        console.log('Inside constructor');
        this.home = home;
    }

    get home() {
        console.log('Inside getter!');
        return this.#home;
    }

    set home(newHome) {
        console.log('Inside setter');
        if (newHome && typeof newHome == 'string') {
            this.#home = newHome;
        }       
    }
}

Zebra.prototype.toString = function() {
    return `I\'m ${this.name}`;
}

const marty = new Zebra('Marty', 57, 'Central Park');
console.log(marty.home);

marty.home = 'Madagascar'; // Invoking the set home method
console.log(marty.home);

console.log(marty.__proto__ === Zebra.prototype);
console.log(Zebra.prototype.__proto__ === Animal.prototype);
console.log(Animal.prototype.__proto__ === Object.prototype);

console.log(marty.toString());

console.log(marty.home); // Invoke get home method