use Expo
go
-- them du lieu de test xem bang Exhibitor trong Java co load dc thong tu DB khong
insert into Exhibitor (EName, EFax, EPhone, EAddress, EWebsite)
	values ('Nam','01243234','0123456789','Dong Da- Ha Noi','http://shopvnn.com')
insert into Exhibitor (EName, EFax, EPhone, EAddress, EWebsite)
	values ('Dung','0345678','0123231212','Ha Dong- Ha Noi','http://dienthoai.com')
insert into Exhibitor (EName, EFax, EPhone, EAddress, EWebsite)
	values ('Hoang','0876543','0123456788','Tu Liem- Ha Noi','http://maytinh.com')
insert into Exhibitor (EName, EFax, EPhone, EAddress, EWebsite)
	values ('Phong','0124312','0123456778','Cau Giay- Ha Noi','http://ebay.com')
insert into Exhibitor (EName, EFax, EPhone, EAddress, EWebsite)
	values ('Quang','2103121','0123456777','Ba Dinh- Ha Noi','http://chodientu.com')

-- Tao Store goi ra tat ca Exhibitor
create proc getAllExhibitor
as
select * from Exhibitor

-- Tao Store co tham so de tao Exhibitor

CREATE PROC AddExhibitor
@Name nvarchar(100),
@Fax float,
@Phone int,
@Address ntext,
@Website SMALLDATETIME
AS
INSERT INTO Exhibitor (EName, EFax, EPhone, EAddress, EWebsite)
VALUES(@Name,@Fax,@Phone,@Address,@Website)
PRINT '1 BAN GHI VUA DUOC THEM'

--Tao Store tim kiem Exhibitor
Create proc findExhibitorbyName
as
Select * from Exhibitor where EName like '%"+pattern+"%'
