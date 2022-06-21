//the car class we will be using. Pretend for the sake of example that this is the setup for our database tables
//or the data we will store in our databases
class Car extends Object {
    name;
    color;
    year;

    constructor(name, color, year) {
        super();
        this.name = name;
        this.color = color;
        this.year = year;
    }

    info() {
        return `I\'m a ${this.color} ${this.year} ${this.name}`;
    }

    marketing() {
        return 'Buy me, im better';
    }
}

module.exports = Car;