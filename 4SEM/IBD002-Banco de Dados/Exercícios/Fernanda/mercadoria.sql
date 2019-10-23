create database mercadoria;
use mercadoria;

create table tbproduto(
    cod_produto INT PRIMARY KEY,
    nome VARCHAR(30),
    estoque  INT(7),
    preco decimal(7,2),
    genero VARCHAR(10)
)
;