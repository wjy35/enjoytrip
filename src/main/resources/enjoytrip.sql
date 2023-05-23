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
-- Table `enjoytrip`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`board` (
  `board_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NULL DEFAULT NULL,
  `current_update` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `subject` VARCHAR(100) NOT NULL,
  `content` VARCHAR(3000) NOT NULL,
  `hit` INT NULL DEFAULT '0',
  `type` ENUM('notice', 'community') NULL DEFAULT 'notice',
  PRIMARY KEY (`board_id`),
  INDEX `user_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `board_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`comment` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `board_id` INT NOT NULL,
  `current_update` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`),
  INDEX `comment_board_fk_idx` (`board_id` ASC) VISIBLE,
  CONSTRAINT `comment_board_fk`
    FOREIGN KEY (`board_id`)
    REFERENCES `enjoytrip`.`board` (`board_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enjoytrip`.`file_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`file_info` (
                                                     `file_info_id` INT NOT NULL AUTO_INCREMENT,
                                                     `board_id` INT NOT NULL,
                                                     `file_url` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`file_info_id`),
  INDEX `board_id_idx` (`board_id` ASC) VISIBLE,
  CONSTRAINT `board_id_fk`
  FOREIGN KEY (`board_id`)
  REFERENCES `enjoytrip`.`board` (`board_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

