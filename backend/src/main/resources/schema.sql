CREATE TABLE usuario (
    id INT PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
);

CREATE TABLE plano (
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    valor DECIMAL(10, 2) NOT NULL
);

CREATE TABLE beneficiario (
    id INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    plano_id INT,
    FOREIGN KEY (plano_id) REFERENCES plano (id)
);