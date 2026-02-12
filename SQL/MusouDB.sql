-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema musoudb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema musoudb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `musoudb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `musoudb` ;

-- -----------------------------------------------------
-- Table `musoudb`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `musoudb`.`curso` (
  `id_curso` BIGINT NOT NULL AUTO_INCREMENT,
  `costo_curso` DECIMAL(10,2) NOT NULL,
  `descripcion_curso` VARCHAR(255) NOT NULL,
  `detalle_curso` VARCHAR(1000) NOT NULL,
  `fin_curso` DATETIME NOT NULL,
  `inicio_curso` DATETIME NOT NULL,
  `modalidad_curso` VARCHAR(45) NOT NULL,
  `nombre_curso` VARCHAR(45) NOT NULL,
  `url_imagen_curso` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_curso`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `musoudb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `musoudb`.`usuario` (
  `id_usuario` BIGINT NOT NULL AUTO_INCREMENT,
  `apellido_usuario` VARCHAR(50) NOT NULL,
  `contrasena_usuario` VARCHAR(50) NOT NULL,
  `correo_usuario` VARCHAR(255) NOT NULL,
  `nombre_usuario` VARCHAR(50) NOT NULL,
  `rol_usuario` INT NOT NULL,
  `telefono_usuario` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `UKdo5kjb0haqlicn34eexyuy1e3` (`correo_usuario` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `musoudb`.`orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `musoudb`.`orden` (
  `id_orden` BIGINT NOT NULL AUTO_INCREMENT,
  `fecha_orden` DATETIME NOT NULL,
  `total_orden` DECIMAL(10,2) NOT NULL,
  `orden_id_usuario` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_orden`),
  INDEX `FKf4qw0g7juq98j5dsiinllqefl` (`orden_id_usuario` ASC) VISIBLE,
  CONSTRAINT `FKf4qw0g7juq98j5dsiinllqefl`
    FOREIGN KEY (`orden_id_usuario`)
    REFERENCES `musoudb`.`usuario` (`id_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `musoudb`.`ordenes_tiene_cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `musoudb`.`ordenes_tiene_cursos` (
  `id_orden` BIGINT NOT NULL,
  `id_curso` BIGINT NOT NULL,
  PRIMARY KEY (`id_orden`, `id_curso`),
  INDEX `FKssqi0h39f10enhgiltdhla0ef` (`id_curso` ASC) VISIBLE,
  CONSTRAINT `FKaqr1jwnup30lk06j8spx2qkhd`
    FOREIGN KEY (`id_orden`)
    REFERENCES `musoudb`.`orden` (`id_orden`),
  CONSTRAINT `FKssqi0h39f10enhgiltdhla0ef`
    FOREIGN KEY (`id_curso`)
    REFERENCES `musoudb`.`curso` (`id_curso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `musoudb`.`recurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `musoudb`.`recurso` (
  `id_recurso` BIGINT NOT NULL AUTO_INCREMENT,
  `costo_recurso` DECIMAL(10,2) NOT NULL,
  `descripcion_recurso` VARCHAR(255) NOT NULL,
  `detalle_recurso` VARCHAR(1000) NOT NULL,
  `nombre_recurso` VARCHAR(45) NOT NULL,
  `url_imagen_recurso` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_recurso`),
  UNIQUE INDEX `UKcacdu3ak3ooerpnjavn51l1n3` (`nombre_recurso` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `musoudb`.`ordenes_tiene_recursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `musoudb`.`ordenes_tiene_recursos` (
  `id_orden` BIGINT NOT NULL,
  `id_recurso` BIGINT NOT NULL,
  PRIMARY KEY (`id_orden`, `id_recurso`),
  INDEX `FKruiqx7n7lwfnbu62cu0a77uln` (`id_recurso` ASC) VISIBLE,
  CONSTRAINT `FK4o7ogxh0m4ssg0y7r8p4b1xeh`
    FOREIGN KEY (`id_orden`)
    REFERENCES `musoudb`.`orden` (`id_orden`),
  CONSTRAINT `FKruiqx7n7lwfnbu62cu0a77uln`
    FOREIGN KEY (`id_recurso`)
    REFERENCES `musoudb`.`recurso` (`id_recurso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `musoudb`.`resena`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `musoudb`.`resena` (
  `id_resena` BIGINT NOT NULL AUTO_INCREMENT,
  `contenido_resena` VARCHAR(255) NOT NULL,
  `fecha_resena` DATETIME NOT NULL,
  `titulo_resena` VARCHAR(45) NOT NULL,
  `valoracion_resena` DECIMAL(2,1) NOT NULL,
  `resena_id_curso` BIGINT NULL DEFAULT NULL,
  `resena_id_usuario` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_resena`),
  INDEX `FKaa4atmmlr9y2yumlsjht25yqg` (`resena_id_curso` ASC) VISIBLE,
  INDEX `FKcsbrq6hlbyp06ltiqmgx5qptg` (`resena_id_usuario` ASC) VISIBLE,
  CONSTRAINT `FKaa4atmmlr9y2yumlsjht25yqg`
    FOREIGN KEY (`resena_id_curso`)
    REFERENCES `musoudb`.`curso` (`id_curso`),
  CONSTRAINT `FKcsbrq6hlbyp06ltiqmgx5qptg`
    FOREIGN KEY (`resena_id_usuario`)
    REFERENCES `musoudb`.`usuario` (`id_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `musoudb`.`usuario_tiene_cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `musoudb`.`usuario_tiene_cursos` (
  `id_usuario` BIGINT NOT NULL,
  `id_curso` BIGINT NOT NULL,
  PRIMARY KEY (`id_usuario`, `id_curso`),
  INDEX `FKo7mc7ljyljs3fx7289nyge2g5` (`id_curso` ASC) VISIBLE,
  CONSTRAINT `FKf4b73gpjrhbq91g6ji92op0yh`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `musoudb`.`usuario` (`id_usuario`),
  CONSTRAINT `FKo7mc7ljyljs3fx7289nyge2g5`
    FOREIGN KEY (`id_curso`)
    REFERENCES `musoudb`.`curso` (`id_curso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `musoudb`.`usuario_tiene_recursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `musoudb`.`usuario_tiene_recursos` (
  `id_usuario` BIGINT NOT NULL,
  `id_recurso` BIGINT NOT NULL,
  PRIMARY KEY (`id_usuario`, `id_recurso`),
  INDEX `FK1jelv6x2qyhxa0hu6qcxm1c3j` (`id_recurso` ASC) VISIBLE,
  CONSTRAINT `FK1jelv6x2qyhxa0hu6qcxm1c3j`
    FOREIGN KEY (`id_recurso`)
    REFERENCES `musoudb`.`recurso` (`id_recurso`),
  CONSTRAINT `FKjc8xn0lp0ye71dh1gdeadbywa`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `musoudb`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
