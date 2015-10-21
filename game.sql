CREATE DATABASE game;
USE  game;

CREATE TABLE sales (
  sale_id  INT         NOT NULL AUTO_INCREMENT,
  gnome_id VARCHAR(45) NOT NULL,
  item_id  VARCHAR(45) NOT NULL,
  quantity INT         NOT NULL,
  PRIMARY KEY (sale_id)
);

CREATE TABLE gnomes (
  gnome_id    VARCHAR(45) NOT NULL,
  gnome_name  VARCHAR(45) NOT NULL,
  gnome_money INT,
  PRIMARY KEY (gnome_id)
);

CREATE TABLE items (
  item_id    VARCHAR(45) NOT NULL,
  item_name  VARCHAR(45) NOT NULL,
  item_price INT         NOT NULL,
  PRIMARY KEY (item_id)
);

ALTER TABLE sales ADD CONSTRAINT fk_sales_gnomes FOREIGN KEY (gnome_id) REFERENCES gnomes (gnome_id);

ALTER TABLE sales ADD CONSTRAINT fk_sales_items FOREIGN KEY (item_id) REFERENCES items (item_id);

INSERT INTO gnomes (gnome_id, gnome_name, gnome_money) VALUES ('001', 'vova', '10');
INSERT INTO gnomes (gnome_id, gnome_name, gnome_money) VALUES ('002', 'dasha', '1');
INSERT INTO gnomes (gnome_id, gnome_name, gnome_money) VALUES ('003', 'yasha', '100');

INSERT INTO items (item_id, item_name, item_price) VALUES ('01', 'sword', 10);
INSERT INTO items (item_id, item_name, item_price) VALUES ('02', 'spear', 6);
INSERT INTO items (item_id, item_name, item_price) VALUES ('03', 'grenade', 2);