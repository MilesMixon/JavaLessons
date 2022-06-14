const express = require('express');
const mongoose = require('mongoose');
require('dotenv').config(); // One and done so I don't need the value from require

const app = express();
const PORT = process.env.PORT || 8080; // Default to 8080 if not in .env

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