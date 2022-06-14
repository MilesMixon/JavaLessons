const router = require('express').Router();
// A router functions the same as your standard app, but it's a subsection of your app

router.get('/', (req, res) => {
    res.send('GET all actors');
});

router.post('/', (req, res) => {
    res.send('POST create new actor!');
});

router.get('/:id', (req, res) => {
    res.send(`GET actor with id of ${req.params.id}`);
});

module.exports = router;