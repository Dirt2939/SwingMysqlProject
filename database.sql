-- Criação do banco de dados
CREATE DATABASE bdpoo;
USE bdpoo;

-- Criação da tabela de usuários
CREATE TABLE tbusuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    senha VARCHAR(50),
    sexo VARCHAR(20),
    fone VARCHAR(20)
);

-- Inserção de um usuário padrão (Opcional)
INSERT INTO tbusuario (nome, email, senha, sexo, fone) 
VALUES ('Administrador', 'admin@admin.com', '1234', 'Masculino', '51999999999')