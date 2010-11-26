use Expo
go
-- them du lieu de test xem bang Expo trong Java co load dc thong tu DB khong
-- luu y kieu datetime la thang truoc ngay sau (mm/dd/yy)
insert into Expo (ExName, ExNumBooth, ExMoney, ExDescription, ExDateStart, ExDateEnd)
	values ('Hoi Cho Mua Na',100,1000000,'Trien lam moi thu phuc vu mua na','1/1/2010','2/1/2010')
insert into Expo (ExName, ExNumBooth, ExMoney, ExDescription, ExDateStart, ExDateEnd)
	values ('Hoi Cho Sat',150,5000000,'Trien lam chuyen ve Sat Thep','5/1/2010','6/2/2010')
insert into Expo (ExName, ExNumBooth, ExMoney, ExDescription, ExDateStart, ExDateEnd)
	values ('Hoi Cho Lua',200,2000000,'Quy tu cac san pham nong nghiep','7/5/2010','9/5/2010')
insert into Expo (ExName, ExNumBooth, ExMoney, ExDescription, ExDateStart, ExDateEnd)
	values ('Hoi Cho Xe',50,9000000,'Trien lam cac san pham oto xe may','11/10/2010','12/9/2010')
insert into Expo (ExName, ExNumBooth, ExMoney, ExDescription, ExDateStart, ExDateEnd)
	values ('Hoi Cho Tong hop',500,500000,'Gioi thieu cac san pham thuoc da nganh','4/17/2010','6/14/2010')

-- Tao Store goi ra tat ca expo
create proc getAllExpo
as
select Expo.ExID, Expo.ExName, Expo.ExNumBooth, Expo.ExMoney, Expo.ExDescription, Expo.ExDateStart, Expo.ExDateEnd
from Expo 

-- Tao Store co tham so de tao Expo

CREATE PROC AddExpo
@Name nvarchar(100),
@NumBooth int,
@Cost float,
@Description ntext,
@DateStart SMALLDATETIME,
@DateEnd SMALLDATETIME
AS
INSERT INTO Expo (ExName, ExNumBooth, ExMoney, ExDescription, ExDateStart, ExDateEnd)
VALUES(@Name,@NumBooth,@Cost,@Description,@DateStart,@DateEnd)

-- Tao Store delete BoothType
create proc deleteExpo
@ID int
as
delete from Expo
where ExID = @ID

--Tao Store de tim kiem Product theo ten
Create PROC findExpo
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @fe nvarchar(200)
set @fe = 'select Expo.ExID, Expo.ExName, Expo.ExNumBooth, Expo.ExMoney, Expo.ExDescription, Expo.ExDateStart, Expo.ExDateEnd from Expo where '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@fe)


-- Tao store edit Expo
create proc editExpo
@id int,
@Name nvarchar(100),
@NumBooth int,
@Cost float,
@Description ntext,
@DateStart SMALLDATETIME,
@DateEnd SMALLDATETIME
as
update Expo
Set @Name = ExName,@NumBooth = ExNumBooth,@Cost = ExMoney,@Description = ExDescription,@DateStart = ExDateStart,@DateEnd = ExDateEnd
where ExID = @id