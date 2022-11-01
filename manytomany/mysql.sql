CREATE TABLE `product` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(128) NOT NULL UNIQUE,
    `count` INT NOT NULL,
    `price` DOUBLE NOT NULL
);

CREATE TABLE `order` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `receiver` VARCHAR(128) NOT NULL,
    `address` VARCHAR(255) NOT NULL,
    `create_time` TIMESTAMP NOT NULL
);

CREATE TABLE `order_product` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `order_id` INT NOT NULL,
    `product_id` INT NOT NULL,
    CONSTRAINT `uid_order_product_id` UNIQUE(`order_id`, `product_id`),
    CONSTRAINT `fk_order_product_order_id` FOREIGN KEY(`order_id`) REFERENCES `order`(`id`),
    CONSTRAINT `fk_order_product_product_id` FOREIGN KEY(`product_id`) REFERENCES `product`(`id`)
);