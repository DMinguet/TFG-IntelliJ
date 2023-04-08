CREATE SCHEMA IF NOT EXISTS `polesp` DEFAULT CHARACTER SET utf8 ;
USE `polesp` ;

-- -----------------------------------------------------
-- Table `polesp`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `polesp`.`usuario` (
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
-- Table `polesp`.`temario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `polesp`.`temario` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `tema` INT NULL,
    `titulo` VARCHAR(45) NULL,
    `pdf` VARCHAR(100) NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `polesp`.`examen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `polesp`.`examen` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(45) NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `polesp`.`pregunta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `polesp`.`pregunta` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `pregunta` VARCHAR(500) NULL,
    `respuesta` CHAR(1) NULL,
    `temario_id` INT NOT NULL,
    `examen_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_preguntas_temario1_idx` (`temario_id` ASC),
    INDEX `fk_pregunta_examen1_idx` (`examen_id` ASC),
    CONSTRAINT `fk_preguntas_temario1`
    FOREIGN KEY (`temario_id`)
    REFERENCES `polesp`.`temario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_pregunta_examen1`
    FOREIGN KEY (`examen_id`)
    REFERENCES `polesp`.`examen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `polesp`.`usuario_has_examen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `polesp`.`usuario_has_examen` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `usuario_id` INT NOT NULL,
    `examen_id` INT NOT NULL,
    `nota` FLOAT NULL,
    `fecha` DATE NULL,
    PRIMARY KEY (`id`, `usuario_id`, `examen_id`),
    INDEX `fk_usuario_has_examen_examen1_idx` (`examen_id` ASC),
    INDEX `fk_usuario_has_examen_usuario1_idx` (`usuario_id` ASC),
    CONSTRAINT `fk_usuario_has_examen_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `polesp`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_usuario_has_examen_examen1`
    FOREIGN KEY (`examen_id`)
    REFERENCES `polesp`.`examen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

------------
-- INSERTS
------------

INSERT INTO polesp.usuario (id, nombre, apellidos, nombre_usuario, contrasenya, email, admin) VALUES (1, 'Daniel', 'Minguet Toril', 'dminguet', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'daminto2001@gmail.com', 1);
INSERT INTO polesp.usuario (id, nombre, apellidos, nombre_usuario, contrasenya, email, admin) VALUES (2, 'Pepe', 'Reina Fejio', 'pepe', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'pepereina@gmail.com', 0);

INSERT INTO polesp.temario (id, tema, titulo, pdf) VALUES (1, 1, 'El Antiguo Régimen', 'https://mega.nz/file/hhk0nKIL#Sqk3EqS4E-x8_Hsz93ijFMP70t-A2pfJOqkfXjsoTpg');
INSERT INTO polesp.temario (id, tema, titulo, pdf) VALUES (2, 2, 'El Movimiento Obrero', 'https://mega.nz/file/Q81zUQTY#cwrDJKuLGoy99tdhkCqvYDgrAQJvXEpgLh5JDcCozOQ');
INSERT INTO polesp.temario (id, tema, titulo, pdf) VALUES (3, 3, 'La Primera Guerra Mundial', 'https://mega.nz/file/l812zCTA#UE6fzeoXW4v0nwaQvmajpF74SmvcLvT89jsXkYHJPZM');
INSERT INTO polesp.temario (id, tema, titulo, pdf) VALUES (4, 4, 'La Segunda Guerra Mundial', null);
INSERT INTO polesp.temario (id, tema, titulo, pdf) VALUES (5, 5, 'La Guerra Fría', null);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (1, '¿Por que se carecteriza el antiguo régimen?

a) Por una baja tasa de natalidad y mortalidad.

b) Por una alta tasa de natalidad y mortalidad.

c) Por la falta de higiene.

d) La a) y la c) son correctas.', 'B', 1, 1);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (2, 'En el sistema político que surgió en Europa en la segunda mitad del Siglo XVIII. Entre los monarcas que ejercieron el despotismo ilustrado figuran:

a) Catalina II de Rusia, Felipe I de España, Federico II de Austria.

b) José II de Austria, Federico II de España, Catalina I de Prusia.

c) Catalina II de Rusia, José II de Austria, Federico II de Prusia y Carlos III de España.

d) Jose I de Rusia, Juan Carlos I de España, Catalina de Aragón, Juana la Loca.', 'C', 1, 1);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (3, '¿Cuando se desarrolla el rococó como estilo artístico?

a) Durante la Segunda Guerra Mundial.

b) En España entre los años 1736 y 1760.

c) En Francia entre 1730 y 1760.

d) Ninguna respuesta es correcta.', 'C', 1, 1);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (4, 'En general, las poblaciones europeas del Antiguo Régimen tenían una serie de rasgos comunes. Señale la respuesta correcta:

a) Una mortalidad muy elevada (entre el 30 y el 38 por mil) y muy baja esperanza de vida al nacer (en torno a los 30 años).

b) Una alta natalidad (7 hijos de media por matrimonio), con una esperanza de vida que apenas llegaba a los 50 años.

c) Una alta tasa de mortalidad, causada por la subalimentación, la falta de higiene.

d) Ninguna es cierta', 'A', 1, 1);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (5, 'Entre los objetivos del sistema político que surgió en Europa en la segunda mitad del Siglo XVIII, se encuentran los siguientes:

a) Incrementar el poder de la monarquía mediante el desarrollo económico, cultural y militar.

b) Racionalizar la Administración con el apoyo de secretarios y ministros ilustrados.

c) Promover programas de desarrollo agrícola e industrial y liberalizar el comercio.

d) Todas son correctas.', 'D', 1, 1);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (6, '¿Durante que siglo se desarrolla en Europa el barroco no sólo como estilo artístico, sino también como movimiento cultural?

a) En el siglo XIV.

b) En el siglo XVIII y el principio del XIV.

c) En el siglo XVI y el primer tercio del siglo XVII.

d) En el siglo XVII y el primer tercio del siglo XVIII.', 'D', 1, 1);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (7, '¿Cuál de las siguientes afirmaciones es correcta?

a) Las sociedades del Antiguo Régimen eran predominantemente rurales y agrarias.

b) El rococó se desarrolló en Francia entre los años 1930 y 1960.

c) La Ilustración surge como sistema político en Europa en el siglo XVII.

d) Ninguna afirmación es correcta.', 'A', 1, 1);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (8, 'El sistema demográfico de las sociedades del Antiguo Régimen se caracterizaba por las siguientes afirmaciones:

a) Por una alta tasa de mortalidad y natalidad, debido al efecto de las guerras y las hambrunas.

b) Por la estrecha dependencia entre el crecimiento de la población y de la economía
agraria.

c) Por el desarrollo del barroco no solo como estilo artístico, sino también como movimiento cultural.

d) Todas las respuestas son incorrectas.', 'B', 1, 1);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (9, 'Durante el siglo XVII y el primer tercio del siglo XVIII, se desarrolló en Europa:

a) El rococó como un movimiento cultural y artístico que se desarrollaría en Francia.

b) El barroco no sólo como estilo artístico, sino también como movimiento cultural.

c) El barroco como un estilo únicamente artístico desarrollado entre 1730 y 1760.

d) Ninguna afirmación es correcta.', 'B', 1, 1);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (10, 'Un rasgo común de las poblaciones europeas del Antiguo Régimen era:

a) En los Estados de Europa, la forma de gobierno predominante era la dictadura.

b) El rococó es un estilo perteneciente al movimiento cultural.

c) Un crecimiento natural que podría no llegar a superar el 2 por mil anual.

d) Todas las afirmaciones son incorrectas.', 'C', 1, 1);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (11, 'El movimiento obrero, también conocido como obrerismo, se define como:

a) El producto de la reacción contrarrevolucionaria de Europa al ser derrotada la Comuna de París.

b) Es un movimiento político en el que los trabajadores asalariados, se asocian, con fines profesionales o políticos.

c) Es un movimiento que no cuestionaba la industrialización, sino que reclamaba cofradías agrupadas de los trabajadores.

d) Ninguna es cierta.', 'B', 2, 2);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (12, 'En los primeros decenios de la industrialización se produjo una degradación de las condiciones de vida de los trabajadores, y entre ellas se encontraban las siguientes:

a) Aumento de la jornada laboral.

b) Pérdida salarial.

c) Generación del trabajo infantil y femenino.

d) Todas las respuestas son correctas.', 'D', 2, 2);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (13, 'El surgimiento de los modernos Estados nacionales e industrializados como Italia, Alemania y Francia, se produce entre los años:

a) Entre 1800 y 1900.

b) Entre 1850 y 1880.

c) Entre 1750 y 1835.

d) Ninguna es correcta.', 'B', 2, 2);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (14, 'La Asociación Internacional de los Trabajadores o Primera Internacional, fue fundada en:

a) En Londres en 1864.

b) En Francia en 1870.

c) En Italia en 1863.

d) Ninguna es correcta.', 'A', 2, 2);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (15, 'Indica cual de las siguientes afirmaciones se encuentra entre los fines de la Primera Internacional:

a) La agrupación del socialismo científico de Marx y Engels, dando así el fundamento teórico necesario al movimiento.

b) La organización política del proletariado en Europa y el resto del mundo, así como un foro para examinar problemas en común y proponer líneas de acción.

c) Todas son correctas.

d) Ninguna es correcta.', 'B', 2, 2);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (16, 'En 1872 el Consejo General de la AIT se trasladó desde Londres, como producto de la reacción contrarrevolucionaria de Europa. ¿A que Ciudad se traslada tras la derrota?

a) París.

b) Nueva York.

c) Italia.

d) Ninguna es correcta.', 'B', 2, 2);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (17, 'La Segunda Internacional se establece en 1889, de corte socialdemócrata, como la sucesora en sus fines políticos, y durará hasta:

a) 1900.

b) 1915.

c) 1916.

d) Ninguna es correcta.', 'C', 2, 2);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (18, 'Al ser fundada la Segunda Internacional, tuvo lugar la división de la mayor parte del movimiento obrero, debido, entre otros factores, a las diferencias entre:

a) Karl Marx y Engels.

b) Mijaíl Bakunin y Engels.

c) Karl Marx y Mijaíl Bakunin.

d) Ninguna es correcta.', 'C', 2, 2);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (19, 'La Tercera Internacional se funda tras la llegada del comunismo a Rusia en:

a) 1900.

b) 1918.

c) 1917.

d) Ninguna es correcta.', 'B', 2, 2);

INSERT INTO polesp.pregunta (id, pregunta, respuesta, temario_id, examen_id) VALUES (20, 'La Cuarta Internacional (1879-1940) fue establecida en un congreso de delegados en:

a) Perigny (París) el 14 de octubre de 1938.

b) Roma (Italia) el 3 de septiembre de 1938.

c) Perigny (París) el 3 de septiembre de 1938.

d) Ninguna es correcta.', 'C', 2, 2);

