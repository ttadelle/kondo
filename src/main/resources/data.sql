insert into TB_USER (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE,EMAIL, NAME, PASSWORD) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP,'thiago@gmail.com','thiago','123456');
insert into TB_USER (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE,EMAIL, NAME, PASSWORD) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP,'isabella@gmail.com','isabella','123456');

insert into TB_ROLE (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, AUTHORITY) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP,'ROLE_ADMIN');
insert into TB_ROLE (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, AUTHORITY) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP,'ROLE_USER');

insert into TB_USER_ROLE (user_id, role_id) values (1,1);
insert into TB_USER_ROLE (user_id, role_id) values (2,2);

insert into TB_TICKET (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, title, description, ticket_status_id, ticket_number) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP, 'Extintor descarregado','Extintor descarregado no primeiro subsolo.',0, 'LIVING20230001');
insert into TB_TICKET (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, title, description, ticket_status_id, ticket_number) values (2,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP, 'Carga extintor vencida','Extintor com carga vencida no segundo andar da Torre 1.',2, 'LIVING20230002');
insert into TB_TICKET (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, title, description, ticket_status_id, ticket_number) values (2,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP, 'Lacre violado','Lacre da mangueira de incêndio violada no primeiro andar da Torre 2.',7, 'LIVING20230003');

insert into TB_TICKET_ACTION_HISTORY (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, ticket_status_id, DESCRIPTION, TICKET_ID ) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP, 0, 'Extintor recolhido para recarga', 1);
insert into TB_TICKET_ACTION_HISTORY (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, ticket_status_id, DESCRIPTION, TICKET_ID ) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP, 1, 'Chamado em análise', 2);
insert into TB_TICKET_ACTION_HISTORY (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, ticket_status_id, DESCRIPTION, TICKET_ID ) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP, 2, 'Extintor recarregado', 2);
insert into TB_TICKET_ACTION_HISTORY (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, ticket_status_id, DESCRIPTION, TICKET_ID ) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP, 7, 'Em análise', 3);

insert into TB_IMAGE (DATA, NAME) values ('http://teste.com', 'imagem.jpg');
insert into TB_IMAGE (DATA, NAME) values ('http://teste.com', 'imagem_isabella.jpg');

insert into TB_PERSON (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, NAME, PHONE_NUMBER, IMAGE_ID, USER_ID) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP, 'THIAGO TADELLE', '11991031386', 1, 1);
insert into TB_PERSON (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, NAME, PHONE_NUMBER, IMAGE_ID, USER_ID) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP, 'ISABELLA MENDES', '11981843778', 2, 2);

insert into TB_BUILDING (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, ADDRESS, CITY, NAME, NUMBER, PROVINCE, STATE, ZIP_CODE) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP, 'RUA DOM VILARES', 'SAO PAULO', 'LIVING CONNECT', 1801, 'VILA VERA', 'SP', '04160001');

insert into TB_APARTMENT (CREATED_BY, CREATION_DATE, LAST_UPDATED_BY, LAST_UPDATE_DATE, APARTMENT, TOWER, BUILDING_ID) values (1,CURRENT_TIMESTAMP,1,CURRENT_TIMESTAMP, '702', '1', 1);

insert into TB_USER_BUILDING (USER_ID, BUILDING_ID) values (1,1);
insert into TB_USER_BUILDING (USER_ID, BUILDING_ID) values (2,1);