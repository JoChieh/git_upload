/*
4-1. 列出 轄管 區域"內有單一 SHELTER大於 1000 CAPACITY  的 POLICE 及 POLICE.TEL 。
4-2. 列出 轄管 區域內有單一 避難設施大於 1000 容人數量的 轄管分局 及 分局連絡電話 並 計算出 各 轄管分局數量 。 （關鍵字 partition
4-3. 承上題， 再補上 避難設施地址 、 類型 。
4-4. 查詢設施地址包含「中」字的避難設施，列出資料必須含 村里別 、 避難設施地址 、 容人數量 、 轄管分局 及 分局連絡電話 。
4-5. 查詢 所有 類別 為 公寓及大樓 的 避難設施 列出 資料必須包含 村里別 、 村里辦公室位置 、 避難設施地址 、 容人數量 。
*/

/*4-1. 列出 轄管 區域"內有單一 SHELTER大於 1000 CAPACITY  的 POLICE 及 POLICE.TEL*/
/*先join 後where*/

select distinct
	POLICE.NAME as "轄區分局",
	POLICE.TEL as "分局連絡電話"
    from MIAOLI_SHELTER SHELTER
    left join MIAOLI_POLICE POLICE
    on SHELTER.POLICE_NO = POLICE.NO
    where CAPACITY > '1000';
/*4-2. 列出 轄管 區域內有單一 避難設施大於 1000 容人數量的 轄管分局 及 分局連絡電話 並 計算出 各 轄管分局數量 。 （關鍵字 partition */

select distinct
    NAME as "轄管分局",
    TEL as "分局連絡電話",
    count(NAME) over (partition by NAME) as "轄管分局數量"
    from(
        select
            POLICE.NAME, 
            POLICE.TEL
            from MIAOLI_SHELTER SHELTER
            left join MIAOLI_POLICE POLICE
            on SHELTER.POLICE_NO = POLICE.NO
            where CAPACITY > '1000'
    );
    
/*4-3. 承上題， 再補上 SHELTER.ADRESS 、 BUILDING.TYPE*/
/*減少子查詢 from SHELTER join POLICE*/
select
    POLICE.NAME as "轄管分局",
    POLICE.TEL as "分局連絡電話",
    SHELTER.ADDRESS as "避難設施地址",
    BUILDING.TYPE as "住宅類型"
 from MIAOLI_SHELTER SHELTER
 left join MIAOLI_POLICE POLICE
 on SHELTER.POLICE_NO = POLICE.NO
 left join MIAOLI_BUILDING BUILDING
 on SHELTER.BUILDING_NO = BUILDING.NO
 where SHELTER.CAPACITY > '1000';
    
/*4-4. 查詢SHELTER.ADDRESS包含「中」字的避難設施，列出資料必須含 村里別VILLAGE.NAME、 SHELTER.ADDRESS 、CAPACITY、POLICE.NAME及POLICE.TEL*/
select 
    VILLAGE.NAME as "轄管村里名",
    SHELTER.ADDRESS as "避難設施地址", 
    SHELTER.CAPACITY as "容納人數",
    POLICE.NAME as "轄管分局",
    POLICE.TEL as "分局電話"
from(
        select VILLAGE_NO,
            ADDRESS,
            CAPACITY,
            POLICE_NO    
            from MIAOLI_SHELTER
            where ADDRESS like '%中%'
    )SHELTER
    left join (
        select NO,
            NAME
            from MIAOLI_VILLAGE
    )VILLAGE
    on SHELTER.VILLAGE_NO = VILLAGE.NO
    
    left join MIAOLI_POLICE POLICE
    on SHELTER.POLICE_NO = POLICE.NO;
    
/*4-5. 查詢 所有 類別BUILDING.TYPE 為 公寓及大樓 的 避難設施 列出 資料必須包含 村里別 、 村里辦公室位置 、 避難設施地址 、 容人數量*/
select VILLAGE.NAME as "村里別",
    VILLAGE.ADDRESS as "村里辦公室位置",
    SHELTER.ADDRESS as "避難設施地址",
    SHELTER.CAPACITY as "容納人數",
    BUILDING.TYPE
    from MIAOLI_SHELTER SHELTER
    
    left join  MIAOLI_VILLAGE VILLAGE
    on SHELTER.VILLAGE_NO = VILLAGE.NO
    
    right join(
        select * from MIAOLI_BUILDING
            where TYPE in ('公寓', '大樓')
    )BUILDING
    on SHELTER.BUILDING_NO = BUILDING.NO;
