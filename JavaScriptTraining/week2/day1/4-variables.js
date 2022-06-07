/**
 * var is either global scoped or function scoped
 * var you can overwrite the value of it very easily. Leads to very hard diagnose bugs
 */

// This variable is globally scoped (to the file)
var x = 10;
var x = 20;

function myFunction() {
    // Variable Hoisting
    // The process of moving all variable declarations to the top of their scope

    console.log(x);
    if (2 == 3) {
        var x = 'x';
    }

    // ..........

    if (2 == 4) {
        // var x = 'x';
    }
}


// myFunction();

var x = 30;

// myFunction();


/**
 * let is block scoped
 * "Block scoped" is essentially the perimeters of the curly braces or "code block"
 */
let y = 'y';
y = 10;

function blockScope() {
    // the declaration of z is STILL hoisted
    // BUT it's not accessible and trying to use it before declaration will throw an error
    // Known as "Temporal Dead Zone"
    console.log(z);

    if (false) {    
        let z = 'z';
        // console.log(z);
        // Now I can z
    }
}

// blockScope();

/**
 * const behaves almost exactly the same as let
 * It is also block scoped
 * BUT you CANNOT assign it a new value
 * final keyword in Java is the equivalent
 * */

const a = 'a';
// a = 10; // Throws an error

const arr = [1, 2, 3];
arr[0] = 0; // Does not throw an error because the reference is the same

console.log(arr);

const obj = {
    lastName: 'Carter'
};

obj.firstName = 'Sean';

let myVar = false;
console.log(typeof myVar);
myVar = 1;
console.log(typeof myVar);