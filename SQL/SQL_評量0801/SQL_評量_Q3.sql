/*MIAOLI_VILLAGE*/
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C001', '大埔里', '竹南鎮公義路1035號', '037-581072');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C002', '竹南里', '竹南鎮竹南里中山路103號', '037-472735');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C003', '山佳里', '竹南鎮山佳里國光街14號', '037-614186');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C004', '埔頂里', '後龍鎮埔頂里中興路136-1號', '037-724839');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C005', '綠苗里', '苗栗市綠苗里中正路766號', '037-333240');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C006', '民族里', '民族里民族路96號', '037-660001');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C007', '忠孝里', '忠孝里光大街82號', '037-661145');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C008', '信義里', '信義里信義路53巷1號', '037-616072');

/*MIAOLI_BUILDING*/
insert into MIAOLI_BUILDING (NO, TYPE)
    values ('B001','公寓');
insert into MIAOLI_BUILDING (NO, TYPE)
    values ('B002', '大樓');
insert into MIAOLI_BUILDING (NO, TYPE)
    values ('B003', '公共設施');
insert into MIAOLI_BUILDING (NO, TYPE)
    values ('B004', '私營單位');
    
/*MIAOLI_POLICE*/
insert into MIAOLI_POLICE(NO, NAME, ADDRESS, TEL)
    values('M001', '竹南分局', '苗栗縣竹南鎮民族街72號', '037-474796');
insert into MIAOLI_POLICE(NO, NAME, ADDRESS, TEL)
    values('M002', '苗栗分局', '苗栗縣苗栗市金鳳街109號', '037-320059');
insert into MIAOLI_POLICE(NO, NAME, ADDRESS, TEL)
    values('M003', '頭份分局', '苗栗縣頭份市中興路503號', '037-663004');
    
/*MIAOLI_SHELTER*/
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('1', '苗栗縣竹南鎮中埔街20號', '100', '1', 'B001', 'C001', 'M001');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('2', '苗栗縣竹南鎮和平街79號', '3142', '1', 'B002', 'C002', 'M001');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('3', '苗栗縣竹南鎮龍山路三段142號', '1072', '1', 'B002', 'C003', 'M001');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('4', '苗栗縣後龍鎮中華路1498號', '32', '1', 'B003', 'C004', 'M001');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('5', '苗栗縣苗栗市米市街80號', '106', '1', 'B001', 'C005', 'M002');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('6', '苗栗縣苗栗市光復路117號', '26', '1', 'B001', 'C005', 'M002');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('7', '苗栗縣苗栗市博愛街109號', '2038', '2', 'B002', 'C005', 'M002');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('8', '苗栗縣苗栗市大同路53號', '128', '2', 'B002', 'C005', 'M002');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('9', '苗栗縣頭份市民族里和平路102號', '353', '1', 'B003', 'C006', 'M003');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('10', '苗栗縣頭份市忠孝忠孝一路69號', '501', '1', 'B004', 'C007', 'M003');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('11', '苗栗縣頭份市信義里中正路65號', '194', '1', 'B001', 'C008', 'M003');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('12', '苗栗縣頭份市信義里中正路116號', '78', '1', 'B004', 'C008', 'M003');
