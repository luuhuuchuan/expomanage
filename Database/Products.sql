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
@EID int,
@CID char(10),
@Name nvarchar(100),
@Price float,
@Number int,
@Description ntext,
@Date smalldatetime
AS
INSERT INTO Products (EID,CID,PName, PPrice, PNumber, PDescription, PDate)
VALUES(@EID,@CID,@Name,@Price,@Number,@Description,@Date)

--Tao Store de xoa Product
CREATE PROC DeleteProducts
@Name nvarchar(100)
AS
  BEGIN 
        DECLARE @id int
        SET @id=(SELECT Pid FROM Products WHERE PName = @Name)
        -- Bat dau xoa
        DELETE FROM Products WHERE PName = @Name
  END

--Tao Store de tim kiem Product theo ten
CREATE PROC findbyName
@Name nvarchar(100)
AS
BEGIN
	SELECT * FROM Products WHERE PName = @Name
END

--Tao Store de Edit Product
Create Proc EditProduct
@Id int,
@EID int,
@CID char(10),
@Name nvarchar(100),
@Price float,
@Number int,
@Description ntext,
@Date smalldatetime
AS
	Begin
		Update Products
		Set EID = @EID,CID = @CID,PName = @Name,PPrice = @Price,PNumber = @Number,PDescription = @Description,PDate = @Date
		Where PID = @Id		
	End

--Store lay ID cua Exhibitor
create proc get_EID
as
select ExID
from Expo