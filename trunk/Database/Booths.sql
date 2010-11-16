use Expo
go
-- them du lieu de test xem bang Exhibitor trong Java co load dc thong tu DB khong
insert into Booths (BTID,SID,CID,BName, BDate, BMoney,BBooker)
	values ('1','1','A001','Quan ao','1/1/2010','2000','true')
insert into Booths (BTID,SID,CID,BName, BDate, BMoney,BBooker)
	values ('1','2','A001','Giay dep','1/1/2010','2000','true')
insert into Booths (BTID,SID,CID,BName, BDate, BMoney,BBooker)
	values ('1','3','A001','Sach vo','1/1/2010','2000','true')
insert into Booths (BTID,SID,CID,BName, BDate, BMoney,BBooker)
	values ('1','4','A001','Helo','1/1/2010','2000','true')




-- Tao Store goi ra tat ca expo
create proc getAllBooths
as
select B.CID,B.BID,BT.BTName,S.SName,B.BName,B.BDate, B.BMoney,B.BBooker 
from Booths B ,BoothType BT ,Staff S
where B.BTID = BT.BTID and B.SID = S.SID

-- Tao Store co tham so de tao Expo

CREATE PROC AddBooths
@Name nvarchar(100),
@Date smalldatetime,
@money float,
@bit bit
AS
INSERT INTO Booths (BTID,SID,CID,BName, BDate, BMoney,BBooker)
VALUES('1','11','A001',@Name,@Date,@money,@bit)
--Tao Store tim kiem Exhibitor
Create proc findExhibitorbyName
as
Select * from Exhibitor where EName like '%"+pattern+"%'
