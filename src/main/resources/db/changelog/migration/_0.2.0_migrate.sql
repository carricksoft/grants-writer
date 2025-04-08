-- liquibase formatted sql
-- changeset zuhaimi:1677359720411-3
CREATE TABLE `department` (
    id BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT `departmentP` PRIMARY KEY (id)
);

