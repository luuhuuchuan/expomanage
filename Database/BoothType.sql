use Expo
go
-- them du lieu de test xem bang Exhibitor trong Java co load dc thong tu DB khong
insert into BoothType (BTName, BTHeight, BTWidth, BoothRemain, BoothLength)
	values ('Quan ao','100','200','20','50')
insert into BoothType (BTName, BTHeight, BTWidth, BoothRemain, BoothLength)
	values ('Giay dep','100','200','20','50')
insert into BoothType (BTName, BTHeight, BTWidth, BoothRemain, BoothLength)
	values ('Hoa qua','100','200','20','50')
insert into BoothType (BTName, BTHeight, BTWidth, BoothRemain, BoothLength)
	values ('Dien tu','100','200','20','50')
insert into BoothType (BTName, BTHeight, BTWidth, BoothRemain, BoothLength)
	values ('Thuc pham','100','200','20','50')

-- Tao Store goi ra tat ca expo
create proc getAllBoothType
as
select * from BoothType

-- Tao Store co tham so de tao Expo

CREATE PROC AddBoothType
@Name nvarchar(100),
@Height float,
@Width float,
@BoothRemain int,
@BoothLength int
AS
INSERT INTO BoothType (BTName, BTHeight, BTWidth, BoothRemain, BoothLength)
VALUES(@Name,@Height,@Width,@BoothRemain,@BoothLength)

--Tao Store tim kiem Exhibitor
Create proc findExhibitorbyName
as
Select * from Exhibitor where EName like '%"+pattern+"%'
