use Expo
go
-- them du lieu de test xem bang Staff trong Java co load dc thong tu DB khong
-- luu y kieu datetime la thang truoc ngay sau (mm/dd/yy)
insert into Staff (CID,SName, SEmail, SPhone, SAddress)
	values ('A001','Kien','kientd@yahoo.com','0987642800','Hoan Kiem- Ha Noi')
insert into Staff (CID,SName, SEmail, SPhone, SAddress)
	values ('A001','Hoa','hoabx@gmail.com','0953900039','Linh Dam- Ha Noi')
insert into Staff (CID,SName, SEmail, SPhone, SAddress)
	values ('A001','Cuong','cuonght@gmail.com','01234599999','Tu Liem- Ha Noi')
insert into Staff (CID,SName, SEmail, SPhone, SAddress)
	values ('A001','Duong','duongnn@gmail.com','01234567999','Cau Giay- Ha Noi')
insert into Staff (CID,SName, SEmail, SPhone, SAddress)
	values ('A001','Tien','tientt@gmail.com','01234567777','Hoang Mai- Ha Noi')

-- Tao Store goi ra tat ca Staff
create proc getAllStaff
as
select S.SID,C.CID,S.SName,S.SEmail,S.SPhone,S.SAddress 
from Staff S join Contact C
on S.CID = C.CID


-- Tao Store co tham so de tao Staff

CREATE PROC AddStaff
@CID char(10),
@Name nvarchar(100),
@Email nvarchar(100),
@Phone nvarchar(50),
@Address ntext
AS
INSERT INTO Staff (CID,SName, SEmail, SPhone, SAddress)
	VALUES(@CID,@Name,@Email,@Phone,@Address)

----Tao Store tim kiem Staff
Create PROC findStaff
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @sta nvarchar(200)
set @sta = 'select S.SID,C.CID,S.SName,S.SEmail,S.SPhone,S.SAddress from Staff S join Contact C on S.CID = C.CID where '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@sta)

--Tao Store de Edit Staff
Create Proc EditStaff
@ID int,
@CID char(10),
@Name nvarchar(100),
@Email nvarchar(100),
@Phone nvarchar(50),
@Address ntext
AS
Update Staff
Set CID = @CID,SName = @Name,SEmail = @Email,SPhone = @Phone,SAddress = @Address
Where SID = @ID

--Tao store de xoa staff
CREATE PROC DeleteStaff
@id int
AS
DELETE FROM Staff WHERE SID = @id

