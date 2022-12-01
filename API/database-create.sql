CREATE DATABASE CODE_CHALLENGE;
USE CODE_CHALLENGE;

DROP TABLE INSUMO;
CREATE TABLE INSUMO(
	id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255),
    gender CHAR(1),
    type VARCHAR(255),
    nationality VARCHAR(255),
    region VARCHAR(255),
    dateOfBirth Date,
    registeredDate Date,
    primary key (id)
);

SELECT * FROM INSUMO;