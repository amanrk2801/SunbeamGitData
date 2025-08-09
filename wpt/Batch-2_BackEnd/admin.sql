CREATE DATABASE LabExam;
USE LabExam;

CREATE TABLE admin(
    id INT PRIMARY KEY  auto_increment,
    Name VARCHAR(40),
    email VARCHAR(40),
    password VARCHAR(100),
    phone varchar(20)
);

