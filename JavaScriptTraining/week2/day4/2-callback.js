/**
 * What is a callback?
 * A callback is simply a function passed to another function that will be called at a later point in time
 * 
 * 
 */

// setTimeout

function sayHello() {
    console.log('Hello!');
    // console.log('Registering goodbye callback');
    setTimeout(sayGoodbye, 3000);
    // console.log('Doing more things');
}

function sayGoodbye() {
    console.log('Goodbye');
}

// console.log('Registering hello callback');

setTimeout(sayHello, 3000);

// console.log('Doing other things');

function mySetTimeout(callback, time) {
    // sleep(time);
    callback();
}

mySetTimeout(() => console.log('Callback!'), 3000);


// setInterval
// setInterval works as the same as setTimeout, but it repeats the process every time (until cancelation)
let count = 0;

const intervalKey = setInterval(() => {
    console.log(++count);
    if (count >= 10) {
        // clearInterval is good for cleaning up your intervals
        clearInterval(intervalKey); // Clear the interval
    }
}, 0); // milliseconds

// while(true) {} // This congests the stack and when something's on the stack, nothing out of the event queue will run