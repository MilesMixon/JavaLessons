const express = require('express');
const mongoose = require('mongoose');
const logger = require('./middleware/logger');
require('dotenv').config(); // One and done so I don't need the value from require

const app = express();
const PORT = process.env.PORT || 8080; // Default to 8080 if not in .env
app.use(express.json()); // This is middleware that auto parses JSON into JS objects between each HTTP request and the endpoint
app.use(logger);

// use() function is used to have the app/router use a piece of middleware

// Custom middleware

// This binds a router object to the url /movies
// Any HTTP request starting with /movies will come here
const movieRouter =  require('./routes/movie.route.js');

app.use('/movies', movieRouter);
app.use('/actors', require('./routes/actor.route'));

app.all('*', (req, res) => {
    res.status(404).send('We don\'t have the resource you\'re looking for.');
});

mongoose.connect(process.env.MONGO_URI)
    .then(() => {
        console.log('Successfully connected to MongoDB!');
    })
    .catch(err => {
        console.error(err);
        // Options
        // Connect to fallback database
        // OR
        // Terminate process
        process.exit(1);
    });

app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}!`);
});