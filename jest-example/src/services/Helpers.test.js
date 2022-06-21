const Car = require('../classes/Car');
const { addCar, initCarList, getCars, clearCars } = require('./Helpers');

// should be testing with fresh data each time
beforeEach(() => {
    //maybe need to initialize something/ setup the fresh data
    //this will simulate us setting up out database
    initCarList();
});

afterEach(() => {
    //need to reset the data too
    //this will simulate us deleting our database
    clearCars();
});

it('test that car list is initialized', () => {
    //without the init method running this fails
    //this is an example of where we woudl need beforeeach
    let temp = getCars();
    expect(temp).not.toEqual(null); //can use the not operator anywhere here
});

it('able to add a car', () => {
    let len = getCars().length;
    expect(len).toEqual(0);

    let res = addCar({name: 'Honda Civic', year: '2010', color: 'Silver'});
    expect(res).toEqual(true);

    res = addCar({name: 'Honda Accord', year: '2012', color: 'Red'});
    expect(res).toEqual(true);

    //cars im expecting
    const car1 = new Car('Honda Civic', 'Silver', '2010');
    const car2 = new Car('Honda Accord', 'Red', '2012');
    res = getCars();
    expect(res).toContainEqual(car1);
    expect(res).toContainEqual(car2);

    len = res.length;
    expect(len).toEqual(2);
});

it('returns the car info', () => {
    addCar({name: 'Mazda RX8', year: '2012', color: 'Blue'});

    let cars = getCars();
    
    //test methods on the car class
    expect(cars[0].info()).toEqual('I\'m a Blue 2012 Mazda RX8');
    expect(cars[0].marketing()).toEqual('Buy me, im better');
});