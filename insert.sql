LOCK TABLES `USUARIOS` WRITE;
INSERT INTO `USUARIOS` (`nombre`,`correo`) VALUES
	('admin','admin@cheapestprice.com'),
	('usuario1','prueba@prueba.com'),
	('tendero1','tendero@tendero.com'),
	('usuario2','prueba2@prueba.com'),
	('tendero2','tendero2@tendero.com'),
	('usuario3','prueba3@prueba.com'),
	('tendero3','tendero3@tendero.com');

LOCK TABLES `TIENDAS` WRITE;
INSERT INTO `TIENDAS` (`direccion`,`x`,`y`,`nombre`,`nit`,`telefono`,`disponible`,`logo`) VALUES
	('Cra. 54d #186-78 a 186-98',4.7649271,-74.0476042,'Donde Pepe','1234567-2','5473829',true,null),
	('Cl. 209 #45-62 a 45-98',4.788479, -74.045011,'Donde Juan','1232567-2','1234567',true,null),
	('La Caro #197-2 a 197-54',4.775933, -74.041923,'Donde Carlos','1295567-2','1234567',true,null);

LOCK TABLES `TENDEROS` WRITE;
INSERT INTO `TENDEROS` (`USUARIOS_id`,`nombre`,`TIENDAS_id`) VALUES
	(3,'tendero1',1),
	(5,'tendero2',3),
	(7,'tendero3',2);

LOCK TABLES `HORARIOS` WRITE;
INSERT INTO `HORARIOS` (`horaInicio`,`horaFin`,`minutosInicio`,`minutosFin`,`TIENDAS_id`,`dia`) VALUES
	(7,19,0,0,1,'Lunes'),
	(7,19,0,0,1,'Jueves'),
	(7,19,0,0,3,'Lunes'),
	(7,19,0,0,3,'Martes'),
	(7,19,0,0,3,'Miércoles'),
	(7,19,0,0,3,'Jueves'),
	(7,19,0,0,3,'Viernes'),
	(7,19,0,0,2,'Lunes'),
	(7,19,0,0,2,'Martes'),
	(7,19,0,0,2,'Miércoles'),
	(7,19,0,0,2,'Jueves'),
	(7,19,0,0,2,'Viernes');

LOCK TABLES `PRODUCTOS` WRITE;
INSERT INTO `PRODUCTOS` (`nombre`,`id`,`marca`,`imagen`,`categoria`) VALUES
	('Leche',1,'Alpina',null,'Lacteos'),
	('Papas BBQ',2,'Margarita',null,'Pasabocas'),
	('Gelatina Fresa',3,'Gelhada',null,'Postre'),
	('Queso Pera',4,'Colanta',null,'Lacteos'),
	('Nutella',5,'Nutella',null,'Lacteos'),
	('Leche Condensada',6,'Lecherita',null,'Lacteos'),
	('Papas Pollo',7,'Margarita',null,'Pasabocas'),
	('Gelatina Mora',8,'Gelhada',null,'Postre'),
	('Queso de Untar',9,'Colanta',null,'Lacteos');

LOCK TABLES `ITEMS` WRITE;
INSERT INTO `ITEMS`    (`PRODUCTOS_id`,`TIENDAS_id`,`precio`) VALUES
	(1,1,3000),
	(2,1,2500),
	(3,1,4000),
	(4,1,500),
	(1,3,3000),
	(2,3,2500),
	(3,3,4000),
	(4,3,500),
	(5,3,1000),
	(6,3,1200),
	(7,3,4000),
	(8,3,2000),
	(1,2,2500),
	(2,2,3000),
	(3,2,3500),
	(4,2,1000),
	(5,2,1500),
	(6,2,1200),
	(7,2,4100),
	(8,2,2900);

LOCK TABLES `LISTAS_MERCADOS` WRITE;
INSERT INTO `LISTAS_MERCADOS` (`nombre`,`fechaCreacion`,`realizado`,`USUARIOS_id`) VALUES
	('ListaMercado1','2017-01-01 00:00:01',false,2),
   	('ListaMercado2','2017-01-10 00:00:01',false,1),
	('ListaMercado','2017-03-28 00:00:01',false,1),
	('ListaMercado','2017-03-28 00:00:01',false,2),
	('ListaMercado','2017-03-28 00:00:01',false,4);

LOCK TABLES `ITEMS_LISTA` WRITE;
INSERT INTO `ITEMS_LISTA` (`comprado`,`favorito`,`ITEMS_id`,`LISTAS_MERCADOS_id`) VALUES
	(false,false,1,1),
	(false,false,3,1),
	(false,false,4,1),
	(false,false,2,2),
	(false,false,3,2),
	(false,false,4,2),
	(false,false,13,3),
	(false,false,6,3),
	(false,false,15,3),
	(false,false,8,3),
	(false,false,9,3),
	(false,false,18,3),
	(false,false,11,3),
	(false,false,12,3),
	(false,false,13,4),
	(false,false,6,4),
	(false,false,15,4),
	(false,false,8,4),
	(false,false,9,4),
	(false,false,18,4),
	(false,false,11,4),
	(false,false,12,4);

/*prueba
tendero
admin
prueba
tendero
prueba
tendero*/
LOCK TABLES `USUARIOS_AUTENTICACION` WRITE;
INSERT INTO `USUARIOS_AUTENTICACION` (`USUARIOS_id`,`hash`,`habilitado`,`rol`) VALUES
	('2','711383a59fda05336fd2ccf70c8059d1523eb41a',true,'Usuario'),
	('3','98e5e0ec81f5f7cb10f9775c359893f5734092a8',true,'Tendero'),
	('1','d033e22ae348aeb5660fc2140aec35850c4da997',true,'Usuario'),
	('4','711383a59fda05336fd2ccf70c8059d1523eb41a',true,'Usuario'),
	('5','98e5e0ec81f5f7cb10f9775c359893f5734092a8',true,'Tendero'),
	('6','711383a59fda05336fd2ccf70c8059d1523eb41a',true,'Usuario'),
	('7','98e5e0ec81f5f7cb10f9775c359893f5734092a8',true,'Tendero');
