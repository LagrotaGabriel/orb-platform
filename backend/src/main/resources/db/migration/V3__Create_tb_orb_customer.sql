-- V4__Create_tb_orb_customer.sql
CREATE TABLE IF NOT EXISTS tb_orb_customer (
    cod_customer_cus UUID PRIMARY KEY,
    ldt_creation_cus TIMESTAMP NOT NULL,
    str_name_cus VARCHAR(60) NOT NULL,
    str_email_cus VARCHAR(60) UNIQUE,
    str_password_cus VARCHAR(255) NOT NULL
);