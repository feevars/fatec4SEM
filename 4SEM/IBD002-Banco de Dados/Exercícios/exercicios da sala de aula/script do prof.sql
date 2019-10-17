create database MERCADORIA;


create table TBPRODUTO (
CODIGO int primary key,
NOME varchar(30),
PRECO decimal (7,2),
GENERO varchar(10)
);

desc tbproduto;


create table QGdoBruninho(
ID_programador int primary key auto_increment,
nome_programador varchar (30),
usa_maconha varchar (90) default 'sim',
complete_sinsalabin varchar (90) default 'mostra as teta pra mim',
sexo varchar (90) default 'faz sim');

insert into qgdobruninho values 
(1, 'Luiz', 'fala que não usa mas usa escondido', 'manda uns nude pra mim', 'gosta'),
(2, 'Brunin', 'seria melhor perguntar quando ele NÃO usa', 'manda jobs pra mim (enquanto to dormindo)', 'só nas horas vagas'),
(3,'Fernandete', 'só se for natural', 'foda-se o bolsonaro pra mim', 'feminino'),
(4,'Robinho', 'sempre teve muita curiosidade mas é cagão', 'manda umas viage pra mim', 'pratica celibato'); 

select * from qgdobruninho;

select nome_programador, usa_maconha from qgdobruninho;

drop table qgdobruninho;

update qgdobruninho set usa_maconha = 'com bastante frequencia' where id_programador = 2;

update qgdobruninho set complete_sinsalabin = 'Manda piadas pra mim' where id_programador = 1;

select nome_programador as 'nome do cabrunco' from qgdobruninho;


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

select nome, (nota1 + nota2 / 2) from tabalunos;

select nome, (nota1 + nota2 / 2) as MÉDIA from tabalunos;

insert into tabalunos (matricula, nome, curso) values (null, 'gilberto', 'ads');

insert into tabalunos (nome, sexo, datanasc, nota1) values ('marta souza', 'f', '2000-01-10', 9.0);

insert into tabalunos set nome='erica mendes', sexo = 'f';
insert into tabalunos set nome='deise carvalho', sexo = 'f';

update tabalunos set nota1 = 10.0, datanasc='1998-10-10' where matricula = 1;

update tabalunos set nota1 = nota1+0.5 where nota2<5.0;

delete from tabalunos where matricula=13;

