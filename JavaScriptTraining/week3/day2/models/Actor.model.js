const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const actorSchema = new Schema({
    firstName: String,
    lastName: String,
    imageURL: String,
    movies: [{
        title: String,
        year: String,
        _id: {
            type: Schema.Types.ObjectId,
            ref: 'Movie'
        }
    }]
});

const Actor = mongoose.model('Actor', actorSchema, 'Actors');
module.exports = Actor;