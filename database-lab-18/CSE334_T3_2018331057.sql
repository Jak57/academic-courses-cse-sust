
CREATE TABLE customer (
  c_id INT PRIMARY KEY,
  c_name VARCHAR(30),
  c_city VARCHAR(30)
);

INSERT INTO customer VALUES(150, "Jakir", "Sylhet");
INSERT INTO customer VALUES(160, "Kim", "Dhaka");
INSERT INTO customer VALUES(170, "Lee", "Mymensingh");

SELECT * FROM customer;

CREATE TABLE shop (
  s_id INT PRIMARY KEY,
  s_name VARCHAR(30),
  s_city VARCHAR(30)
);

INSERT INTO shop VALUES(3, "Arong", "Sylhet");
INSERT INTO shop VALUES(4, "Daraz", "Dhaka");

SELECT * FROM shop;


CREATE TABLE product (
  p_id INT PRIMARY KEY,
  p_name VARCHAR(30),
  p_price FLOAT,
  p_rating FLOAT
);

INSERT INTO product VALUES(6, "Mangoo", 9, 3.6);
INSERT INTO product VALUES(7, "Banana", 20, 3.3);
INSERT INTO product VALUES(8, "Guava", 7, 3.9);

SELECT * FROM product;

CREATE TABLE p_order (
  o_id INT PRIMARY KEY,
  c_id INT,
  s_id INT,
  p_id INT,
  FOREIGN KEY (c_id) REFERENCES customer(c_id),
  FOREIGN KEY (s_id) REFERENCES shop(s_id),
  FOREIGN KEY (p_id) REFERENCES product(p_id)
);

INSERT INTO p_order VALUES(30, 150, 3, 6);
INSERT INTO p_order VALUES(31, 150, 4, 7);
INSERT INTO p_order VALUES(32, 160, 4, 7);
INSERT INTO p_order VALUES(33, 150, 3, 8);
INSERT INTO p_order VALUES(34, 150, 4, 6);

SELECT * FROM p_order;

CREATE TABLE availability (
  s_id INT,
  p_id INT,
  FOREIGN KEY (s_id) REFERENCES shop(s_id),
  FOREIGN KEY (p_id) REFERENCES product(p_id)
);

INSERT INTO availability VALUES(3, 6);
INSERT INTO availability VALUES(3, 7);
INSERT INTO availability VALUES(4, 6);
INSERT INTO availability VALUES(4, 8);

SELECT * FROM availability;


-- a

SELECT DISTINCT product.p_id 
FROM product, p_order
WHERE c_id = 150 AND p_rating > 3.5;


-- b

SELECT o_id
FROM product, p_order
WHERE product.p_id = p_order.p_id AND p_price < 10;

-- c 

SELECT s_name
FROM customer, shop
WHERE c_city = s_city AND c_id = 150;

-- d

SELECT c_name 
FROM customer
WHERE c_id NOT IN (
  SELECT DISTINCT customer.c_id 
  FROM customer, p_order
  WHERE customer.c_id = p_order.c_id
);

-- e 

SELECT p_id, p_name 
FROM product 
WHERE p_id NOT IN (
  SELECT t1.p_id FROM (
  SELECT * 
    FROM (
      SELECT * 
      FROM (SELECT s_id FROM shop) AS sh, (SELECT p_id FROM product) AS pr
    ) AS t
    WHERE (t.s_id, t.p_id) NOT IN (
      (SELECT * FROM availability)
    )
  ) AS t1
);


-- f 

SELECT C.c_id
FROM customer AS C
WHERE C.c_id IN (
  SELECT c_id FROM p_order
);
