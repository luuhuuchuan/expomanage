use Expo
go
-- them du lieu de test xem bang Staff trong Java co load dc thong tu DB khong
insert into Users (UName, UPass, UTypeUser, UEmail)
	values ('Manh','123456','1','manhnm@gmail.com')
insert into Users (UName, UPass, UTypeUser, UEmail, EID)
	values ('Dung','123456','2','dungdt@yahoo.com',1)
insert into Users (UName, UPass, UTypeUser, UEmail, EID)
	values ('Tuan','123456','2','tuantt@gmail.com',2)
insert into Users (UName, UPass, UTypeUser, UEmail, EID)
	values ('Vu','123456','2','vunt@gmail.com',3)
insert into Users (UName, UPass, UTypeUser, UEmail, EID)
	values ('Quang','123456','2','quangnm@gmail.com',4)

-- Tao Store goi ra tat ca Staff
create proc getAllUser
as
select * from User

-- Tao Store co tham so de tao Staff

CREATE PROC AddUser
@Name nvarchar(100),
@Pass varchar(100),
@TypeUser tinyint,
@Email varchar(100),
@EID int
AS
INSERT INTO Users (UName, UPass, UTypeUser, UEmail, EID)
	VALUES(@Name,@Pass,@TypeUser,@Email,@EID)