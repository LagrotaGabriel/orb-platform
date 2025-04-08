-- V2__Create_tb_orb_cup.sql
CREATE TABLE IF NOT EXISTS tb_orb_cup (
    cod_cup_cup UUID PRIMARY KEY,
    ldt_creation_cup TIMESTAMP NOT NULL,
    ldt_update_cup TIMESTAMP NOT NULL,
    bln_activated_cup BOOLEAN NOT NULL,
    enm_model_cup VARCHAR(255) NOT NULL,
    enm_color_cup VARCHAR(255) NOT NULL
);