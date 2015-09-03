---------------------------------------------------------------------------------id CHAR!!!!!

CREATE TABLE `game`.`gamers` (
`gamer_id` INT NOT NULL,
`name` VARCHAR(45) NOT NULL COMMENT '',
`money` INT NULL COMMENT '',
PRIMARY KEY (`gamer_id`)  COMMENT '');

CREATE TABLE `game`.`tools` (
`item_id` INT NOT NULL,
`items` VARCHAR(45) NOT NULL COMMENT '',
`gamer_id` INT NOT NULL COMMENT '',
PRIMARY KEY (`item_id`)  COMMENT '');


CREATE TABLE `game`.`sales` (
`sale_id` INT NOT NULL COMMENT '',
`item_id` INT NOT NULL COMMENT '',
`gamer_id` INT NOT NULL COMMENT '',
PRIMARY KEY (`sale_id`)  COMMENT '');

alter table sales add constraint fk_sales_tools foreign key (item_id) references tools (item_id)

alter table sales add constraint fk_sales_gamers foreign key (gamer_id) references gamers (gamer_id)

INSERT INTO `game`.`gamers` (`gamer_id`, `name`, `money`) VALUES ('1', 'hui', '34');
INSERT INTO `game`.`gamers` (`gamer_id`, `name`, `money`) VALUES ('2', 'pisda', '324');
INSERT INTO `game`.`gamers` (`gamer_id`, `name`, `money`) VALUES ('3', 'blyad', '33');


