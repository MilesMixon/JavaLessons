import { useEffect, useState } from 'react';
import axios from 'axios';

export const MovieList = () => {

    const [movies, setMovies] = useState([]);

    // As soon as the component loads, we fetch all movies
    useEffect(() => {
        axios.get('http://localhost:8085/movies')
            .then(res => setMovies(res.data));
    }, []);

    return (
        <div>
            {/* Transform the movies array into an array of JSX elements */}
            {movies.map((movie, index) => {
                // For our keys, we should use some unique property for the key value
                // Using index is a last resort if you have nothing else to use
                // Unique ids should be used ONLY if the id was created at time of data creation (It won't change)
                return (
                    <div key={movie._id}>
                        <div><strong>{movie.title}</strong></div>
                        <div><strong>{movie.director}</strong></div>
                        <div><strong>{movie.year}</strong></div>
                        <div>Rotten Tomatoes Score: {movie.rating}</div>
                        <ul>
                            {movie.leadActors.map(actor => {
                                return (
                                    <li key={actor._id}>
                                        {actor.firstName} {actor.lastName}
                                    </li>
                                );
                            })}
                        </ul>
                    </div>
                );
            })}
        </div>
    );
}