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