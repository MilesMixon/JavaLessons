import { useContext } from 'react';
import ThemeContext from '../contexts/ThemeContext';
import { Nav, NavItem, NavLink, NavSection } from '../components/Nav';

// This is an opinionated NavBar
export const AppNav = () => {
    const theme = useContext(ThemeContext); // When the context Provider changes in App.jsx, this component will rerender

    return (
        <Nav backgroundColor={theme.backgroundColor} color={theme.color}>
            <NavSection jc="flex-start">
                <NavItem>
                    <NavLink to="/">Home</NavLink>
                </NavItem>
                <NavItem>
                    <NavLink to="/movies">Movies</NavLink>
                </NavItem>
            </NavSection>
            <NavSection jc="flex-end">
                <NavItem>
                    Sign In
                </NavItem>
                <NavItem>Sign Up</NavItem>
            </NavSection>
        </Nav>
    );
}