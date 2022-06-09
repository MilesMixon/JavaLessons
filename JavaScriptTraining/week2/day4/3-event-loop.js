console.log('1');

setTimeout(() => console.log('2'), 0); // setTimeout and setInterval are macrotasks

setTimeout(() => console.log('3'), 0);

Promise.resolve('4').then(data => console.log(data)); // Promises are added to the microtask queue and receive priority over macrotasks

console.log('5');


// 4 -> 1 -> 5 -> 2 -> 3
// 1 -> 4 -> 5 -> 2 -> 3 #1
// 1 -> 5 -> 2 -> 3 -> 4 #2
// 1 -> 5 -> 4 -> 2 -> 3 This is the answer