
create table  t_lineas(
 cod_linea   int primary key,
 nombre      varchar(50) not null
 ) ENGINE = InnoDB ;

Insert into  t_lineas  values(1,'PLAZA CASTILLA-CONGOSTO');
Insert into  t_lineas  values(2,'VENTAS-CUATRO CAMINOS');
Insert into  t_lineas  values(3,'LEGAZPI-MONCLOA');
Insert into  t_lineas  values(4,'ARGÜELLES-PARQUE DE SANTA MARÍA');
Insert into  t_lineas  values(5,'CANILLEJAS-CASA DE CAMPO');
Insert into  t_lineas  values(6,'CIRCULAR');
Insert into  t_lineas  values(7,'LAS MUSAS-PITIS');


create table  t_trenes(
 cod_tren   int primary key,
 nombre     varchar(50) not null,
 tipo       varchar(20) not null,
 cod_linea     int not null,
 cod_cochera   int not null,
 FOREIGN KEY (cod_linea)    REFERENCES   t_lineas(cod_linea)
) ENGINE = InnoDB ;

Insert into  t_trenes values (1,'COCHE 3000 , 10','SERIE 3000',2,1);
Insert into  t_trenes values (2,'COCHE 3000 , 20','SERIE 3000',2,1);
Insert into  t_trenes values (3,'COCHE 3000 , 30','SERIE 3000',2,1);
Insert into  t_trenes values (4,'COCHE 5000 , 1','SERIE 5000',1,2);
Insert into  t_trenes values (5,'COCHE 5000 , 2','SERIE 5000',1,2);
Insert into  t_trenes values (6,'COCHE 5000 , 3','SERIE 5000',1,2);
Insert into  t_trenes values (7,'COCHE 5000 , 4','SERIE 5000',1,2);
Insert into  t_trenes values (8,'COCHE 6000 , 10','SERIE 6000',3,3);
Insert into  t_trenes values (9,'COCHE 6000 , 20','SERIE 6000',3,3);
Insert into  t_trenes values (10,'COCHE 6000 , 30','SERIE 6000',3,3);
Insert into  t_trenes values (11,'COCHE 9000 , 1','SERIE 9000',4,2);
Insert into  t_trenes values (12,'COCHE 9000 , 2','SERIE 9000',4,2);
Insert into  t_trenes values (13,'COCHE 9000 , 3','SERIE 9000',4,2);
Insert into  t_trenes values (14,'COCHE 9000 , 4','SERIE 9000',4,2);
Insert into  t_trenes values (15,'COCHE 8000 , 11','SERIE 8000',5,6);
Insert into  t_trenes values (16,'COCHE 8000 , 12','SERIE 8000',5,6);
Insert into  t_trenes values (17,'COCHE 8000 , 13','SERIE 8000',5,6);
Insert into  t_trenes values (18,'COCHE 8400 , 41','SERIE 8400',6,7);
Insert into  t_trenes values (19,'COCHE 8400 , 42','SERIE 8400',6,7);
Insert into  t_trenes values (20,'COCHE 8400 , 43','SERIE 8400',6,7);
Insert into  t_trenes values (21,'COCHE 8400 , 54','SERIE 8400',7,5);
Insert into  t_trenes values (22,'COCHE 8400 , 55','SERIE 8400',7,5);

COMMIT;
