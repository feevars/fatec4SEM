/*CREATE DATABASE ESCOLA;
USE ESCOLA;
CREATE TABLE TABALUNOS(
	MATRICULA INT AUTO_INCREMENT PRIMARY KEY,
    NOME VARCHAR(30) NOT NULL,
    SEXO CHAR(1) DEFAULT 'M',
    DATANASC DATE,
    CURSO CHAR(3),
    NOTA1 DECIMAL(5,2),
    NOTA2 DECIMAL(5,2)
    );
    SELECT * FROM TABALUNOS;
    INSERT INTO TABALUNOS (NOME, DATANASC, CURSO, NOTA1, NOTA2) VALUES
    ('Renato Paiva', '1998-10-10', 'ADS', 6, 7),
    ('Marcelo Guimaraes','1997-10-20', 'SEG', 5,8),
	('Alexandre Cardoso', '1998-01-10','ADS', 8, 10),
	('Carlos Carvalho','1996-05-20', 'SEG', 6.5, 8.5),
	('Paulo Pavanini', '1995-08-15','ADS', 7,9);
    INSERT INTO TABALUNOS (NOME, SEXO, DATANASC, CURSO, NOTA1, NOTA2) VALUES
    ('Mariana Menezes', 'f','1998-12-25','ADS', 4,8),
	('Deise Guimaraes', 'f', '1997-01-25','SEG', 5, 8),
	('Ana Luiza Santos', 'f', '1996-05-13','JOG',8,8.5),
	('Vera Mendes','f','1997-11-01','COM',6,6.5),
	('Juliana Santos', 'f', '1998-08-20','ADS',8,4); 
    SELECT * FROM TABALUNOS;

-----------------INSERIR 2 REGISTROS NOVOS
  
	INSERT INTO TABALUNOS (MATRICULA,NOME,CURSO) VALUES    
    (NULL,'Gilberto','ADS');
    SELECT NOME FROM TABALUNOS WHERE NOME = 'Gilberto';
	SELECT * FROM TABALUNOS;
    INSERT INTO TABALUNOS (NOME, CURSO, NOTA1) VALUES
    ('Fernandinha', 'ADS', '10.0');
    SELECT * FROM TABALUNOS;
    
----------------INCLUIR 1 REGISTRO  INTO 'TABALUNOS COM SETS' 

  INSERT INTO TABALUNOS SET NOME='Erica Mendes',SEXO='F';
  INSERT INTO TABALUNOS SET NOME='DEISE CARVALHO',SEXO='F';
  SELECT * FROM TABALUNOS; 
  DELETE FROM TABALUNOS WHERE NOME = 'DEISE CARVALHO';

----------------
*/
