/**
 * async/await builds on top of Promises as a cleaner way of handling promises
 * 
 * Instead of using .then and .catch, we write our Promise handlers as we normally woulds
 * 
 * We write our asynchronous the same as our synchronous code
 */

// To use async/await we must define async functions

async function myFirstAsyncFunction() {
    // If I throw it will be translated to returning a rejected promise
    return 'Hello Async!'; // Just like .then, anything returned in an async function will automatically be wrapped in a Promise
}

// console.log(myFirstAsyncFunction()); // Returns a promise

// The async function returns a promise, and I can unpack it using .then()
myFirstAsyncFunction().then(msg => console.log(msg)).catch(err => console.error(err + ' Error'));



// await
const withAwait = async () => {
    // await MUST be used inside async functions
    const msg = await myFirstAsyncFunction(); // await acts the same as .then. It auto unpacks Promise to get the resolve value
    // await WILL fail if the Promise is rejected
    console.log(msg + ' inside withAwait');

}

withAwait();

// This is a way to use await on the top level
// This is known as a AIIFE
(async () => {
    await myFirstAsyncFunction();
})();


const inStockItems = ['Apple', 'Banana', 'Milk', 'Eggs', 'Bread', 'Ice Cream'];

/**
 * I send someone to go shop for items at the store for me
 */

const travel = async location => {
    await new Promise(resolve => setTimeout(() => {
        console.log(`Traveling to ${location}`);
        resolve();
    }, 5000));
} 

const findItems = async items => {
    await new Promise((resolve, reject) => setTimeout(() => {
        for (let item of items) {
            // find returns undefined if the item was not found in the array
            if (inStockItems.find(inStockItem => inStockItem === item) == undefined) {
                return reject(`${item} could not be found`);
            }
        }
        console.log(`Purchasing ${items}`);
        resolve();
    }, 3000));
}

const checkout = async () => {
    await new Promise(resolve => setTimeout(() => {
        console.log('Checking out');
        resolve();
    }, 2000));
}

const buyItemsFromStore = async (startLocation, endLocation, items) => {
    /**
     * 1. Drive to the store
     * 2. Find items
     * 3. Purchase
     * 4. Head home
     */
    try {
        await travel(endLocation); // Must finish getting to the store, before buying items
        await findItems(items);
        await checkout();
        await travel(startLocation);
        console.log('Shopping success!');
    } catch (err) {
        console.error(err);
        console.log('Shopping failure :(');
    } finally {
        console.log('Shopping journey over');
    }
}

buyItemsFromStore('Home', 'Publix', ['Apple', 'Milk', 'Honey']);