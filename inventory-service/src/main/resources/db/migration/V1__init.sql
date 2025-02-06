CREATE TABLE t_inventory
(
    id           BIGINT(20) AUTO_INCREMENT NOT NULL,
    sku_code     VARCHAR(255) NULL,
    quantity     INT(11) NULL,
    CONSTRAINT pk_t_orders PRIMARY KEY (id)
);