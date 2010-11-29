use Expo
go

Alter table Staff
ADD EID int
-- noi bang EID vao Exhibitor
alter table Staff 
add constraint FK_ConsEID 
foreign key (EID) references Exhibitor 
-- xoa truong 
Alter table Booths
drop CONSTRAINT FK_Booths_Staff
Alter table Booths
drop column SID
-- them truong BID vao bang Staff
Alter table Staff
add BID int
foreign key (BID) references Booths 