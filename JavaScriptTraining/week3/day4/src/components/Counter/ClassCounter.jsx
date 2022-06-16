import React from 'react';

// Before function hooks we used class components for stateful components

// You'll often hear class components referred to as "classical components"

export class ClassCounter extends React.Component {

    // The constructor is going be used to initialize things in React class components
    constructor() {
        super(); // This will register with React.Component constructor to enable it to be a React component
        this.state = {
            count: 0
        }
        this.increment = this.increment.bind(this);
        this.decrement = this.decrement.bind(this);
    }

    increment() {
        // Never mutate state directly
        // State is immutable
        // setState will indicate to React that a rerender should happen
        // this.state.count++;

        this.setState({count: this.state.count + 1});
    }

    decrement() {
        // this.state.count--;
        this.setState({count: this.state.count - 1});
    }

    // Lifecycle methods
    // These functions called at various stages of a components lifecycle

    // Runs as soon as the component is rendered for the very first time
    // If there's any data we need to fetch using an HTTP request, this is typically a good spot to do so
    componentDidMount() {
        console.log('I am rendered!');
    }

    // Runs right before the component is unrendered/removed from the DOM
    // This is useful for any cleanup that may occur
    // clearInterval should done here
    componentWillUnmount() {
        console.log('I am about to be unrendered');
    }

    // Runs everytime a rerender occurs (AKA whenever the state changes)
    componentDidUpdate(prevProps, prevState) {
        // Do not setState in here. Or you will recursively call this function

        // If the count changed, then run this code
        if (prevState.count !== this.state.count) {
            console.log(this.state.count);
        }
    }

    // Render is akin to return in a function component
    // It "renders" the JSX to the page
    // React will look to call render on any class component automatically
    render() {
        return (
            <>
                <h1>Hello Class Component!</h1>
                {/* {} indicates an expression. It's an area where we can inject values, or write JavaScript code */}
                <h2>Current Count is: {this.state.count}</h2>
                <button onClick={this.increment}>+</button>
                <button onClick={this.decrement}>-</button>
            </>
        );
    }
}