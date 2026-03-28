CREATE DATABASE IF NOT EXISTS meu_trabalho;
USE meu_trabalho;

CREATE TABLE IF NOT EXISTS funcionario (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    sobrenome VARCHAR(50),
    idade INT,
    salario DOUBLE
);