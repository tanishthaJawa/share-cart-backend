INSERT INTO users (user_id, user_name, contact_no, email, address) VALUES
(1, 'John Doe', '1234567890', 'john.doe@example.com', '123 Main St, Anytown, USA'),
(2, 'Jane Smith', '0987654321', 'jane.smith@example.com', '456 Elm St, Othertown, USA');

-- Insert data into guest_user table
INSERT INTO guest_user (guest_id, contact_no, email, primary_account_holder) VALUES
(1, '1112223333', 'guest1@example.com', 1),
(2, '4445556666', 'guest2@example.com', 2);

-- Insert data into products table
INSERT INTO products (product_id, product_name, product_category, product_qty, product_price) VALUES
(1, 'Laptop', 'Electronics', 10, 999.99),
(2, 'Smartphone', 'Electronics', 20, 499.99),
(3, 'Tablet', 'Electronics', 15, 299.99);

-- Insert data into cart table
INSERT INTO cart (cart_id, user_id, price) VALUES
(1, 1, 1499.98),
(2, 2, 499.99);

-- Insert data into cart_details table
INSERT INTO cart_details (cart_details_id, cart_id, product_id, product_qty) VALUES
(1, 1, 1, 1),
(2, 1, 2, 1),
(3, 2, 2, 1);