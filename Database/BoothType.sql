use Expo
go
-- them du lieu de test xem bang Exhibitor trong Java co load dc thong tu DB khong
insert into BoothType (BTName,ExID , BTHeight, BTWidth, BoothRemain, BoothLength)
	values ('Quan ao',1,100,200,20,50)
insert into BoothType (BTName,ExID , BTHeight, BTWidth, BoothRemain, BoothLength)
	values ('Giay dep',5,100,200,20,50)
insert into BoothType (BTName,ExID , BTHeight, BTWidth, BoothRemain, BoothLength)
	values ('Hoa qua',2,100,200,20,50)
insert into BoothType (BTName,ExID , BTHeight, BTWidth, BoothRemain, BoothLength)
	values ('Dien tu',3,100,200,20,50)
insert into BoothType (BTName,ExID , BTHeight, BTWidth, BoothRemain, BoothLength)
	values ('Thuc pham',4,100,200,20,50)


-- Tao Store goi ra tat ca expo
create proc getAllBoothType
as
select BT.BTName,E.ExName,BT.BTHeight, BT.BTWidth, BT.BoothRemain, BT.BoothLength 
from BoothType BT join Expo E
on BT.ExID = E.ExID


-- Tao Store goi ra ten va id tat ca expo
create proc getID_Name_Of_Expo2
as
select ExName, ExID
from Expo

exec getID_Name_Of_Expo2

-- Tao Store co tham so de tao Expo

CREATE PROC AddBoothType
@Name nvarchar(100),
@ExID int,
@Height float,
@Width float,
@BoothRemain int,
@BoothLength int
AS
INSERT INTO BoothType (BTName,ExID, BTHeight, BTWidth, BoothRemain, BoothLength)
VALUES(@Name,@ExID,@Height,@Width,@BoothRemain,@BoothLength)

-- Tao Store delete BoothType
create proc deleteBoothType
@ID int
as
delete from BoothType
where BTID = @ID

-- Tao store edit BoothType
create proc editBoothType
@ID int,
@Name nvarchar(100),
@ExID int,
@Height float,
@Width float,
@BoothRemain int,
@BoothLength int
as
update BoothType
set BTName = @Name
where BTID = @ID

update BoothType
set ExID = @ExID
where BTID = @ID

update BoothType
set BTHeight = @Height
where BTID = @ID

update BoothType
set BTWidth = @Width
where BTID = @ID

update BoothType
set BoothRemain = @BoothRemain
where BTID = @ID

update BoothType
set BoothLength = @BoothLength
where BTID = @ID


--Tao Store tim kiem Exhibitor
Create proc findExhibitorbyName
as
Select * from Exhibitor where EName like '%"+pattern+"%'
