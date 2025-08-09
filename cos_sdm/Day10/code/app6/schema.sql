create table User (
    id integer primary key auto_increment,
    name varchar(50),
    email varchar(50),
    password varchar(100)
);

create table Product(
    id integer primary key auto_increment,
    title varchar(50),
    price float
);

-- insert dummy user
insert into User(name, email, password) values ('user1', 'user1@test.com', 'user1');

-- insert dummy products
insert into Product(title, price) values ('product1', 100), ('product2', 200), ('product3', 300);