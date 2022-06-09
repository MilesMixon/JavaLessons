/**
 * Higher Order Functions (HOF):
 * 
 * Functions that take a function as a parameter OR return a function
 */

// timesX is an HOF since it returns a function
function timesX(x) {
    return function(y) {
        return x * y;
    }
}

const forEachInArray = (arr, action) => {
    for (let elem of arr) {
        action(elem);
    }
}

const fibs = [1, 1, 2, 3, 5, 8, 13, 21];

function printItem(item) {
    console.log(item);
}

// I can pass a function previously defined to another function
forEachInArray(fibs, printItem);
console.log();

// I can use anonymous functions for "one time use" functions
// Anonymous functions are functions with no name
forEachInArray(fibs, function(item) {
    console.log(item * 2);
});

console.log();

// We can also do the same with arrow functions
// Arrow functions are preferred because they were made for this exact purpose
forEachInArray(fibs, item => console.log(item * 10));


function dummyFn() {
    console.log(this);
}

new dummyFn();

const dummyArrow = () => console.log(this);
dummyArrow();

function Dog(name) {
    this.name = name;

    this.bark = () => {
        console.log(`Bark! (My name is ${this.name})`);
    }
}

const dog = new Dog('Fido');
dog.bark();

/**
 * Arrow functions take on the surrounding scope's version of 'this'
 * Standard functions make their own definition
 */

let myArrowFunction = () => console.log('Old function');

myArrowFunction = item => console.log(item)

myArrowFunction('Hello');


/**
 * Array HOFs
 * 
 * forEach
 * map
 * filter
 * reduce
 * 
 * None of these mutate the underlying array
 */

const musicArtists = ['Led Zeppelin', 'Jon Provan', 'Metallica', 'Johnny Cash', 'A$AP Rocky', 'Queen', 'Judas Priest', 'Jon Bon Jovi'];

// forEach
// Perform some function on each element of the array
// Does not return anything

musicArtists.forEach(elem => console.log(elem)); // iterates over musicArtists and prints them all

// this newArtists will be undefined since forEach doesn't return any value
const newArtists = musicArtists.forEach(elem => {
    return elem.toUpperCase(); // You can return in a forEach, but the return will be ignored
});

console.log(newArtists);

// map
// Perform some function on each element of the array
// Constructs a new array and whatever is returned will get added to that new array

const upperCasedArtists = musicArtists.map(elem => {
    return elem.toUpperCase();
});

console.log(upperCasedArtists);

// filter
// Takes a function that acts as a filtering criteria for the array
// If the return value is truthy, the value is kept
// If the value is falsy, the value is discarded
// This constructs and returns a new array consisting only of those values kept

const artistsStartingWithJ = musicArtists.filter(elem => {
    return elem.charAt(0).toUpperCase() === 'J'; // Only want first letter J
});

console.log(artistsStartingWithJ);

const students = [{name: 'John', grade: 90}, {name: 'Sally', grade: 85}, {name: 'Joe', grade: 95}];

console.log(students.filter(({grade}) => grade >= 90));

// reduce
// Reduce taking a function that accumulates our array into a value
// I take an acc (accumulator) that represents the current value as well as the element we're looking at

// Find the student with the highest grade
const top = students.reduce((topStudent, currentStudent) => {
    return topStudent.grade < currentStudent.grade ? topStudent : currentStudent;
});

console.log(top);

let currentTop = null;
for (let student of students) {
    // ?. is the optional chaining operator
    // AKA if a NullPointerException were to occur, substitute undefined instead
    if (currentTop == null || student.grade > currentTop.grade) {
        currentTop = student;
    }
}

console.log(currentTop);

const quarterlySpending = [5000, 12000, 9000, 30000];

// totalSpending will be the final value of acc
const totalSpending = quarterlySpending.reduce((acc, currQuarter) => {
    // The value that is returned becomes the acc on the next iteration
    return acc + currQuarter;
}, 50); // second parameter is optional, but will specify the start value for acc

console.log(totalSpending);

let sum = 0;
for (let quarter of quarterlySpending) {
    sum += quarter;
}




// Chaining these HOFs together
// I want a mega band
// I will only get the bands starting with J
// Then I will upper case all band names
// Then I will concatenate them all into one giant band name

const megaBand = musicArtists
    .filter(artist => artist.charAt(0).toUpperCase() === 'J')
    // forEach is a terminator. I must it at the end of the chain if I want to use it
    // I cannot chain off of forEach since it returns undefined
    .map(artist => artist.toUpperCase())
    .reduce((acc, artist) => acc + ' ' + artist);

console.log(megaBand);


// Functional Programming
/**
 * Functional Programming is a programming paradigm (like OOP or procedural)
 * 
 * Functional Programming is all about "pure functions"
 * 
 * A "pure function" is a function with no side effects
 * - Side effects are things mutate the underlying array
 * - The function should only do one thing
 * 
 * Big benfit is being able to stitch these functions together to achieve some end data without mutating the original data source
 */

const myForEach = () => {
    console.log(this);
}

Array.prototype.myForEach = myForEach;

[1, 2, 3].myForEach();