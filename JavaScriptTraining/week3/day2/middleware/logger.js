const logger = (req, res, next) => {
    // next is a function that invoking will cause the next middleware to execute
    console.log('Request received from ' + req.originalUrl);
    next(); // Without next(), the HTTP requests will hang
}

module.exports = logger;