LOCK TABLES `HORARIOS` WRITE;
INSERT INTO `HORARIOS` (`horaInicio`,`horaFin`,`minutosInicio`,`minutosFin`,`Tiendas_x`,`Tiendas_y`,`Tiendas_nit`,`dia`) VALUES
			(7,19,0,0,4.7649271,-74.0476042,'1234567-2','Lunes'),
			(7,19,0,0,4.7649271,-74.0476042,'1234567-2','Jueves');

LOCK TABLES `ITEMS` WRITE;
INSERT INTO `ITEMS`    (`PRODUCTOS_id`,`TIENDAS_x`,`TIENDAS_y`,`TIENDAS_nit`,`precio`) VALUES
		       (1,4.7649271,-74.0476042,'1234567-2',3000),
		       (2,4.7649271,-74.0476042,'1234567-2',2500),
		       (3,4.7649271,-74.0476042,'1234567-2',4000),
		       (4,4.7649271,-74.0476042,'1234567-2',500);

LOCK TABLES `ITEMS_LISTA` WRITE;
INSERT INTO `ITEMS_LISTA` (`comprado`,`favorito`,`ITEMS_PRODUCTOS_id`,`ITEMS_TIENDAS_x`,`ITEMS_TIENDAS_y`,`ITEMS_TIENDAS_nit`,`LISTAS_MERCADOS_nombre`,`LISTAS_MERCADOS_USUARIOS_correo`) 	VALUES
	      (false,false,1,4.7649271,-74.0476042,'1234567-2','ListaMercado1','prueba@prueba.com'),
	      (false,false,3,4.7649271,-74.0476042,'1234567-2','ListaMercado1','prueba@prueba.com'),
	      (false,false,4,4.7649271,-74.0476042,'1234567-2','ListaMercado1','prueba@prueba.com'),
	      (false,false,2,4.7649271,-74.0476042,'1234567-2','ListaMercado2','admin@cheapestprice.com'),
	      (false,false,3,4.7649271,-74.0476042,'1234567-2','ListaMercado2','admin@cheapestprice.com'),
	      (false,false,4,4.7649271,-74.0476042,'1234567-2','ListaMercado2','admin@cheapestprice.com');

LOCK TABLES `LISTAS_MERCADOS` WRITE;
INSERT INTO `LISTAS_MERCADOS` (`nombre`,`fechaCreacion`,`realizado`,`USUARIOS_correo`) VALUES
			('ListaMercado1','2017-01-01 00:00:01',false,'prueba@prueba.com'),
		        ('ListaMercado2','2017-01-10 00:00:01',false,'admin@cheapestprice.com');

LOCK TABLES `OPINIONES` WRITE;
INSERT INTO `OPINIONES` (`id`,`comentario`,`gusta`,`fecha`,`USUARIOS_correo`,`TIENDAS_x`,`TIENDAS_y`,`TIENDAS_nit`) VALUES
			(1,'lololololol',false,'2017-04-23 00:00:01','prueba@prueba.com',4.7649271,-74.0476042,'1234567-2');

LOCK TABLES `PRODUCTOS` WRITE;
INSERT INTO `PRODUCTOS` (`nombre`,`id`,`marca`,`imagen`,`categoria`) VALUES
			('Leche',1,'Alpina',null,'Lacteos'),
			('Papas BBQ',2,'Margarita',null,'Pasabocas'),
			('Gelatina Fresa',3,'Gelhada',null,'Postre'),
			('Queso Pera',4,'Colanta',null,'Lacteos');

LOCK TABLES `TENDEROS` WRITE;
INSERT INTO `TENDEROS` (`USUARIOS_correo`,`nombre`,`TIENDAS_x`,`TIENDAS_y`,`TIENDAS_nit`) VALUES
			('tendero@tendero.com',`tendero1`,4.7649271,-74.0476042,'1234567-2');

LOCK TABLES `TIENDAS` WRITE;
INSERT INTO `TIENDAS` (`direccion`,`x`,`y`,`nombre`,`nit`,`telefono`,`disponible`,`logo`) VALUES
		      ('CR NM #NM-NM',4.7649271,-74.0476042,'Donde Pepe','1234567-2','5473829',true,null);

LOCK TABLES `USUARIOS` WRITE;
INSERT INTO `USUARIOS` (`nombre`,`correo`) VALUES
		       ('usuario1','prueba@prueba.com'),
		       ('tendero1','tendero@tendero.com'),
		       ('admin','admin@cheapestprice.com');


LOCK TABLES `USUARIOS_ROLES` WRITE;
INSERT INTO `USUARIOS_ROLES` (`id`,`USUARIOS_correo`,`rol`) VALUES
			     (1,'tendero@tendero.com','Tendero'),
			     (2,'prueba@prueba.com','Usuario'),
			     (3,'admin@cheapestprice.com','Usuario');

LOCK TABLES `USUARIOS_AUTENTICACION` WRITE;
INSERT INTO `USUARIOS_AUTENTICACION` (`USUARIOS_correo`,`hash`,`habilitado`) VALUES
				     ('prueba@prueba.com','$2a$06$xP01EJ/jiHbM76ydX52M.uYQX4GTqjvrAJyBkkrzU8Y.uUAx7hmQK',true),
				     ('tendero@tendero.com','$2a$06$dQSpBh.CyVqRIt8VJQiniOoJwfA2lopdKC8vt4CRYKGYFwRwqo02y',true),
				     ('admin@cheapestprice.com','$2a$04$9bTPMRnWTVwi.xUjK2uQn.iCZowsVnNode.hG.czbSzT3LWDNn6Gu',true);




