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
select * from Staff

-- Tao Store co tham so de tao Staff

CREATE PROC AddStaff
@Name nvarchar(100),
@Email nvarchar(100),
@Phone int,
@Address ntext
AS
INSERT INTO Staff (SName, SEmail, SPhone, SAddress)
	VALUES(@Name,@Email,@Phone,@Address)
END
