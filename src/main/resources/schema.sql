-- Create table for products
CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255),
                         price DOUBLE PRECISION,
                         createdAt TIMESTAMP,
                        updatedAt TIMESTAMP

);
INSERT INTO product (name, price, createdAt, updatedAt) VALUES
                                                              ('Dell XPS 13 Laptop', 1499.99, NOW(), NOW()),
                                                              ('iPhone 13 Pro', 1099.99, NOW(), NOW()),
                                                              ('Sony WH-1000XM4 Headphones', 349.99, NOW(),NULL),
                                                              ('Canon EOS R5 Camera', 3899.99, NOW(), NOW()),
                                                              ('iPad Air', 599.99, NOW(), NOW()),
                                                              ('Fitbit Charge 5 Fitness Tracker', 179.99, NOW(), NOW()),
                                                              ('Sonos Move Wireless Speaker', 399.99, NOW(), NOW()),
                                                              ('Samsung T7 Portable SSD 1TB', 159.99, NOW(), NOW()),
                                                              ('LG UltraGear 27GN950-B Monitor', 899.99, NOW(), NOW()),
                                                              ('HP OfficeJet Pro 9025e Printer', 329.99, NOW(), NOW()),
                                                              ('Sony A8F BRAVIA OLED TV', 2499.99, NOW(), NOW()),
                                                              ('Bose SoundLink Micro Bluetooth Speaker', 99.99, NOW(),NULL),
                                                              ('Garmin Fenix 7X Sapphire', 899.99, NOW(), NOW()),
                                                              ('Microsoft Surface Pro 8', 999.99, NOW(), NOW()),
                                                              ('Nikon Z9 Mirrorless Camera', 5499.99, NOW(), NOW()),
                                                              ('Samsung Galaxy Tab S8', 749.99, NOW(), NOW()),
                                                              ('Razer Blade 15 Gaming Laptop', 1999.99, NOW(), NOW()),
                                                              ('Apple Watch Series 7', 399.99, NOW(), NOW()),
                                                              ('DJI Mavic 3 Drone', 2199.99, NOW(), NOW()),
                                                              ('Alienware AW3420DW Curved Monitor', 1099.99, NOW(), NOW());

-- Create table for customers
CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          address VARCHAR(255) NOT NULL
);
-- Insert sample data into the customer table
INSERT INTO customer (name, email, address) VALUES
                                                ('Alice Brown', 'alice@example.com', '123 Main St, Anytown, USA'),
                                                ('Bob Smith', 'bob@example.com', '456 Elm St, Anytown, USA'),
                                                ('Charlie Davis', 'charlie@example.com', '789 Oak St, Anytown, USA'),
                                                ('David Lee', 'david@example.com', '101 Pine St, Anytown, USA'),
                                                ('Eve Wilson', 'eve@example.com', '111 Cedar St, Anytown, USA'),
                                                ('Frank White', 'frank@example.com', '222 Maple St, Anytown, USA'),
                                                ('Grace Young', 'grace@example.com', '333 Birch St, Anytown, USA'),
                                                ('Hannah Patel', 'hannah@example.com', '444 Walnut St, Anytown, USA'),
                                                ('Ian Kumar', 'ian@example.com', '555 Cherry St, Anytown, USA'),
                                                ('Julia Kim', 'julia@example.com', '666 Willow St, Anytown, USA'),
                                                ('Kevin Johnson', 'kevin@example.com', '777 Oak St, Anytown, USA'),
                                                ('Lily Chang', 'lily@example.com', '888 Pine St, Anytown, USA'),
                                                ('Mike Anderson', 'mike@example.com', '999 Cedar St, Anytown, USA'),
                                                ('Nancy Wilson', 'nancy@example.com', '000 Maple St, Anytown, USA'),
                                                ('Oliver Taylor', 'oliver@example.com', '123 Birch St, Anytown, USA'),
                                                ('Patricia Brown', 'patricia@example.com', '456 Walnut St, Anytown, USA'),
                                                ('Quinn Davis', 'quinn@example.com', '789 Cherry St, Anytown, USA'),
                                                ('Rachel Patel', 'rachel@example.com', '101 Willow St, Anytown, USA'),
                                                ('Samuel Lee', 'samuel@example.com', '111 Oak St, Anytown, USA'),
                                                ('Tina Kumar', 'tina@example.com', '222 Pine St, Anytown, USA');
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
                                     (5),
                                     (6),
                                     (7),
                                     (8),
                                     (9),
                                     (10),
                                     (11),
                                     (12),
                                     (13),
                                     (14),
                                     (15),
                                     (16),
                                     (17),
                                     (18),
                                     (19),
                                     (20);
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
                                                     (2, 4),
                                                     (3, 5),
                                                     (3, 6),
                                                     (4, 7),
                                                     (4, 8),
                                                     (5, 9),
                                                     (5, 10),
                                                     (6, 11),
                                                     (6, 12),
                                                     (7, 13),
                                                     (7, 14),
                                                     (8, 15),
                                                     (8, 16),
                                                     (9, 17),
                                                     (9, 18),
                                                     (10, 19),
                                                     (10, 20);
