#SQL Comment
-- SQL Comment (This one needs a space between the two dashes and the text)
/*
SQL Comment
*/

/*
	SQL Tables
		-Primary Key: a column or set of columns that uniquely identity every row
        -Canidate Key: set of columns in a database that could be a primary key (reasonable choice)
        -Surrogate Key: a column or set of columns that can be used as a primary key in place of the primary key
						or to make one if none exists
		-Foreign Key: a reference to the primary key of another table

	Normalization - a way to reduce data redundancy and save on disk space
		- 3 forms that we will be covering:
			- 1st normal form (1NF): 
									1. Every row needs a primary key
									2. no repeating groups
			- 2nd normal form (2NF): 
									1. Must be in 1NF
                                    2. No Partial Dependencies
			- 3rd normal form (3NF): 
									1. Must be in 2NF
									2. No Transitive Dependencies (functional dependencies)
*/

# Select statements
# Select <something> from <somewhere> where <something is true>;
# * is your wildcard that means everything
# SQL is not case sensitive for keywords
# Have to end statements in a ; same as Java
# if no where is specified then it grabs everything
SELECT * FROM customer;

# The order i list these is the order they are returned
SELECT LastName, FirstName, Address, City, Company FROM customer;

SELECT * FROM customer WHERE CustomerId >= 10;

# AND and OR behave as you would expect
SELECT * FROM customer WHERE CustomerId >= 10 AND CustomerID <= 30; 
SELECT * FROM customer WHERE CustomerId BETWEEN 10 AND 30; # inclusive, same as above

# single = for equality instead of ==
SELECT * FROM customer WHERE CustomerId >= 10 OR CustomerID = 3;

SELECT * FROM customer WHERE CustomerId >= 10 OR CustomerID = 3 ORDER BY FirstName DESC;

# Same query
SELECT * FROM customer WHERE CustomerId = 11 OR CustomerId = 21 OR CustomerId = 32 OR CustomerId = 40 OR CustomerId = 24;
SELECT * FROM chinook.customer WHERE CustomerId IN (11, 21, 32, 40, 24);

Select * from zulmak.vehicles;

# Insert
# INSERT INTO <somewhere> <something> VALUES <the data>;
INSERT INTO vehicles (make, model, year, color, mileage, electric) VALUES ('Benz Patent Motor Car', 'model no. 1', 1886, 'Brown', 0, 0);

INSERT INTO vehicles 
	(make, model, year, color, price, mileage, electric) 
VALUES 
	('Lamborghini', 'Aventador SVJ', 2022, 'Blue', 221342.99, 200, 0),
	('Honda', 'Civic', 2010, 'Grey', 5856.99, 200000, 0),
    ('Kia', 'K5', 2022, 'Meteorite', 22000.99, 0, false),
    ('Nissan', 'Sentra', 2022, 'White', 20000, 0, 0),
    ('Empire', 'Death Star', 1980, 'Black', 800000.99, 0, 0),
    ('Wayne', 'Batmobile', 1972, 'Black', 600000.99, 500000, false),
    ('Scion', 'FR-5', 2013, 'White', 45000.99, 86000, 1),
    ('Chevrolet', 'Camero IROC Z28', 1986, 'Rally Yellow', 15000, 25000, 0),
    ('Plymouth', 'Fury', 1963, 'Candy Apple Red', 265000, 10000, 0),
    ('Mitsubishi', 'Eclipse', 1997, 'grey', 20, 240000, false);

SELECT color, make, model, year from vehicles where mileage > 0 ORDER BY Price ASC;

# as gives a column/ set of columns an alias
# concat combines things
SELECT id, CONCAT(year, " ", make, " ", model) as name, color, price from vehicles;

Select * from vehicles;
# update commands
# needs the where clause for updates and deletes or else it will apply to everything
UPDATE vehicles SET price = 26337 WHERE id = 1;

# safe mode will stop me from doing this. need the PK for updates in safe mode
UPDATE vehicles SET mileage = 26000 WHERE year = 2022;

# would not recommend, but it'll allow it
UPDATE vehicles SET mileage = 27000 WHERE id between 1 and 35 and year = 2022;

# sub query
SELECT make, model
FROM vehicles WHERE year IN (SELECT year FROM vehicles WHERE year >= 1900);

select count(*) from vehicles;
select sum(id) from vehicles;

INSERT INTO vehicles 
	(make, model, year, color, price, mileage, electric) 
VALUES 
	('Lamborghini', 'Aventador SVJ Roadster', 2022, 'Neon Blue', 231342.99, 250, 0),
	('Toyota', 'Corolla', 1998, 'Red', 7856.99, 201000, 0),
    ('Honda', 'Accord', 2012, 'Green', 15856.99, 200000, 0);
    
DELETE FROM vehicles WHERE id = 13;

INSERT INTO vehicles 
	(id, make, model, year, color, price, mileage, electric) 
VALUES 
	(13, 'Toyota', 'Corolla', 1998, 'Neon Pink', 7856.99, 201000, 0);
    
INSERT INTO owners
	(name, favoriteColor, favoriteFood, age) 
VALUES 
	('Jon Provan', 'Black', 'Pulled Pork BBQ', 29),
	('Bree Ridley', 'Purple', 'Spicy Foods', 25),
    ('Patrick Walsh', 'Blue', 'Pickles',37),
    ('Dan Pickles', 'Red', 'Pickles',39),
    ('Jason Harris', 'Forest Green', 'Italian',32),
    ('Miles Mixon', 'Blue', 'Chicken Tenders',24),
    ('Sean Carter', 'Green', 'Mango',22),
    ('Kevin Gil', 'Blue', 'Italian',16),
    ('Kevin Kelbach', 'Burgundy', 'Chicken',23),
    ('Jason Bourne', 'Blue', 'Justice', 36);
    
SELECT * FROM owners;
