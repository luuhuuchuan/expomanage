use Expo
go
---------------------LOGIN-------------------
go 
if Object_id('dbo.doLogin','P') is not null
drop proc doLogin
go
create PROC doLogin
@User nvarchar(50)
AS
Select UName,UPass,UTypeUser,EID from [User] where UName=@User 
----------------------------------------EXPO-------------------------------------------
-- Tao Store goi ra tat ca expo
go 
if Object_id('dbo.getAllExpo','P') is not null
drop proc getAllExpo
go
create proc getAllExpo
as
select Expo.ExID, Expo.ExName, Expo.ExNumBooth, Expo.ExMoney, Expo.ExDescription, Expo.ExDateStart, Expo.ExDateEnd
from Expo 

-- Tao Store co tham so de tao Expo
go 
if Object_id('dbo.AddExpo','P') is not null
drop proc AddExpo
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
if Object_id('dbo.deleteExpo','P') is not null
drop proc deleteExpo
go
create proc deleteExpo
@ID int
as
begin
	delete from BoothType
		where ExID = @ID
	delete from Contract
		where ExID = @ID
	delete from Sponsors
		where ExID = @ID
	delete from Expo
		where ExID = @ID
end

-- Tao Store goi ra ten va id tat ca expo
go 
if Object_id('dbo.getID_Name_Of_Expo','P') is not null
drop proc getID_Name_Of_Expo
go
create proc getID_Name_Of_Expo
as
select ExName, ExID
from Expo



--Tao Store de tim kiem Product theo ten
go 
if Object_id('dbo.findExpo','P') is not null
drop proc findExpo
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
if Object_id('dbo.editExpo','P') is not null
drop proc editExpo
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
if Object_id('dbo.getAllBooths','P') is not null
drop proc getAllBooths
go
create proc getAllBooths
as
select B.CID,B.BID,BT.BTName,B.BName,B.BDate,B.BMoney,B.BBooker 
from Booths B ,BoothType BT
where B.BTID = BT.BTID


go 
if Object_id('dbo.get_CID','P') is not null
drop proc get_CID
go
create proc get_CID
as
select CID
from Contract


go 
if Object_id('dbo.get_BoothType','P') is not null
drop proc get_BoothType
go
create proc get_BoothType
as
select BTName , BTID
from BoothType

go 
if Object_id('dbo.get_Booth','P') is not null
drop proc get_Booth
go
create proc get_Booth
as
select BName , BID
from Booths


-- Tao Store co tham so de tao Expo
go 
if Object_id('dbo.AddBooths','P') is not null
drop proc AddBooths
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
if Object_id('dbo.editBooths','P') is not null
drop proc editBooths
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
if Object_id('dbo.deleteBooths','P') is not null
drop proc deleteBooths
go
create proc deleteBooths
@ID int
as
delete from Booths
where BID = @ID

-- Tao store search Booths
go 
if Object_id('dbo.findBooths','P') is not null
drop proc findBooths
go
Create PROC findBooths
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @fb nvarchar(200)
set @fb = 'select B.CID, B.BID, BT.BTName, B.BName, B.BDate, B.BMoney, B.BBooker from Booths B join BoothType BT on B.BTID = BT.BTID where '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@fb)

------------------------------------------------BOTHTYPE------------------------------------------
-- Tao Store goi ra tat ca expo
go 
if Object_id('dbo.getAllBoothType','P') is not null
drop proc getAllBoothType
go
create proc getAllBoothType
as
select BT.BTID,BT.BTName,E.ExName,BT.BTHeight, BT.BTWidth, BT.BoothRemain, BT.BoothLength 
from BoothType BT join Expo E
on BT.ExID = E.ExID

-- Tao Store co tham so de tao BoothType
go 
if Object_id('dbo.AddBoothType','P') is not null
drop proc AddBoothType
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
if Object_id('dbo.deleteBoothType','P') is not null
drop proc deleteBoothType
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
if Object_id('dbo.findBoothType','P') is not null
drop proc findBoothType
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
if Object_id('dbo.editBoothType','P') is not null
drop proc editBoothType
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
if Object_id('dbo.getAllExhibitor','P') is not null
drop proc getAllExhibitor
go
create proc getAllExhibitor
as
select * from Exhibitor

-- Tao Store co tham so de tao Exhibitor
go 
if Object_id('dbo.AddExhibitor','P') is not null
drop proc AddExhibitor
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
if Object_id('dbo.findExhibitor','P') is not null
drop proc findExhibitor
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
if Object_id('dbo.EditExhibitor','P') is not null
drop proc EditExhibitor
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
if Object_id('dbo.DeleteExhibitor','P') is not null
drop proc DeleteExhibitor
go
create PROC DeleteExhibitor
@id int
AS
begin
	DELETE FROM Staff WHERE CID IN (SELECT CID FROM Contract WHERE EID = @id)
	DELETE FROM Products WHERE CID IN (SELECT CID FROM Contract WHERE EID = @id)
	DELETE FROM Contract WHERE EID = @id
	DELETE FROM Products WHERE EID = @id
	DELETE FROM [User] WHERE EID = @id
	DELETE FROM Exhibitor WHERE EID = @id
end
--Tao Store lay ra ID moi nhat cua Exhibitor
go 
if Object_id('dbo.GetExhibitorID','P') is not null
drop proc GetExhibitorID
go
Create Proc GetExhibitorID
AS
Select Max(EID) From Exhibitor

--------------------------------------------------------------------------------------------------

------------------------------------------------PRODUCT------------------------------------------
-- Tao Store goi ra tat ca Products
go 
if Object_id('dbo.getAllProducts','P') is not null
drop proc getAllProducts
go
create proc getAllProducts
@EID int
as
select * from Products where EID=@EID


-- Tao Store co tham so de tao Products
go 
if Object_id('dbo.AddProducts','P') is not null
drop proc AddProducts
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
if Object_id('dbo.DeleteProducts','P') is not null
drop proc DeleteProducts
go
CREATE PROC DeleteProducts
@id int
AS
DELETE FROM Products WHERE PID = @id

--Tao Store de tim kiem Product theo ten
go 
if Object_id('dbo.findProduct','P') is not null
drop proc findProduct
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
if Object_id('dbo.EditProduct','P') is not null
drop proc EditProduct
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
if Object_id('dbo.getAllSponsors','P') is not null
drop proc getAllSponsors
go
create proc getAllSponsors
as
select S.SpID,S.SpName,E.ExName,S.SpMoney,S.SpDescription 
from Sponsors as S join Expo as E
on S.ExID = E.ExID 

-- tao store lay thong tin 1 sponsor
go 
if Object_id('dbo.getSponsorByID','P') is not null
drop proc getSponsorByID
go
create proc getSponsorByID
@id int
as
select * from Sponsors 
where SpID=@id

-- Tao Store co tham so de tao Expo
go 
if Object_id('dbo.AddSponsor','P') is not null
drop proc AddSponsor
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
if Object_id('dbo.editSponsor','P') is not null
drop proc editSponsor
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
if Object_id('dbo.deleteSponsor','P') is not null
drop proc deleteSponsor
go
create proc deleteSponsor
@ID int
as
delete from Sponsors
where SpID = @ID

-- Tao store search Sponsor
go 
if Object_id('dbo.findSponsor','P') is not null
drop proc findSponsor
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
if Object_id('dbo.getAllStaff','P') is not null
drop proc getAllStaff
go
create proc getAllStaff
@EID int
as
select S.SID,C.CID,S.SName,S.SEmail,S.SPhone,S.SAddress,B.BName 
From Staff S,Contract C,Booths B
where S.CID = C.CID and B.BID = S.BID and S.EID = @EID


-- Tao Store co tham so de tao Staff
go 
if Object_id('dbo.AddStaff','P') is not null
drop proc AddStaff
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
if Object_id('dbo.findStaff','P') is not null
drop proc findStaff
go
create PROC findStaff
@EID int,
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @sta nvarchar(200)
set @sta = 'select S.SID,C.CID,S.SName,S.SEmail,S.SPhone,S.SAddress,B.BName from Staff S ,Contract C,Booths B where S.CID = C.CID and S.BID=B.BID and S.EID ='+CAST(@EID AS varchar)+' and '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@sta)

--Tao Store de Edit Staff
go 
if Object_id('dbo.EditStaff','P') is not null
drop proc EditStaff
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
if Object_id('dbo.DeleteStaff','P') is not null
drop proc DeleteStaff
go
CREATE PROC DeleteStaff
@id int
AS
DELETE FROM Staff WHERE SID = @id

--------------------------------------------------------------------------------------------------

------------------------------------------------USER------------------------------------------
-- Tao Store goi ra tat ca Staff
go 
if Object_id('dbo.getAllUser','P') is not null
drop proc getAllUser
go
create proc getAllUser
as
select * from [User]

-- Tao Store co tham so de tao Staff
go 
if Object_id('dbo.AddUser','P') is not null
drop proc AddUser
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
if Object_id('dbo.findUser','P') is not null
drop proc findUser
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
if Object_id('dbo.EditUser','P') is not null
drop proc EditUser
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
if Object_id('dbo.DeleteUser','P') is not null
drop proc DeleteUser
go
CREATE PROC DeleteUser
@name nvarchar(100)
AS
DELETE FROM [User] WHERE UName = @name

----Tao Store check userName da ton tai hay chua
go 
if Object_id('dbo.checkUser','P') is not null
drop proc checkUser
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
------------------------------------------------Contract-------------------------------------------
--Store GetAllContract
go 
if Object_id('dbo.getAllContract','P') is not null
drop proc getAllContract
go
create Proc getAllContract
@EID int
As
Begin
	if(@EID is null)
		Select C.CID,Ex.ExName,C.CUserCredential,C.CNumOfBooth,C.CPaid,C.CDateRegister,C.CDateSent,C.CDateReturn,C.CDateLastChange,C.CStatus,Pr.PrType
		From Contract as C 
		join Priority as Pr 
		on C.PrID = Pr.PrID
		join Expo as Ex
		on Ex.ExID = C.ExID
		where C.CDateSent is not null
	else
		Select C.CID,Ex.ExName,C.CUserCredential,C.CNumOfBooth,C.CPaid,C.CDateRegister,C.CDateSent,C.CDateReturn,C.CDateLastChange,C.CStatus,Pr.PrType
		From Contract as C 
		join Priority as Pr
		on C.PrID = Pr.PrID
		join Expo as Ex
		on Ex.ExID = C.ExID
		where C.EID=@EID
end

--Store update 1 Contract
go 
if Object_id('dbo.UpdateContract','P') is not null
drop proc UpdateContract
go
Create Proc UpdateContract
@id char(10),
@ExID int,
@User nvarchar(100),
@NumBooth int,
@Date smalldatetime
As
begin
	Update [Contract]
	Set ExID = @ExID,CUserCredential = @User,CNumOfBooth=@NumBooth,CDateLastChange=@Date
	Where CID = @id
end


--Store xoa 1 Contract
go 
if Object_id('dbo.DeleteContract','P') is not null
drop proc DeleteContract
go
Create Proc DeleteContract
@id char(10)
As
begin
	DELETE FROM Contract WHERE EID = @id
end

--Store send Contract
go 
if Object_id('dbo.SendContract','P') is not null
drop proc SendContract
go
Create Proc SendContract
@Cid char(10),
@SendDate smalldatetime
As
begin
	Update [Contract]
	Set CDateSent = @SendDate
	Where CID = @Cid
end

--Store return Contract
go 
if Object_id('dbo.ReturnContract','P') is not null
drop proc ReturnContract
go
Create Proc ReturnContract
@Cid char(10),
@Date smalldatetime,
@Paid float
As
begin
	Update [Contract]
	Set CDateReturn = @Date,CPaid = @Paid,CStatus = 'true'
	Where CID = @Cid
end
---Store Choice Booth
go 
if Object_id('dbo.showAllInformation','P') is not null
drop proc showAllInformation
go
create proc showAllInformation
@ID char(10)
as
select B.BID,B.BName, BT.BTName, BT.BoothLength,BT.BoothRemain, B.BMoney, B.BDate, B.BBooker
from Booths B join BoothType BT
on B.BTID = BT.BTID 
where BT.ExID = @ID


---Store đếm
go 
if Object_id('dbo.countExpo','P') is not null
drop proc countExpo
go
Create proc countExpo
as
begin
	declare @ex int
	set @ex = (select count(ExID) from Expo)
	declare @e int
	set @e = (select count(EID) from Exhibitor)
	declare @bt int
	set @bt = (select count(BTID) from BoothType)
	declare @b int
	set @b = (select count(BID) from Booths)
	declare @sp int
	set @sp = (select count(SpID) from Sponsors)
	declare @s int
	set @s = (select count(SID) from Staff)
	declare @p int
	set @p = (select count(PID) from Products)
	declare @c int
	set @c = (select count(CID) from Contract)
	select @ex as 'Total Expo',@e as 'Total Exhibitor', @bt as 'Total BoothType'
,@b as 'Total Booths',@sp as 'Total Sponsors',@s as 'Total Staff',@p as 'Total Product',@c as 'Total Contract'
end

---Store đếm cho Exhibitor
go 
if Object_id('dbo.countExhibitor','P') is not null
drop proc countExhibitor
go
Create proc countExhibitor
@id int
as
begin
	declare @s int
	set @s = (select count(SID) from Staff where EID = @id)
	declare @p int
	set @p = (select count(PID) from Products where EID = @id)
	declare @b int
	set @b = (select sum(CNumOfBooth) from Contract where EID = @id)
	declare @c int
	set @c = (select count(CID) from Contract where EID = @id)
	select @s as 'Total Staff',@p as 'Total Product',@b as 'Number of Booth', @c as 'Total Contract'
end
