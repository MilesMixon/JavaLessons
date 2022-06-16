export const Form = () => {
    return (
        <form>
            <label htmlFor="username">Username: </label>
            <div>

            <input id="username" type="text" placeholder="Please enter your username"/> 
            </div>
            <input type="password" />
            <input type="number" />
            <input type="email" />
            <input type="color" />
            <input type="date" />
            <input type="submit" value="Submit Form" />
        </form>
    );
}