export class Vehicle {
    id: number;
    make: string;
    model: string;
    year: number;
    color: string;
    price: number;

    constructor(id: number, make: string, model: string, year: number, color: string, price: number) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }
}
