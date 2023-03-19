CREATE SCHEMA IF NOT EXISTS `academiapolesp` DEFAULT CHARACTER SET utf8 ;
USE `academiapolesp` ;

-- -----------------------------------------------------
-- Table `academiapolesp`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `academiapolesp`.`usuario` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(45) NULL,
    `apellidos` VARCHAR(80) NULL,
    `nombre_usuario` VARCHAR(45) NULL,
    `contrasenya` VARCHAR(100) NULL,
    `email` VARCHAR(80) NULL,
    `admin` TINYINT NULL,
    PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `academiapolesp`.`temario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `academiapolesp`.`temario` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `tema` INT NULL,
    `titulo` VARCHAR(45) NULL,
    `pdf` VARCHAR(100) NULL,
    PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `academiapolesp`.`examen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `academiapolesp`.`examen` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(45) NULL,
    PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `academiapolesp`.`examenes_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `academiapolesp`.`examenes_user` (
    `fk_usuario` INT NOT NULL,
    `fk_examen` INT NOT NULL,
    `nota` FLOAT NULL,
    `fecha` DATE NULL,
    PRIMARY KEY (`fk_usuario`, `fk_examen`),
    CONSTRAINT `fk_usuario_has_examen_usuario`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `academiapolesp`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_usuario_has_examen_examen1`
    FOREIGN KEY (`fk_examen`)
    REFERENCES `academiapolesp`.`examen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `academiapolesp`.`preguntas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `academiapolesp`.`preguntas` (
    `id` INT NOT NULL,
    `fk_temario` INT NOT NULL,
    `pregunta` VARCHAR(500) NULL,
    `respuesta` ENUM('A', 'B', 'C', 'D', 'E') NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_preguntas_temario1`
    FOREIGN KEY (`fk_temario`)
    REFERENCES `academiapolesp`.`temario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `academiapolesp`.`preguntas_exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `academiapolesp`.`preguntas_exam` (
    `fk_examen` INT NOT NULL,
    `fk_preguntas` INT NOT NULL,
    PRIMARY KEY (`fk_examen`, `fk_preguntas`),
    CONSTRAINT `fk_examen_has_preguntas_examen1`
    FOREIGN KEY (`fk_examen`)
    REFERENCES `academiapolesp`.`examen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_examen_has_preguntas_preguntas1`
    FOREIGN KEY (`fk_preguntas`)
    REFERENCES `academiapolesp`.`preguntas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `academiapolesp`.`datos_examen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `academiapolesp`.`datos_examen` (
    `fk_usuario` INT NOT NULL,
    `fk_examen` INT NOT NULL,
    `fk_preguntas` INT NOT NULL,
    `respuesta_alumno` ENUM('A', 'B', 'C', 'D', 'E') NULL,
    PRIMARY KEY (`fk_usuario`, `fk_examen`, `fk_preguntas`),
    CONSTRAINT `fk_usuario_has_examen_has_preguntas_usuario_has_examen1`
    FOREIGN KEY (`fk_usuario` , `fk_examen`)
    REFERENCES `academiapolesp`.`examenes_user` (`fk_usuario` , `fk_examen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_usuario_has_examen_has_preguntas_preguntas1`
    FOREIGN KEY (`fk_preguntas`)
    REFERENCES `academiapolesp`.`preguntas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;