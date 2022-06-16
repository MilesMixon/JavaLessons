import { useEffect, useState } from 'react';
import axios from 'axios';

export const MovieList = () => {

    const [movies, setMovies] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8085/movies')
            .then(res => setMovies(res.data));
    }, []);

    return (
        <div>
            Movie List
            <a href="http://localhost:8085/movies">Get ALL Movies</a>
        </div>
    );
}