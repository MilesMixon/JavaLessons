// Object[] myArray = {"", 1, false};

// const arr = new Array(); // Another way to create an array

const myArray = ["", 1, false];

const fruits = ['Mango', 'Banana', 'Peach', 'Pear'];

console.log('Fruits before pop: ' + fruits);

fruits.pop(); // Removes AND returns the final element of the array

console.log('Fruits after pop: ' + fruits);

console.log([].pop()); // Return undefined, does not throw error

// Remove the first element of an array

fruits.shift();

console.log('Fruits after shift: ' + fruits);

// unshift will add an item to the front of the array
fruits.unshift('Pineapple');
console.log('Fruits after unshift: ' + fruits);

// push will add an item to the end of the array
fruits.push('Cherry');

console.log('Fruits after push: ' + fruits);


// Print the item at index 0
console.log('Index 0: ' + fruits[0]);

// ArrayIndexOutOfBounds in Java just yields undefined in JavaScript
console.log('Index 0: ' + fruits[-1]);

// at method works similar to Python
// I can use .at(-1) to get the final element of the array
// -2 returns the second last element
console.log(`Final element: ${fruits.at(-1)}`);

// Finding a specific item
console.log('Index of mango: ' + fruits.indexOf('Mango')); // -1 indicates not found
console.log('Index of banana: ' + fruits.indexOf('Banana')); // 1

// Trim
// Trim takes off the trailing and leading whitespace
console.log('                 Hello World                 '.trim()); // Hello World

// Copy an array
const fruitsCopy = fruits.slice(); // Creates a deep copy of our array
// Deep copy is the same data, different memory address

console.log(fruitsCopy);
fruitsCopy.shift();
console.log('Fruits copy: ' + fruitsCopy);
console.log('Fruits: ' + fruits);

// Remove specifically the middle element of an array
// splice()

// I want to remove Peach
const peachIndex = fruits.indexOf('Peach');

// First param: The index to start at for removal
// Second param: The amount of indices to remove starting at the first param
const removedFruits = fruits.splice(peachIndex, 1); // returns a new array consisting of the values removed
console.log(removedFruits); // Contains ['Peach', 'Cherry']

console.log(fruits);

// I don't like splice and I want use remove

// Picture this as though it were within the Array class as a method
function remove(index) {
    const removedValues = this.splice(index, 1); // this refers to the array that I'm calling it with
    console.log('\n\nREMOVING THESE VALUES');
    console.log(removedValues);
    console.log('\n\n');
}

Array.prototype.remove = remove; // I added the remove method to ALL arrays everywhere

const planets = ['Mercury', 'Venus', 'Earth', 'Mars'];

const venusIndex = planets.indexOf('Venus');
planets.remove(venusIndex);

console.log(planets);