import { useState } from "react";
import { Article } from "./components/Article";
import { ClassCounter, FunctionCounter } from "./components/Counter"; // same things as /components/Counter/index.js
import { Form } from "./components/Form";
import { MovieList } from "./components/MovieList";
import { PropComponent } from "./components/PropComponent";
import { RefExample } from "./components/RefExample";

// React function based component

const App = () => {
    // Whatever is returned from these functions will be what is rendered

    const [shouldRender, setShouldRender] = useState(true);

    const toggleComponent = () => {
        setShouldRender(!shouldRender);
    }

    return (
        <>
            <MovieList />
            {/* if shouldRender is true, render ClassCounter, if not don't */}
            {/* {shouldRender && <ClassCounter />} */}
            {/* {shouldRender && <FunctionCounter />} */}
            <PropComponent name="Jimmy" age={12}>
                <p>
                    <PropComponent name="Sally" age={14} >
                        <h3>"Hi! My name is Sally and I like to bike!"</h3>
                    </PropComponent>
                </p>
                <p>
                    I like to play ball!
                </p>
            </PropComponent>
            {/* <PropComponent name="Sally" age={14} >
                <h3>"Hi! My name is Sally and I like to bike!"</h3>
            </PropComponent> */}
            
            <Article title="Why React is Awesome" author="Sean Carter" datePublished="06/16/2022">
                <p>
                    Here, I will talk about React.
                </p>
                <p>
                    First point, React is flexible.
                </p>
                <p>
                    In conclusion, React is awesome.
                </p>
            </Article>

            <Article title="Why React is Terrible" author="Sean Carter">
                <p>
                    Here, I will talk about React.
                </p>
                <p>
                    First point, React is awful.
                </p>
                <p>
                    In conclusion, React is terrible.
                </p>
            </Article>

            <RefExample />
            <RefExample />
            <RefExample />

            <br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
            <Form />

            <br />
            <button onClick={toggleComponent}>Toggle Render</button>
        </>
    );   
}

export const a = 'A'; // This is a regular export. Also sometimes a "named export" since you have to refer to it by variable name

export default App; // Only one default per file
// Default exports can renamed in the other file