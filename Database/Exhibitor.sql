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
@Fax varchar(30),
@Phone varchar(30),
@Address ntext,
@Website varchar(100)
AS
BEGIN
	INSERT INTO Exhibitor (EName, EFax, EPhone, EAddress, EWebsite)
	VALUES(@Name,@Fax,@Phone,@Address,@Website)
END

----Tao Store tim kiem Exhibitor
Create PROC findExhibitor
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @exh nvarchar(200)
set @exh = 'Select * from Exhibitor where '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@exh)

--Tao Store de Edit Exhibitor
Create Proc EditExhibitor
@ID int,
@Name nvarchar(100),
@Fax varchar(30),
@Phone varchar(30),
@Address ntext,
@Website varchar(100)
AS
Update Exhibitor
Set EName = @Name,EFax = @Fax,Ephone = @Phone,EAddress = @Address,EWebsite = @Website
Where EID = @ID

--Tao store de xoa exhibitor
CREATE PROC DeleteExhibitor
@id int
AS
DELETE FROM Exhibitor WHERE EID = @id

--Tao Store lay ra ID moi nhat cua Exhibitor
Create Proc GetExhibitorID
AS
Select Max(EID) From Exhibitor

exec GetExhibitorID