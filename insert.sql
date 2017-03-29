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
	('Cl. 209 #45-62 a 45-98',4.788479, -74.045011,'Donde Juan','1295567-2','1234567',true,null),
	('La Caro #197-2 a 197-54',4.775933, -74.041923,'Donde Juan','1295567-2','1234567',true,null);

LOCK TABLES `TENDEROS` WRITE;
INSERT INTO `TENDEROS` (`USUARIOS_correo`,`nombre`,`TIENDAS_x`,`TIENDAS_y`,`TIENDAS_nit`) VALUES
	('tendero@tendero.com','tendero1',4.7649271,-74.0476042,'1234567-2'),
	('tendero2@tendero.com','tendero2',4.775933, -74.041923,'1295567-2'),
	('tendero3@tendero.com','tendero3',4.788479, -74.045011,'1232567-2');

LOCK TABLES `HORARIOS` WRITE;
INSERT INTO `HORARIOS` (`horaInicio`,`horaFin`,`minutosInicio`,`minutosFin`,`Tiendas_x`,`Tiendas_y`,`Tiendas_nit`,`dia`) VALUES
	(7,19,0,0,4.7649271,-74.0476042,'1234567-2','Lunes'),
	(7,19,0,0,4.7649271,-74.0476042,'1234567-2','Jueves'),
	(7,19,0,0,4.775933, -74.041923,'1295567-2','Lunes'),
	(7,19,0,0,4.775933, -74.041923,'1295567-2','Martes'),
	(7,19,0,0,4.775933, -74.041923,'1295567-2','Miércoles'),
	(7,19,0,0,4.775933, -74.041923,'1295567-2','Jueves'),
	(7,19,0,0,4.775933, -74.041923,'1295567-2','Viernes'),
	(7,19,0,0,4.788479, -74.045011,'1232567-2','Lunes'),
	(7,19,0,0,4.788479, -74.045011,'1232567-2','Martes'),
	(7,19,0,0,4.788479, -74.045011,'1232567-2','Miércoles'),
	(7,19,0,0,4.788479, -74.045011,'1232567-2','Jueves'),
	(7,19,0,0,4.788479, -74.045011,'1232567-2','Viernes');

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
INSERT INTO `ITEMS`    (`PRODUCTOS_id`,`TIENDAS_x`,`TIENDAS_y`,`TIENDAS_nit`,`precio`) VALUES
	(1,4.7649271,-74.0476042,'1234567-2',3000),
	(2,4.7649271,-74.0476042,'1234567-2',2500),
	(3,4.7649271,-74.0476042,'1234567-2',4000),
	(4,4.7649271,-74.0476042,'1234567-2',500),
	(1,4.775933, -74.041923,'1295567-2',3000),
	(2,4.775933, -74.041923,'1295567-2',2500),
	(3,4.775933, -74.041923,'1295567-2',4000),
	(4,4.775933, -74.041923,'1295567-2',500),
	(5,4.775933, -74.041923,'1295567-2',1000),
	(6,4.775933, -74.041923,'1295567-2',1200),
	(7,4.775933, -74.041923,'1295567-2',4000),
	(8,4.775933, -74.041923,'1295567-2',2000),
	(1,4.788479, -74.045011,'1232567-2',2500),
	(2,4.788479, -74.045011,'1232567-2',3000),
	(3,4.788479, -74.045011,'1232567-2',3500),
	(4,4.788479, -74.045011,'1232567-2',1000),
	(5,4.788479, -74.045011,'1232567-2',1500),
	(6,4.788479, -74.045011,'1232567-2',1200),
	(7,4.788479, -74.045011,'1232567-2',4100),
	(8,4.788479, -74.045011,'1232567-2',2900);

LOCK TABLES `LISTAS_MERCADOS` WRITE;
INSERT INTO `LISTAS_MERCADOS` (`nombre`,`fechaCreacion`,`realizado`,`USUARIOS_correo`) VALUES
	('ListaMercado1','2017-01-01 00:00:01',false,'prueba@prueba.com'),
    ('ListaMercado2','2017-01-10 00:00:01',false,'admin@cheapestprice.com')
	('ListaMercado','2017-03-28 00:00:01',false,'admin@cheapestprice.com'),
	('ListaMercado','2017-03-28 00:00:01',false,'prueba@prueba.com');
	('ListaMercado','2017-03-28 00:00:01',false,'prueba2@prueba.com');

LOCK TABLES `ITEMS_LISTA` WRITE;
INSERT INTO `ITEMS_LISTA` (`comprado`,`favorito`,`ITEMS_PRODUCTOS_id`,`ITEMS_TIENDAS_x`,`ITEMS_TIENDAS_y`,`ITEMS_TIENDAS_nit`,`LISTAS_MERCADOS_nombre`,`LISTAS_MERCADOS_USUARIOS_correo`) 	VALUES
	(false,false,1,4.7649271,-74.0476042,'1234567-2','ListaMercado1','prueba@prueba.com'),
	(false,false,3,4.7649271,-74.0476042,'1234567-2','ListaMercado1','prueba@prueba.com'),
	(false,false,4,4.7649271,-74.0476042,'1234567-2','ListaMercado1','prueba@prueba.com'),
	(false,false,2,4.7649271,-74.0476042,'1234567-2','ListaMercado2','admin@cheapestprice.com'),
	(false,false,3,4.7649271,-74.0476042,'1234567-2','ListaMercado2','admin@cheapestprice.com'),
	(false,false,4,4.7649271,-74.0476042,'1234567-2','ListaMercado2','admin@cheapestprice.com'),
	(false,false,1,4.788479, -74.045011,'1232567-2','ListaMercado','admin@cheapestprice.com'),
	(false,false,2,4.775933, -74.041923,'1295567-2','ListaMercado','admin@cheapestprice.com'),
	(false,false,3,4.788479, -74.045011,'1232567-2','ListaMercado','admin@cheapestprice.com'),
	(false,false,4,4.775933, -74.041923,'1295567-2','ListaMercado','admin@cheapestprice.com'),
	(false,false,5,4.775933, -74.041923,'1295567-2','ListaMercado','admin@cheapestprice.com'),
	(false,false,6,4.788479, -74.045011,'1232567-2','ListaMercado','admin@cheapestprice.com'),
	(false,false,7,4.775933, -74.041923,'1295567-2','ListaMercado','admin@cheapestprice.com'),
	(false,false,8,4.775933, -74.041923,'1295567-2','ListaMercado','admin@cheapestprice.com'),
	(false,false,1,4.788479, -74.045011,'1232567-2','ListaMercado','prueba@prueba.com'),
	(false,false,2,4.775933, -74.041923,'1295567-2','ListaMercado','prueba@prueba.com'),
	(false,false,3,4.788479, -74.045011,'1232567-2','ListaMercado','prueba@prueba.com'),
	(false,false,4,4.775933, -74.041923,'1295567-2','ListaMercado','prueba@prueba.com'),
	(false,false,5,4.775933, -74.041923,'1295567-2','ListaMercado','prueba@prueba.com'),
	(false,false,6,4.788479, -74.045011,'1232567-2','ListaMercado','prueba@prueba.com'),
	(false,false,7,4.775933, -74.041923,'1295567-2','ListaMercado','prueba@prueba.com'),
	(false,false,8,4.775933, -74.041923,'1295567-2','ListaMercado','prueba@prueba.com');

/*prueba
tendero
admin
prueba
tendero
prueba
tendero*/
LOCK TABLES `USUARIOS_AUTENTICACION` WRITE;
INSERT INTO `USUARIOS_AUTENTICACION` (`USUARIOS_correo`,`hash`,`habilitado`,`rol`) VALUES
	('prueba@prueba.com','$2a$06$xP01EJ/jiHbM76ydX52M.uYQX4GTqjvrAJyBkkrzU8Y.uUAx7hmQK',true,'Usuario'),
	('tendero@tendero.com','$2a$06$dQSpBh.CyVqRIt8VJQiniOoJwfA2lopdKC8vt4CRYKGYFwRwqo02y',true,'Tendero'),
	('admin@cheapestprice.com','$2a$04$9bTPMRnWTVwi.xUjK2uQn.iCZowsVnNode.hG.czbSzT3LWDNn6Gu',true,'Usuario'),
	('prueba2@prueba.com','$2a$06$xP01EJ/jiHbM76ydX52M.uYQX4GTqjvrAJyBkkrzU8Y.uUAx7hmQK',true,'Usuario'),
	('tendero2@tendero.com','$2a$06$dQSpBh.CyVqRIt8VJQiniOoJwfA2lopdKC8vt4CRYKGYFwRwqo02y',true,'Tendero'),
	('prueb3@prueba.com','$2a$06$xP01EJ/jiHbM76ydX52M.uYQX4GTqjvrAJyBkkrzU8Y.uUAx7hmQK',true,'Usuario'),
	('tendero3@tendero.com','$2a$06$dQSpBh.CyVqRIt8VJQiniOoJwfA2lopdKC8vt4CRYKGYFwRwqo02y',true,'Tendero');
