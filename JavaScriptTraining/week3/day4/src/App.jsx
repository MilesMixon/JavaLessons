import { useState } from "react";
import { ClassCounter, FunctionCounter } from "./components/Counter"; // same things as /components/Counter/index.js

// React function based component

const App = () => {
    // Whatever is returned from these functions will be what is rendered

    const [shouldRender, setShouldRender] = useState(true);

    const toggleComponent = () => {
        setShouldRender(!shouldRender);
    }

    return (
        <>
            {/* if shouldRender is true, render ClassCounter, if not don't */}
            {/* {shouldRender && <ClassCounter />} */}
            {shouldRender && <FunctionCounter />}
            <br />
            <button onClick={toggleComponent}>Toggle Render</button>
        </>  
    );   
}

export const a = 'A'; // This is a regular export. Also sometimes a "named export" since you have to refer to it by variable name

export default App; // Only one default per file
// Default exports can renamed in the other file