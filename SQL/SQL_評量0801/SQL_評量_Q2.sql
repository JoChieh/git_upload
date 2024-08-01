create table MIAOLI_SHELTER(
    NO NUMBER primary key,
    ADDRESS NVARCHAR2(20),
    CAPACITY INTEGER,
    UNDERGROUND_FLOORS INTEGER,
    BUILDING_NO VARCHAR2(10 BYTE),
    VILLAGE_NO VARCHAR2(10 BYTE),
    POLICE_NO VARCHAR2(10 BYTE));

create table MIAOLI_BUILDING(
    NO VARCHAR2(10 BYTE) primary key,
    TYPE NVARCHAR2(20));

create table MIAOLI_VILLAGE(
    NO VARCHAR2(10 BYTE) primary key,
    NAME NVARCHAR2(20),
    ADDRESS NVARCHAR2(100),
    TEL NVARCHAR2(20));

create table MIAOLI_POLICE(
    NO VARCHAR2(10 BYTE) primary key,
    NAME NVARCHAR2(20),
    ADDRESS NVARCHAR2(100),
    TEL NVARCHAR2(20));
    
    
/*CREATE з╣жи*/
select * from MIAOLI_SHELTER;
select * from MIAOLI_BUILDING;
select * from MIAOLI_VILLAGE;
select * from MIAOLI_POLICE;

/*е[F.K.*/
alter table MIAOLI_SHELTER
    add foreign key(BUILDING_NO) references MIAOLI_BUILDING(NO);
    
alter table MIAOLI_SHELTER
    add foreign key(VILLAGE_NO) references MIAOLI_VILLAGE(NO);
    
alter table MIAOLI_SHELTER
    add foreign key(POLICE_NO) references MIAOLI_POLICE(NO);