import { createStore } from 'redux';
import { userReducer } from './reducers/userReducer';

// Deprecated, Developers indicating to use redux-toolkit
const store = createStore(userReducer);

export default store;