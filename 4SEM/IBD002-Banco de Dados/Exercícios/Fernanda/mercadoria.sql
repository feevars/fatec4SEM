create database mercadoria;
use mercadoria;

create table tbproduto(
    cod_produto INT PRIMARY KEY,
    nome VARCHAR(30),
    estoque  INT(7),
    preco decimal(7,2),
    genero VARCHAR(10)
)

create table tabaluno{
    matricula int,

}

/*
!!!!preciso arrumar o meu mySQL!!!!



>>>>>>>>>>>>>>>>>>>PRIMEIRA PARTE DA AULA - TEORIA<<<<<<<<<<<<<<<<<<<<<<<<



COMANDOS DML -  insert, update, delete (MANIPULAÇÃO), select

-------------"INSERT"------------- 

INSERT INTO <nome_tabela> (<lisa de colunas>) VALUES (<lista de valores>) 
INSERT INTO tabaluno (matricula, nome, sobrenome) VALUES (14, 'Maria', 'Rios') 
INSERT INTO tabaluno SET matricula=20, nome='Marta', sobrenome='Mendonça', sexo='f'

-------------"UPDATE"-------------
UPDATE <nome_tabela> SET <coluna> = <novo_valor>, [<coluna2>=<valor2>]...
[WHERE <condição>]

UPDATE tabaluno SET nota=7.0
WHERE matricula=14;

UPDATE TABEMPREGADO SET nota = nota+0.5
WHERE nota<6;

-------------"DELETE"-------------
delete - funcionário q nao existe mais, por exemplo

DELETE FROM <nome_tabela> WHERE <condição>

DELETE FROM tabaluno WHERE matricula=20
DELETE FROM inativos WHERE datademissao < '1970-01-01'

***campo date: ano-mes-dia


rollpack - copiar antes de excluir
commit - 

-------------"SELECT"-------------
select - seleciona os campos com restrições condicionais
SELECT nome FROM tabpessoas WHERE idade > 18
                            AND salario < 1000
                            AND sexo = 'F'

SELECT nome, idade, salario FROM tabpessoas WHERE nome = 'Maria' AND idade >30 AND salario <8000

SELECT * FROM = seleciona todas as colunas da tabela

SELECT nome, qtdd, preco, qtdd*preco AS Total FROM tabproduto

DISTINCT - grupo de colunas com o mesmo conteúdo, tipo os cursos da fatec zl

ORDER BY (ordena alfabetica, ascendente ou descendente)

>>>>>>>>>>>>>>>>>>>SEGUNDA PARTE DA AULA - PRÁTICA<<<<<<<<<<<<<<<<<<<<<<<<

*/


;

