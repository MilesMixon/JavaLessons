## React

# What is React?

- React is a JavaScript UI Library/Framework created by FaceBook
- Component Based System
- Allows us to separate logic into reusable components that handle their own internal "state"
- React is "client-side rendered" opposed to "server-side rendered"

# Virtual DOM

- React believes that the view should be a direct representation of the state (the view does not determine the state)
  - View = F(state)
- Editing a specific HTML element while the app is being rendered using the vanilla DOM can result in more rerendering than necessary
- React intelligently interfaces with the DOM to only rerender elements that have had their internal state changed
- When updating the DOM, React will compare the old tree structure to the new one, and tell the DOM to only change where state changed

# State

- State refers to the internal data/behavior of an application/component
- It's used in the rendering process to flag areas that need to be updated
  - The reason is because the view is a direct result of the state
- "One-way data binding" in React, which means that the state changes the view, but the view does NOT change the state

# Webpack

- Webpack is a build tool used to take my development code and build it/minify/optimize my code to production form
  - Can be as simple as removing whitespace
- Works commonly in conjunction with Babel to target a specific version of JavaScript to build towards
- Also useful for injecting any environment variables during build time

# Babel

- Allows us to take a 2022 version of JavaScript and "transpile" to a 2015 verison of JavaScript
  - You can specify what version of JavaScript of JS to target and it will take your code and translate it to use that
  - Remove newer features if the older version doesn't allow it (ie. let/const, class, spread, rest, async/await)
  - This is why JavaScript MUST always be backwards compatabile
- This is primarily useful for allowing older browsers such as Internet Explorer to run the JavaScript since they don't support newer JS
- Allows developers to write with the new syntax while still supporting older web browsers

# JSX

- JavaScript XML
- It mirrors HTML to make it feel I'm writing HTML even though it's just JavaScript
- It's instructions for React to create the HTML
  - It does by having Babel convert JSX to JavaScript (React.createElement()) and use that to create the native HTML element using JavaScript's own document.createElement()