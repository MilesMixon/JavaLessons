import { useState, useEffect } from 'react';

export const FunctionCounter = () => {

    // useState is a hook
    // Hooks are what were added to function components to add the same behavior as class components
    // THey're called hooks because they allow us to hook into some aspect of our component

    // Use array destructuring to extract the state variable as well as the setter for it
    const [count, setCount] = useState(0);

    // Above your return, you can define any functions or varaibles you wish to use down below
    // These are all "private" due to closures

    // let count = 0; // Not stateful

    // useEffect we can use to trigger "side-effects" on our components
    // AKA any feature we would like to run at various points of a component's lifecycle
    // Think of useEffect as componentDidUpdate, componentDidMount, and componentWillUnmount all wrapped into one hook

    // Any time state changes, this callback function is executed
    useEffect(() => {
        console.log('State changed!');
    });

    // componentDidMount equivalent
    useEffect(() => {
        console.log('I am rendered!');
    }, []); // Dependency array. When an item in the array changes value, the callback is executed

    // componentDidUpdate equivalent
    // this useEffect only runs the callback on mount and whenever the count state changes
    useEffect(() => {
        console.log('Count updated! ' + count);
    }, [count]);

    // componentWillUnmount equivalent
    useEffect(() => {
        const intervalKey = setInterval(() => {
            console.log(new Date());
        }, 1000);

        // The function is returned will be executed as soon as the component unmounts
        return () => {
            console.log('I am unrendered!');
            clearInterval(intervalKey);
        }
    }, []);

    const increment = () => {
        // I use the setCount for changing the count state
        setCount(count + 1);
    }

    const decrement = () => {
        // count--;
        setCount(count - 1)
    }

    return (
        <>
            <h1>Hello Function Component!</h1>
            {/* {} indicates an expression. It's an area where we can inject values, or write JavaScript code */}
            <h2>Current Count is: {count}</h2>
            <button onClick={increment}>+</button>
            <button onClick={decrement}>-</button>
        </>
    );
}