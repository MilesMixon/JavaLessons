// require
// It's import from Java
// We use it to bring code from other modules

const http = require('http');

// console.log(http);

// createServer returns a server instance
// Accepts a callback function as an argument to handle HTTP requests
const server = http.createServer((req, res) => {
    if (req.url === '/') {
        // Home page code goes here
        res.write('<h1>Welcome Home!</h1>');
        if (req.method === 'GET') {
            res.write('<h2>GET!</h2>');
        } else if (req.method === 'POST') {
            res.write('<h2>POST!</h2>');
        }
        return res.end();
        
    } else if (req.url === '/about') {
        // About page code goes here
        res.write('<h1>Welcome to the About Page!</h1>');
        return res.end();
    } else {
        res.writeHead(404);
        res.write('<h1>The page you\'re looking for could not be found</h1>');
        res.end();
    }
});

// Run server on port
server.listen(8080);