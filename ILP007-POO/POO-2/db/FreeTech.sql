CREATE DATABASE FreeTech;
USE FreeTech;
CREATE TABLE `Administrador` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `password` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
);
CREATE TABLE `Curso` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `titulo` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `descricao` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `dataCriacao` TIMESTAMP NOT NULL,
    `dataAtualizacao` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE `Aula` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `titulo` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `descricao` TEXT(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `linkVideo` VARCHAR(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `transcricaoVideo` TEXT (1000000) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    `tempoVideo` SMALLINT unsigned NOT NULL,
    `numeroAula` INT NOT NULL,
    `cursoId` INT NOT NULL,
    CONSTRAINT `fk_cursoId_aulaId` FOREIGN KEY (`cursoId`) REFERENCES `Curso` (`id`)
);
CREATE TABLE `Exercicio` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
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
    `aulaId` INT NOT NULL,
    CONSTRAINT `fk_exercicio_aulaId` FOREIGN KEY (`aulaId`) REFERENCES `Aula`(`id`)
);
CREATE TABLE `Estudante` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    `username` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `password` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `nome` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    `sobrenome` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    `email` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
    `telefone` VARCHAR(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    `dataNascimento` DATE,
    `pontos` SMALLINT unsigned NOT NULL DEFAULT '0',
    `instrutor` BOOLEAN NOT NULL DEFAULT '0'
); CREATE TABLE `CursoInstrutor` (
    `cursoId` INT NOT NULL,
    `instrutorId` INT NOT NULL,
    CONSTRAINT `fk_cursoId_instrutorId` FOREIGN KEY (`cursoId`) REFERENCES `Curso`(`id`),
    CONSTRAINT `fk_instrutorId_cursoId` FOREIGN KEY (`instrutorId`) REFERENCES `Estudante`(`id`)
);
CREATE TABLE `EstudanteCurso` (
    `estudanteId` INT NOT NULL,
    `cursoId` INT NOT NULL,
    `pontos` SMALLINT UNSIGNED NOT NULL DEFAULT '0',
    `concluido` BOOLEAN NOT NULL DEFAULT '0',
    CONSTRAINT `fk_estudanteId_cursoId` FOREIGN KEY (`estudanteId`) REFERENCES `Estudante`(`id`),
    CONSTRAINT `fk_cursoId_estudanteId` FOREIGN KEY (`cursoId`) REFERENCES `Curso`(`id`)
);
CREATE TABLE `EstudanteExercicio`(
    `estudanteId` INT NOT NULL,
    `exercicioId` INT NOT NULL,
    `acertou` BOOLEAN NOT NULL DEFAULT '0',
    CONSTRAINT `fk_estudanteId_exercicioId` FOREIGN KEY (`estudanteId`) REFERENCES `Estudante` (`id`),
    CONSTRAINT `fk_exercicioId_estudanteId` FOREIGN KEY (`exercicioId`) REFERENCES `Exercicio` (`id`)
);