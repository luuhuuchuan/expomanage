CREATE DATABASE [Expo]
Go
USE [Expo]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Priority]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Priority](
	[PrID] [int] IDENTITY(1,1) NOT NULL,
	[PrType] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Priority] PRIMARY KEY CLUSTERED 
(
	[PrID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Exhibitor]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Exhibitor](
	[EID] [int] IDENTITY(1,1) NOT NULL,
	[EName] [nvarchar](100) NOT NULL,
	[EFax] [varchar](30) NULL,
	[EPhone] [varchar](30) NOT NULL,
	[EAddress] [ntext] NOT NULL,
	[EWebsite] [varchar](100) NULL,
 CONSTRAINT [PK_Exhibitor] PRIMARY KEY CLUSTERED 
(
	[EID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Expo]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Expo](
	[ExID] [int] IDENTITY(1,1) NOT NULL,
	[ExName] [nvarchar](100) NOT NULL,
	[ExNumBooth] [int] NOT NULL,
	[ExMoney] [float] NOT NULL,
	[ExDescription] [ntext] NULL,
	[ExDateStart] [smalldatetime] NOT NULL,
	[ExDateEnd] [smalldatetime] NOT NULL,
 CONSTRAINT [PK_Expo] PRIMARY KEY CLUSTERED 
(
	[ExID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Booths]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Booths](
	[BID] [int] IDENTITY(1,1) NOT NULL,
	[BTID] [int] NOT NULL,
	[SID] [int] NOT NULL,
	[CID] [char](10) NOT NULL,
	[BName] [nvarchar](100) NOT NULL,
	[BDate] [smalldatetime] NOT NULL,
	[BMoney] [float] NOT NULL,
	[BBooker] [bit] NOT NULL,
 CONSTRAINT [PK_Booths] PRIMARY KEY CLUSTERED 
(
	[BID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Contact]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Contact](
	[CID] [char](10) NOT NULL,
	[ExID] [int] NOT NULL,
	[EID] [int] NOT NULL,
	[PrID] [int] NOT NULL,
	[CUserCredential] [nvarchar](100) NOT NULL,
	[CNumOfBooth] [int] NOT NULL,
	[CPaid] [float] NOT NULL,
	[CDateRegister] [smalldatetime] NOT NULL,
	[CDateSent] [smalldatetime] NOT NULL,
	[CDateReturn] [smalldatetime] NOT NULL,
	[CDateLastChange] [smalldatetime] NOT NULL,
	[CStatus] [bit] NOT NULL,
 CONSTRAINT [PK_Contact] PRIMARY KEY CLUSTERED 
(
	[CID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Staff]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Staff](
	[SID] [int] IDENTITY(1,1) NOT NULL,
	[CID] [char](10) NOT NULL,
	[SName] [nvarchar](100) NOT NULL,
	[SEmail] [nvarchar](100) NOT NULL,
	[SPhone] [int] NOT NULL,
	[SAddress] [ntext] NOT NULL,
 CONSTRAINT [PK_Staff] PRIMARY KEY CLUSTERED 
(
	[SID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Products]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Products](
	[PID] [int] IDENTITY(1,1) NOT NULL,
	[EID] [int] NOT NULL,
	[CID] [char](10) NOT NULL,
	[PName] [nvarchar](100) NOT NULL,
	[PPrice] [float] NULL,
	[PNumber] [int] NULL,
	[PDescription] [ntext] NULL,
	[PDate] [smalldatetime] NOT NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[PID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[User]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[User](
	[UName] [nvarchar](100) NOT NULL,
	[UPass] [varchar](100) NOT NULL,
	[UTypeUser] [tinyint] NULL,
	[UEmail] [varchar](100) NULL,
	[EID] [int] NULL,
 CONSTRAINT [PK_User_1] PRIMARY KEY CLUSTERED 
(
	[UName] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BoothType]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[BoothType](
	[BTID] [int] IDENTITY(1,1) NOT NULL,
	[BTName] [nvarchar](100) NOT NULL,
	[ExID] [int] NULL,
	[BTHeight] [float] NULL,
	[BTWidth] [float] NULL,
	[BoothRemain] [int] NOT NULL,
	[BoothLength] [int] NOT NULL,
 CONSTRAINT [PK_BoothType] PRIMARY KEY CLUSTERED 
(
	[BTID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Sponsors]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Sponsors](
	[SpID] [int] IDENTITY(1,1) NOT NULL,
	[ExID] [int] NULL,
	[SpName] [nvarchar](100) NOT NULL,
	[SpMoney] [float] NULL,
	[SpDescription] [nchar](10) NULL,
 CONSTRAINT [PK_Sponsors] PRIMARY KEY CLUSTERED 
(
	[SpID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Booths_BoothType1]') AND parent_object_id = OBJECT_ID(N'[dbo].[Booths]'))
ALTER TABLE [dbo].[Booths]  WITH CHECK ADD  CONSTRAINT [FK_Booths_BoothType1] FOREIGN KEY([BTID])
REFERENCES [dbo].[BoothType] ([BTID])
GO
ALTER TABLE [dbo].[Booths] CHECK CONSTRAINT [FK_Booths_BoothType1]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Booths_Staff]') AND parent_object_id = OBJECT_ID(N'[dbo].[Booths]'))
ALTER TABLE [dbo].[Booths]  WITH CHECK ADD  CONSTRAINT [FK_Booths_Staff] FOREIGN KEY([SID])
REFERENCES [dbo].[Staff] ([SID])
GO
ALTER TABLE [dbo].[Booths] CHECK CONSTRAINT [FK_Booths_Staff]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Contact_Exhibitor]') AND parent_object_id = OBJECT_ID(N'[dbo].[Contact]'))
ALTER TABLE [dbo].[Contact]  WITH CHECK ADD  CONSTRAINT [FK_Contact_Exhibitor] FOREIGN KEY([EID])
REFERENCES [dbo].[Exhibitor] ([EID])
GO
ALTER TABLE [dbo].[Contact] CHECK CONSTRAINT [FK_Contact_Exhibitor]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Contact_Expo]') AND parent_object_id = OBJECT_ID(N'[dbo].[Contact]'))
ALTER TABLE [dbo].[Contact]  WITH CHECK ADD  CONSTRAINT [FK_Contact_Expo] FOREIGN KEY([ExID])
REFERENCES [dbo].[Expo] ([ExID])
GO
ALTER TABLE [dbo].[Contact] CHECK CONSTRAINT [FK_Contact_Expo]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Contact_Priority]') AND parent_object_id = OBJECT_ID(N'[dbo].[Contact]'))
ALTER TABLE [dbo].[Contact]  WITH CHECK ADD  CONSTRAINT [FK_Contact_Priority] FOREIGN KEY([PrID])
REFERENCES [dbo].[Priority] ([PrID])
GO
ALTER TABLE [dbo].[Contact] CHECK CONSTRAINT [FK_Contact_Priority]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Staff_Contact]') AND parent_object_id = OBJECT_ID(N'[dbo].[Staff]'))
ALTER TABLE [dbo].[Staff]  WITH CHECK ADD  CONSTRAINT [FK_Staff_Contact] FOREIGN KEY([CID])
REFERENCES [dbo].[Contact] ([CID])
GO
ALTER TABLE [dbo].[Staff] CHECK CONSTRAINT [FK_Staff_Contact]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Products_Contact]') AND parent_object_id = OBJECT_ID(N'[dbo].[Products]'))
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Contact] FOREIGN KEY([CID])
REFERENCES [dbo].[Contact] ([CID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Contact]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Products_Exhibitor1]') AND parent_object_id = OBJECT_ID(N'[dbo].[Products]'))
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Exhibitor1] FOREIGN KEY([EID])
REFERENCES [dbo].[Exhibitor] ([EID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Exhibitor1]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_User_Exhibitor]') AND parent_object_id = OBJECT_ID(N'[dbo].[User]'))
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Exhibitor] FOREIGN KEY([EID])
REFERENCES [dbo].[Exhibitor] ([EID])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Exhibitor]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_BoothType_Expo]') AND parent_object_id = OBJECT_ID(N'[dbo].[BoothType]'))
ALTER TABLE [dbo].[BoothType]  WITH CHECK ADD  CONSTRAINT [FK_BoothType_Expo] FOREIGN KEY([ExID])
REFERENCES [dbo].[Expo] ([ExID])
GO
ALTER TABLE [dbo].[BoothType] CHECK CONSTRAINT [FK_BoothType_Expo]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Sponsors_Expo1]') AND parent_object_id = OBJECT_ID(N'[dbo].[Sponsors]'))
ALTER TABLE [dbo].[Sponsors]  WITH CHECK ADD  CONSTRAINT [FK_Sponsors_Expo1] FOREIGN KEY([ExID])
REFERENCES [dbo].[Expo] ([ExID])
GO
ALTER TABLE [dbo].[Sponsors] CHECK CONSTRAINT [FK_Sponsors_Expo1]

