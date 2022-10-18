-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema portfolio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema portfolio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `portfolio` DEFAULT CHARACTER SET utf8 ;
USE `portfolio` ;

-- -----------------------------------------------------
-- Table `portfolio`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`User` (
  `userId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `position` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  `bannerSrc` TEXT(1000) NULL,
  `profileImageSrc` TEXT(1000) NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Interests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Interests` (
  `interestId` INT NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `label` VARCHAR(45) NOT NULL,
  `User_userId` INT NOT NULL,
  PRIMARY KEY (`interestId`, `User_userId`),
  INDEX `fk_Interests_User_idx` (`User_userId` ASC) VISIBLE,
  CONSTRAINT `fk_Interests_User`
    FOREIGN KEY (`User_userId`)
    REFERENCES `portfolio`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`SkillTypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`SkillTypes` (
  `SkillTypeId` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`SkillTypeId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Skills` (
  `skillId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `value` TINYINT(100) NOT NULL,
  `User_userId` INT NOT NULL,
  `SkillTypeId` INT NOT NULL,
  PRIMARY KEY (`skillId`, `User_userId`, `SkillTypeId`),
  INDEX `fk_Skills_User1_idx` (`User_userId` ASC) VISIBLE,
  INDEX `fk_Skills_SkillTypes1_idx` (`SkillTypeId` ASC) VISIBLE,
  CONSTRAINT `fk_Skills_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `portfolio`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Skills_SkillTypes1`
    FOREIGN KEY (`SkillTypeId`)
    REFERENCES `portfolio`.`SkillTypes` (`SkillTypeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Institutions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Institutions` (
  `institutionId` INT NOT NULL,
  `name` VARCHAR(90) NOT NULL,
  `logo` TEXT(1000) NULL,
  PRIMARY KEY (`institutionId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Education`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Education` (
  `educationId` INT NOT NULL,
  `degree` VARCHAR(45) NOT NULL,
  `startDateYear` VARCHAR(5) NOT NULL,
  `endDateYear` VARCHAR(5) NULL,
  `User_userId` INT NOT NULL,
  `institutionId` INT NOT NULL,
  PRIMARY KEY (`educationId`, `User_userId`, `institutionId`),
  INDEX `fk_Education_User1_idx` (`User_userId` ASC) VISIBLE,
  INDEX `fk_Education_Institutions1_idx` (`institutionId` ASC) VISIBLE,
  CONSTRAINT `fk_Education_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `portfolio`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Education_Institutions1`
    FOREIGN KEY (`institutionId`)
    REFERENCES `portfolio`.`Institutions` (`institutionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`ProfessionalExperience`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`ProfessionalExperience` (
  `professionalExpId` INT NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NULL,
  `description` VARCHAR(255) NULL,
  `User_userId` INT NOT NULL,
  PRIMARY KEY (`professionalExpId`, `User_userId`),
  INDEX `fk_ProfessionalExperience_User1_idx` (`User_userId` ASC) VISIBLE,
  CONSTRAINT `fk_ProfessionalExperience_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `portfolio`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Idioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Idioms` (
  `idiomId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `value` VARCHAR(1) NOT NULL,
  `User_userId` INT NOT NULL,
  PRIMARY KEY (`idiomId`, `User_userId`),
  INDEX `fk_Idioms_User1_idx` (`User_userId` ASC) VISIBLE,
  CONSTRAINT `fk_Idioms_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `portfolio`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Reference`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Reference` (
  `referenceId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `position` VARCHAR(45) NULL,
  `User_userId` INT NOT NULL,
  PRIMARY KEY (`referenceId`, `User_userId`),
  INDEX `fk_Reference_User1_idx` (`User_userId` ASC) VISIBLE,
  CONSTRAINT `fk_Reference_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `portfolio`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Projects` (
  `projectId` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `short` VARCHAR(255) NULL,
  `imageSrc` TEXT(1000) NULL,
  `projectLink` TEXT(1000) NULL,
  `User_userId` INT NOT NULL,
  PRIMARY KEY (`projectId`, `User_userId`),
  INDEX `fk_Projects_User1_idx` (`User_userId` ASC) VISIBLE,
  CONSTRAINT `fk_Projects_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `portfolio`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`SoftwareValues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`SoftwareValues` (
  `softwareValueId` INT NOT NULL,
  `value` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`softwareValueId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Softwares`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Softwares` (
  `softwareId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `User_userId` INT NOT NULL,
  `softwareValueId` INT NOT NULL,
  PRIMARY KEY (`softwareId`, `User_userId`, `softwareValueId`),
  INDEX `fk_Softwares_User1_idx` (`User_userId` ASC) VISIBLE,
  INDEX `fk_Softwares_SoftwareValues1_idx` (`softwareValueId` ASC) VISIBLE,
  CONSTRAINT `fk_Softwares_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `portfolio`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Softwares_SoftwareValues1`
    FOREIGN KEY (`softwareValueId`)
    REFERENCES `portfolio`.`SoftwareValues` (`softwareValueId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`ContactIcons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`ContactIcons` (
  `contactIconId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`contactIconId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Contact` (
  `contactId` INT NOT NULL,
  `data` VARCHAR(90) NOT NULL,
  `User_userId` INT NOT NULL,
  `contactIconId` INT NOT NULL,
  PRIMARY KEY (`contactId`, `User_userId`, `contactIconId`),
  INDEX `fk_Contact_User1_idx` (`User_userId` ASC) VISIBLE,
  INDEX `fk_Contact_ContactIcons1_idx` (`contactIconId` ASC) VISIBLE,
  CONSTRAINT `fk_Contact_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `portfolio`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contact_ContactIcons1`
    FOREIGN KEY (`contactIconId`)
    REFERENCES `portfolio`.`ContactIcons` (`contactIconId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`SocialNetIcons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`SocialNetIcons` (
  `socialNetIconId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`socialNetIconId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`SocialNet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`SocialNet` (
  `socialNetIdt` INT NOT NULL,
  `iconName` VARCHAR(255) NOT NULL,
  `link` TEXT(1000) NULL,
  `User_userId` INT NOT NULL,
  `SocialNetIcons_socialNetIconId` INT NOT NULL,
  PRIMARY KEY (`socialNetIdt`, `User_userId`, `SocialNetIcons_socialNetIconId`),
  INDEX `fk_SocialNet_User1_idx` (`User_userId` ASC) VISIBLE,
  INDEX `fk_SocialNet_SocialNetIcons1_idx` (`SocialNetIcons_socialNetIconId` ASC) VISIBLE,
  CONSTRAINT `fk_SocialNet_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `portfolio`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SocialNet_SocialNetIcons1`
    FOREIGN KEY (`SocialNetIcons_socialNetIconId`)
    REFERENCES `portfolio`.`SocialNetIcons` (`socialNetIconId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Countries` (
  `countryId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`countryId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Cities` (
  `cityId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `countryId` INT NOT NULL,
  PRIMARY KEY (`cityId`, `countryId`),
  INDEX `fk_Cities_Countries1_idx` (`countryId` ASC) VISIBLE,
  CONSTRAINT `fk_Cities_Countries1`
    FOREIGN KEY (`countryId`)
    REFERENCES `portfolio`.`Countries` (`countryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Enterprises`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Enterprises` (
  `enterpriseId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `logo` VARCHAR(45) NULL,
  PRIMARY KEY (`enterpriseId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Enterprises_has_Cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Enterprises_has_Cities` (
  `enterpriseId` INT NOT NULL,
  `cityId` INT NOT NULL,
  PRIMARY KEY (`enterpriseId`, `cityId`),
  INDEX `fk_Enterprises_has_Cities_Cities1_idx` (`cityId` ASC) VISIBLE,
  INDEX `fk_Enterprises_has_Cities_Enterprises1_idx` (`enterpriseId` ASC) VISIBLE,
  CONSTRAINT `fk_Enterprises_has_Cities_Enterprises1`
    FOREIGN KEY (`enterpriseId`)
    REFERENCES `portfolio`.`Enterprises` (`enterpriseId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Enterprises_has_Cities_Cities1`
    FOREIGN KEY (`cityId`)
    REFERENCES `portfolio`.`Cities` (`cityId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`ProfessionalExperience_has_Enterprises`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`ProfessionalExperience_has_Enterprises` (
  `professionalExpId` INT NOT NULL,
  `enterpriseId` INT NOT NULL,
  PRIMARY KEY (`professionalExpId`, `enterpriseId`),
  INDEX `fk_ProfessionalExperience_has_Enterprises_Enterprises1_idx` (`enterpriseId` ASC) VISIBLE,
  INDEX `fk_ProfessionalExperience_has_Enterprises_ProfessionalExper_idx` (`professionalExpId` ASC) VISIBLE,
  CONSTRAINT `fk_ProfessionalExperience_has_Enterprises_ProfessionalExperie1`
    FOREIGN KEY (`professionalExpId`)
    REFERENCES `portfolio`.`ProfessionalExperience` (`professionalExpId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ProfessionalExperience_has_Enterprises_Enterprises1`
    FOREIGN KEY (`enterpriseId`)
    REFERENCES `portfolio`.`Enterprises` (`enterpriseId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Institutions_has_Cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Institutions_has_Cities` (
  `institutionId` INT NOT NULL,
  `cityId` INT NOT NULL,
  PRIMARY KEY (`institutionId`, `cityId`),
  INDEX `fk_Institutions_has_Cities_Cities1_idx` (`cityId` ASC) VISIBLE,
  INDEX `fk_Institutions_has_Cities_Institutions1_idx` (`institutionId` ASC) VISIBLE,
  CONSTRAINT `fk_Institutions_has_Cities_Institutions1`
    FOREIGN KEY (`institutionId`)
    REFERENCES `portfolio`.`Institutions` (`institutionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Institutions_has_Cities_Cities1`
    FOREIGN KEY (`cityId`)
    REFERENCES `portfolio`.`Cities` (`cityId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`ProfessionalExperience_has_Enterprises_has_Cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`ProfessionalExperience_has_Enterprises_has_Cities` (
  `ProfessionalExperience_User_userId` INT NOT NULL,
  `ProfessionalExperience_professionalExpId` INT NOT NULL,
  `Enterprises_has_Cities_enterpriseId` INT NOT NULL,
  `Enterprises_has_Cities_cityId` INT NOT NULL,
  PRIMARY KEY (`ProfessionalExperience_User_userId`, `ProfessionalExperience_professionalExpId`, `Enterprises_has_Cities_enterpriseId`, `Enterprises_has_Cities_cityId`),
  INDEX `fk_ProfessionalExperience_has_Enterprises_has_Cities_Enterp_idx` (`Enterprises_has_Cities_enterpriseId` ASC, `Enterprises_has_Cities_cityId` ASC) VISIBLE,
  INDEX `fk_ProfessionalExperience_has_Enterprises_has_Cities_Profes_idx` (`ProfessionalExperience_professionalExpId` ASC, `ProfessionalExperience_User_userId` ASC) VISIBLE,
  CONSTRAINT `fk_ProfessionalExperience_has_Enterprises_has_Cities_Professi1`
    FOREIGN KEY (`ProfessionalExperience_professionalExpId` , `ProfessionalExperience_User_userId`)
    REFERENCES `portfolio`.`ProfessionalExperience` (`professionalExpId` , `User_userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ProfessionalExperience_has_Enterprises_has_Cities_Enterpri1`
    FOREIGN KEY (`Enterprises_has_Cities_enterpriseId` , `Enterprises_has_Cities_cityId`)
    REFERENCES `portfolio`.`Enterprises_has_Cities` (`enterpriseId` , `cityId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`Education_has_Institutions_has_Cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`Education_has_Institutions_has_Cities` (
  `Education_User_userId` INT NOT NULL,
  `Education_educationId` INT NOT NULL,
  `Education_institutionId` INT NOT NULL,
  `Institutions_has_Cities_institutionId` INT NOT NULL,
  `Institutions_has_Cities_cityId` INT NOT NULL,
  PRIMARY KEY (`Education_User_userId`, `Education_educationId`, `Education_institutionId`, `Institutions_has_Cities_institutionId`, `Institutions_has_Cities_cityId`),
  INDEX `fk_Education_has_Institutions_has_Cities_Institutions_has_C_idx` (`Institutions_has_Cities_institutionId` ASC, `Institutions_has_Cities_cityId` ASC) VISIBLE,
  INDEX `fk_Education_has_Institutions_has_Cities_Education1_idx` (`Education_educationId` ASC, `Education_User_userId` ASC, `Education_institutionId` ASC) VISIBLE,
  CONSTRAINT `fk_Education_has_Institutions_has_Cities_Education1`
    FOREIGN KEY (`Education_educationId` , `Education_User_userId` , `Education_institutionId`)
    REFERENCES `portfolio`.`Education` (`educationId` , `User_userId` , `institutionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Education_has_Institutions_has_Cities_Institutions_has_Cit1`
    FOREIGN KEY (`Institutions_has_Cities_institutionId` , `Institutions_has_Cities_cityId`)
    REFERENCES `portfolio`.`Institutions_has_Cities` (`institutionId` , `cityId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
