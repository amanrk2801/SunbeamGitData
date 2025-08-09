DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS product;

CREATE TABLE user(
    id INT,
    name VARCHAR(20),
    age INT
);

CREATE TABLE product(
    pid INT,
    name VARCHAR(20),
    price INT
);

INSERT INTO user VALUES
(1,"Anil",30),
(2,"Mukesh",32),
(3,"Ramesh",35),
(4,"Suresh",40),
(5,"Ram",45);

INSERT INTO product VALUES
(1,"Pen",10),
(2,"Pencil",5),
(3,"Book",35),
(4,"Eraser",4),
(5,"Sharpner",15);