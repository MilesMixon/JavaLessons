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

const myOtherRange = new Range(0, 20);
console.log(...myOtherRange);
console.log(...myOtherRange);

// ANother way to iterate over iterables is another type of for loop
// for of loop

const obj = {
    firstName: 'Sean',
    lastName: 'Carter'
}

for (let val of myOtherRange) {
    console.log(val);
}

/**
 * Instead of creating objects that they themselves are iterable, look to store in a container that's iterable
 * 
 * The most common of which is an array
 * String are also iterable 
 * objects are not iterable, but they can be spread (special exemption)
 */

const nums = [1, 52, 252, 46, -24, 71];

// Copies the elements over from the old array into the new one, then appends 0, 56, and 39 to the end
const moreNums = [...nums, 0, 56, 39];
console.log(moreNums);

moreNums.push(100); // This one mutates the moreNums array to add 100 to the end
const newArr = [...moreNums, 100]; // This one leaves moreNums as is, but creates a new array that's a copy of moreNums with 100 at the end

// Instead of using slice I can also use spread
const letters = ['a', 'b', 'c'];
const copy = [...letters];
copy.push('d');
console.log(copy);

// Objects are NOT iterable, but JS made a special exception for the spread operator
// I cannot use for of, but I can use spread

const student = {
    fullName: {
        firstName: 'John',
        lastName: 'Doe'
    },
    major: 'Computer Science',
    classes: ['Computer Science', 'Philosophy', 'World History', 'Music']
};

// Create a copy of the student object
const studentCopy = {...student};

// Create a copy and override the major property to be Philosophy
const studentCopy2 = {...student, major: 'Philosophy'};

// Create a new object with the property major, then copies the contents of the student object
// If major exists on the student object, 'Undecided' will be overridden
const studentCopy3 = {major: 'Undecided', ...student};
console.log(studentCopy3);

// You can also use it with Strings
console.log(...'Hello World');

for (let char of 'Hello World') {
    console.log(char)
}

// If I want a char array
const charArray = [...'This is my string'];
console.log(charArray);

// Generator Functions provide a cleaner syntax for iterating over an object
function* myGeneratorFunction(count=0, reps=5) {
    // There's a special keyword for generators called yield
    // yield is an abstraction over returning {value: 0, done: false}
    for (let i = 0; i <= reps; i++) {
        yield count++; // {value: count, done: false} is the equivalent
    }
    // When it hits the bottom of the function, next will return {value: undefined, done: true}
}

const myGen = myGeneratorFunction(0, 5);
console.log(myGen.next());
console.log(myGen.next());
console.log(myGen.next());
console.log(myGen.next());

const myOtherGen = myGeneratorFunction(0, 20);
console.log(...myOtherGen);

// Rest operator (...)
// It does the opposite of spread; instead it condenses multiple values into one

// var args which variable number of arguments
// Makes our functions super malleable since I can call it with 0-1 million arguments, it'll work the same

// the rest operator MUST be the last parameter to a function
function restFunction(...nums) {
    for (let num of nums) {
        // doStuff(num);
    }
    console.log(nums);
}

restFunction(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

function displayMovies(numberOneMovie, numberTwoMovie, numberThreeMovie, ...restOfMovies) {
    console.log(`The number one movie is ${numberOneMovie}`);
    console.log(`The number two movie is ${numberTwoMovie}`);
    if (numberThreeMovie != null) {
        console.log(`The number three movie is ${numberThreeMovie}`);
    }
    console.log('Here\'s the rest I guess');
    for (let movie of restOfMovies) {
        console.log(movie);
    }
}

displayMovies('The Incredibles', 'Encanto', 'Inception', 'Interstellar', 'Shawshank Redemption', 'The Batman');

displayMovies('The Incredibles', 'Encanto');


// Array Destructuring
function returnMovies() {
    return ['The Incredibles', 'Encanto', 'Inception', 'Interstellar', 'Shawshank Redemption', 'The Batman'];
}

// I declare variables and pull out the value at the position and store them accordingly
let [movie1, movie2, movie3, ...rest] = returnMovies();
console.log(movie1, movie2, movie3, rest);

// Pull out movie1, skip movie2, pull out movie3
[movie1,,movie3] = returnMovies();

// Object Destructuring
const john = {
    fullName: {
        firstName: 'John',
        lastName: 'Doe'
    },
    major: 'Computer Science',
    classes: ['Computer Science', 'Philosophy', 'World History', 'Music']
};

// If I want specific values out of an object, I can do object destructuring
const { classes, fullName, ...restOfProps } = john;

console.log(classes);
console.log(restOfProps); // restOfProps is missing what was destructured
console.log(john); // john remains untouched

function adjustSettings({volume, brightness=100, hasSubtitles }) {
    console.log(`Volume being set to ${volume}`);
    console.log(`Brightness being set to ${brightness}`);
    console.log(`Subtitles on? ${hasSubtitles}`)
}

const options = {
    opacity: 100,
    hasSubtitles: true,
    volume: 80
}

adjustSettings(options);
adjustSettings({volume: 60, brightness: 30, hasSubtitles: false});

// Arrow Functions
// Arrow functions are anonymous functions, but more lightweight

const anonymousRegularFunction = function() {
    console.log('Hello World');
}

const anonymousArrowFunction = () => console.log('Hello World');


const addTwoNumbers = (num1, num2) => {
    return num1 + num2;
}

/**
 * Rules for Arrow Functions
 * 
 * You have to use the => operator
 * 
 * If you have no parameters, you must use ()
 * If you have two or more parameters, you must use ()
 * If you have exactly one parameter, the () are optional
 * 
 * Curly braces are optional so long as your function is only one line
 * If I want to use the return keyword, I must use curly braces
 * If I don't have curly braces, the one line automatically it for you
 */

const printNum = num => console.log(num);

const addOne = num => num + 1; // returning num

console.log(addOne(3));


/**
 * (word1, word2) => { word1 + word2 };
 * 
 * () => 'Hello World';
 */

 ((word1, word2) => { word1 + word2 })();
