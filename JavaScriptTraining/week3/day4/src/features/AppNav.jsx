import { useContext } from 'react';
import { useSelector } from 'react-redux';
import ThemeContext from '../contexts/ThemeContext';
import { Nav, NavItem, NavLink, NavSection } from '../components/Nav';

// This is an opinionated NavBar
export const AppNav = () => {
    const theme = useContext(ThemeContext); // When the context Provider changes in App.jsx, this component will rerender

    const { username } = useSelector(store => store);

    return (
        <Nav backgroundColor={theme.backgroundColor} color={theme.color}>
            <NavSection jc="flex-start">
                <NavItem>
                    <NavLink to="/">Home</NavLink>
                </NavItem>
                <NavItem>
                    <NavLink to="/movies" transitionColor="#0000FF">Movies</NavLink>
                </NavItem>
                <NavItem>
                    <NavLink to="/redux">Redux</NavLink>
                </NavItem>
                <NavItem>
                    <NavLink to="/translations">Translations</NavLink>
                </NavItem>
            </NavSection>
            <NavSection jc="flex-end">
                {/* If the username is truthy, render the hello message, otherwise don't render anything */}
                {username && <NavItem>Hello, {username}!</NavItem>}
                <NavItem>
                    Sign In
                </NavItem>
                <NavItem>Sign Up</NavItem>
            </NavSection>
        </Nav>
    );
}