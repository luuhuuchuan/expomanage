use Expo
go
-- them du lieu de test xem bang Products trong Java co load dc thong tu DB khong
-- luu y kieu datetime la thang truoc ngay sau (mm/dd/yy)
insert into Products (EID,CID,PName, PPrice, PNumber, PDescription, PDate)
	values (1,'A001','Ways RS',17500000,100,'Dong xe moi cua Honda','1/1/2010')
insert into Products (EID,CID,PName, PPrice, PNumber, PDescription, PDate)
	values (1,'A001','Nokia X6',6940000,200,'Dong dien thoai cam ung','7/5/2010')
insert into Products (EID,CID,PName, PPrice, PNumber, PDescription, PDate)
	values (1,'A001','HP500',13500000,150,'May tinh thuong hieu viet','8/6/2010')
insert into Products (EID,CID,PName, PPrice, PNumber, PDescription, PDate)
	values (1,'A001','Compac',13500,300,'Den Compac','10/6/2010')
insert into Products (EID,CID,PName, PPrice, PNumber, PDescription, PDate)
	values (1,'A001','Thanh Giong',7500000,150,'May tinh viet','9/8/2010')
-- Tao Store goi ra tat ca Products
create proc getAllProducts
as
select * from Products

-- Tao Store co tham so de tao Products

CREATE PROC AddProducts
@Name nvarchar(100),
@Price float,
@Number int,
@Description ntext,
@Date SMALLDATETIME
AS
BEGIN
	INSERT INTO Products (PName, PPrice, PNumber, PDescription, PDate)
	VALUES(@Name,@Price,@Number,@Description,@Date)
END
