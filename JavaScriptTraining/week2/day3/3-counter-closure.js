// Factory Function
// Function Closure

function counter(intitialCount=0) {

    // This is essentially a private variable since I don't return it in the object
    let count = intitialCount;

    function increment(step=1) {
        count += step;
    }

    // private helper function
    function decrement(step=1) {
        count -= step;
    }

    function getCount() {
        return count;
    }

    function setCount(newCount) {
        count = newCount;
    }

    // This determines what the outside world has access to
    // If it's not returned its private
    const ret = {
        add: increment,
        increment, // synonymous with increment: increment
        decrement,
        getCount,
        setCount: setCount
    }
    
    return ret;
}

const myCounter = counter(5);
myCounter.add(5);
myCounter.increment(3);
console.log(myCounter.getCount());

const anotherCounter = counter(100);

console.log(anotherCounter.getCount());
console.log(myCounter.getCount());