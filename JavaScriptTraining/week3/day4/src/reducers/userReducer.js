
const initialState = {
    username: '',
    friends: []
};

// userReducer should return the new state for this reducer
export const userReducer = (state=initialState, action) => {
    switch(action.type) {
        case 'SET_USERNAME':
            // payload is the data they're calling our reducer with
            // { type: 'SET_USERNAME', payload: 'react_lover_123'}
            console.log('SET_USERNAME');
            return {...state, username: action.payload};
        case 'ADD_FRIEND':
            // {type: 'ADD_FRIEND', payload: {firstName: 'Sally', 'lastName: 'Smith'}}
            return {...state, friends: [...state.friends, action.payload]};
        case 'REMOVE_FRIEND':
            // Remove any person from the friend's list whose first name matches the action payload's firstname
            return { ...state, friends: state.friends?.filter(friend => friend !== action.payload)};
        default:
            return state; // Returns the previous state. AKA make no changes
    }
}