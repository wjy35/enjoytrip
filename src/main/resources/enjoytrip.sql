drop database enjoytrip;
create database enjoytrip;
use enjoytrip;

CREATE SCHEMA IF NOT EXISTS `enjoytrip` DEFAULT CHARACTER SET utf8mb3 ;
USE `enjoytrip` ;

-- -----------------------------------------------------
-- Table `enjoytrip`.`authority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`authority` (
  `authority_id` INT NOT NULL COMMENT '1 : 기본 유저',
  PRIMARY KEY (`authority_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`user` (
  `user_id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(10) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `authority` INT NULL DEFAULT '1',
  `salt` VARCHAR(200) NULL DEFAULT NULL,
  `token` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`community`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`community` (
  `community_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NOT NULL,
  `regist_time` DATETIME default now(),
  `subject` VARCHAR(100) NOT NULL,
  `content` VARCHAR(3000) NOT NULL,
  `hit` INT NULL DEFAULT '0',
  PRIMARY KEY (`community_id`, `user_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id_board`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

insert into user(user_id,name,address,password,email) value ('ssafy','ssafy','ssafy','ssafy','ssafy@ssafy');
insert into community(user_id,subject,content) value ('ssafy','ssafy','ssafy');

select * from community;

