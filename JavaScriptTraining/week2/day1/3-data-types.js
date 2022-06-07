/**
 * Primitives:
 * - number
 * - string
 * - boolean
 * - null
 * - undefined
 * - BigInt
 * - Symbol
 * 
 * Objects:
 * - Objects
 * - Arrays
 * - Functions
 */

var num = null;
console.log(typeof num);
// console.log(num);

var msg = true;
if (typeof msg == 'string') {
    console.log(msg.trim());
} else {
    console.log('That\'s not a string');
}


// Don't do this (code obfuscating)
function myFunction() {

}

myFunction.firstName = 'Sean';
myFunction.doSomething = function() {
    console.log('Doing something');
}

class Square {}

myFunction.doSomething();

var obj = new Array();
console.log(typeof myFunction);