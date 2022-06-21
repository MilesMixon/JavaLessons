import { useRef } from "react";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './ActorForm.css';

export const ActorForm = () => {

    const firstNameRef = useRef();
    const lastNameRef = useRef();
    const navigate = useNavigate();

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            await axios.post('http://localhost:8085/actors', 
                            { firstName: firstNameRef.current.value, lastName: lastNameRef.current.value });
            navigate('../', {replace: true});
        } catch (error) {
            console.log('Something Went Wrong');
        }
    }

    return (
        <>
            <form className="MyForm" onSubmit={handleSubmit} >
                <label htmlFor="firstName">First Name:</label>
                <div>
                    <input id="firstName" type="text" placeholder="First Name" ref={firstNameRef} />
                </div>

                <label htmlFor="lastName">Last Name:</label>
                <div>
                    <input id="lastName" type="text" placeholder="Last Name" ref={lastNameRef} />
                </div>

                <input type="submit" value="Add Actor" />
            </form>
        </>
    );
}