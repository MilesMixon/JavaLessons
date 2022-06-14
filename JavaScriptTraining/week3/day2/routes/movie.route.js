const router = require('express').Router();
const { createMovie, findMovieById, findAllMovies } = require('../controllers/movie.controller');
// A router functions the same as your standard app, but it's a subsection of your app

// GET /movies
router.get('/', async (req, res) => {
    const movies = await findAllMovies();
    res.json(movies);
});

router.post('/', (req, res) => {
    res.send('POST create new movie!');
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