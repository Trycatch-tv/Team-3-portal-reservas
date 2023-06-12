insert into roless (name, description) values ('ADMIN','Administrador general del sistema');
insert into roless (name, description) values ('USER','Usuario general del sistema');
insert into clientes (email, password) values ('admin@admin.com','');
insert into clientes (email, password) values ('user1@user.com','');
insert into clientes (email, password) values ('user2@user.com','');
insert into clientes (email, password) values ('user3@user.com','');
insert into roless_clientes (roless_id, cliente_id) values (1,1);
insert into roless_clientes (roless_id, cliente_id) values (2,2);
insert into roless_clientes (roless_id, cliente_id) values (2,3);
insert into roless_clientes (roless_id, cliente_id) values (2,4);
insert into states (name, description) values ('Libre','Mesa disponible para ser reservada');
insert into states (name, description) values ('Reservada','Mesa reservada en este horario');
insert into profile(name,last_name,address,phone,postal_code,avatar,clientes_id) values ('Ronald','Garcia','Chile','234234234','0000','mi_avatar',1);
insert into profile(name,last_name,address,phone,postal_code,avatar,clientes_id) values ('Maribel','Rojas','Chile','123123123','0001','mi_avatar',2);
insert into profile(name,last_name,address,phone,postal_code,avatar,clientes_id) values ('Junior','Rojas','Chile','123123123','0002','mi_avatar',3);
insert into profile(name,last_name,address,phone,postal_code,avatar,clientes_id) values ('Miriam','Rojas','Chile','123123123','0001','mi_avatar',4);
insert into config_restaurant(name, slogan,logo,banner,description,address,postal_code,phone,code_trade,email,clientes_id)  values ('Margo','miSlogan','miLogo','miBanner','Mi descripción', 'Santiago','0005','45665444','6456645D','margo@rest.cl',2)
insert into sucursal(name, observation,address,location,postal_code,phone,time_seat,max_waiting,config_restaurant_id) values ('Central', 'miObservation','miAdrress','miLocation','0004','3453453','3:00:00','0:20:00',1)
insert into category_dish (name, description) values ('Entradas','Primero plato');
insert into category_dish (name, description) values ('Principal','Segundo plato o plato fuerte');
insert into dish(name, description, image,price, categorydish_id,config_restaurant_id) values ('Ensalada','Excelente plato, contiene tomate y lechuga','imagenPlato',7.99,1,1)
insert into dish(name, description, image,price, categorydish_id,config_restaurant_id) values ('Lenguado meniere','Excelente plato de pescado','imagenPlato',15.99,2,1)
insert into table_rest(name, description, capacity,position, status,sucursal_id) values('Mesa 1','Caliente',4,'interior',true,1)
insert into table_rest(name, description, capacity,position, status,sucursal_id) values('Mesa 2','Ventana',2,'Exterior',true,1)
insert into schedule(day, start_service, end_service,status,sucursal_id) values ('Lunes','12:00:00','24:00:00',true,1)
insert into schedule(day, start_service, end_service,status,sucursal_id) values ('Martes','12:00:00','24:00:00',true,1)
insert into booking (date_book,time_book,people,clientes_id,states_id,sucursal_id,tables_id) values ('2023-06-19','13:30:00',4,3,2,1,1)
insert into booking (date_book,time_book,people,clientes_id,states_id,sucursal_id,tables_id) values ('2023-06-20','15:30:00',6,4,2,1,1)



