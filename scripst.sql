CREATE TABLE `game`.`new_table` (
`gamer_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
`name` VARCHAR(45) NOT NULL COMMENT '',
`money` INT NULL COMMENT '',
PRIMARY KEY (`gamer_id`)  COMMENT '');

CREATE TABLE `game`.`items` (
`item_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
`items` VARCHAR(45) NOT NULL COMMENT '',
`gamer_id` INT NOT NULL COMMENT '',
PRIMARY KEY (`item_id`)  COMMENT '');


ALTER TABLE items ADD CONSTRAINT FK_items_gamers FOREIGN KEY (gamer_id) REFERENCES gamers (gamer_id)