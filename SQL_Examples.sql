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

# %: any number of characters
# _: one character
SELECT * FROM owners WHERE favoriteColor LIKE 'B%';

SELECT * FROM owners WHERE name LIKE '_e%';

SELECT * FROM chinook.artist WHERE Name LIKE '___';

SELECT * FROM owners;
SELECT * FROM vehicles;

# can use union to combine the output of two queries into one result set
SELECT * FROM owners WHERE favoriteColor LIKE '_l%' 
UNION
SELECT * FROM owners WHERE name LIKE '_a%';



UPDATE vehicles SET owner = 6 WHERE id= 2;
UPDATE vehicles SET owner = 1 WHERE id= 6;
UPDATE vehicles SET owner = 4 WHERE id= 7;
UPDATE vehicles SET owner = 6 WHERE id= 3;
UPDATE vehicles SET owner = 7 WHERE id= 1;
UPDATE vehicles SET owner = 3 WHERE id= 11;
UPDATE vehicles SET owner = 5 WHERE id= 12;
UPDATE vehicles SET owner = 10 WHERE id= 15;
UPDATE vehicles SET owner = 2 WHERE id= 8;

select * from vehicles join owners on vehicles.owner = owners.id;
#the same as a n inner join
select 
	CONCAT(v.year, " ", v.make, " ", v.model) as vehicle, 
    v.color, 
    v.price, 
    o.name, 
    o.favoriteColor, 
    o.age 
from vehicles v join owners o on v.owner = o.id;
#same as above
select 
	CONCAT(v.year, " ", v.make, " ", v.model) as vehicle, 
    v.color, 
    v.price, 
    o.name, 
    o.favoriteColor, 
    o.age 
from vehicles v inner join owners o on v.owner = o.id;

select 
	CONCAT(v.year, " ", v.make, " ", v.model) as vehicle, 
    v.color, 
    v.price, 
    o.name, 
    o.favoriteColor, 
    o.age 
from vehicles v left join owners o on v.owner = o.id;

select 
	CONCAT(v.year, " ", v.make, " ", v.model) as vehicle, 
    v.color, 
    v.price, 
    o.name, 
    o.favoriteColor, 
    o.age 
from vehicles v right join owners o on v.owner = o.id;

#another way do to an inner join
select 
	CONCAT(v.year, " ", v.make, " ", v.model) as vehicle, 
    v.color, 
    v.price, 
    o.name, 
    o.favoriteColor, 
    o.age 
from vehicles v, owners o where v.owner = o.id;

select 
	v.id,
    CONCAT(v.year, " ", v.make, " ", v.model) as vehicle, 
    v.color, 
    v.price, 
    o.name, 
    o.favoriteColor, 
    o.age 
from vehicles v join owners o on v.owner = o.id WHERE v.id > 3;

# Group By clause is used with aggregates 
select 
	o.name,
    o.age,
    o.favoriteColor,
    SUM(v.id) as car_weight
from vehicles v, owners o where v.owner = o.id GROUP BY o.id;

select 
	o.name,
    o.age,
    o.favoriteColor,
    COUNT(v.id) as cars,
    SUM(v.price) as debt
from vehicles v, owners o where v.owner = o.id GROUP BY o.id;

# having is used in conjunction with group by clauses
# is is basically the where clause for a group by
select 
	o.name,
    o.age,
    o.favoriteColor,
    COUNT(v.id) as cars,
    SUM(v.price) as debt
from vehicles v, owners o where v.owner = o.id GROUP BY o.id HAVING debt > 200000;

# aggregate functions: any function that takes in a value/ set of values and returns a 
# 						scalar
/*
	Some aggregates:
					- AVG
                    - COUNT
					- MAX
                    - MIN
                    - SUM
*/
# scalar: a single numerical value

SELECT * FROM owners;
SELECT * FROM vehicles;

# what is we wanted to check this first?
# we can do that through transactions
# Databases function using the principal of A.C.I.D.
/*
	Atomicity: Your queries either fail completely or succeed completely
    Consistency: The database can only be brought from one valid state to another
    Isolation: When running queries concurrently the end output is the same as running them sequentially
    Durability: Once a transactions is committed it is permenant even in the case of database failure
*/

#Transactions run a set of queries as one unit
# under the hood mysql wraps everything in a transaction unless I specifically tell it not to
START TRANSACTION; #nothing past this point sticks until i tell it to
# you tell transactions to save using commit and tell them to undo using rollback
SELECT * FROM vehicles;
UPDATE vehicles SET owner = 9 WHERE id= 4;
UPDATE vehicles SET owner = 5 WHERE id= 5;
UPDATE vehicles SET owner = 7 WHERE id= 9;
SELECT * FROM vehicles;
#ROLLBACK; # undo what the transaction was trying to do
COMMIT; # saves the transaction and makes it permenant
SELECT * FROM vehicles;
ROLLBACK;