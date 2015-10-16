create database game;
use database game;

create table sales (sale_id int not null auto_increment, gnome_id varchar(45) not null,
 item_id varchar(45) not null, quantity int not null, primary key (sale_id));

create table gnomes (gnome_id varchar(45) not null,
  gnome_name varchar(45) not null, gnome_money int, primary key (gnome_id));

create table items (item_id varchar(45) not null,
  item_name varchar(45) not null, item_price int not null, primary key(item_id));

alter table sales add constraint fk_sales_gnomes foreign key (gnome_id) references gnomes (gnome_id);

alter table sales add constraint fk_sales_items foreign key (item_id) references items (item_id);

insert into gnomes (gnome_id, gnome_name, gnome_money) values ('001', 'vova', '10');
insert into gnomes (gnome_id, gnome_name, gnome_money) values ('002', 'dasha', '1');
insert into gnomes (gnome_id, gnome_name, gnome_money) values ('003', 'yasha', '100');

insert into items (item_id, item_name, item_price) values ('01', 'sword', 10);
insert into items (item_id, item_name, item_price) values ('02', 'spear', 6);
insert into items (item_id, item_name, item_price) values ('03', 'grenade', 2);