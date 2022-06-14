const Movie = require('../models/Movie.model');

const createMovie = async () => {

}

const findMovieById = async id => {
    try {
        // If no movie is found, this does NOT return a rejected promise. Instead null is returned
        const movie = await Movie.findById(id);
        if (movie == null) {
            throw `No movie with the id of ${id} found.`;
        }
        return movie; // Movie was found and we return it
    } catch (err) {
        console.error(err);
        throw { status: 404, message: err }; // Akin to rejecting a Promise
    }
}

const findAllMovies = async (limit=0) => {
    const movies = await Movie.find(); // GET all movies
    return movies;
}

module.exports = { createMovie, findMovieById, findAllMovies };