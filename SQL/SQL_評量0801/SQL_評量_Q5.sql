/*
5-1. ��s�����]�I�a�} �O �u�]�߿� �˫n��M���� 79 �� �v���e�H�ƶq�� 5000 �H �C
5-2. �R�������]�I�p �� 1000 �e�H�ƶq�� ��� �C
*/

/*5-1*/
update MIAOLI_SHELTER
    set PEOPLE = '5000'
    where ADDRESS = '�]�߿��˫n��M����79��';
    
/*5-2*/
delete from MIAOLI_SHELTER
    where PEOPLE < '1000';
/*���W�r*/
