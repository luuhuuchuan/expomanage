use Expo
go
-- them du lieu de test xem bang Products trong Java co load dc thong tu DB khong
-- luu y kieu datetime la thang truoc ngay sau (mm/dd/yy)
insert into Products (EID,CID,PName, PPrice, PNumber, PDescription, PDate)
	values (1,'A001','Nokia C3',4500000,20,'Dong dien thoai moi cua Nokia','1/1/2010')
insert into Products (EID,CID,PName, PPrice, PNumber, PDescription, PDate)
	values (1,'A001','Nokia X6',6940000,30,'Dong dien thoai cam ung','7/5/2010')
insert into Products (EID,CID,PName, PPrice, PNumber, PDescription, PDate)
	values (1,'A001','HP500',13500000,15,'May tinh thuong hieu viet','8/6/2010')
insert into Products (EID,CID,PName, PPrice, PNumber, PDescription, PDate)
	values (1,'A001','Compac',13500000,30,'Den Compac','10/6/2010')
insert into Products (EID,CID,PName, PPrice, PNumber, PDescription, PDate)
	values (1,'A001','Thanh Giong',7500000,15,'May tinh viet','9/8/2010')
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
@id int
AS
DELETE FROM Products WHERE PID = @id

--Tao Store de tim kiem Product theo ten
Create PROC findProduct
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @sp nvarchar(200)
set @sp = 'Select * from Products where '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@sp)

exec findProduct 'PID', '4'
--Tao Store de Edit Product
Create Proc EditProduct
@Id int,
@CID char(10),
@Name nvarchar(100),
@Price float,
@Number int,
@Description ntext
AS
Update Products
Set CID = @CID,PName = @Name,PPrice = @Price,PNumber = @Number,PDescription = @Description
Where PID = @Id

--Store lay ID cua Exhibitor
create proc get_EID
as
select EName, EID
from Exhibitor
