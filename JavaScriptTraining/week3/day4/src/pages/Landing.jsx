import { useState } from "react";
import { useSelector } from "react-redux";
import { PropComponent } from "../components/PropComponent";
import { RefExample } from "../components/RefExample";
import { CSSComponent, StyledComponents, Center } from "../components/StylePractice";
import { Article } from "../components/Article";
import { ClassCounter, FunctionCounter } from "../components/Counter"; // same things as /components/Counter/index.js
import { Form } from "../components/Form";

export const Landing = () => {

    
    const [shouldRender, setShouldRender] = useState(true);

    const toggleComponent = () => {
        setShouldRender(!shouldRender);
    }

    const username = useSelector(store => store.username);

    return (
        <>
            <CSSComponent />
            <StyledComponents />
            {/* if shouldRender is true, render ClassCounter, if not don't */}
            {/* {shouldRender && <ClassCounter />} */}
            {/* {shouldRender && <FunctionCounter />} */}
            <PropComponent name={username} age={12}>
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
            
            <Center>
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
            </Center>

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