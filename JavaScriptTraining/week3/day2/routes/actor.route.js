const router = require('express').Router();
const { createActor } = require('../controllers/actor.controller');
// A router functions the same as your standard app, but it's a subsection of your app

router.get('/', (req, res) => {
    res.send('GET all actors');
});

router.post('/', async (req, res) => {
    try {
        const actorId = await createActor(req.body);
        res.json({_id: actorId});
    } catch (err) {
        res.status(err?.status || 400).json(err);
    }
});

router.get('/:id', (req, res) => {
    res.send(`GET actor with id of ${req.params.id}`);
});

module.exports = router;