use Expo
go

-- noi bang Booth vao Contact
alter table Booths 
add constraint FK_ConsCID 
foreign key (CID) references Contact 

-- chuyen cot SpDescription sang ntext
Alter table Sponsors
ALTER COLUMN SpDescription ntext