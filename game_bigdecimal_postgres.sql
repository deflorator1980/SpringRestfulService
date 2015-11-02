CREATE DATABASE game_bigdecimal_postgres;
\c game_bigdecimal_postgres;

CREATE TABLE sales (
  sale_id  SERIAL PRIMARY KEY,
  gnome_id VARCHAR(45) NOT NULL,
  item_id  VARCHAR(45) NOT NULL,
  quantity INT      NOT NULL
);

CREATE TABLE gnomes (
  gnome_id    VARCHAR(45) NOT NULL,
  gnome_name  VARCHAR(45) NOT NULL,
  gnome_money NUMERIC(20, 2),
  CONSTRAINT gnomes_pkey PRIMARY KEY (gnome_id)
);

CREATE TABLE items (
  item_id    VARCHAR(45) NOT NULL,
  item_name  VARCHAR(45) NOT NULL,
  item_price NUMERIC (20, 2),
  PRIMARY KEY (item_id)
);

ALTER TABLE sales ADD CONSTRAINT fk_sales_gnomes FOREIGN KEY (gnome_id) REFERENCES gnomes (gnome_id);

ALTER TABLE sales ADD CONSTRAINT fk_sales_items FOREIGN KEY (item_id) REFERENCES items (item_id);

INSERT INTO gnomes (gnome_id, gnome_name, gnome_money) VALUES ('001', 'vova', '10');
INSERT INTO gnomes (gnome_id, gnome_name, gnome_money) VALUES ('002', 'dasha', '1');
INSERT INTO gnomes (gnome_id, gnome_name, gnome_money) VALUES ('003', 'yasha', '100');

INSERT INTO items (item_id, item_name, item_price) VALUES ('01', 'sword', 10);
INSERT INTO items (item_id, item_name, item_price) VALUES ('02', 'spear', 4);
INSERT INTO items (item_id, item_name, item_price) VALUES ('03', 'grenade', 2);