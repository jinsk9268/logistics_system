CREATE TABLE logistics_admin (
    code VARCHAR(30) PRIMARY KEY ,
    id VARCHAR(30) NOT NULL UNIQUE ,
    password VARCHAR(100) NOT NULL ,
    name VARCHAR(30) NOT NULL ,
    mobile VARCHAR(30) NOT NULL ,
    created_at DATETIME NOT NULL ,
    modified_at DATETIME
);

CREATE TABLE agency (
    code VARCHAR(30) PRIMARY KEY ,
    password VARCHAR(100) NOT NULL ,
    agency_name VARCHAR(30) NOT NULL ,
    email VARCHAR(50) NOT NULL ,
    ceo_name VARCHAR(30) NOT NULL ,
    business_number VARCHAR(30) NOT NULL ,
    contact VARCHAR(30) NOT NULL ,
    shipping_address VARCHAR(1000) NOT NULL ,
    credit_limit BIGINT NOT NULL DEFAULT 0,
    created_at DATETIME NOT NULL ,
    modified_at DATETIME
);

CREATE TABLE agency_credit_transaction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    agency_code VARCHAR(30) NOT NULL,
    credit_change BIGINT NOT NULL ,
    notes VARCHAR(3000) ,
    created_at DATETIME NOT NULL ,
    modified_at DATETIME,

    FOREIGN KEY (agency_code) REFERENCES agency (code)
);

CREATE TABLE product (
    code VARCHAR(30) PRIMARY KEY ,
    name VARCHAR(30) NOT NULL ,
    supply_price INT NOT NULL ,
    vat FLOAT NOT NULL ,
    box_quantity INT NOT NULL ,
    description VARCHAR(3000) ,
    manufacturer VARCHAR(30) ,
    created_at DATETIME NOT NULL ,
    modified_at DATETIME
);

CREATE TABLE product_stock (
    product_code VARCHAR(30) PRIMARY KEY ,
    quantity INT NOT NULL ,
    created_at DATETIME NOT NULL ,
    modified_at DATETIME ,

    FOREIGN KEY (product_code) REFERENCES product (code)
);

CREATE TABLE product_stock_transaction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_code VARCHAR(30) NOT NULL ,
    stock_change VARCHAR(30) NOT NULL ,
    notes VARCHAR(3000) ,
    quantity INT NOT NULL ,
    created_at DATETIME NOT NULL ,
    modified_at DATETIME ,

    FOREIGN KEY (product_code) REFERENCES product (code)
);

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    agency_code VARCHAR(30) NOT NULL ,
    order_date DATE NOT NULL ,
    shipping_date DATE NOT NULL ,
    order_status VARCHAR(30) NOT NULL DEFAULT 'PENDING' ,
    total_quantity INT NOT NULL ,
    total_supply_price BIGINT NOT NULL ,
    total_vat FLOAT NOT NULL ,
    total_amount BIGINT NOT NULL ,
    notes VARCHAR(3000) ,
    created_at DATETIME NOT NULL ,
    modified_at DATETIME ,

    FOREIGN KEY (agency_code) REFERENCES agency (code)
);

CREATE TABLE order_detail (
    order_id BIGINT ,
    product_code VARCHAR(30) ,
    quantity INT NOT NULL ,
    product_supply_price BIGINT NOT NULL ,
    product_vat FLOAT NOT NULL ,
    product_total_amount BIGINT NOT NULL ,
    created_at DATETIME NOT NULL ,
    modified_at DATETIME ,

    PRIMARY KEY (order_id, product_code) ,
    FOREIGN KEY (order_id) REFERENCES orders (id) ,
    FOREIGN KEY (product_code) REFERENCES product (code)
);

CREATE TABLE shipping (
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    order_id BIGINT NOT NULL ,
    shipping_complete_date DATE NOT NULL ,
    total_quantity INT NOT NULL ,
    total_supply_price BIGINT NOT NULL ,
    total_vat FLOAT NOT NULL ,
    total_amount BIGINT NOT NULL ,
    notes VARCHAR(3000) ,
    created_at DATETIME NOT NULL ,
    modified_at DATETIME ,

    FOREIGN KEY (order_id) REFERENCES orders (id)
);

CREATE TABLE shipping_detail (
    shipping_id BIGINT ,
    product_code VARCHAR(30) ,
    quantity INT NOT NULL ,
    product_supply_price BIGINT NOT NULL ,
    product_vat FLOAT NOT NULL ,
    product_total_amount BIGINT NOT NULL ,
    created_at DATETIME NOT NULL ,
    modified_at DATETIME ,

    PRIMARY KEY (shipping_id, product_code) ,
    FOREIGN KEY (shipping_id) REFERENCES shipping (id) ,
    FOREIGN KEY (product_code) REFERENCES product (code)
);
