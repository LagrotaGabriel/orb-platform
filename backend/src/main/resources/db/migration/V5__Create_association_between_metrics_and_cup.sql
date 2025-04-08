-- Tabela de associação entre cliente e copo (join table)
CREATE TABLE tb_orb_cup_metrics (
    cod_cup_cup UUID NOT NULL,
    cod_metrics_mtc UUID NOT NULL,
    PRIMARY KEY (cod_cup_cup, cod_metrics_mtc),
    CONSTRAINT fk_cup FOREIGN KEY (cod_cup_cup)
        REFERENCES tb_orb_cup (cod_cup_cup)
        ON DELETE CASCADE,
    CONSTRAINT fk_metrics FOREIGN KEY (cod_metrics_mtc)
        REFERENCES tb_orb_metrics (cod_metrics_mtc)
        ON DELETE CASCADE
);