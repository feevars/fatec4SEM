/*criação do banco escola*/
create database escola;

use escola;
create table tabalunos(
   matricula int auto_increment primary key,
   
   nome varchar(30) not null,
   
   sexo char(1) default 'm',
   
   datanasc date,
   
   curso char(3),
   
   nota1 decimal(5,2),
   
   nota2 decimal(5,2)
   );
   
 /*insere dados na tabela*/

insert into tabalunos (nome,datanasc,curso,nota1,nota2) values

('Renato Paiva', '1998-10-10','ADS',6,7),

('Marcelo Guimaraes','1997-10-20', 'SEG', 5,8),

('Alexandre Cardoso', '1998-01-10','ADS', 8, 10),

('Carlos Carvalho','1996-05-20', 'SEG', 6.5, 8.5),

('Paulo Pavanini', '1995-08-15','ADS', 7,9);

insert into tabalunos (nome, sexo,datanasc, curso, nota1, nota2)
values
('Mariana Menezes', 'f','1998-12-25','ADS', 4,8),

('Deise Guimaraes', 'f', '1997-01-25','SEG', 5, 8),

('Ana Luiza Santos', 'f', '1996-05-13','JOG',8,8.5),

('Vera Mendes','f','1997-11-01','COM',6,6.5),

('Juliana Santos', 'f', '1998-08-20','ADS',8,4); 
   
select * from tabalunos; 

/* comandos realizados em aula */

/*INSERIR 2 NOVOS REGISTROS*/
INSERT INTO TABALUNOS (MATRICULA, NOME, CURSO) VALUES 
(null, 'Gilmar Mendes', 'Gestão Empresarial'),

(null, 'Luana Bergas', 'Comércio Exterior');

/* INCLUIR UM REGISTRO 'INTO TABALUNOS COM VALUES'*/
INSERT INTO TABALUNOS (NOME, SEXO, DATANASC, NOTA1) VALUES ('Marta Souza', 'f', 
                                                            '200-01-10', '9.0');

/*INCLUIR 1 REGISTRO INTO 'TABALUNOS COM SETS'*/
INSERT INTO TABALUNOS SET NOME = 'Erica Mendes',SEXO='f';
INSERT INTO TABALUNOS SET NOME='Deise Carvalho',SEXO='f';

/* ALTERAR NOTA1 PARA 10.0 E DATA DE NASCIMENTO = '1998-10-10'*/

UPDATE TABALUNOS SET NOTA1 = '10.0' AND DATANASC = '1998-10-10';


