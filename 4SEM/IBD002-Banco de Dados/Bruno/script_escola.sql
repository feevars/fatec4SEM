CREATE DATABASE Escola;

USE Escola;

CREATE TABLE Aluno (
	matricula int auto_increment primary key unique,
    nome varchar(30) not null,
    sexo char(1) default 'm',
    dataNasc date,
    curso char(3),
    nota1 decimal(4,2),
    nota2 decimal(4,2)
);

INSERT INTO Aluno (nome, sexo, dataNasc, curso, nota1, nota2) values
	('Bruno Harnik', 'm', '1987-06-03', 'ADS', 9.5, 8.75),
    ('Fernanda Pinheiro Reis', 'f', '1998-06-24', 'ADS', 9.25, 9.8),
    ('Renato Cunha', 'm', '1983-02-12', 'LOG', 5.2, 4.1),
    ('Paula Mendonça', 'f', '1994-03-23', 'GES', 2.1, 4.3),
    ('Renato Paiva', 'm', '1998-10-10','ADS',6,7),
	('Marcelo Guimaraes', 'm', '1997-10-20', 'SEG', 5,8),
	('Alexandre Cardoso', 'm', '1998-01-10','ADS', 8, 10),
	('Carlos Carvalho', 'm', '1996-05-20', 'SEG', 6.5, 8.5),
	('Paulo Pavanini', 'm', '1995-08-15','ADS', 7,9),
	('Mariana Menezes', 'f','1998-12-25','ADS', 4,8),
    ('Deise Guimaraes', 'f', '1997-01-25','SEG', 5, 8),
	('Ana Luiza Santos', 'f', '1996-05-13','JOG',8,8.5),
    ('Vera Mendes','f','1997-11-01','COM',6,6.5),
	('Juliana Santos', 'f', '1998-08-20','ADS',8,4); 