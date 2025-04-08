-- Tabela de associação entre cliente e copo (join table)
CREATE TABLE tb_orb_customer_cups (
    cod_customer_cus UUID NOT NULL,
    cod_cup_cup UUID NOT NULL,
    PRIMARY KEY (cod_customer_cus, cod_cup_cup),
    CONSTRAINT fk_customer FOREIGN KEY (cod_customer_cus)
        REFERENCES tb_orb_customer (cod_customer_cus)
        ON DELETE CASCADE,
    CONSTRAINT fk_cup FOREIGN KEY (cod_cup_cup)
        REFERENCES tb_orb_cup (cod_cup_cup)
        ON DELETE CASCADE
);