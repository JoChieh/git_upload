/*
4-1. �C�X �Һ� �ϰ�"������@ SHELTER�j�� 1000 CAPACITY  �� POLICE �� POLICE.TEL �C
4-2. �C�X �Һ� �ϰ줺����@ �����]�I�j�� 1000 �e�H�ƶq�� �Һޤ��� �� �����s���q�� �� �p��X �U �Һޤ����ƶq �C �]����r partition
4-3. �ӤW�D�A �A�ɤW �����]�I�a�} �B ���� �C
4-4. �d�߳]�I�a�}�]�t�u���v�r�������]�I�A�C�X��ƥ����t �����O �B �����]�I�a�} �B �e�H�ƶq �B �Һޤ��� �� �����s���q�� �C
4-5. �d�� �Ҧ� ���O �� ���J�Τj�� �� �����]�I �C�X ��ƥ����]�t �����O �B �����줽�Ǧ�m �B �����]�I�a�} �B �e�H�ƶq �C
*/

/*4-1. �C�X �Һ� �ϰ�"������@ SHELTER�j�� 1000 CAPACITY  �� POLICE �� POLICE.TEL*/

select distinct
	POLICE.NAME as "�ҰϤ���",
	POLICE.TEL as "�����s���q��"
    from(
        select CAPACITY, POLICE_NO
            from MIAOLI_SHELTER
            where CAPACITY > '1000'
    )SHELTER
    left join MIAOLI_POLICE POLICE
    on SHELTER.POLICE_NO = POLICE.NO;
/*4-2. �C�X �Һ� �ϰ줺����@ �����]�I�j�� 1000 �e�H�ƶq�� �Һޤ��� �� �����s���q�� �� �p��X �U �Һޤ����ƶq �C �]����r partition */

select distinct
    NAME as "�Һޤ���",
    TEL as "�����s���q��",
    count(NAME) over (partition by NAME) as "�Һޤ����ƶq"
    from(
        select
            POLICE.NAME, 
            POLICE.TEL
            from(
                select CAPACITY, POLICE_NO
                    from MIAOLI_SHELTER
                    where CAPACITY > '1000'
            )SHELTER
            left join MIAOLI_POLICE POLICE
            on SHELTER.POLICE_NO = POLICE.NO
    );
    
/*4-3. �ӤW�D�A �A�ɤW SHELTER.ADRESS �B BUILDING.TYPE*/
select
    NAME as "�Һޤ���",
    TEL as "�����s���q��",
    ADDRESS as "�����]�I�a�}",
    TYPE as "��v����"
    /*count(NAME_TEL.NAME) over (partition by NAME_TEL.NAME) as COUNT*/
    from(
        select /*SHELTER.CAPACITY, SHELTER.POLICE_NO, POLICE.NO, */
            SHELTER.ADDRESS,
            SHELTER.POLICE_NO,
            SHELTER.BUILDING_NO,
            POLICE.NAME, 
            POLICE.TEL
            from(
                select ADDRESS,
                    CAPACITY,
                    POLICE_NO,
                    BUILDING_NO
                    from MIAOLI_SHELTER
                    where CAPACITY > '1000'
            )SHELTER
            left join(
                select NO, NAME, TEL from MIAOLI_POLICE
            )POLICE
            on SHELTER.POLICE_NO = POLICE.NO
    )NAME_TEL
    
    left join MIAOLI_BUILDING BUILDING
    on NAME_TEL. BUILDING_NO = BUILDING.NO;
    
/*4-4. �d��SHELTER.ADDRESS�]�t�u���v�r�������]�I�A�C�X��ƥ����t �����OVILLAGE.NAME�B SHELTER.ADDRESS �BCAPACITY�BPOLICE.NAME��POLICE.TEL*/
select 
    VILLAGE.NAME as "�Һާ����W",
    SHELTER.ADDRESS as "�����]�I�a�}", 
    SHELTER.CAPACITY as "�e�ǤH��",
    POLICE.NAME as "�Һޤ���",
    POLICE.TEL as "�����q��"
from(
        select VILLAGE_NO,
            ADDRESS,
            CAPACITY,
            POLICE_NO    
            from MIAOLI_SHELTER
            where ADDRESS like '%��%'
    )SHELTER
    left join (
        select NO,
            NAME
            from MIAOLI_VILLAGE
    )VILLAGE
    on SHELTER.VILLAGE_NO = VILLAGE.NO
    
    left join MIAOLI_POLICE POLICE
    on SHELTER.POLICE_NO = POLICE.NO;
    
/*4-5. �d�� �Ҧ� ���OBUILDING.TYPE �� ���J�Τj�� �� �����]�I �C�X ��ƥ����]�t �����O �B �����줽�Ǧ�m �B �����]�I�a�} �B �e�H�ƶq*/
select VILLAGE.NAME as "�����O",
    VILLAGE.ADDRESS as "�����줽�Ǧ�m",
    SHELTER.ADDRESS as "�����]�I�a�}",
    SHELTER.CAPACITY as "�e�ǤH��",
    BUILDING.TYPE
    from MIAOLI_SHELTER SHELTER
    
    left join  MIAOLI_VILLAGE VILLAGE
    on SHELTER.VILLAGE_NO = VILLAGE.NO
    
    right join(
        select * from MIAOLI_BUILDING
            where TYPE in ('���J', '�j��')
    )BUILDING
    on SHELTER.BUILDING_NO = BUILDING.NO;
