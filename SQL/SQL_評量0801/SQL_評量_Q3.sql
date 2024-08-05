/*MIAOLI_VILLAGE*/
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C001', '�j�H��', '�˫n���q��1035��', '037-581072');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C002', '�˫n��', '�˫n��˫n�����s��103��', '037-472735');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C003', '�s�Ψ�', '�˫n��s�Ψ������14��', '037-614186');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C004', '�H����', '���s��H����������136-1��', '037-724839');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C005', '��]��', '�]�ߥ���]��������766��', '037-333240');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C006', '���ڨ�', '���ڨ����ڸ�96��', '037-660001');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C007', '������', '���������j��82��', '037-661145');
insert into MIAOLI_VILLAGE (NO, NAME, ADDRESS, TEL)
    values ('C008', '�H�q��', '�H�q���H�q��53��1��', '037-616072');

/*MIAOLI_BUILDING*/
insert into MIAOLI_BUILDING (NO, TYPE)
    values ('B001','���J');
insert into MIAOLI_BUILDING (NO, TYPE)
    values ('B002', '�j��');
insert into MIAOLI_BUILDING (NO, TYPE)
    values ('B003', '���@�]�I');
insert into MIAOLI_BUILDING (NO, TYPE)
    values ('B004', '�p����');
    
/*MIAOLI_POLICE*/
insert into MIAOLI_POLICE(NO, NAME, ADDRESS, TEL)
    values('M001', '�˫n����', '�]�߿��˫n����ڵ�72��', '037-474796');
insert into MIAOLI_POLICE(NO, NAME, ADDRESS, TEL)
    values('M002', '�]�ߤ���', '�]�߿��]�ߥ������109��', '037-320059');
insert into MIAOLI_POLICE(NO, NAME, ADDRESS, TEL)
    values('M003', '�Y������', '�]�߿��Y����������503��', '037-663004');
    
/*MIAOLI_SHELTER*/
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('1', '�]�߿��˫n���H��20��', '100', '1', 'B001', 'C001', 'M001');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('2', '�]�߿��˫n��M����79��', '3142', '1', 'B002', 'C002', 'M001');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('3', '�]�߿��˫n���s�s���T�q142��', '1072', '1', 'B002', 'C003', 'M001');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('4', '�]�߿����s���ظ�1498��', '32', '1', 'B003', 'C004', 'M001');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('5', '�]�߿��]�ߥ��̥���80��', '106', '1', 'B001', 'C005', 'M002');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('6', '�]�߿��]�ߥ����_��117��', '26', '1', 'B001', 'C005', 'M002');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('7', '�]�߿��]�ߥ��շR��109��', '2038', '2', 'B002', 'C005', 'M002');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('8', '�]�߿��]�ߥ��j�P��53��', '128', '2', 'B002', 'C005', 'M002');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('9', '�]�߿��Y�������ڨ��M����102��', '353', '1', 'B003', 'C006', 'M003');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('10', '�]�߿��Y�������������@��69��', '501', '1', 'B004', 'C007', 'M003');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('11', '�]�߿��Y�����H�q��������65��', '194', '1', 'B001', 'C008', 'M003');
insert into MIAOLI_SHELTER (NO, ADDRESS, PEOPLE, UNDERGROUND_FLOORS, BUILDING_NO, VILLAGE_NO, POLICE_NO)
    values ('12', '�]�߿��Y�����H�q��������116��', '78', '1', 'B004', 'C008', 'M003');
