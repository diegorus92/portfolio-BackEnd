/*
	1) Una empresa tiene registrados a sus clientes en una tabla llamada clientes. 
	También tiene una tabla "provincias" donde registra los nombres de las provincias. 
	En base a los datos cargados aquí, Queremos saber de qué provincias tenemos clientes, 
	sin repetir el nombre de la provincia: las consultas que permitan responder las siguientes preguntas:
*/


create table clientes (
  codigo int unsigned auto_increment,
  nombre varchar(30) not null,
  domicilio varchar(30),
  ciudad varchar(20),
  codigoProvincia tinyint unsigned,
  telefono varchar(11),
  primary key(codigo)
 );
 
 create table provincias(
  codigo tinyint unsigned auto_increment,
  nombre varchar(20),
  primary key (codigo)
 );
 
 insert into provincias (nombre) values('Cordoba');
 insert into provincias (nombre) values('Santa Fe');
 insert into provincias (nombre) values('Corrientes');
 insert into provincias (nombre) values('Misiones');
 insert into provincias (nombre) values('Salta');
 insert into provincias (nombre) values('Buenos Aires');
 insert into provincias (nombre) values('Neuquen');

 insert into clientes (nombre,domicilio,ciudad,codigoProvincia,telefono)
  values ('Lopez Marcos', 'Colon 111', 'Córdoba',1,'null');
 insert into clientes (nombre,domicilio,ciudad,codigoProvincia,telefono)
  values ('Perez Ana', 'San Martin 222', 'Cruz del Eje',1,'4578585');
 insert into clientes (nombre,domicilio,ciudad,codigoProvincia,telefono)
  values ('Garcia Juan', 'Rivadavia 333', 'Villa Maria',1,'4578445');
 insert into clientes (nombre,domicilio,ciudad,codigoProvincia,telefono)
  values ('Perez Luis', 'Sarmiento 444', 'Rosario',2,null);
 insert into clientes (nombre,domicilio,ciudad,codigoProvincia,telefono)
  values ('Pereyra Lucas', 'San Martin 555', 'Cruz del Eje',1,'4253685');
 insert into clientes (nombre,domicilio,ciudad,codigoProvincia,telefono)
  values ('Gomez Ines', 'San Martin 666', 'Santa Fe',2,'0345252525');
 insert into clientes (nombre,domicilio,ciudad,codigoProvincia,telefono)
  values ('Torres Fabiola', 'Alem 777', 'Villa del Rosario',1,'4554455');
 insert into clientes (nombre,domicilio,ciudad,codigoProvincia,telefono)
  values ('Lopez Carlos', 'Irigoyen 888', 'Cruz del Eje',1,null);
 insert into clientes (nombre,domicilio,ciudad,codigoProvincia,telefono)
  values ('Ramos Betina', 'San Martin 999', 'Cordoba',1,'4223366');
 insert into clientes (nombre,domicilio,ciudad,codigoProvincia,telefono)
  values ('Lopez Lucas', 'San Martin 1010', 'Posadas',4,'0457858745');
  
 /*1-¿Qué provincias no tenemos clientes?*/
SELECT p.nombre AS "Provincias sin clientes", c.nombre 
FROM provincias p /*Se selecciona la tabla provincias (sera la tabla LEFT)*/
LEFT JOIN clientes c /*Une todos los datos sin excepción de la tabla LEFT (provincias) con la tabla clientes (RIGHT)*/
ON c.codigoProvincia = p.codigo /*Unirá ambas tablas segun los codigos expuestos*/
WHERE c.codigoProvincia IS NULL; /*Establece la condición de mostrar los datos de las provincias  donde la relacion sea null con los datos de clientes (provincias sin clientes)*/
  
  
/*2-¿Qué provincias tienen clientes? Pero sin repetir el nombre de la provincia. Un tip, vas a necesitar la sentencia distinct*/
SELECT DISTINCT p.nombre AS "Provincias con clientes" 
FROM provincias p
LEFT JOIN  clientes c 
ON c.codigoProvincia = p.codigo
WHERE c.codigoProvincia IS NOT NULL;