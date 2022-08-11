DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS product_categories;
DROP TABLE IF EXISTS suppliers;

CREATE TABLE products
(
    id integer not null,
    product_name  varchar not null,
    price integer not null,
    product_category_id integer not null,
    supplier_id integer not null
);

CREATE TABLE product_categories
(
    id            integer not null,
    category_name varchar not null
);

CREATE TABLE suppliers
(
    id integer not null,
    supplier_name  varchar not null
);

ALTER TABLE products ADD PRIMARY KEY (id);
ALTER TABLE product_categories ADD PRIMARY KEY (id);
ALTER TABLE suppliers ADD PRIMARY KEY (id);

ALTER TABLE products
    ADD CONSTRAINT product_category_fk
    FOREIGN KEY (product_category_id)
    REFERENCES product_categories(id);

ALTER TABLE products
    ADD CONSTRAINT supplier_id_fk
    FOREIGN KEY (supplier_id)
    REFERENCES suppliers(id);