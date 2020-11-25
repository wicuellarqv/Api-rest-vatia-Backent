CREATE TABLE FUENTE (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    NOMBRE VARCHAR(255) NOT NULL,
    ESTADO CHAR(1)
);

INSERT INTO FUENTE (NOMBRE, ESTADO) VALUES ('BANCO DE LA REPÚBLICA', 'A'),('BANCOLOMBIA', 'A');


CREATE TABLE USUARIO (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    NOMBRE VARCHAR(255) NOT NULL,
    CORREO VARCHAR(100),
    CLAVE VARCHAR(100),
);

INSERT INTO USUARIO (NOMBRE,CORREO,CLAVE) VALUES ('JUAN CARLOS MORENO','JUANMORENO@VATIA.COM.CO','ADMIN');

CREATE TABLE IPC (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    INDICE NUMERIC(6,2) NOT NULL,
    ANIO INT NOT NULL,
    MES1 NUMERIC(4,2),
    MES2 NUMERIC(4,2),
    MES3 NUMERIC(4,2),
    MES4 NUMERIC(4,2),
    MES5 NUMERIC(4,2),
    MES6 NUMERIC(4,2),
    MES7 NUMERIC(4,2),
    MES8 NUMERIC(4,2),
    MES9 NUMERIC(4,2),
    MES10 NUMERIC(4,2),
    MES11 NUMERIC(4,2),
    MES12 NUMERIC(4,2),
    FUENTE INT
    CONSTRAINT IPC_ANIO UNIQUE (ANIO)
);

CREATE TABLE LOGIPC (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    ID_IPC INT FOREIGN KEY REFERENCES IPC(ID) NOT NULL,
    ID_USUARIO INT FOREIGN KEY REFERENCES USUARIO(ID) NOT NULL,
    FECHA DATE,
    HORA TIME,
    OPERACION VARCHAR(30),
    MENSAJE VARCHAR,
);

ALTER TABLE LOGIPC ADD CONSTRAINT DF_FECCHA DEFAULT 'CURRENT_DATE' FOR FECHA;
ALTER TABLE LOGIPC ADD CONSTRAINT DF_HORA DEFAULT 'CURRENT_TIMESTAMP' FOR HORA;

CREATE TABLE HISIPC (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    FECHA DATE,
    HORA TIME,
    ID_IPC INT FOREIGN KEY REFERENCES IPC(ID) NOT NULL,
    INDICE NUMERIC(6,2) NOT NULL,
    ANIO INT NOT NULL,
    MES1 NUMERIC(4,2),
    MES2 NUMERIC(4,2),
    MES3 NUMERIC(4,2),
    MES4 NUMERIC(4,2),
    MES5 NUMERIC(4,2),
    MES6 NUMERIC(4,2),
    MES7 NUMERIC(4,2),
    MES8 NUMERIC(4,2),
    MES9 NUMERIC(4,2),
    MES10 NUMERIC(4,2),
    MES11 NUMERIC(4,2),
    MES12 NUMERIC(4,2),
    FUENTE INT
);

ALTER TABLE HISIPC ADD CONSTRAINT HISIPC_DF_FECCHA DEFAULT 'CURRENT_DATE' FOR FECHA;
ALTER TABLE HISIPC ADD CONSTRAINT HISIPC_DF_HORA DEFAULT 'CURRENT_TIMESTAMP' FOR HORA;



CREATE TABLE IPP (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    INDICE NUMERIC(6,2) NOT NULL,
    ANIO INT NOT NULL,
    MES1 NUMERIC(4,2),
    MES2 NUMERIC(4,2),
    MES3 NUMERIC(4,2),
    MES4 NUMERIC(4,2),
    MES5 NUMERIC(4,2),
    MES6 NUMERIC(4,2),
    MES7 NUMERIC(4,2),
    MES8 NUMERIC(4,2),
    MES9 NUMERIC(4,2),
    MES10 NUMERIC(4,2),
    MES11 NUMERIC(4,2),
    MES12 NUMERIC(4,2),
    FUENTE INT
    CONSTRAINT IPP_ANIO UNIQUE (ANIO)
);

CREATE TABLE LOGIPP (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    ID_IPP INT FOREIGN KEY REFERENCES IPP(ID) NOT NULL,
    ID_USUARIO INT FOREIGN KEY REFERENCES USUARIO(ID) NOT NULL,
    FECHA DATE,
    HORA TIME,
    OPERACION VARCHAR(30),
    MENSAJE VARCHAR,
);

ALTER TABLE LOGIPP ADD CONSTRAINT IPP_DF_FECCHA DEFAULT 'CURRENT_DATE' FOR FECHA;
ALTER TABLE LOGIPP ADD CONSTRAINT IPP_DF_HORA DEFAULT 'CURRENT_TIMESTAMP' FOR HORA;

CREATE TABLE HISIPP (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    FECHA DATE,
    HORA TIME,
    ID_IPP INT FOREIGN KEY REFERENCES IPP(ID) NOT NULL,
    INDICE NUMERIC(6,2) NOT NULL,
    ANIO INT NOT NULL,
    MES1 NUMERIC(4,2),
    MES2 NUMERIC(4,2),
    MES3 NUMERIC(4,2),
    MES4 NUMERIC(4,2),
    MES5 NUMERIC(4,2),
    MES6 NUMERIC(4,2),
    MES7 NUMERIC(4,2),
    MES8 NUMERIC(4,2),
    MES9 NUMERIC(4,2),
    MES10 NUMERIC(4,2),
    MES11 NUMERIC(4,2),
    MES12 NUMERIC(4,2),
    FUENTE INT
);

ALTER TABLE HISIPP ADD CONSTRAINT HISIPP_DF_FECCHA DEFAULT 'CURRENT_DATE' FOR FECHA;
ALTER TABLE HISIPP ADD CONSTRAINT HISIPP_DF_HORA DEFAULT 'CURRENT_TIMESTAMP' FOR HORA;