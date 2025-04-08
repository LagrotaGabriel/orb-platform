-- V1__Create_tb_orb_metrics.sql
CREATE TABLE IF NOT EXISTS tb_orb_metrics (
    cod_metrics_mtc UUID PRIMARY KEY,
    ldt_sync_mtc TIMESTAMP NOT NULL,
    dbl_temperature_mtc DOUBLE PRECISION NOT NULL,
    dbl_actualvolume_mtc DOUBLE PRECISION NOT NULL,
    dbl_remainingvolume_mtc DOUBLE PRECISION NOT NULL,
    dbl_batterypercentage_mtc DOUBLE PRECISION NOT NULL,
    bln_closed_mtc BOOLEAN NOT NULL
);