-- customer table for sqlite

CREATE TABLE customer(
id integer, -- rowid autoincrement
firstname varchar(20) not null,
lastname varchar(40) not null,
birthyear int,
sex char(1),
streetaddress varchar(30),
postcode char(5),
email varchar(50), 
bonusscore decimal(3,1),
primary key(id)
);

-- more tables