import { useRef, useState } from "react";

export const RefExample = () => {
    // useRef and useState are super similar

    /**
     * useRef
     * 
     * If I change useRef, it does NOT cause a rerender (unlike useState)
     * useRef is a step above a local variable (ex. let count = 0) since it's value is persisted across rerenders
     * 
     * We can also use ref to bind it to a native HTML element
     * This is opposed to document.getElementById('someId')
     * 
     */

    // I can update this value on my own. There's no setter since it's not state
    let count = useRef(0);
    const inputRef = useRef();

    const [toggle, setToggle] = useState(false);

    const increment = () => {
        count.current++;
        console.log(count);
    }

    return (
        <>
            <h3>The current value of the ref is: {count.current}</h3>
            <button onClick={increment}>+</button>
            <button onClick={() => setToggle(!toggle)}>Toggle State</button>
            <input ref={inputRef} />
            <button onClick={() => console.log(inputRef.current.value)}>Check Input Value</button>
        </>
    );
}