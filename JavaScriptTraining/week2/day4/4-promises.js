/**
 * Promises were released as an answer to callbacks
 * 
 * Nested callbacks (Pyramid of Doom OR Callback Hell) they work, but the code looked so bad
 * - Hard to read and maintain
 * 
 * Promises are an object that represent the eventual success or failure of an asynchronous operation
 * 
 * Promise states:
 * 
 * Pending: The asynchronous operation is still occuring
 * Resolved: The asynchronous operation was a success (good ending)
 * Rejected: The asynchronous operation was a failure (bad ending)
 * Settled: The promise is done and the callback was executed
 */

// Creating a Promise

const orderFood = (order) => {
    return new Promise((resolve, reject) => {
        if (order === 'Calamari') {
            reject('We\'re out of calamari');
        } else {
            resolve(`Enjoy your ${order}`);
        }
    });
}

const promise = orderFood('French Fries');

promise
.then(msg => console.log(msg)) // Handles resolved promises
.catch(msg => console.error(msg)) // Handles rejected promises
.finally(() => console.log('I always run'));

// I'm gonna try and simulate an operation that will take time

const makeNetworkRequest = (url, data) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (url === 'www.bing.com') {
                reject({msg: 'We don\'t service Bing'});
            }
            resolve({msg: `The request to ${url} was successful!`, data, status: 500});
        }, 3000);     
    });
}

const networkPromise = makeNetworkRequest('www.google.com', {firstName: 'Sean', favoriteColor: 'blue'});

console.log(networkPromise);

networkPromise
    .then(data => {
        console.log('First .then()');
        if (data.status === 200) {
            return 'Another promise'; // Return is returning a Resolved Promise implicitely 
        }
        if (data.status >= 400) {
            console.log('400 or up status code');
            throw 'No 400+ errors allowed'; // Any throw statement will be interpreted as returing a rejected Promise implicitely
        }
    })
    .then(data => console.log(data))
    .catch(err => {
        console.error(err);
        return 'Crisis Averted.'
    })
    .then(msg => console.log(msg)); // throw in this one will not cause the above .catch to run

    // These chains only go downstream

// If I have 3 separate promise I want to happen the same time, but I need all promises to be resolved before continuing
// I should Promise.all

const timedPromise = (time, name) => { // To emulate network speeds
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (name === 'Quick') {
                reject(`${name} Promise failed`);
            }
            resolve(`${name} Promise finished!`);
        }, time);
    });
}

const quickPromise = timedPromise(0, 'Quick');
const mediumPromise = timedPromise(5000, 'Medium');
const slowPromise = timedPromise(8000, 'Long');

Promise.any([quickPromise, mediumPromise, slowPromise])
    .then(data => {
        console.log('Inside Promise.any then block');
        console.log(data);
    })
    .catch(err => { // This catch triggers the second any of promises fail
        console.log('Inside Promise.any catch block');
        console.log(err);
    });
