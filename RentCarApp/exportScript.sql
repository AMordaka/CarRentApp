drop table CAR cascade constraints;
drop table CAR_TYPE cascade constraints;
drop table OWNED_CAR cascade constraints;
drop table PERSISTENT_LOGINS cascade constraints;
drop table PROFILE cascade constraints;
drop table RESERVATION cascade constraints;
drop table USER_T cascade constraints;
drop table USERS_PROFILES cascade constraints;
drop table CAR cascade constraints;
drop table CAR_TYPE cascade constraints;
drop table OWNED_CAR cascade constraints;
drop table PERSISTENT_LOGINS cascade constraints;
drop table PROFILE cascade constraints;
drop table RESERVATION cascade constraints;
drop table USER_T cascade constraints;
drop table USERS_PROFILES cascade constraints;
drop sequence hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table CAR (CAR_ID number(19,0) not null, AVAILABLE number(1,0) not null, REG_NO varchar2(255 char) not null, RETURN_DATE varchar2(255 char), START_DATE varchar2(255 char), YEAR varchar2(4 char) not null, CAR_TYPE_ID number(10,0), primary key (CAR_ID));
create table CAR_TYPE (CAR_TYPE_ID number(10,0) not null, MARK varchar2(255 char) not null, MODEL varchar2(255 char) not null, primary key (CAR_TYPE_ID));
create table OWNED_CAR (USER_ID number(10,0) not null, CAR_ID number(19,0) not null, primary key (CAR_ID, USER_ID));
create table PERSISTENT_LOGINS (series varchar2(255 char) not null, last_used timestamp, TOKEN varchar2(255 char) not null, USERNAME varchar2(255 char) not null, primary key (series));
create table PROFILE (id number(10,0) not null, TYPE varchar2(15 char) not null, primary key (id));
create table RESERVATION (USER_ID number(10,0) not null, CAR_ID number(19,0) not null, primary key (USER_ID, CAR_ID));
create table USER_T (id number(10,0) not null, EMAIL varchar2(255 char) not null, FIRST_NAME varchar2(255 char) not null, LAST_NAME varchar2(255 char) not null, PASSWORD varchar2(255 char) not null, PICTURE blob, SSO_ID varchar2(255 char) not null, primary key (id));
create table USERS_PROFILES (USER_ID number(10,0) not null, USER_PROFILE_ID number(10,0) not null, primary key (USER_ID, USER_PROFILE_ID));
alter table PERSISTENT_LOGINS add constraint UK_3gq9wkitbp2ave684iu50mhn7 unique (TOKEN);
alter table PERSISTENT_LOGINS add constraint UK_a6c251uovnx2cp2c3vv2dentk unique (USERNAME);
alter table PROFILE add constraint UK_47od1axoagehbude9lu8cog52 unique (TYPE);
alter table USER_T add constraint UK_jy7y85m0318nf7pml0slm1a2i unique (SSO_ID);
alter table CAR add constraint FKfe8x0lyd8i0wcg0u0ntofgg1 foreign key (CAR_TYPE_ID) references CAR_TYPE;
alter table OWNED_CAR add constraint FKci4vlb77ojurubjhywet9b5ge foreign key (CAR_ID) references CAR;
alter table OWNED_CAR add constraint FKca8wesgx4c4al1xbs7ylm1rdk foreign key (USER_ID) references USER_T;
alter table RESERVATION add constraint FKk5wceodxcbfq4pwy93avl9dtg foreign key (CAR_ID) references CAR;
alter table RESERVATION add constraint FKh75mqr56jaf6o3b116im8r2du foreign key (USER_ID) references USER_T;
alter table USERS_PROFILES add constraint FK5wr604pr9ppjo8egvdoy6nd7e foreign key (USER_PROFILE_ID) references PROFILE;
alter table USERS_PROFILES add constraint FKkejsr19ecu31p1jtl08j7lyew foreign key (USER_ID) references USER_T;
