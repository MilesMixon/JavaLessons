// Write a program that prints a name

function sayHello(name, age) {
    console.log('Hello, ' + name + ' and you are ' + age + ' years old'); // This works
    console.log(`Hello, ${name} and you are ${age} years old`); // template string (preferred)
}

// If undefined is passed for the value at its slot, use the default value
function functionWithDefaultParams(a=1, b=2, c=b) {
    console.log(`The value of a is ${a}`);
    console.log(`The value of b is ${b}`);
    console.log(`The value of c is ${c}`);
    return a + b + c;
}

// sayHello('Sean', 23);
// sayHello('Miles', 23);

console.log(functionWithDefaultParams(5, 10, 3));


function calculateArea(length=1, width) {

}

/**
 * 
 * @param {number | Object} val
 * @returns {number}
 */
function remove(val) {
    
}

function registerStudent(student) {
    // Handles null/undefined, but also 0, '', false
    if (student == undefined) {
        throw new Error();
    }
}

