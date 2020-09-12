--CREATE TABLE 'users' (
--  'user_id' int(11) NOT NULL AUTO_INCREMENT,
--  'username' varchar(45) NOT NULL,
--  'password' varchar(64) NOT NULL,
--  'role' varchar(45) NOT NULL,
--  'enabled' int(4) DEFAULT NULL,
--  PRIMARY KEY ('user_id')
--);

CREATE TABLE `user-security-data`.`users` ( `user_id` INT(11) NOT NULL AUTO_INCREMENT , `username` VARCHAR(45) NOT NULL , `password` VARCHAR(64) NOT NULL , `role` VARCHAR(45) NOT NULL , `enabled` TINYINT(4) NULL DEFAULT NULL , PRIMARY KEY (`user_id`)) ENGINE = InnoDB;