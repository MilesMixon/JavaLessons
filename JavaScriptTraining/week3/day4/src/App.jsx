import { useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { AppNav } from './features';
import { Landing, Movies, Error } from './pages';
import ThemeContext, { themes } from './contexts/ThemeContext';


// React function based component

const App = () => {
    // Whatever is returned from these functions will be what is rendered

    const [currTheme, setCurrTheme] = useState(themes.light);

    const toggleTheme = () => {
        if (currTheme === themes.light) {
            setCurrTheme(themes.dark);
        } else {
            setCurrTheme(themes.light);
        }
    }

    return (
        <ThemeContext.Provider value={currTheme}>
            {/* Everything in here is going to managed by react-router-dom so that it can toggle between pages */}
            <BrowserRouter>
                <AppNav />
                <button onClick={toggleTheme}>Toggle Theme</button>
                <Routes>
                    {/* When the URL in the browser becomes /, toggle on the Landing page */}
                    <Route path="/" element={<Landing />} />
                    <Route path="/movies" element={<Movies />} />
                    <Route path="/movies/abc" element={<h1>ABC movie</h1>} />
                    <Route path="*" element={<Error />} />
                </Routes>
            </BrowserRouter>
        </ThemeContext.Provider>
    );   
}

export const a = 'A'; // This is a regular export. Also sometimes a "named export" since you have to refer to it by variable name

export default App; // Only one default per file
// Default exports can renamed in the other file