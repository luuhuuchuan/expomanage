use Expo
go
-- them du lieu de test xem bang Exhibitor trong Java co load dc thong tu DB khong
insert into Staff (CID, SName, SEmail, SPhone ,SAddress)
	values ('1','Vu','vunt@fpt.edu,vn','123456','ha noi')
insert into Booths (BTID,SID,CID,BName, BDate, BMoney,BBooker)
	values ('1','1','001','Quan ao','1/1/2010','2000','true')


-- Tao Store goi ra tat ca expo
create proc getAllBooths
as
select * from Booths

-- Tao Store co tham so de tao Expo

CREATE PROC AddBooths
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
