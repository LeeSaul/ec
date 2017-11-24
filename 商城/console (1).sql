CREATE TABLE customer
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(255) NOT NULL,
    customer_password VARCHAR(255) NOT NULL,
    customer_phone VARCHAR(255),
    customer_email VARCHAR(255),
    customer_money DECIMAL(10,2) DEFAULT '0.00',
    customer_create_time DATETIME,
    login_time TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
    customer_status VARCHAR(50)
);
CREATE TABLE admin
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    admin_name VARCHAR(255) NOT NULL,
    admin_password VARCHAR(255) NOT NULL,
    admin_state VARCHAR(255) DEFAULT 'normal',
    admin_money DECIMAL(10,2) DEFAULT '0.00',
    admin_last_time TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL
);
CREATE TABLE product
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    product_name VARCHAR(255) NOT NULL,
    product_price DECIMAL(10,2) DEFAULT '0.00',
    product_type VARCHAR(255),
    product_create_time DATETIME
);
CREATE TABLE product_detail
(
    id INT(11) PRIMARY KEY NOT NULL,
    product_id INT(11) NOT NULL,
    small_image VARCHAR(255),
    big_image VARCHAR(255),
    product_caption VARCHAR(255),
    CONSTRAINT product_detail_product_fk FOREIGN KEY (product_id) REFERENCES product (id)
);
CREATE INDEX product_detail_product_fk ON product_detail (product_id);
CREATE TABLE stock
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    product_id INT(11) NOT NULL,
    admin_id INT(11) NOT NULL,
    stock_number INT(11),
    stock_update_time TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
    CONSTRAINT stock_admin_id_fk FOREIGN KEY (admin_id) REFERENCES admin (id),
    CONSTRAINT stock_product_id_fk FOREIGN KEY (product_id) REFERENCES product (id)
);
CREATE INDEX stock_admin_id_fk ON stock (admin_id);
CREATE INDEX stock_product_id_fk ON stock (product_id);
CREATE TABLE inner_stock
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    product_id INT(11) NOT NULL,
    admin_id INT(11) NOT NULL,
    inner_stock_number INT(11),
    inner_time DATETIME,
    CONSTRAINT inner_stock_admin_id_fk FOREIGN KEY (admin_id) REFERENCES admin (id),
    CONSTRAINT inner_stock_product_id_fk FOREIGN KEY (product_id) REFERENCES product (id)
);
CREATE INDEX inner_stock_admin_id_fk ON inner_stock (admin_id);
CREATE INDEX inner_stock_product_id_fk ON inner_stock (product_id);
CREATE TABLE out_stock
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    product_id INT(11) NOT NULL,
    admin_id INT(11) NOT NULL,
    out_stock_time INT(11),
    out_time DATETIME,
    CONSTRAINT out_stock_admin_id_fk FOREIGN KEY (admin_id) REFERENCES admin (id),
    CONSTRAINT out_stock_product_id_fk FOREIGN KEY (product_id) REFERENCES product (id)
);
CREATE INDEX out_stock_admin_id_fk ON out_stock (admin_id);
CREATE INDEX out_stock_product_id_fk ON out_stock (product_id);
CREATE TABLE shelf
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    product_id INT(11) NOT NULL,
    admin_id INT(11) NOT NULL,
    shelf_create_time DATETIME,
    shelf_status VARCHAR(255),
    CONSTRAINT shelf_admin_id_fk FOREIGN KEY (admin_id) REFERENCES admin (id),
    CONSTRAINT shelf_product_id_fk FOREIGN KEY (product_id) REFERENCES product (id)
);
CREATE INDEX shelf_admin_id_fk ON shelf (admin_id);
CREATE INDEX shelf_product_id_fk ON shelf (product_id);
CREATE TABLE address
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    customer_id INT(11) NOT NULL,
    province VARCHAR(255),
    city VARCHAR(255),
    county VARCHAR(255),
    road VARCHAR(255),
    address_create_time TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
    address_status VARCHAR(255),
    CONSTRAINT address_customer_id_fk FOREIGN KEY (customer_id) REFERENCES customer (id)
);
CREATE INDEX address_customer_id_fk ON address (customer_id);
CREATE TABLE shopcart
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    customer_id INT(11) NOT NULL,
    product_id INT(11) NOT NULL,
    product_cart_count INT(11),
    create_cart_time DATETIME,
    CONSTRAINT shopcart_customer_id_fk FOREIGN KEY (customer_id) REFERENCES customer (id),
    CONSTRAINT shopcart_product_id_fk FOREIGN KEY (product_id) REFERENCES product (id)
);
CREATE INDEX shopcart_customer_id_fk ON shopcart (customer_id);
CREATE INDEX shopcart_product_id_fk ON shopcart (product_id);
CREATE TABLE order_list
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    customer_id INT(11) NOT NULL,
    address_id INT(11) NOT NULL,
    total_money DECIMAL(10,2) DEFAULT '0.00',
    order_status VARCHAR(255) DEFAULT 'not_pay' NOT NULL,
    order_create_time DATETIME,
    CONSTRAINT order_list_address_id_fk FOREIGN KEY (address_id) REFERENCES address (id),
    CONSTRAINT order_list_customer_id_fk FOREIGN KEY (customer_id) REFERENCES customer (id)
);
CREATE INDEX order_list_address_id_fk ON order_list (address_id);
CREATE INDEX order_list_customer_id_fk ON order_list (customer_id);
CREATE TABLE order_item
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    order_list_id INT(11) NOT NULL,
    product_id INT(11) NOT NULL,
    product_count INT(11),
    item_create_time DATETIME,
    item_order_status VARCHAR(255),
    CONSTRAINT order_item_order_list_id_fk FOREIGN KEY (order_list_id) REFERENCES order_list (id),
    CONSTRAINT order_item_product_id_fk FOREIGN KEY (product_id) REFERENCES product (id)
);
CREATE INDEX order_item_order_list_id_fk ON order_item (order_list_id);
CREATE INDEX order_item_product_id_fk ON order_item (product_id);




insert into admin(admin_name, admin_password)
    VALUES ('xiaohuang','123456');