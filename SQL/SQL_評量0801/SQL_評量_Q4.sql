/*
4-1. �C�X �Һ� �ϰ�"������@ SHELTER�j�� 1000 CAPACITY  �� POLICE �� POLICE.TEL �C
4-2. �C�X �Һ� �ϰ줺����@ �����]�I�j�� 1000 �e�H�ƶq�� �Һޤ��� �� �����s���q�� �� �p��X �U �Һޤ����ƶq �C �]����r partition
4-3. �ӤW�D�A �A�ɤW �����]�I�a�} �B ���� �C
4-4. �d�߳]�I�a�}�]�t�u���v�r�������]�I�A�C�X��ƥ����t �����O �B �����]�I�a�} �B �e�H�ƶq �B �Һޤ��� �� �����s���q�� �C
4-5. �d�� �Ҧ� ���O �� ���J�Τj�� �� �����]�I �C�X ��ƥ����]�t �����O �B �����줽�Ǧ�m �B �����]�I�a�} �B �e�H�ƶq �C
*/

/*4-1. �C�X �Һ� �ϰ�"������@ SHELTER�j�� 1000 CAPACITY  �� POLICE �� POLICE.TEL*/
/*��join ��where*/

select distinct
	POLICE.NAME as "�ҰϤ���",
	POLICE.TEL as "�����s���q��"
    from MIAOLI_SHELTER SHELTER
    left join MIAOLI_POLICE POLICE
    on SHELTER.POLICE_NO = POLICE.NO
    where PEOPLE > '1000';
/*4-2. �C�X �Һ� �ϰ줺����@ �����]�I�j�� 1000 �e�H�ƶq�� �Һޤ��� �� �����s���q�� �� �p��X �U �Һޤ����ƶq �C �]����r partition */

select distinct
    POLICE.NAME as "�Һޤ���",
    POLICE.TEL as "�����s���q��",
    count(POLICE.NAME) over (partition by POLICE.NAME) as "�Һޤ����ƶq"
 from STUDENT.MIAOLI_SHELTER SHELTER
 left join STUDENT.MIAOLI_POLICE POLICE
 on SHELTER.POLICE_NO = POLICE.NO
 where SHELTER.PEOPLE > '1000';
    
/*4-3. �ӤW�D�A �A�ɤW SHELTER.ADRESS �B BUILDING.TYPE*/
/*��֤l�d�� from SHELTER join POLICE*/
select
    POLICE.NAME as "�Һޤ���",
    POLICE.TEL as "�����s���q��",
    SHELTER.ADDRESS as "�����]�I�a�}",
    BUILDING.TYPE as "��v����"
 from STUDENT.MIAOLI_SHELTER SHELTER
 left join MIAOLI_POLICE POLICE
 on SHELTER.POLICE_NO = POLICE.NO
 left join STUDENT.MIAOLI_BUILDING BUILDING
 on SHELTER.BUILDING_NO = BUILDING.NO
 where SHELTER.PEOPLE > '1000';
    
/*4-4. �d��SHELTER.ADDRESS�]�t�u���v�r�������]�I�A�C�X��ƥ����t �����OVILLAGE.NAME�B SHELTER.ADDRESS �BCAPACITY�BPOLICE.NAME��POLICE.TEL*/
select 
    VILLAGE.NAME as "�Һާ����W",
    SHELTER.ADDRESS as "�����]�I�a�}", 
    SHELTER.PEOPLE as "�e�ǤH��",
    POLICE.NAME as "�Һޤ���",
    POLICE.TEL as "�����q��"
 from STUDENT.MIAOLI_SHELTER SHELTER
 left join STUDENT.MIAOLI_VILLAGE VILLAGE
 on SHELTER.VILLAGE_NO = VILLAGE.NO
 left join STUDENT.MIAOLI_POLICE POLICE
 on SHELTER.POLICE_NO = POLICE.NO
 where SHELTER.ADDRESS like '%��%';
    
/*4-5. �d�� �Ҧ� ���OBUILDING.TYPE �� ���J�Τj�� �� �����]�I �C�X ��ƥ����]�t �����O �B �����줽�Ǧ�m �B �����]�I�a�} �B �e�H�ƶq*/
select VILLAGE.NAME as "�����O",
    VILLAGE.ADDRESS as "�����줽�Ǧ�m",
    SHELTER.ADDRESS as "�����]�I�a�}",
    SHELTER.PEOPLE as "�e�ǤH��",
    BUILDING.TYPE as "��v����"
    from MIAOLI_SHELTER SHELTER
    
    left join  MIAOLI_VILLAGE VILLAGE
    on SHELTER.VILLAGE_NO = VILLAGE.NO
    
    right join MIAOLI_BUILDING BUILDING
    on SHELTER.BUILDING_NO = BUILDING.NO
    
    where BUILDING.TYPE in ('���J', '�j��')
