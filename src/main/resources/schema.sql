-- Create table for products
CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255),
                         price DOUBLE PRECISION
);
INSERT INTO product (name, price) VALUES
                                      ('Product 1', 10.0),
                                      ('Product 2', 20.0),
                                      ('Product 3', 30.0),
                                      ('Product 4', 40.0),
                                      ('Product 5', 50.0);
-- Create table for customers
CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          address VARCHAR(255) NOT NULL
);
-- Insert sample data into the customer table
INSERT INTO customer (name, email, address) VALUES
                                                ('Customer 1', 'customer1@example.com', 'Address 1'),
                                                ('Customer 2', 'customer2@example.com', 'Address 2'),
                                                ('Customer 3', 'customer3@example.com', 'Address 3'),
                                                ('Customer 4', 'customer4@example.com', 'Address 4'),
                                                ('Customer 5', 'customer5@example.com', 'Address 5');
-- Create table for orders
CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        customer_id INTEGER REFERENCES customer(id)
);
-- Insert sample data into the orders table
INSERT INTO orders (customer_id) VALUES
                                     (1),
                                     (2),
                                     (3),
                                     (4),
                                     (5);
-- Create table for the many-to-many relationship between products and orders
CREATE TABLE order_product (
                               order_id INTEGER REFERENCES orders(id) ON DELETE CASCADE,
                               product_id INTEGER REFERENCES product(id) ON DELETE CASCADE,
                               PRIMARY KEY (order_id, product_id)
);
INSERT INTO order_product (order_id, product_id) VALUES
                                                     (1, 1),
                                                     (1, 2),
                                                     (2, 3),
                                                     (3, 4),
                                                     (4, 5);
