-- Create database
CREATE DATABASE product_db;

-- Use the database
USE product_db;

-- Create products table
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(100),
    price int,
    category VARCHAR(100)
);

-- Insert dummy data
INSERT INTO products (name, description, price, category) VALUES
('Laptop', 'Dell Inspiron 15', 55000, 'Electronics'),
('Smartphone', 'Samsung Galaxy M14', 13500, 'Electronics'),
('Shoes', 'Nike Running Shoes', 4500, 'Footwear'),
('Book', 'JavaScript: The Good Parts', 800, 'Books');
