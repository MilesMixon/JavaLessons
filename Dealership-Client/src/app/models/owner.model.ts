export class Owner {
    //think of everything in here as your class
    id: number;
    name: string;
    favoriteFood: string;
    favoriteColor: string;
    age: number;

    constructor (id: number, name: string, favoriteFood: string, favoriteColor: string, age: number) {
        this.id = id;
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.favoriteColor = favoriteColor;
        this.age = age;
    }
}
