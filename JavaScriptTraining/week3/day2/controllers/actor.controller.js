const Actor = require('../models/Actor.model');

const createActor = async ({firstName, lastName, imageURL, movies}) => {
    try {
        const actor = new Actor({
            firstName,
            lastName,
            imageURL,
            movies
        });
        await actor.save();
        return actor._id;
    } catch (err) {
        console.error(err);
        throw { status: 400, message: err };
    }
}

const addMovieToActor = async (_id, { title, year, _id: movieId }) => {
    try {
        // Pushes onto the array for the field 'movies', a new object containing title, year, and movieId
        await Actor.findByIdAndUpdate(_id, { $push: { movies: { title, year, _id: movieId } } });
    } catch (err) {
        console.error(err);
        throw { status: 400, message: err };
    }
}

module.exports = { createActor, addMovieToActor };