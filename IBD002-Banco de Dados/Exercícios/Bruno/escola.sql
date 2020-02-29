    CREATE DATABASE Escola;

    USE Escola;

    CREATE TABLE Alunos(
        matricula INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(30) NOT NULL,
        sexo CHAR(1) DEFAULT 'M',
        dataNasc DATE,
        curso CHAR(3),
        nota1 DECIMAL(5,2),
        nota2 DECIMAL(5,2)
    );

    INSERT INTO Alunos (nome, dataNasc, curso, nota1, nota2) VALUES
        ('Bruno Harnik', '1987-03-06', 'ADS', 6, 7),
        ('Fernanda Pinheiro Reis', '1998-06-24', 'ADS', 10, 9.6),
        ('Robson Ferreira', '1990-10-10', 'ADS', 8.5, 9),
        ('Luiz Fernando Geraldo', '1992-05-25', 'ADS', 6.2, 9.8),
        ('Ananias Falcão', '1923-12-29', 'Pirotecnia', 2.4, 2.1);
        

