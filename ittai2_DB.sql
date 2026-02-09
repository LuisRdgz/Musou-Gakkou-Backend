-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ittaidb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ittaidb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ittaidb` DEFAULT CHARACTER SET utf8mb3 ;
USE `ittaidb` ;

-- -----------------------------------------------------
-- Table `ittaidb`.`cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ittaidb`.`cursos` (
  `id_curso` INT NOT NULL AUTO_INCREMENT,
  `fecha_inicio_curso` DATE NOT NULL,
  `fecha_cierre_curso` DATE NOT NULL,
  `costo_curso` DOUBLE NOT NULL,
  `descripcion_curso` TINYTEXT NOT NULL,
  `detalle_curso` MEDIUMTEXT NOT NULL,
  `modalidad_curso` VARCHAR(45) NOT NULL,
  `nombre_curso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_curso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ittaidb`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ittaidb`.`usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre_usuario` VARCHAR(50) NOT NULL,
  `apellido_usuario` VARCHAR(50) NOT NULL,
  `correo_usuario` VARCHAR(255) NOT NULL,
  `telefono_usuario` VARCHAR(45) NOT NULL,
  `contraseña_usuario` VARCHAR(50) NOT NULL,
  `rol_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `correo_usuario_UNIQUE` (`correo_usuario` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ittaidb`.`ordenes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ittaidb`.`ordenes` (
  `id_orden` INT NOT NULL AUTO_INCREMENT,
  `total_orden` DOUBLE NOT NULL,
  `fecha_orden` DATE NOT NULL,
  `usuarios_id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_orden`, `usuarios_id_usuario`),
  INDEX `fk_ordenes_usuarios_idx` (`usuarios_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_ordenes_usuarios`
    FOREIGN KEY (`usuarios_id_usuario`)
    REFERENCES `ittaidb`.`usuarios` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ittaidb`.`recursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ittaidb`.`recursos` (
  `id_recurso` INT NOT NULL AUTO_INCREMENT,
  `costo_recurso` DOUBLE NOT NULL,
  `titulo_recurso` VARCHAR(45) NOT NULL,
  `detalle_recurso` MEDIUMTEXT NOT NULL,
  `descripcion_recurso` TINYTEXT NOT NULL,
  PRIMARY KEY (`id_recurso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ittaidb`.`reseñas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ittaidb`.`reseñas` (
  `id_reseñas` INT NOT NULL AUTO_INCREMENT,
  `valoracion_reseña` FLOAT NOT NULL,
  `fecha_reseña` DATE NOT NULL,
  `contenido_reseña` TINYTEXT NOT NULL,
  `titulo_reseña` TINYTEXT NOT NULL,
  `cursos_id_curso` INT NOT NULL,
  PRIMARY KEY (`id_reseñas`, `cursos_id_curso`),
  INDEX `fk_reseñas_cursos1_idx` (`cursos_id_curso` ASC) VISIBLE,
  CONSTRAINT `fk_reseñas_cursos1`
    FOREIGN KEY (`cursos_id_curso`)
    REFERENCES `ittaidb`.`cursos` (`id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ittaidb`.`ordenes_has_recursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ittaidb`.`ordenes_has_recursos` (
  `ordenes_id_orden` INT NOT NULL,
  `ordenes_usuarios_id_usuario` INT NOT NULL,
  `recursos_id_recurso` INT NOT NULL,
  PRIMARY KEY (`ordenes_id_orden`, `ordenes_usuarios_id_usuario`, `recursos_id_recurso`),
  INDEX `fk_ordenes_has_recursos_recursos1_idx` (`recursos_id_recurso` ASC) VISIBLE,
  INDEX `fk_ordenes_has_recursos_ordenes1_idx` (`ordenes_id_orden` ASC, `ordenes_usuarios_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_ordenes_has_recursos_ordenes1`
    FOREIGN KEY (`ordenes_id_orden` , `ordenes_usuarios_id_usuario`)
    REFERENCES `ittaidb`.`ordenes` (`id_orden` , `usuarios_id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordenes_has_recursos_recursos1`
    FOREIGN KEY (`recursos_id_recurso`)
    REFERENCES `ittaidb`.`recursos` (`id_recurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ittaidb`.`usuarios_has_cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ittaidb`.`usuarios_has_cursos` (
  `usuarios_id_usuario` INT NOT NULL,
  `cursos_id_curso` INT NOT NULL,
  PRIMARY KEY (`usuarios_id_usuario`, `cursos_id_curso`),
  INDEX `fk_usuarios_has_cursos_cursos1_idx` (`cursos_id_curso` ASC) VISIBLE,
  INDEX `fk_usuarios_has_cursos_usuarios1_idx` (`usuarios_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios_has_cursos_usuarios1`
    FOREIGN KEY (`usuarios_id_usuario`)
    REFERENCES `ittaidb`.`usuarios` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_has_cursos_cursos1`
    FOREIGN KEY (`cursos_id_curso`)
    REFERENCES `ittaidb`.`cursos` (`id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ittaidb`.`ordenes_has_cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ittaidb`.`ordenes_has_cursos` (
  `ordenes_id_orden` INT NOT NULL,
  `ordenes_usuarios_id_usuario` INT NOT NULL,
  `cursos_id_curso` INT NOT NULL,
  PRIMARY KEY (`ordenes_id_orden`, `ordenes_usuarios_id_usuario`, `cursos_id_curso`),
  INDEX `fk_ordenes_has_cursos_cursos1_idx` (`cursos_id_curso` ASC) VISIBLE,
  INDEX `fk_ordenes_has_cursos_ordenes1_idx` (`ordenes_id_orden` ASC, `ordenes_usuarios_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_ordenes_has_cursos_ordenes1`
    FOREIGN KEY (`ordenes_id_orden` , `ordenes_usuarios_id_usuario`)
    REFERENCES `ittaidb`.`ordenes` (`id_orden` , `usuarios_id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordenes_has_cursos_cursos1`
    FOREIGN KEY (`cursos_id_curso`)
    REFERENCES `ittaidb`.`cursos` (`id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ittaidb`.`usuarios_has_recursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ittaidb`.`usuarios_has_recursos` (
  `usuarios_id_usuario` INT NOT NULL,
  `recursos_id_recurso` INT NOT NULL,
  PRIMARY KEY (`usuarios_id_usuario`, `recursos_id_recurso`),
  INDEX `fk_usuarios_has_recursos_recursos1_idx` (`recursos_id_recurso` ASC) VISIBLE,
  INDEX `fk_usuarios_has_recursos_usuarios1_idx` (`usuarios_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios_has_recursos_usuarios1`
    FOREIGN KEY (`usuarios_id_usuario`)
    REFERENCES `ittaidb`.`usuarios` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_has_recursos_recursos1`
    FOREIGN KEY (`recursos_id_recurso`)
    REFERENCES `ittaidb`.`recursos` (`id_recurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;