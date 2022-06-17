import { useState, useRef } from 'react';
import { useDispatch, useSelector } from 'react-redux';

export const ReduxExamples = () => {

    const [username, setUsername] = useState('');
    const usernameRef = useRef();
    const friendRef = useRef();
    const removeRef = useRef();
    const dispatcher = useDispatch();

    const friends = useSelector(store => store.friends);

    const handleSubmit = (event) => {
        // This prevents the page refresh of a form submission
        event.preventDefault();
        // usernameRef.current.value
        dispatcher({type: 'SET_USERNAME', payload: usernameRef.current.value});
        usernameRef.current.value = null;
    }

    const addFriend = (e) => {
        e.preventDefault();
        dispatcher({type: 'ADD_FRIEND', payload: friendRef.current.value});
        friendRef.current.value = null;
    }

    const removeFriend = (e) => {
        e.preventDefault();
        dispatcher({type: 'REMOVE_FRIEND', payload: removeRef.current.value});
        removeRef.current.value = null;
    }

    return (
        <>
            <form>
                <label htmlFor="username">Change Username</label>
                {/* Controlled input. React decides when it changes/rerenders */}
                {/* <input id="username" placeholder="Please enter a username" value={username} onChange={(e) => setUsername(e.target.value)}/> */}
                {/* Uncontrolled input. Input decides its own state, DOM decides when it rerenders */}
                <input id="username" placeholder="Please enter a username" ref={usernameRef} />
                <button onClick={handleSubmit}>Set Username</button>
            </form>

            <form>
                <label htmlFor="addFriend">Add Friend</label>
                <input id="addFriend" placeholder="Please enter a friend's name you wish to add" ref={friendRef} />
                <button onClick={addFriend}>Add Friend</button>
            </form>

            <form>
                <label htmlFor="removeFriend">Remove Friend</label>
                <input id="removeFriend" placeholder="Please enter a friend's name you wish to remove" ref={removeRef} />
                <button onClick={removeFriend}>Remove Friend</button>
            </form>

            <ol>
                {friends.map((friend, index) => {
                    // You may use index if your list is not going change in order, or size
                    return (
                        <li key={index}>{friend}</li>
                    );
                })}
            </ol>
        </>
    );
}