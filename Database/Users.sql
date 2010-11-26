use Expo
go
-- them du lieu de test xem bang Staff trong Java co load dc thong tu DB khong
insert into [User] (UName, UPass, UTypeUser, UEmail)
	values ('Manh','123456','1','manhnm@gmail.com')
insert into [User] (UName, UPass, UTypeUser, UEmail, EID)
	values ('Dung','123456','2','dungdt@yahoo.com',1)
insert into [User] (UName, UPass, UTypeUser, UEmail, EID)
	values ('Tuan','123456','2','tuantt@gmail.com',2)
insert into [User] (UName, UPass, UTypeUser, UEmail, EID)
	values ('Vu','123456','2','vunt@gmail.com',3)
insert into [User] (UName, UPass, UTypeUser, UEmail, EID)
	values ('Quang','123456','2','quangnm@gmail.com',4)

-- Tao Store goi ra tat ca Staff
create proc getAllUser
as
select * from [User]

exec getAllUser
-- Tao Store co tham so de tao Staff

CREATE PROC AddUser
@Name nvarchar(100),
@Pass varchar(100),
@TypeUser tinyint,
@Email varchar(100),
@EID int
AS
INSERT INTO [User] (UName, UPass, UTypeUser, UEmail, EID)
	VALUES(@Name,@Pass,@TypeUser,@Email,@EID)
END

----Tao Store tim kiem User
Create PROC findUser
@Where nvarchar(50),
@Key nvarchar(100)
AS
Declare @use nvarchar(200)
set @use = 'Select * from [User] where '+ @Where + ' like '+char(39)+'%'  + @Key +'%' + char(39)
execute(@use)

--Tao Store de Edit User
Create Proc EditUser
@Name nvarchar(100),
@Pass nvarchar(100),
@TypeUser nvarchar(50),
@Email ntext
AS
Update [User]
Set UName = @Name,UPass = @Pass,UTypeUser = @TypeUser,UEmail = @Email
Where UName = @Name

--Tao store de xoa user
CREATE PROC DeleteUser
@name nvarchar(100)
AS
DELETE FROM [User] WHERE UName = @name