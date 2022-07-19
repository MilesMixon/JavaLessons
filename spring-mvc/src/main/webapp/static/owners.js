let owner = {};

document.addEventListener("DOMContentLoaded", function () {
    let owners = [];
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8080/servlet-example/api/owners");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            JSON.parse(xhr.responseText).forEach(element => {
                console.log(element);
                owners.push(element);
                updateTable(element);
            });
        }
    }
    xhr.send();

    document.getElementById("new-owner").addEventListener("submit", function(event) {
        event.preventDefault();
        let _name = document.getElementById("Name").value;
        let _favCol = document.getElementById("FavCol").value;
        let _faveFood = document.getElementById("FavFood").value;
        let _age = document.getElementById("Age").value;
        owner = { name: _name, favoriteColor: _favCol, favoriteFood: _faveFood, age: _age };
        console.log(owner);

        let xhrPost = new XMLHttpRequest();
        xhrPost.open("POST", "http://localhost:8080/servlet-example/api/owners");
        xhrPost.setRequestHeader("Content-Type", "application/json");
        xhrPost.onreadystatechange = function() {
            if (xhrPost.readyState === 4) {
                updateTable(owner);
                document.getElementById("Name").value = null;
                document.getElementById("FavCol").value = null;
                document.getElementById("FavFood").value = null;
                document.getElementById("Age").value = null;
            }
        }
        xhrPost.send(JSON.stringify(owner));
    });
});

function updateTable(person) {
    //first create the new row and any data fields
    let row = document.createElement("TR");
    let id = document.createElement("TD");
    let name = document.createElement("TD");
    let favColor = document.createElement("TD");
    let favFood = document.createElement("TD");
    let age = document.createElement("TD");

    //populate those rows
    id.innerText = person.id;
    name.innerText = person.name;
    favColor.innerText = person.favoriteColor;
    favFood.innerText = person.favoriteFood;
    age.innerText = person.age;

    //add them to the row
    row.appendChild(id);
    row.appendChild(name);
    row.appendChild(favColor);
    row.appendChild(favFood);
    row.appendChild(age);

    //add the row
    document.getElementById("owner-list-body").appendChild(row);
}