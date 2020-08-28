/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 11                       */
/* Created on:     27/08/2020 18:18:40                          */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_EQUIPOIN_RELATIONS_DOCUMENT') then
    alter table EQUIPOINVENTARIADO
       delete foreign key FK_EQUIPOIN_RELATIONS_DOCUMENT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_INVENTAR_RELATIONS_MUEBLE') then
    alter table INVENTARIO
       delete foreign key FK_INVENTAR_RELATIONS_MUEBLE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MUEBLE_RELATIONS_TIPOMUEB') then
    alter table MUEBLE
       delete foreign key FK_MUEBLE_RELATIONS_TIPOMUEB
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MUEBLE_RELATIONS_USUXUBI') then
    alter table MUEBLE
       delete foreign key FK_MUEBLE_RELATIONS_USUXUBI
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MUEBLE_RELATIONS_CUENTACO') then
    alter table MUEBLE
       delete foreign key FK_MUEBLE_RELATIONS_CUENTACO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MUEBLE_RELATIONS_COLOR') then
    alter table MUEBLE
       delete foreign key FK_MUEBLE_RELATIONS_COLOR
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MUEBLE_RELATIONS_MARCA') then
    alter table MUEBLE
       delete foreign key FK_MUEBLE_RELATIONS_MARCA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MUEBLE_RELATIONS_ESTADO') then
    alter table MUEBLE
       delete foreign key FK_MUEBLE_RELATIONS_ESTADO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_UBICACIO_RELATIONS_AREADEPE') then
    alter table UBICACION
       delete foreign key FK_UBICACIO_RELATIONS_AREADEPE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_USUXUBI_RELATIONS_USUARIO') then
    alter table USUXUBI
       delete foreign key FK_USUXUBI_RELATIONS_USUARIO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_USUXUBI_RELATIONS_UBICACIO') then
    alter table USUXUBI
       delete foreign key FK_USUXUBI_RELATIONS_UBICACIO
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='AREADEPENDENCIA_PK'
     and t.table_name='AREADEPENDENCIA'
) then
   drop index AREADEPENDENCIA.AREADEPENDENCIA_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='AREADEPENDENCIA'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table AREADEPENDENCIA
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='COLOR_PK'
     and t.table_name='COLOR'
) then
   drop index COLOR.COLOR_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='COLOR'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table COLOR
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='CUENTACONTABLE_PK'
     and t.table_name='CUENTACONTABLE'
) then
   drop index CUENTACONTABLE.CUENTACONTABLE_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='CUENTACONTABLE'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table CUENTACONTABLE
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='DOCUMENTOINVENTARIO_PK'
     and t.table_name='DOCUMENTOINVENTARIO'
) then
   drop index DOCUMENTOINVENTARIO.DOCUMENTOINVENTARIO_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='DOCUMENTOINVENTARIO'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table DOCUMENTOINVENTARIO
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_11_FK'
     and t.table_name='EQUIPOINVENTARIADO'
) then
   drop index EQUIPOINVENTARIADO.RELATIONSHIP_11_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='EQUIPOINVENTARIADO_PK'
     and t.table_name='EQUIPOINVENTARIADO'
) then
   drop index EQUIPOINVENTARIADO.EQUIPOINVENTARIADO_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='EQUIPOINVENTARIADO'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table EQUIPOINVENTARIADO
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ESTADO_PK'
     and t.table_name='ESTADO'
) then
   drop index ESTADO.ESTADO_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='ESTADO'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table ESTADO
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_8_FK'
     and t.table_name='INVENTARIO'
) then
   drop index INVENTARIO.RELATIONSHIP_8_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='INVENTARIO_PK'
     and t.table_name='INVENTARIO'
) then
   drop index INVENTARIO.INVENTARIO_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='INVENTARIO'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table INVENTARIO
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='MARCA_PK'
     and t.table_name='MARCA'
) then
   drop index MARCA.MARCA_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='MARCA'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table MARCA
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_13_FK'
     and t.table_name='MUEBLE'
) then
   drop index MUEBLE.RELATIONSHIP_13_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_5_FK'
     and t.table_name='MUEBLE'
) then
   drop index MUEBLE.RELATIONSHIP_5_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_4_FK'
     and t.table_name='MUEBLE'
) then
   drop index MUEBLE.RELATIONSHIP_4_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_3_FK'
     and t.table_name='MUEBLE'
) then
   drop index MUEBLE.RELATIONSHIP_3_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_2_FK'
     and t.table_name='MUEBLE'
) then
   drop index MUEBLE.RELATIONSHIP_2_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_1_FK'
     and t.table_name='MUEBLE'
) then
   drop index MUEBLE.RELATIONSHIP_1_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='MUEBLE_PK'
     and t.table_name='MUEBLE'
) then
   drop index MUEBLE.MUEBLE_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='MUEBLE'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table MUEBLE
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='TIPOMUEBLE_PK'
     and t.table_name='TIPOMUEBLE'
) then
   drop index TIPOMUEBLE.TIPOMUEBLE_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='TIPOMUEBLE'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table TIPOMUEBLE
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_9_FK'
     and t.table_name='UBICACION'
) then
   drop index UBICACION.RELATIONSHIP_9_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='UBICACION_PK'
     and t.table_name='UBICACION'
) then
   drop index UBICACION.UBICACION_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='UBICACION'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table UBICACION
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='USUARIO_PK'
     and t.table_name='USUARIO'
) then
   drop index USUARIO.USUARIO_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='USUARIO'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table USUARIO
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_12_FK'
     and t.table_name='USUXUBI'
) then
   drop index USUXUBI.RELATIONSHIP_12_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_10_FK'
     and t.table_name='USUXUBI'
) then
   drop index USUXUBI.RELATIONSHIP_10_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='USUXUBI_PK'
     and t.table_name='USUXUBI'
) then
   drop index USUXUBI.USUXUBI_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='USUXUBI'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table USUXUBI
end if;

/*==============================================================*/
/* Table: AREADEPENDENCIA                                       */
/*==============================================================*/
create table AREADEPENDENCIA 
(
   ADID                 integer                        not null AUTO_INCREMENT,
   ADNOMBRE             long varchar                   not null,
   ADDESCRIPCION        long varchar                   not null,
   ADESTADO             smallint                       not null,
   constraint PK_AREADEPENDENCIA primary key (ADID)
);

/*==============================================================*/
/* Index: AREADEPENDENCIA_PK                                    */
/*==============================================================*/
create unique index AREADEPENDENCIA_PK on AREADEPENDENCIA (
ADID ASC
);

/*==============================================================*/
/* Table: COLOR                                                 */
/*==============================================================*/
create table COLOR 
(
   COLID                integer                        not null AUTO_INCREMENT,
   COLNOMBRE            long varchar                   null,
   COLDESCRIPCION       long varchar                   null,
   COLESTADO            smallint                       null,
   constraint PK_COLOR primary key (COLID)
);

/*==============================================================*/
/* Index: COLOR_PK                                              */
/*==============================================================*/
create unique index COLOR_PK on COLOR (
COLID ASC
);

/*==============================================================*/
/* Table: CUENTACONTABLE                                        */
/*==============================================================*/
create table CUENTACONTABLE 
(
   CCID                 integer                        not null AUTO_INCREMENT,
   CCNOMBRE             long varchar                   null,
   CCDESCRIPCION        long varchar                   null,
   CCCODIGOCUENTACONTABLE long varchar                   null,
   CCESTADO             smallint                       null,
   constraint PK_CUENTACONTABLE primary key (CCID)
);

/*==============================================================*/
/* Index: CUENTACONTABLE_PK                                     */
/*==============================================================*/
create unique index CUENTACONTABLE_PK on CUENTACONTABLE (
CCID ASC
);

/*==============================================================*/
/* Table: DOCUMENTOINVENTARIO                                   */
/*==============================================================*/
create table DOCUMENTOINVENTARIO 
(
   DIID                 integer                        not null AUTO_INCREMENT,
   DIFECHA              timestamp                      not null,
   DIARCHIVOIMPORTADO   long varchar                   not null,
   DITESTADO            smallint                       not null,
   constraint PK_DOCUMENTOINVENTARIO primary key (DIID)
);

/*==============================================================*/
/* Index: DOCUMENTOINVENTARIO_PK                                */
/*==============================================================*/
create unique index DOCUMENTOINVENTARIO_PK on DOCUMENTOINVENTARIO (
DIID ASC
);

/*==============================================================*/
/* Table: EQUIPOINVENTARIADO                                    */
/*==============================================================*/
create table EQUIPOINVENTARIADO 
(
   EIID                 integer                        not null AUTO_INCREMENT,
   DIID                 integer                        null,
   EITYPE               char(3)                        not null,
   EIEVIDENTIFIER       varchar(255)                   not null,
   EISIGNAL             decimal                        not null,
   EISEENCOUNT          integer                        not null,
   EIFIRSTSEEN          long varchar                   not null,
   EILASTSEEN           long varchar                   not null,
   EIASCII              varchar(255)                   not null,
   EIESTADO             smallint                       not null,
   constraint PK_EQUIPOINVENTARIADO primary key (EIID)
);

/*==============================================================*/
/* Index: EQUIPOINVENTARIADO_PK                                 */
/*==============================================================*/
create unique index EQUIPOINVENTARIADO_PK on EQUIPOINVENTARIADO (
EIID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_11_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_11_FK on EQUIPOINVENTARIADO (
DIID ASC
);

/*==============================================================*/
/* Table: ESTADO                                                */
/*==============================================================*/
create table ESTADO 
(
   ESTID                integer                        not null AUTO_INCREMENT,
   ESTNOMBRE            long varchar                   not null,
   ESTESTADO            smallint                       not null,
   constraint PK_ESTADO primary key (ESTID)
);

/*==============================================================*/
/* Index: ESTADO_PK                                             */
/*==============================================================*/
create unique index ESTADO_PK on ESTADO (
ESTID ASC
);

/*==============================================================*/
/* Table: INVENTARIO                                            */
/*==============================================================*/
create table INVENTARIO 
(
   INDID                integer                        not null AUTO_INCREMENT,
   MUEID                integer                        null,
   INVFECHAINVENTARI    date                           not null,
   INVCODIGOETIQUETA    long varchar                   not null,
   INVCAMPO1            long varchar                   not null,
   INVESTADO            smallint                       not null,
   constraint PK_INVENTARIO primary key (INDID)
);

/*==============================================================*/
/* Index: INVENTARIO_PK                                         */
/*==============================================================*/
create unique index INVENTARIO_PK on INVENTARIO (
INDID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_8_FK on INVENTARIO (
MUEID ASC
);

/*==============================================================*/
/* Table: MARCA                                                 */
/*==============================================================*/
create table MARCA 
(
   MARID                integer                        not null AUTO_INCREMENT,
   MARNOMBRE            long varchar                   null,
   MARDESCRIPCION       long varchar                   null,
   MARESTADO            smallint                       null,
   constraint PK_MARCA primary key (MARID)
);

/*==============================================================*/
/* Index: MARCA_PK                                              */
/*==============================================================*/
create unique index MARCA_PK on MARCA (
MARID ASC
);

/*==============================================================*/
/* Table: MUEBLE                                                */
/*==============================================================*/
create table MUEBLE 
(
   MUEID                integer                        not null AUTO_INCREMENT,
   CCID                 integer                        null,
   TMID                 integer                        null,
   ESTID                integer                        null,
   MARID                integer                        null,
   COLID                integer                        null,
   USUXUBIID            integer                        null,
   MUECODIGOETIQUETA    long varchar                   not null,
   MUEDESCRIPCION       long varchar                   not null,
   MUESERIE             long varchar                   not null,
   MUEFECHACOMPRA       date                           not null,
   MUEFECHAFABRICACION  date                           not null,
   MUEFECHAEXPIRACION   date                           not null,
   MUEFD                long varchar                   not null,
   MUEFO                long varchar                   not null,
   MUEVALORNUEVO        decimal                        not null,
   MUEVALORCOMERCIAL    decimal                        not null,
   MUEVALORREMANENTE    decimal                        not null,
   MUECANTIDAD          numeric                        not null,
   MUEVALORUNITARIO     decimal                        not null,
   MUEVALORTOTAL        decimal                        not null,
   MUEESTADO            smallint                       not null,
   constraint PK_MUEBLE primary key (MUEID)
);

/*==============================================================*/
/* Index: MUEBLE_PK                                             */
/*==============================================================*/
create unique index MUEBLE_PK on MUEBLE (
MUEID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_1_FK on MUEBLE (
TMID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_2_FK on MUEBLE (
CCID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_3_FK on MUEBLE (
COLID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_4_FK on MUEBLE (
MARID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_5_FK on MUEBLE (
ESTID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_13_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_13_FK on MUEBLE (
USUXUBIID ASC
);

/*==============================================================*/
/* Table: TIPOMUEBLE                                            */
/*==============================================================*/
create table TIPOMUEBLE 
(
   TMID                 integer                        not null AUTO_INCREMENT,
   TMNOMBRE             long varchar                   not null,
   TMDESCRIPCION        long varchar                   not null,
   TMESTADO             smallint                       not null,
   constraint PK_TIPOMUEBLE primary key (TMID)
);

/*==============================================================*/
/* Index: TIPOMUEBLE_PK                                         */
/*==============================================================*/
create unique index TIPOMUEBLE_PK on TIPOMUEBLE (
TMID ASC
);

/*==============================================================*/
/* Table: UBICACION                                             */
/*==============================================================*/
create table UBICACION 
(
   UBIID                integer                        not null AUTO_INCREMENT,
   ADID                 integer                        null,
   UBINOMBRE            long varchar                   not null,
   UBIESTADO            smallint                       not null,
   constraint PK_UBICACION primary key (UBIID)
);

/*==============================================================*/
/* Index: UBICACION_PK                                          */
/*==============================================================*/
create unique index UBICACION_PK on UBICACION (
UBIID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_9_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_9_FK on UBICACION (
ADID ASC
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO 
(
   USUID                integer                        not null AUTO_INCREMENT,
   USUNOMBRES           long varchar                   not null,
   USUAPELLIDOS         long varchar                   not null,
   USUEMAIL             long varchar                   not null,
   USUCONTRASENIA       long varchar                   not null,
   USUAUTHKEY           long varchar                   not null,
   USUACCESOTOKEN       long varchar                   not null,
   USUESTADO            smallint                       not null,
   ROLE                 numeric                        null,
   constraint PK_USUARIO primary key (USUID)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
USUID ASC
);

/*==============================================================*/
/* Table: USUXUBI                                               */
/*==============================================================*/
create table USUXUBI 
(
   USUXUBIID            integer                        not null AUTO_INCREMENT,
   UBIID                integer                        null,
   USUID                integer                        null,
   USUXUBIESTADO        smallint                       not null,
   constraint PK_USUXUBI primary key (USUXUBIID)
);

/*==============================================================*/
/* Index: USUXUBI_PK                                            */
/*==============================================================*/
create unique index USUXUBI_PK on USUXUBI (
USUXUBIID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_10_FK on USUXUBI (
USUID ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_12_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_12_FK on USUXUBI (
UBIID ASC
);

alter table EQUIPOINVENTARIADO
   add constraint FK_EQUIPOIN_RELATIONS_DOCUMENT foreign key (DIID)
      references DOCUMENTOINVENTARIO (DIID)
      on update restrict
      on delete restrict;

alter table INVENTARIO
   add constraint FK_INVENTAR_RELATIONS_MUEBLE foreign key (MUEID)
      references MUEBLE (MUEID)
      on update restrict
      on delete restrict;

alter table MUEBLE
   add constraint FK_MUEBLE_RELATIONS_TIPOMUEB foreign key (TMID)
      references TIPOMUEBLE (TMID)
      on update restrict
      on delete restrict;

alter table MUEBLE
   add constraint FK_MUEBLE_RELATIONS_USUXUBI foreign key (USUXUBIID)
      references USUXUBI (USUXUBIID)
      on update restrict
      on delete restrict;

alter table MUEBLE
   add constraint FK_MUEBLE_RELATIONS_CUENTACO foreign key (CCID)
      references CUENTACONTABLE (CCID)
      on update restrict
      on delete restrict;

alter table MUEBLE
   add constraint FK_MUEBLE_RELATIONS_COLOR foreign key (COLID)
      references COLOR (COLID)
      on update restrict
      on delete restrict;

alter table MUEBLE
   add constraint FK_MUEBLE_RELATIONS_MARCA foreign key (MARID)
      references MARCA (MARID)
      on update restrict
      on delete restrict;

alter table MUEBLE
   add constraint FK_MUEBLE_RELATIONS_ESTADO foreign key (ESTID)
      references ESTADO (ESTID)
      on update restrict
      on delete restrict;

alter table UBICACION
   add constraint FK_UBICACIO_RELATIONS_AREADEPE foreign key (ADID)
      references AREADEPENDENCIA (ADID)
      on update restrict
      on delete restrict;

alter table USUXUBI
   add constraint FK_USUXUBI_RELATIONS_USUARIO foreign key (USUID)
      references USUARIO (USUID)
      on update restrict
      on delete restrict;

alter table USUXUBI
   add constraint FK_USUXUBI_RELATIONS_UBICACIO foreign key (UBIID)
      references UBICACION (UBIID)
      on update restrict
      on delete restrict;

