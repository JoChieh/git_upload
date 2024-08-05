/*
5-1. 更新避難設施地址 是 「苗栗縣 竹南鎮和平街 79 號 」的容人數量為 5000 人 。
5-2. 刪除避難設施小 於 1000 容人數量的 資料 。
*/

/*5-1*/
update MIAOLI_SHELTER
    set PEOPLE = '5000'
    where ADDRESS = '苗栗縣竹南鎮和平街79號';
    
/*5-2*/
delete from MIAOLI_SHELTER
    where PEOPLE < '1000';
/*換名字*/
