# What is Redux?

- It is a state management solution
- It aims elevate state management from the individual component, and instead, put it in a global scope
- Helps avoid "prop drilling" similar to context
- Redux is NOT React specific, but it is one of the most popular state management libraries for React

# What data should be stored in Redux?

- Avoid storing EVERYTHING in Redux
- Try to distinguish between component data and application data
  - Component data is state that only one component cares about
  - Application data is data that used EVERYWHERE in your application
    - Things like a shopping cart, user data, network data, etc.

# Flux Pattern

1. An event is triggered by the user (in the view)
2. An action is dispatched to update the reducers
3. Reducers take dispatched event and handle it by updating the store as need be
4. The view is updated, and the cycle continues