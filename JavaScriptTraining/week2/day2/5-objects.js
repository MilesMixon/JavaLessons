// Objects in JavaScript are essentially a HashMap AKA key-value pairs
// It's the same as a Python dictionary

const student = {
    firstName: 'Mary',
    lastName: 'Smith',
    age: 20,
    major: 'Philisophy'
}

function myFunc() {

}

const student2 = {
    firstName: 'John',
    lastName: 'Doe',
    age: 30,
    major: 'Art'
}

// Accessing a value on the student object
console.log(student.major); // Akin to getters

// Adding a value to the student object
student.friends = [student2];

console.log(student.friends);

// Mutate existing values
student.firstName = 'Gary'; // Akin to setters
console.log(student.firstName);

// [] notation for accessing object properties

// This is not valid JS code
// student.date of birth = '06/07/2022';

// I can add that property or 'key' by using square brackets
student['date of birth'] = '06/07/2022';

console.log(student);

// student.prop = 'prop'

// Iterate over the properties/keys of my student object
console.log('Key: Value');
for (let prop in student) {
    // console.log(student.prop); // Looks for the key 'prop'
    console.log(`${prop}: ${student[prop]}`); // This is the only time I really use square brackets
}


const wildcard = 'Ace';

const obj = {
    // The value of wildcard will become the key
    [wildcard]: 'Wildcard Value'
};

console.log(obj);

function myFunction(key, value) {
    return {
        [key]: value
    }
}


// Advanced object properties


console.log(Object.getOwnPropertyDescriptor(student, 'firstName'));

Object.defineProperty(student, 'firstName', {writable: false}); // Prevents me from setting the value of firstName
Object.defineProperty(student, 'firstName', {enumerable: false}); // Inhibits the visibility of firstName
Object.defineProperty(student, 'firstName', {configurable: false}); // Prevents me from altering the configuration of firstName

console.log(student.firstName);

// Object.defineProperty(student, 'firstName', {writable: true}); // This breaks since I set configurable to false
student.firstName = 'Mary'; // I can no longer change the value of firstName on the student object
console.log(student.firstName);

// for in iterates over 'enumerable' properties
for (prop in student) {
    console.log(prop);
}

console.log(student.__proto__);

console.log(student);