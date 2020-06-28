CREATE DATABASE FreeTech;
USE FreeTech;
CREATE TABLE `Administrador` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `password` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    PRIMARY KEY (`id`)
); CREATE TABLE `Curso` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `descricao` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `dataCriacao` TIMESTAMP NOT NULL,
    `dataAtualizacao` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
); CREATE TABLE `Aula` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `descricao` TEXT(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `linkVideo` VARCHAR(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `transcricaoVideo` TEXT (1000000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `tempoVideo` SMALLINT unsigned NOT NULL,
    PRIMARY KEY (`id`)
); CREATE TABLE `Exercicio` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `questao` TEXT(6500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `alternativaCorreta` TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `alternativaIncorreta1` TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `alternativaIncorreta2` TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `alternativaIncorreta3` TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `alternativaIncorreta4` TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `explicacao` TEXT(6500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `tempoResposta` INT unsigned NOT NULL,
    `pontos` TINYINT unsigned NOT NULL DEFAULT '1',
    PRIMARY KEY (`id`)
); CREATE TABLE `Estudante` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `password` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `nome` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `sobrenome` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `email` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `telefone` VARCHAR(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `dataNascimento` DATE NOT NULL,
    `pontos` SMALLINT unsigned NOT NULL DEFAULT '0',
    `instrutor` BOOLEAN NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
); CREATE TABLE `CursoInstrutor` (
    `idCurso` INT NOT NULL,
    `idInstrutor` INT NOT NULL,
    PRIMARY KEY (`idCurso`, `idInstrutor`),
    CONSTRAINT `fk_idCursoCriado` FOREIGN KEY (`idCurso`) REFERENCES `Curso`(`id`),
    CONSTRAINT `fk_idInstrutor` FOREIGN KEY (`idInstrutor`) REFERENCES `Estudante`(`id`)
); CREATE TABLE `EstudanteCurso` (
    `idEstudante` INT NOT NULL,
    `idCurso` INT NOT NULL,
    `pontos` SMALLINT UNSIGNED NOT NULL,
    `concluido` BOOLEAN NOT NULL DEFAULT '0',
    PRIMARY KEY (`idEstudante`, `idCurso`),
    CONSTRAINT `fk_idEstudanteInscrito` FOREIGN KEY (`idEstudante`) REFERENCES `Estudante`(`id`),
    CONSTRAINT `fk_idCursoInscrito` FOREIGN KEY (`idCurso`) REFERENCES `Curso`(`id`)
); CREATE TABLE `AulaCurso` (
    `aulaId` INT NOT NULL,
    `cursoId` INT NOT NULL,
    `numeroAula` INT NOT NULL,
    CONSTRAINT `fk_aulaId_cursoId` FOREIGN KEY (`aulaId`) REFERENCES `Aula` (`id`),
    CONSTRAINT `fk_cursoId_aulaId` FOREIGN KEY (`cursoId`) REFERENCES `Curso` (`id`)
); CREATE TABLE `ExercicioAula`(
    `exercicioId` INT NOT NULL,
    `aulaId` INT NOT NULL,
    CONSTRAINT `fk_aulaId_exercicioId` FOREIGN KEY (`aulaId`) REFERENCES `Aula` (`id`),
    CONSTRAINT `fk_exercicioId_aulaId` FOREIGN KEY (`exercicioId`) REFERENCES `Exercicio` (`id`)
); CREATE TABLE `EstudanteExercicio`(
    `estudanteId` INT NOT NULL,
    `exercicioId` INT NOT NULL,
    `acertou` BOOLEAN NOT NULL DEFAULT '0',
    CONSTRAINT `fk_estudanteId_exercicioId` FOREIGN KEY (`estudanteId`) REFERENCES `Estudante` (`id`),
    CONSTRAINT `fk_exercicioId_estudanteId` FOREIGN KEY (`exercicioId`) REFERENCES `Exercicio` (`id`)
);