use Expo
go
-- them du lieu de test xem bang sponsors trong Java co load dc thong tu DB khong
-- luu y kieu datetime la thang truoc ngay sau (mm/dd/yy)
insert into Sponsors ( ExID, SpName, SpMoney, SpDescription)
	values (1,'ABBank Computer',3000000,'')
insert into Sponsors ( ExID, SpName, SpMoney, SpDescription)
	values (2,'Dong A Bank',6300000,'')
insert into Sponsors ( ExID, SpName, SpMoney, SpDescription)
	values (3,'Viglacera',500000,'')
insert into Sponsors (ExID, SpName, SpMoney, SpDescription)
	values (4,'Tap doan FPT',8000000,'')
insert into Sponsors( ExID, SpName, SpMoney, SpDescription)
	values (5,'Ngan hang Tien Phong ',5000000,'')

-- Tao Store goi ra tat ca expo
create proc getAllSponsors
as
select S.SpID,S.SpName,E.ExName,S.SpMoney,S.SpDescription 
from Sponsors as S join Expo as E
on S.ExID = E.ExID 


-- Tao Store co tham so de tao Expo

CREATE PROC AddSponsor
@ExID int
@SpName nvarchar(100) 
@SpMoney float
@SpDescription nchar(10) 
@FLAG INT OUTPUT

AS
BEGIN
	INSERT INTO Sponsors ( ExID, SpName, SpMoney, SpDescription)
		VALUES(@ExID,@Name,@Money,@Description)
	SET	@FLAG = 1;
	SELECT @FLAG
END

-- Chay thu Store
--DECLARE @F INT
--exec addExpo 'Hoi Sung',100,6000000,'Trien lam cac loai sung','11/10/2010','12/9/2010',@F OUTPUT
