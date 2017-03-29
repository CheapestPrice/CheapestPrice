-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-03-20 17:39:57.026

-- tables
-- Table: HORARIOS
CREATE TABLE HORARIOS (
    horaInicio int NOT NULL,
    horaFin int NOT NULL,
    minutosInicio int NOT NULL,
    minutosFin int NOT NULL,
    TIENDAS_x double(100,10) NOT NULL,
    TIENDAS_y double(100,10) NOT NULL,
    TIENDAS_nit varchar(100) NOT NULL,
    dia varchar(50) NOT NULL,
    CHECK (horaInicio>=0 AND horaInicio<=23),
    CHECK (horaFin>=0 AND horaFin<=23),
    CHECK (minutosInicio>=0 AND minutosInicio<=59),
    CHECK (minutosFin>=0 AND minutosFin<=59),
    CHECK (dia IN ('Lunes','Martes','Miercoles','Jueves','Viernes','Sabado','Domingo')),
    CHECK ((horaFin > hotaInicio) or (horaFin=horaInicio and minutosFin>minutosInicio)),
    CONSTRAINT HORARIOS_pk PRIMARY KEY (TIENDAS_x,TIENDAS_y,TIENDAS_nit,dia)
);

-- Table: ITEMS
CREATE TABLE ITEMS (
    PRODUCTOS_id bigint NOT NULL,
    TIENDAS_x double(100,10) NOT NULL,
    TIENDAS_y double(100,10) NOT NULL,
    TIENDAS_nit varchar(100) NOT NULL,
    precio bigint NOT NULL,
    CHECK (precio>0),
    CONSTRAINT ITEMS_pk PRIMARY KEY (PRODUCTOS_id,TIENDAS_x,TIENDAS_y,TIENDAS_nit)
);

-- Table: ITEMS_LISTA
CREATE TABLE ITEMS_LISTA (
    comprado bool NOT NULL,
    favorito bool NOT NULL,
    ITEMS_PRODUCTOS_id bigint NOT NULL,
    ITEMS_TIENDAS_x double(100,10) NOT NULL,
    ITEMS_TIENDAS_y double(100,10) NOT NULL,
    ITEMS_TIENDAS_nit varchar(100) NOT NULL,
    LISTAS_MERCADOS_nombre varchar(100) NOT NULL,
    LISTAS_MERCADOS_USUARIOS_correo varchar(100) NOT NULL,
    CONSTRAINT ITEMS_LISTA_pk PRIMARY KEY (ITEMS_PRODUCTOS_id,ITEMS_TIENDAS_x,ITEMS_TIENDAS_y,ITEMS_TIENDAS_nit,LISTAS_MERCADOS_nombre,LISTAS_MERCADOS_USUARIOS_correo)
);

-- Table: LISTAS_MERCADOS
CREATE TABLE LISTAS_MERCADOS (
    nombre varchar(100) NOT NULL,
    fechaCreacion timestamp NOT NULL,
    realizado bool NOT NULL,
    USUARIOS_correo varchar(100) NOT NULL,
    CONSTRAINT LISTAS_MERCADOS_pk PRIMARY KEY (nombre,USUARIOS_correo)
);

-- Table: OPINIONES
CREATE TABLE OPINIONES (
    id int NOT NULL AUTO_INCREMENT,
    comentario varchar(100) NOT NULL,
    gusta bool NOT NULL,
    fecha timestamp NOT NULL,
    USUARIOS_correo varchar(100) NOT NULL,
    TIENDAS_x double(100,10) NOT NULL,
    TIENDAS_y double(100,10) NOT NULL,
    TIENDAS_nit varchar(100) NOT NULL,
    CONSTRAINT OPINIONES_pk PRIMARY KEY (id)
);

-- Table: PRODUCTOS
CREATE TABLE PRODUCTOS (
    nombre varchar(100) NOT NULL,
    id bigint NOT NULL AUTO_INCREMENT,
    marca varchar(100) NOT NULL,
    imagen blob NULL,
    categoria varchar(100) NOT NULL,
    CONSTRAINT PRODUCTOS_pk PRIMARY KEY (id)
);

-- Table: TENDEROS
CREATE TABLE TENDEROS (
    USUARIOS_correo varchar(100) NOT NULL,
    TIENDAS_x double(100,10) NOT NULL,
    TIENDAS_y double(100,10) NOT NULL,
    TIENDAS_nit varchar(100) NOT NULL,
    nombre varchar(100) NOT NULL,
    CONSTRAINT TENDEROS_pk PRIMARY KEY (USUARIOS_correo)
);

-- Table: TIENDAS
CREATE TABLE TIENDAS (
    direccion varchar(100) NOT NULL,
    x double(100,10) NOT NULL,
    y double(100,10) NOT NULL,
    nombre varchar(100) NOT NULL,
    nit varchar(100) NOT NULL,
    telefono varchar(100) NOT NULL,
    disponible bool NOT NULL,
    logo blob NULL,
    CONSTRAINT TIENDAS_pk PRIMARY KEY (x,y,nit)
);

-- Table: USUARIOS
CREATE TABLE USUARIOS (
    correo varchar(100) NOT NULL,
    nombre varchar(100) NOT NULL,
    CONSTRAINT USUARIOS_pk PRIMARY KEY (correo)
);

-- Table: USUARIOS_AUTENTICACION
CREATE TABLE USUARIOS_AUTENTICACION (
    USUARIOS_correo varchar(100) NOT NULL,
    hash varchar(70) NOT NULL,
    habilitado bool NOT NULL,
    CONSTRAINT USUARIOS_AUTENTICACION_pk PRIMARY KEY (USUARIOS_correo)
);


-- foreign keys
-- Reference: HORARIOS_TIENDAS (table: HORARIOS)
ALTER TABLE HORARIOS ADD CONSTRAINT HORARIOS_TIENDAS FOREIGN KEY HORARIOS_TIENDAS (TIENDAS_x,TIENDAS_y,TIENDAS_nit)
    REFERENCES TIENDAS (x,y,nit);

-- Reference: ITEMS_LISTA_ITEMS (table: ITEMS_LISTA)
ALTER TABLE ITEMS_LISTA ADD CONSTRAINT ITEMS_LISTA_ITEMS FOREIGN KEY ITEMS_LISTA_ITEMS (ITEMS_PRODUCTOS_id,ITEMS_TIENDAS_x,ITEMS_TIENDAS_y,ITEMS_TIENDAS_nit)
    REFERENCES ITEMS (PRODUCTOS_id,TIENDAS_x,TIENDAS_y,TIENDAS_nit);

-- Reference: ITEMS_LISTA_LISTAS_MERCADOS (table: ITEMS_LISTA)
ALTER TABLE ITEMS_LISTA ADD CONSTRAINT ITEMS_LISTA_LISTAS_MERCADOS FOREIGN KEY ITEMS_LISTA_LISTAS_MERCADOS (LISTAS_MERCADOS_nombre,LISTAS_MERCADOS_USUARIOS_correo)
    REFERENCES LISTAS_MERCADOS (nombre,USUARIOS_correo);

-- Reference: ITEMS_PRODUCTOS (table: ITEMS)
ALTER TABLE ITEMS ADD CONSTRAINT ITEMS_PRODUCTOS FOREIGN KEY ITEMS_PRODUCTOS (PRODUCTOS_id)
    REFERENCES PRODUCTOS (id);

-- Reference: ITEMS_TIENDAS (table: ITEMS)
ALTER TABLE ITEMS ADD CONSTRAINT ITEMS_TIENDAS FOREIGN KEY ITEMS_TIENDAS (TIENDAS_x,TIENDAS_y,TIENDAS_nit)
    REFERENCES TIENDAS (x,y,nit);

-- Reference: LISTAS_MERCADOS_USUARIOS (table: LISTAS_MERCADOS)
ALTER TABLE LISTAS_MERCADOS ADD CONSTRAINT LISTAS_MERCADOS_USUARIOS FOREIGN KEY LISTAS_MERCADOS_USUARIOS (USUARIOS_correo)
    REFERENCES USUARIOS (correo);

-- Reference: OPINIONES_TIENDAS (table: OPINIONES)
ALTER TABLE OPINIONES ADD CONSTRAINT OPINIONES_TIENDAS FOREIGN KEY OPINIONES_TIENDAS (TIENDAS_x,TIENDAS_y,TIENDAS_nit)
    REFERENCES TIENDAS (x,y,nit);

-- Reference: OPINIONES_USUARIOS (table: OPINIONES)
ALTER TABLE OPINIONES ADD CONSTRAINT OPINIONES_USUARIOS FOREIGN KEY OPINIONES_USUARIOS (USUARIOS_correo)
    REFERENCES USUARIOS (correo);

-- Reference: TENDEROS_TIENDAS (table: TENDEROS)
ALTER TABLE TENDEROS ADD CONSTRAINT TENDEROS_TIENDAS FOREIGN KEY TENDEROS_TIENDAS (TIENDAS_x,TIENDAS_y,TIENDAS_nit)
    REFERENCES TIENDAS (x,y,nit);

-- Reference: USUARIOS_AUTENTICACION_USUARIOS (table: USUARIOS_AUTENTICACION)
ALTER TABLE USUARIOS_AUTENTICACION ADD CONSTRAINT USUARIOS_AUTENTICACION_USUARIOS FOREIGN KEY USUARIOS_AUTENTICACION_USUARIOS (USUARIOS_correo)
    REFERENCES USUARIOS (correo);

-- Reference: USUARIOS_TENDEROS (table: TENDEROS)
ALTER TABLE TENDEROS ADD CONSTRAINT USUARIOS_TENDEROS FOREIGN KEY USUARIOS_TENDEROS (USUARIOS_correo)
    REFERENCES USUARIOS (correo);

-- End of file.

