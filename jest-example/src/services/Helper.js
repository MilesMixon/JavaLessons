const Car = require('../classes/Car');
/*
    pretend that these are methods that would send cars to our car database.
    these are the methods we want to test in this case.
    we can test these js methods with jest as well just like testing Java methods and classes
*/
let carList = null;

const initCarList = () => {
    carList = [];
}

const addCar = ({name, year, color}) => {
    const car = new Car(name, color, year);

    try {
        carList.push(car);
        return true;
    } catch (err) {
        return false;
    }
}

const getCars = () => {
    return carList;
}

const clearCars = () => {
    carList = null;
}

module.exports = { initCarList, addCar, getCars, clearCars };