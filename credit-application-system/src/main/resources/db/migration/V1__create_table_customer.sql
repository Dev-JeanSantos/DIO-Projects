CREATE TABLE tb_customer (
  id BIGINT AUTO_INCREMENT NOT NULL,
   firstName VARCHAR(255) NOT NULL,
   lastName VARCHAR(255) NOT NULL,
   cpf VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   zipCode VARCHAR(255) NOT NULL,
   street VARCHAR(255) NOT NULL,
   CONSTRAINT pk_tb_customer PRIMARY KEY (id)
);

ALTER TABLE tb_customer ADD CONSTRAINT uc_tb_customer_cpf UNIQUE (cpf);

ALTER TABLE tb_customer ADD CONSTRAINT uc_tb_customer_email UNIQUE (email);