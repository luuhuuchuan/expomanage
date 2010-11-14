--Va loi cau truc CSDL lan 1:D
use expo
GO
-- bo 2 cot BLength va BRemain
Alter table Booths
drop column BLength,BRemain
-- them BoothLength va BoothRemain vao BoothType
Alter table BoothType
add BoothLength int,BoothRemain int
-- doi kieu int cua fax va phone cua bang exhibitor sang varchar
Alter table Exhibitor
ALTER COLUMN EFax varchar(30) 
Alter table Exhibitor
ALTER COLUMN EPhone varchar(30)
