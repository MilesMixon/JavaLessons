const Movie = require('../models/Movie.model');
const { addMovieToActor } = require('./actor.controller');

const createMovie = async ({title, year, director, rating, leadActors, otherActors}) => {
    try {
        const movie = new Movie({
            title,
            year,
            director,
            rating,
            leadActors,
            otherActors
        }); // This alone does not save to the database, this just simply prepares for the database
        await movie.save(); // Saves the newly created movie to the database

        // I need to update the actors to add the new movie to their record
        // Typically this done with a transaction
        for (let actor of movie.leadActors) {
            await addMovieToActor(actor._id, movie);
        }
        for (let actor of movie.otherActors) {
            await addMovieToActor(actor._id, movie);
        }

        return movie._id; // Return the id of the newly created. Could also return the entire object
    } 
    // This catch will occur if any of the values are up to standard
    catch (err) {
        console.error(err);
        throw { status: 400, message: err };
    }
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