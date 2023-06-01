CREATE TABLE tb_credit (
  id BIGINT AUTO_INCREMENT NOT NULL,
   creditCode UUID NOT NULL,
   creditValue DECIMAL NOT NULL,
   dayFirstInstallment date NOT NULL,
   numberOfInstallments INT NOT NULL,
   status VARCHAR(255),
   customer_id BIGINT,
   CONSTRAINT pk_tb_credit PRIMARY KEY (id)
);

ALTER TABLE tb_credit ADD CONSTRAINT uc_tb_credit_creditcode UNIQUE (creditCode);

ALTER TABLE tb_credit ADD CONSTRAINT FK_TB_CREDIT_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES tb_customer (id);