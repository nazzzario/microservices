CREATE TABLE t_orders
(
    id           BIGINT(20) AUTO_INCREMENT NOT NULL,
    order_number VARCHAR(255) NULL,
    sku_code     VARCHAR(255) NULL,
    price        DECIMAL(19, 2) NULL,
    quantity     INT(11) NULL,
    CONSTRAINT pk_t_orders PRIMARY KEY (id)
);