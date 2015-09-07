CREATE TABLE `game2`.`gnomes` (
  `gnome_id` VARCHAR(45) NOT NULL COMMENT '',
  `gnome_name` VARCHAR(45) NOT NULL COMMENT '',
  `gnome_money` DECIMAL(8,2) NULL COMMENT '',
  PRIMARY KEY (`gnome_id`)  COMMENT '');

CREATE TABLE `game2`.`items` (
  `item_id` INT NOT NULL COMMENT '',
  `item_name` VARCHAR(45) NOT NULL COMMENT '',
  `item_price` DECIMAL(8,2) NOT NULL COMMENT '',
  PRIMARY KEY (`item_id`)  COMMENT '');

CREATE TABLE `game2`.`sales` (
  `sale_id` VARCHAR(45) NOT NULL COMMENT '',
  `gnome_id` VARCHAR(45) NOT NULL COMMENT '',
  `item_id` VARCHAR(45) NOT NULL COMMENT '',
  `quantity` INT NOT NULL COMMENT '',
  PRIMARY KEY (`sale_id`)  COMMENT '');

INSERT INTO `game2`.`gnomes` (`gnome_id`, `gnome_name`, `gnome_money`) VALUES ('001', 'vova', '23');
INSERT INTO `game2`.`gnomes` (`gnome_id`, `gnome_name`, `gnome_money`) VALUES ('002', 'dasha', '34');
INSERT INTO `game2`.`gnomes` (`gnome_id`, `gnome_name`, `gnome_money`) VALUES ('003', 'yasha', '342');

INSERT INTO `game2`.`items` (`item_id`, `item_name`, `item_price`) VALUES ('01', 'sword', '5');
INSERT INTO `game2`.`items` (`item_id`, `item_name`, `item_price`) VALUES ('02', 'spear', '3');
INSERT INTO `game2`.`items` (`item_id`, `item_name`, `item_price`) VALUES ('03', 'grenade', '1');


INSERT INTO `game2`.`sales` (`sale_id`, `gnome_id`, `item_id`, `quantity`) VALUES ('10', '001', '02', '1');
INSERT INTO `game2`.`sales` (`sale_id`, `gnome_id`, `item_id`, `quantity`) VALUES ('20', '002', '02', '1');
INSERT INTO `game2`.`sales` (`sale_id`, `gnome_id`, `item_id`, `quantity`) VALUES ('30', '002', '03', '4');
INSERT INTO `game2`.`sales` (`sale_id`, `gnome_id`, `item_id`, `quantity`) VALUES ('40', '003', '02', '1');


select gnomes.gnome_name, gnomes.gnome_money, items.item_name, sales.quantity
from gnomes, items, sales
where gnomes.gnome_id = sales.gnome_id and sales.item_id = items.item_id;