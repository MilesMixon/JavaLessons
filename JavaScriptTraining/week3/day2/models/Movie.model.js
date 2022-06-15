// Mongoose allows us to provide a schema for our documents
const mongoose = require('mongoose');
const Schema = mongoose.Schema;

// Sample star wars object
const starWars = {
    title: 'Star Wars',
    year: 1977,
    director: 'George Lucas',
    rating: 90,
    leadActors: [{
        firstName: 'Mark',
        lastName: 'Hamill',
        imageURL: 'www.markhamill.com',
        actorId: '1312hfkdjsafkj41'
    }],
    otherActors: [
        {
            actorId: 'fdasfj5jlejart523'
        }
    ]
};

// Create a Movie schema
const movieSchema = new Schema({
    // If I don't specify an _id property, MongoDB will auto create one for me
    // _id is the primary key of my document

    // If you want a property called type you must use the following syntax
    // This allows for a field 'type' of type String
    // type: {
    //     type: String
    // }
    title: String,
    year: Number, // use Date if you want the full date
    director: {
        // This object syntax allows us to specify more details for our field
        type: String,
        required: true
    },
    rating: {
        // Rating can be from 0 - 100
        type: Number,
        // Tuple with first element being the min value, second being the error message
        min: [0, 'Movie cannot have a lower rating than 0'],
        max: [100, 'Movie cannot have a higher rating than 100']
        // By default, these fields are NOT required
    },
    // I will embed the data
    leadActors: [{
        // This is the data being stored on the lead actors
        firstName: String,
        lastName: String,
        imageURL: String,
        // If they want the rest of actor data, they have the actorId
        _id: {
            type: Schema.Types.ObjectId, // This symbolizes a MongoDB _id
            ref: 'Actor' // Refer to another Mongoose model
        }
    }],
    // I will only reference
    otherActors: [{
        _id: {
            type: Schema.Types.ObjectId, // This symbolizes a MongoDB _id
            ref: 'Actor' // Refer to another Mongoose model
        }
    }]
});

//                        Model Name | Schema Object | Collection Name in Atlas
const Movie = mongoose.model('Movie', movieSchema, 'Movies');
module.exports = Movie; // require('Movie.model.js') will return this Movie class