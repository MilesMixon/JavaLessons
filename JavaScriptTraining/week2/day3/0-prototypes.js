/**
 * Prototypes are JS means of incorpiating inheritance into the language
 * To inherit, we chain the prototypes together a la a LinkedList
 * 
 * __proto__ - Object's prototype
 * prototype - Funtion's prototype
 */

// Constructor Function
// Constructor functions were used for OOP in JS before class syntax added
// Classes weren't added to JS until 2015, but you can still do OOP before them

function Animal(name, age) {
    this.name = name;
    this.age = age;
}

// We can add methods to the constructor function's prototype to add new methods or "override" existing ones
Animal.prototype.toString = function() {
    return `My name is ${this.name} and I am ${this.age} years old!`;
}

Animal.favoriteFood = "Mango";

/**
 * new keyword in JavaScript
 * 1. Create a new JavaScript object
 * 2. Adds a __proto__ property to that object that 'points' the constructor function's prototype property
 * 3. Bind all references of 'this' in the constructor function to the newly created object
 * 4. Returns 'this' if nothing else is returned
 */

const animal = new Animal('Doug', 4);

animal.favoriteFood = 'Mango';
console.log(animal);

console.log(animal.__proto__ === Animal.prototype); // true

const obj = {}; // new Object();
console.log(obj.__proto__ === Object.prototype); // true

// Objects created using this method are NOT part of the inheritance tree (it doesn't inherit from Object)
const obj2 = Object.create(null);
console.log(obj2.__proto__ === Object.prototype); // false


// Inherited methods for our animal object
// Indicates that the prototype chain is intact
console.log(Animal.prototype.__proto__ === Object.prototype);

console.log(Object.prototype.__proto__); // null __proto__ typically represents the end of the prototype chain

// I have access to toString since animal IS-A Object
console.log(animal.toString());

// animal.valueOf = function() {
//     console.log('Hey');
// }

console.log(animal.valueOf());

const animal2 = new Animal("Carl", 7);
console.log(Animal.favoriteFood); // Access "static" property

// Inheritance with constructor functions
function Zebra(name, age, home) {
    Animal.call(this, name, age); // treat this like super() in Java
    this.home = home;
}

Zebra.prototype.__proto__ = Animal.prototype;

const zebra = new Zebra('Marty', 57, 'Central Park');
console.log(zebra);