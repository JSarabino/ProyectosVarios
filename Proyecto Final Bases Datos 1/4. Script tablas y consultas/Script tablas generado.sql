/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     9/03/2022 11:05:02 p. m.                     */
/*==============================================================*/


alter table ELECTRODOMESTICO
   drop constraint FK_ELECTROD_VENDE_TIENDAEL;

drop index VENDE_FK;

drop table ELECTRODOMESTICO cascade constraints;

drop table TIENDAELECTRODOMESTICOS cascade constraints;

/*==============================================================*/
/* Table: ELECTRODOMESTICO                                      */
/*==============================================================*/
create table ELECTRODOMESTICO 
(
   ELECT_SERIAL         INTEGER              not null,
   TIENDA_NIT           INTEGER              not null,
   ELECT_TIPO           VARCHAR2(20)         not null
      constraint CKC_ELECT_TIPO_ELECTROD check (ELECT_TIPO in ('Televisor','Lavadora','Nevera')),
   ELECT_ANIOFABRICACION INTEGER              not null,
   ELECT_MARCA          VARCHAR2(40)         not null,
   ELECT_PAISORIGEN     VARCHAR2(40)         not null,
   constraint PK_ELECTRODOMESTICO primary key (ELECT_SERIAL)
);

/*==============================================================*/
/* Index: VENDE_FK                                              */
/*==============================================================*/
create index VENDE_FK on ELECTRODOMESTICO (
   TIENDA_NIT ASC
);

/*==============================================================*/
/* Table: TIENDAELECTRODOMESTICOS                               */
/*==============================================================*/
create table TIENDAELECTRODOMESTICOS 
(
   TIENDA_NIT           INTEGER              not null,
   TIENDA_NOMBRE        VARCHAR2(50)         not null,
   TIENDA_FECHACREACION DATE                 not null,
   constraint PK_TIENDAELECTRODOMESTICOS primary key (TIENDA_NIT)
);

alter table ELECTRODOMESTICO
   add constraint FK_ELECTROD_VENDE_TIENDAEL foreign key (TIENDA_NIT)
      references TIENDAELECTRODOMESTICOS (TIENDA_NIT);

