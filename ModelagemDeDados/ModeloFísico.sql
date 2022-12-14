/* Físico_SiteViagens: */

CREATE DATABASE agenciaViagens;

USE agenciaViagens;

CREATE TABLE pacotesViagens (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    destino VARCHAR(50) NOT NULL,
    hospedagem VARCHAR(50) NOT NULL,
    diarias VARCHAR(20) NOT NULL,
    preco DECIMAL(10,2) NOT NULL
);

CREATE TABLE promocao (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nomePromocao VARCHAR(50) NOT NULL,
    tipoPromocao VARCHAR(50) NOT NULL,
    desconto DECIMAL(3,2) NOT NULL,
    fk_pacotesViagens_id INT NOT NULL
);
 
ALTER TABLE promocao ADD CONSTRAINT FK_promocao_pacote
    FOREIGN KEY (fk_pacotesViagens_id)
    REFERENCES pacotesViagens (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE;
