// In Java the == operator MUST compare two objects of the same type

// == behaves in JavaScript
// == compares the VALUES between two things

// This is still true because the two items have the same value, 2
if (2 == '2') {
    console.log('Equal!');
}

// JavaScript added the === to behave more like Java
// === is the "strict equality operator"
// It takes both the value AND the type into account

function myTripleEquals(val1, val2) {
    if (typeof val1 != typeof val2) { // guard clause
        return false;
    }
    return val1 == val2;
}

function canKeepFish(length, species, gender) {
    if (species == 'shark') {
        return false;
    }
    if (length < 5) {
        return false;
    }
    if (gender == 'F') {
        return false;
    }
    return true;   
}

console.log(2 === '2');


/**
 * ! - Not
 * == - Equals
 * === - Strict Equals
 * != - Not Equals
 * !== - Strict NOt Equals
 * || - Logical OR
 * | - Bitwise OR
 * && - Logical AND
 * & - Bitwise AND
 */

/**
 * Truthy and Falsy values
 * 
 * Falsy values are not a boolean false, but will be treated as though they were
 * 
 * Falsy:
 * - false
 * - 0
 * - -0
 * - 0n (BigInt)
 * - null
 * - undefined
 * - NaN (Not a Number)
 * - ''
 * 
 * Truthy:
 * - Anything that's not falsy
 * - '0'
 * - []
 * - {}
 * - 'false'
 * - 42
 */

console.log('The value after casting is: ' + Boolean(1)); // Treat this as casting to Boolean
console.log('The value after casting is: ' + !!1); // This does the same thing

// NaN occurs whenever something really hammy goes on when trying to perform artithemetic and stuff fails
console.log(typeof NaN);

let num = 0;
if (num) {
    console.log(num);
} else {
    console.log('I don\'t accept 0');
}

console.log(Boolean(' '));

// In general you're always use ===

// There's one case I use ==
if (undefined == null) {
    console.log('True');
}

// If I only want no null/undefined values (but 0 and '' is okay)
if (num == null) {
    console.log('Prints true ONLY if num is null/undefined');
}

// This prevents null/undefined, BUT it also prevents '', 0, -0
if (num) {

}

num = 20

// Ternary
const value = (num > 20) ? 'Good' : 'Bad';

// Nested Ternary
const value2 = (num > 20) ? 'Good' : (num == 20) ? 'Meh' : 'Bad';
const value3 = (num != 20) ? (num > 20) ? 'Good' : 'Bad' : 'Meh';
const value4 = (num == 20) ? 'Meh' : (num > 20) ? 'Good' : 'Bad';

if (num == 20) {
    console.log('Meh');
} else if (num > 20) {
    console.log('Good');
} else {
    console.log('Bad');
}

console.log(value);

// Variable assignment using truthy/falsy

function sumArray(nums) {
    nums = Array.isArray(nums) ? nums : []; // ternary approach

    let sum = 0;
    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];
    }
    return sum;
}

// With addition, null will be translated to 0
// undefined + any numeric value will NaN
let ans = sumArray([1, null, undefined, '']); // 7
console.log('Array sum: '+ typeof ans);

// This is a channel on your computer that you expose to the outside world
// Common to run a webserver on a port

function determinePort(port) {
    // If they gave me a truthy value for the port, use the port they provided
    // If not, default to 8080
    port = port || 9000;

    // If port is null or undefined use 9000
    // if (port == null) {
    //     port = 9000;
    // }

    // This uses the port provided so long as it's not null/undefined
    // If it is, use 9000
    port = port ?? 9000; // Nullish Coalescing Operator
    port ??= 9000;

    return port;
}

console.log('The value of the boolean expression is: ' + (true && 500));

console.log(`The port selected is ${determinePort('Hello World')}`);