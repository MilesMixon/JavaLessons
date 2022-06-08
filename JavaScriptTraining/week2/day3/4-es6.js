// ES6 means it's the sixth convention for ECMAScript
// ECMAScript is a convention for upgrading JavaScript functionality

/**
 * ES6/ES2015 added loads of new features to the language
 * 
 * class
 * spread operator
 * rest operator
 * async/await (ES7)
 * object/array destrutcturing
 */

// Spread Operator is ...
// Spread takes an 'iterable' object and fans it out in full

// An iterable object follows the "Iterator Protocol"
// Returns a function called next() that returns an object
// Value is the value being looked at currently
// Done is whether I'm done looping or not

function Range(count, limit) { // 0 -10
    this.initialCount = count;
    this.count = count;
    this.limit = limit;

    this.next = function() {
        this.count++;
        if (this.count > this.limit) {
            this.count = this.initialCount;
            return {value: null, done: true};
        } else {
            return {value: this.count, done: false};
        }
    }

    // I am using bracket syntax for the reason that I need to inject the value returned from Symbol.iterator as the key
    this[Symbol.iterator] = function() {
        return this;
    }
}

class RangeClass {
    #initialCount;
    #count;
    #limit;

    constructor(count, limit) {
        this.#initialCount = count;
        this.#count = count;
        this.#limit = limit;
    }

    next() {
        this.#count++;
        if (this.#count > this.#limit) {
            this.#count = this.#initialCount;
            return {value: null, done: true};
        } else {
            return {value: this.#count, done: false};
        }
    }

    [Symbol.iterator] = function() {
        return this;
    }
}

const myRange = new Range(0, 5);

console.log(myRange.next());
console.log(myRange.next());
console.log(myRange.next());
console.log(myRange.next());
console.log(myRange.next());
console.log(myRange.next());
console.log(myRange.next());
console.log(myRange.next());
console.log(myRange.next());

const myOtherRange = new RangeClass(0, 10);
console.log(...myOtherRange);
console.log(...myOtherRange);