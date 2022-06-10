// index.js

const express = require('express');

// app is our web application
const app = express();
const PORT = 8081; // typically read from env

// I need to tell my app it needs to be handle JSON data
// express.json() looks on the Request headers for the mime type
// If it's application/json, then parse the JSON into a JavaScript object
app.use(express.json()); // middleware

// Listen for GET requests with a URL of /
app.get('/', (req, res) => {
    res.write('Hello GET request!');
    res.send(); // Sends a message on response object back to the client
});

app.get('/movies', (req, res) => {
    res.send('GET all movies!');
});

app.post('/movies', (req, res) => {
    const data = req.body; // I need some mechanism to interpret JSON
    console.log(data);
    data.rating = '10/10';

    // .json expects a JavaScript object as a param and will convert to JSON
    // This is more semantic and is often used since JSON is the de-facto way to transfer data over the wire
    res.status(201).json(data);
});

app.get('/movies/:id', (req, res) => {
    // req.params.id Gets the wildcard value from the URL
    const {id} = req.params;
    res.send(`GET movie with id of ${id}!`);
});

app.get('/movies/en', (req, res) => {
    res.send('GET ALL english movies!');
});

app.post('/', (req, res) => {
    res.send('Hello POST request!');
});

// All requests will be handled here
// All handles ALL HTTP methods
app.all('*', (req, res) => {
    console.log('Request received'); // This just prints on the server side

    // I can chain and continuosly build out my response object using the builder design pattern
    res.status(404).type('.html').send('<strong>This is not the page you are looking for</strong>');
});

// Run server on a port
app.listen(PORT, () => {
    // This callback will run once my server starts listening
    console.log(`Server is up and running on port ${PORT}`);
});

// CTL + C to kill process