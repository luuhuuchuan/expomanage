use Expo
go
-- them du lieu de test xem bang Staff trong Java co load dc thong tu DB khong
insert into Users (UName, UPass, UTypeUser, UEmail)
	values ('Manh','123456','01','manhnm@gmail.com')
insert into Users (UName, UPass, UTypeUser, UEmail)
	values ('Dung','123456','02','dungdt@yahoo.com')
insert into Users (UName, UPass, UTypeUser, UEmail)
	values ('Tuan','123456','03','tuantt@gmail.com')
insert into Users (UName, UPass, UTypeUser, UEmail)
	values ('Vu','123456','04','vunt@gmail.com')
insert into Users (UName, UPass, UTypeUser, UEmail)
	values ('Quang','123456','05','quangnm@gmail.com')

-- Tao Store goi ra tat ca Staff
create proc getAllUser
as
select * from Users

-- Tao Store co tham so de tao Staff

CREATE PROC AddUser
@Name nvarchar(100),
@Pass varchar(100),
@TypeUser tinyint,
@Email varchar(100),
@FLAG INT OUTPUT

AS
BEGIN
	INSERT INTO Users (UName, UPass, UTypeUser, UEmail)
		VALUES(@Name,@Pass,@TypeUser,@Email)
	SET	@FLAG = 1;
	SELECT @FLAG
END