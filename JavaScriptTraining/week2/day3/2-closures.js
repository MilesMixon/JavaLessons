/**
 * Closure: A function that contains an encapsulated reference to its surrounding "Lexical Environment"
 * 
 * AKA an inner function that has access to values defined in an exterior scope
 */

const x = 10;

function myFunction() {
    console.log(x); // Prints the x from the outer scope
}

myFunction();

function myClosure(name) {
    const age = 22;

    (function() { // anonymous function (no name). It doesn't need a name since it invokes itself
        console.log(`My name is ${name} and I am ${age} years old`);
    })(); // IIFE (Immediately Invoked Function Expression/Self Executing Function)
}

myClosure('Bob');

function myClosureWithReturn(name, age) {
    return function() {
        console.log(`My name is ${name} and I am ${age} years old`);   
    }
}

const samGreet = myClosureWithReturn('Sam', 48);

const kimberlyGreet = myClosureWithReturn('Kimberly', 26);
kimberlyGreet();
samGreet();

function timesX(x) {
    return function(y) {
        return x * y;
    }
}

const times2 = timesX(2);
times2(5);

// Invoke the outer function, then invoke the inner
console.log(timesX(10)(5)); // 50


const times10 = timesX(10);
console.log(times2(16));
console.log(times10(5));