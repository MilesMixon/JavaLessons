import { useState } from "react";

export const PropComponent = (props) => {

    return (
        <>
            <h1>Name: {props.name}</h1>
            <h2>Age: {props.age}</h2>
            {props.children}
        </>
    );
}

export default PropComponent;