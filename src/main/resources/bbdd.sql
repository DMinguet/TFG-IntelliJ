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
    INDEX `fk_usuario_has_examen_examen1_idx` (`fk_examen` ASC),
    INDEX `fk_usuario_has_examen_usuario_idx` (`fk_usuario` ASC),
    CONSTRAINT `fk_usuario_has_examen_usuario`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `academiapolesp`.`usuario` (`id`),
    CONSTRAINT `fk_usuario_has_examen_examen1`
    FOREIGN KEY (`fk_examen`)
    REFERENCES `academiapolesp`.`examen` (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `academiapolesp`.`preguntas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `academiapolesp`.`preguntas` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `pregunta` VARCHAR(500) NULL,
    `respuesta` ENUM('A', 'B', 'C', 'D') NULL,
    `fk_temario` INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_preguntas_temario1_idx` (`fk_temario` ASC),
    CONSTRAINT `fk_preguntas_temario1`
    FOREIGN KEY (`fk_temario`)
    REFERENCES `academiapolesp`.`temario` (`id`))
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `academiapolesp`.`preguntas_exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `academiapolesp`.`preguntas_exam` (
    `fk_examen` INT NOT NULL,
    `fk_preguntas` INT NOT NULL,
    PRIMARY KEY (`fk_examen`, `fk_preguntas`),
    INDEX `fk_examen_has_preguntas_preguntas1_idx` (`fk_preguntas` ASC),
    INDEX `fk_examen_has_preguntas_examen1_idx` (`fk_examen` ASC),
    CONSTRAINT `fk_examen_has_preguntas_examen1`
    FOREIGN KEY (`fk_examen`)
    REFERENCES `academiapolesp`.`examen` (`id`),
    CONSTRAINT `fk_examen_has_preguntas_preguntas1`
    FOREIGN KEY (`fk_preguntas`)
    REFERENCES `academiapolesp`.`preguntas` (`id`))
    ENGINE = InnoDB;

------------
-- INSERTS
------------

INSERT INTO academiapolesp.usuario (id, nombre, apellidos, nombre_usuario, contrasenya, email, admin) VALUES (1, 'Daniel', 'Minguet Toril', 'dminguet', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'daminto2001@gmail.com', 1);
INSERT INTO academiapolesp.usuario (id, nombre, apellidos, nombre_usuario, contrasenya, email, admin) VALUES (2, 'Pepe', 'Reina Fejio', 'pepe', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'pepereina@gmail.com', 0);

INSERT INTO academiapolesp.temario (id, tema, titulo, pdf) VALUES (1, 1, 'El Antiguo Régimen', 'https://mega.nz/file/hhk0nKIL#Sqk3EqS4E-x8_Hsz93ijFMP70t-A2pfJOqkfXjsoTpg');
INSERT INTO academiapolesp.temario (id, tema, titulo, pdf) VALUES (2, 2, 'El Movimiento Obrero', 'https://mega.nz/file/Q81zUQTY#cwrDJKuLGoy99tdhkCqvYDgrAQJvXEpgLh5JDcCozOQ');
INSERT INTO academiapolesp.temario (id, tema, titulo, pdf) VALUES (3, 3, 'La Primera Guerra Mundial', 'https://mega.nz/file/l812zCTA#UE6fzeoXW4v0nwaQvmajpF74SmvcLvT89jsXkYHJPZM');
INSERT INTO academiapolesp.temario (id, tema, titulo, pdf) VALUES (4, 4, 'La Segunda Guerra Mundial', null);
INSERT INTO academiapolesp.temario (id, tema, titulo, pdf) VALUES (5, 5, 'La Guerra Fría', null);

INSERT INTO academiapolesp.preguntas (id, pregunta, respuesta, fk_temario) VALUES (1, 'Por que se carecteriza el antiguo régimen:
a) Por una baja tasa de natalidad y mortalidad.
b) Por una alta tasa de natalidad y mortalidad.
c) Por la falta de higiene.
d) La a) y la c) son correctas.', 'B', 1);

INSERT INTO academiapolesp.preguntas (id, pregunta, respuesta, fk_temario) VALUES (2, 'En el sistema político que surgió en Europa en la segunda mitad del Siglo XVIII. Entre los
monarcas que ejercieron el despotismo ilustrado figuran:
a) Catalina II de Rusia, Felipe I de España, Federico II de Austria.
b) José II de Austria, Federico II de España, Catalina I de Prusia.
c) Catalaina II de Rusia, José II de Austria, Federico II de Prusia y Carlos III de España.
d) Jose I de Rusia, Juan Carlos I de España, Catalina de Aragón, Juana la Loca.', 'C', 1);

INSERT INTO academiapolesp.preguntas (id, pregunta, respuesta, fk_temario) VALUES (3, '¿Cuando se desarrolla el rococó como estilo artístico?
a) Durante la Segunda Guerra Mundial.
b) En España entre los años 1736 y 1760.
c) En Francia entre 1730 y 1760.
d) Ninguna respuesta es correcta.', 'C', 1);

INSERT INTO academiapolesp.preguntas (id, pregunta, respuesta, fk_temario) VALUES (4, 'En general, las poblaciones europeas del Antiguo Régimen tenían una serie de rasgos comunes. Señale la respuesta correcta:
a) Una mortalidad muy elevada (entre el 30 y el 38 por mil) y muy baja esperanza de vida al nacer (en torno a los 30 años)
b) Una alta natalidad (7 hijos de media por matrimonio), con una esperanza de vida que apenas llegaba a los 50 años.
c) Una alta tasa de mortalidad, causada por la subalimentación, la falta de higiene
d) Ninguna es cierta', 'A', 1);

INSERT INTO academiapolesp.preguntas (id, pregunta, respuesta, fk_temario) VALUES (5, 'Entre los objetivos del sistema político que surgió en Europa en la segunda mitad del Siglo XVIII,
se encuentran los siguientes:
a) Incrementar el poder de la monarquía mediante el desarrollo económico, cultural y militar.
b) Racionalizar la Administración con el apoyo de secretarios y ministros ilustrados.
c) Promover programas de desarrollo agrícola e industrial y liberalizar el comercio.
d) Todas son correctas.', 'D', 1);

INSERT INTO academiapolesp.preguntas (id, pregunta, respuesta, fk_temario) VALUES (6, '¿Durante que siglo se desarrolla en Europa el barroco no sólo como estilo artístico, sino también
como movimiento cultural?
a) En el siglo XIV.
b) En el siglo XVIII y el principio del XIV.
c) En el siglo XVI y el primer tercio del siglo XVII-
d) En el siglo XVII y el primer tercio del siglo XVIII.', 'D', 1);

INSERT INTO academiapolesp.preguntas (id, pregunta, respuesta, fk_temario) VALUES (7, '¿Cual de las siguientes afirmaciones es correcta?
a) Las sociedades del Antiguo Régimen eran predominantemente rurales y agrarias.
b) El rococó se desarrolló en Francia entre los años 1930 y 1960.
c) La Ilustración surge como sistema político en Europa en el siglo XVII.
d) Ninguna afirmación es correcta.', 'A', 1);

INSERT INTO academiapolesp.preguntas (id, pregunta, respuesta, fk_temario) VALUES (8, 'El sistema demográfico de las sociedades del Antiguo Régimen se caracterizaba por las siguientes
afirmaciones:
a) Por una alta tasa de mortalidad y natalidad, debido al efecto de las guerras y las hambrunas.
b) Por la estrecha dependencia entre el crecimiento de la población y de la economía
agraria.
c) Por el desarrollo del barroco no solo como estilo artístico, sino también como movimiento
cultural.
d) Todas las respuestas son incorrectas.', 'B', 1);

INSERT INTO academiapolesp.preguntas (id, pregunta, respuesta, fk_temario) VALUES (9, 'Durante el siglo XVII y el primer tercio del siglo XVIII, se desarrolló en Europa:
a) El rococó como un movimiento cultural y artístico que se desarrollaría en Francia.
b) El barroco no sólo como estilo artístico, sino también como movimiento cultural.
c) El barroco como un estilo unicamente artístico desarrollado entre 1730 y 1760.
d) Ninguna afirmación es correcta.', 'B', 1);

INSERT INTO academiapolesp.preguntas (id, pregunta, respuesta, fk_temario) VALUES (10, 'Un rasgo común de las poblaciones europeas del Antiguo Régimen era:
a) En los Estados de Europa, la forma de gobierno predominante era la dictadura.
b) El rococó es un estilo perteneciente al movimiento cultural.
c) Un crecimiento natural que podría no llegar a superar el 2 por mil anual.
d) Todas las afirmaciones son incorrectas.', 'C', 1);
