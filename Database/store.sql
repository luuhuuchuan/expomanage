use Expo
go

go
create PROC doLogin
@User nvarchar(50)
AS
Select UName,UPass,UTypeUser,EID from [User] where UName=@User 
----------------------------------------EXPO-------------------------------------------
-- Tao Store goi ra tat ca expo
go
create proc getAllExpo
as
select Expo.ExID, Expo.ExName, Expo.ExNumBooth, Expo.ExMoney, Expo.ExDescription, Expo.ExDateStart, Expo.ExDateEnd
from Expo 

-- Tao Store co tham so de tao Expo
go
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
go
create proc deleteExpo
@ID int
as
begin
	delete from BoothType
		where ExID = @ID
	delete from Contact
		where ExID = @ID
	delete from Sponsors
		where ExID = @ID
	delete from Expo
		where ExID = @ID
end

-- Tao Store goi ra ten va id tat ca expo
go
create proc getID_Name_Of_Expo
as
select ExName, ExID
from Expo



--Tao Store de tim kiem Product theo ten
go
Create PROC findExpo
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @fe nvarchar(200)
set @fe = 'select Expo.ExID, Expo.ExName, Expo.ExNumBooth, Expo.ExMoney, Expo.ExDescription, Expo.ExDateStart, Expo.ExDateEnd from Expo where '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@fe)


-- Tao store edit Expo
go
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
Set ExName = @Name,ExNumBooth = @NumBooth,ExMoney = @Cost,ExDescription = @Description,ExDateStart = @DateStart,ExDateEnd = @DateEnd
where ExID = @id


----------------------------------------BOOTH-------------------------------------------

-- Tao Store goi ra tat ca expo
go
create proc getAllBooths
as
select B.CID,B.BID,BT.BTName,B.BName,B.BDate,B.BMoney,B.BBooker 
from Booths B ,BoothType BT
where B.BTID = BT.BTID


--
go
create proc get_CID
as
select CID
from Contact

--
go
create proc get_BoothType
as
select BTName , BTID
from BoothType

go
create proc get_Booth
as
select BName , BID
from Booths


-- Tao Store co tham so de tao Expo
go
CREATE PROC AddBooths
@BTID int,
@CID char(10),
@Name nvarchar(100),
@Date smalldatetime,
@money float,
@booker bit
AS
INSERT INTO Booths (BTID, CID, BName, BDate, BMoney, BBooker)
VALUES(@BTID,@CID,@Name,@Date,@money,@booker)

-- Tao store edit BoothType
go
create proc editBooths
@id int,
@BTID int,
@CID char(10),
@Name nvarchar(100),
@Date smalldatetime,
@money float
as
update Booths
Set BTID = @BTID,CID = @CID,BName = @Name,BDate = @Date,BMoney = @money
where BID = @id

-- Tao store dele Booths
go
create proc deleteBooths
@ID int
as
delete from Booths
where BID = @ID

-- Tao store search Booths
go
Create PROC findBooths
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @fb nvarchar(200)
set @fb = 'select B.CID, B.BID, BT.BTName, B.BName, B.BDate, B.BMoney, B.BBooker from Booths B ,BoothType BT  where B.BTID = BT.BTID and '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@fb)
exec findBooths
------------------------------------------------BOTHTYPE------------------------------------------
-- Tao Store goi ra tat ca expo
go
create proc getAllBoothType
as
select BT.BTID,BT.BTName,E.ExName,BT.BTHeight, BT.BTWidth, BT.BoothRemain, BT.BoothLength 
from BoothType BT join Expo E
on BT.ExID = E.ExID

-- Tao Store co tham so de tao BoothType
go
CREATE PROC AddBoothType
@Name nvarchar(100),
@ExID int,
@Height float,
@Width float,
@BoothRemain int,
@BoothLength int
AS
INSERT INTO BoothType (BTName,ExID, BTHeight, BTWidth, BoothRemain, BoothLength)
VALUES(@Name,@ExID,@Height,@Width,@BoothRemain,@BoothLength)

-- Tao Store delete BoothType
go
create proc deleteBoothType
@ID int
as
begin
	delete from Booths
		where BTID = @ID
	delete from BoothType
		where BTID = @ID
end



--Tao Store de tim kiem Product theo ten
go
create PROC findBoothType
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @fbt nvarchar(200)
set @fbt = 'select BT.BTID,BT.BTName,E.ExName,BT.BTHeight, BT.BTWidth, BT.BoothRemain, BT.BoothLength from BoothType BT join Expo E on BT.ExID = E.ExID where '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@fbt)


-- Tao store edit BoothType
go
create proc editBoothType
@id int,
@Name nvarchar(100),
@ExID int,
@Height float,
@Width float,
@BoothRemain int,
@BoothLength int
as
update BoothType
Set BTName = @Name,ExID = @ExID,BTHeight = @Height,BTWidth = @Width,BoothRemain = @BoothRemain,BoothLength = @BoothLength
where BTID = @id

--------------------------------------------------------------------------------------------------

------------------------------------------------EXHIBITOR------------------------------------------
-- Tao Store goi ra tat ca Exhibitor
go
create proc getAllExhibitor
as
select * from Exhibitor

-- Tao Store co tham so de tao Exhibitor
go
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
go
Create PROC findExhibitor
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @exh nvarchar(200)
set @exh = 'Select * from Exhibitor where '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@exh)

--Tao Store de Edit Exhibitor
go
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
go
create PROC DeleteExhibitor
@id int
AS
begin
	DELETE FROM Staff WHERE CID IN (SELECT CID FROM Contact WHERE EID = @id)
	DELETE FROM Products WHERE CID IN (SELECT CID FROM Contact WHERE EID = @id)
	DELETE FROM Contact WHERE EID = @id
	DELETE FROM Products WHERE EID = @id
	DELETE FROM [User] WHERE EID = @id
	DELETE FROM Exhibitor WHERE EID = @id
end
--Tao Store lay ra ID moi nhat cua Exhibitor
go
Create Proc GetExhibitorID
AS
Select Max(EID) From Exhibitor

--------------------------------------------------------------------------------------------------

------------------------------------------------PRODUCT------------------------------------------
-- Tao Store goi ra tat ca Products
go
create proc getAllProducts
@EID int
as
select * from Products where EID=@EID


-- Tao Store co tham so de tao Products
go
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
go
CREATE PROC DeleteProducts
@id int
AS
DELETE FROM Products WHERE PID = @id

--Tao Store de tim kiem Product theo ten
go
Create PROC findProduct
@EID varchar,
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @sp nvarchar(200)
set @sp = 'Select * from Products where EID='+@EID+' and '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@sp)


--Tao Store de Edit Product
go
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
--------------------------------------------------------------------------------------------------

------------------------------------------------SPONSOR------------------------------------------
-- Tao Store goi ra tat ca Sponsors
go
create proc getAllSponsors
as
select S.SpID,S.SpName,E.ExName,S.SpMoney,S.SpDescription 
from Sponsors as S join Expo as E
on S.ExID = E.ExID 

-- tao store lay thong tin 1 sponsor
go
create proc getSponsorByID
@id int
as
select * from Sponsors 
where SpID=@id

-- Tao Store co tham so de tao Expo
go
CREATE PROC AddSponsor
@ExID int,
@SpName nvarchar(100),
@SpMoney float,
@SpDescription ntext 
AS
INSERT INTO Sponsors ( ExID, SpName, SpMoney, SpDescription)
	VALUES(@ExID,@SpName,@SpMoney,@SpDescription)


----------edit
go
create proc editSponsor
@id int,
@name nvarchar(100),
@eid int,
@money float,
@description ntext 
as
update Sponsors
set SpName = @name,ExID = @eid,SpMoney = @money,SpDescription = @description
where SpID = @id

-- Tao store dele Sponsor
go
create proc deleteSponsor
@ID int
as
delete from Sponsors
where SpID = @ID

-- Tao store search Sponsor
go
create PROC findSponsor
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @fs nvarchar(200)
set @fs = 'select S.SpID,S.SpName,E.ExName,S.SpMoney,S.SpDescription from Sponsors as S join Expo as E on S.ExID = E.ExID  where '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@fs)
--------------------------------------------------------------------------------------------------

------------------------------------------------STAFF------------------------------------------
-- Tao Store goi ra tat ca Staff
go
create proc getAllStaff
@EID int
as
select S.SID,C.CID,S.SName,S.SEmail,S.SPhone,S.SAddress,B.BName 
From Staff S,Contact C,Booths B
where S.CID = C.CID and B.BID = S.BID and S.EID = @EID


-- Tao Store co tham so de tao Staff
go
CREATE PROC AddStaff
@CID char(10),
@Name nvarchar(100),
@Email nvarchar(100),
@Phone nvarchar(50),
@Address ntext,
@EID int,
@BID int
AS
INSERT INTO Staff (CID,SName, SEmail, SPhone, SAddress, EID,BID)
	VALUES(@CID,@Name,@Email,@Phone,@Address,@EID,@BID)

----Tao Store tim kiem Staff
go
create PROC findStaff
@EID int,
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @sta nvarchar(200)
set @sta = 'select S.SID,C.CID,S.SName,S.SEmail,S.SPhone,S.SAddress,B.BName from Staff S ,Contact C,Booths B where S.CID = C.CID and S.BID=B.BID and S.EID ='+CAST(@EID AS varchar)+' and '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@sta)

--Tao Store de Edit Staff
go
Create Proc EditStaff
@ID int,
@CID char(10),
@Name nvarchar(100),
@Email nvarchar(100),
@Phone nvarchar(50),
@Address ntext,
@BID int
AS
Update Staff
Set CID = @CID,SName = @Name,SEmail = @Email,SPhone = @Phone,SAddress = @Address,BID = @BID
Where SID = @ID

--Tao store de xoa staff
go
CREATE PROC DeleteStaff
@id int
AS
DELETE FROM Staff WHERE SID = @id

--------------------------------------------------------------------------------------------------

------------------------------------------------USER------------------------------------------
-- Tao Store goi ra tat ca Staff
go
create proc getAllUser
as
select * from [User]

-- Tao Store co tham so de tao Staff
go
CREATE PROC AddUser
@Name nvarchar(100),
@Pass varchar(100),
@TypeUser tinyint,
@Email varchar(100),
@EID int
AS
INSERT INTO [User] (UName, UPass, UTypeUser, UEmail, EID)
	VALUES(@Name,@Pass,@TypeUser,@Email,@EID)

----Tao Store tim kiem User
go
Create PROC findUser
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @use nvarchar(200)
set @use = 'Select * from [User] where '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@use)

--Tao Store de Edit User
go
Create Proc EditUser
@oName nvarchar(100),
@nName nvarchar(100),
@Pass varchar(100),
@Email varchar(100)
AS
Update [User]
Set UName = @nName,UPass = @Pass,UEmail = @Email
Where UName = @oName

--Tao store de xoa user
go
CREATE PROC DeleteUser
@name nvarchar(100)
AS
DELETE FROM [User] WHERE UName = @name

----Tao Store check userName da ton tai hay chua
go
Create PROC checkUser
@Name nvarchar(100)
AS
begin 
	declare @status bit
	if (@Name in (select UName from [User]))
		set @status = 'true'
	else 
		set @status = 'false'
	select @status 
end

--------------------------------------------------------------------------------------------------