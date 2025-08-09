create database car_showroom;
use car_showroom;

CREATE TABLE car (
    id INT PRIMARY KEY auto_increment,
    name VARCHAR(40),
    model VARCHAR(40),
    price INT,
    carColor VARCHAR(10),
    fuel_type varchar(20),
    image VARCHAR(200)
);


