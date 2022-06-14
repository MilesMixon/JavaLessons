const router = require('express').Router();
const { createMovie, findMovieById, findAllMovies } = require('../controllers/movie.controller');
// A router functions the same as your standard app, but it's a subsection of your app

// GET /movies
router.get('/', async (req, res) => {
    const movies = await findAllMovies();
    res.json(movies);
});

router.post('/', async (req, res) => {
    try {
        const movieId = await createMovie(req.body);
        res.status(201).json({_id: movieId});
    } catch (err) {
        res.status(err?.status || 500).json(err);
    }
});

router.get('/:id', async (req, res) => {
    try {
        const movie = await findMovieById(req.params.id);
        res.json(movie);
    } catch (err) {
        res.status(err?.status || 400).json(err);
    }
});

module.exports = router;