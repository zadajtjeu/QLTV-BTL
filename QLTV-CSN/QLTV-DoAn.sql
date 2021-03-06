use master
go 
create database QLTV 
go
use QLTV
go 
create table DOCGIA(
	sothe nchar(10) not null primary key,
	hoten nvarchar(50) ,
	ngaysinh nvarchar(20),
	diachi nvarchar(50),
	sodienthoai nvarchar(20)
)
create table LOAITAILIEU(
	maloaitailieu nchar(10) primary key,
	tenloaitailieu nvarchar(50)
)
create table TAILIEU(
	masach nchar(10) not null primary key,
	tensach nvarchar(50),
	tentg nvarchar(50),
	namxb int,
	dongia decimal,
	maloaitailieu nchar(10) not null,
	constraint FK_TAILIEU_LOAITAILIEU foreign key (maloaitailieu) references LOAITAILIEU(maloaitailieu)
)
create table MUONTRA(
	mamuon nchar(10) not null primary key,
	Songaymuon int,
	masach nchar(10) not null ,
	sothe nchar(10) not null,
	constraint FK_MUONTRA_TAILIEU foreign key (masach) references TAILIEU(masach),
	constraint FK_MUONTRA_DOCGIA foreign key (sothe) references DOCGIA(sothe)
)
create table PHIEUMUON(
	mamuon nchar(10) not null primary key,
	tiencoc decimal,
	tienphimuon decimal,
	constraint FK_PHIEUMUON_MUONTRA foreign key (mamuon) references MUONTRA(mamuon)
)

GO


/* INSERT SAMPLE DATA */

INSERT INTO DOCGIA VALUES('DG_01', N'Nguyễn Cao Kỳ', '22/03/1999', N'Thái Bình', '0123456789'),
						 ('DG_02', N'Lê Văn Luyện', '10/02/1998', N'Hà Giang', '0912345678'),
						 ('DG_03', N'Hoàng Thị Mơ', '15/08/1997', N'Thái Nguyên', '0355525252'),
						 ('DG_04', N'Lại Hà Thi', '25/07/2000', N'Hà Nội', '022225552'),
						 ('DG_05', N'Huỳnh Đại La', '03/03/2000', N'Hưng Yên', '04585795423'),
						 ('DG_06', N'Phan Tú Lê', '02/01/2000', N'Vĩnh Phúc', '0874126521'),
						 ('DG_07', N'Lý Nhã Kỳ Cùng', '22/12/1999', N'Hải Dương', '1111'),
						 ('DG_08', N'Hoàng Lê Công Cốc', '29/02/2000', N'Hà Nội', '1111'),
						 ('DG_09', N'Lê Lý Thị Mộng', '11/11/2000', N'Hà Giang', '111')
INSERT INTO LOAITAILIEU VALUES('TL_01', N'Lý luận chính trị'),
							  ('TL_02', N'Khoa học xã hội và nhân văn'),
							  ('TL_03', N'Toán học và Khoa học tự nhiên'),
							  ('TL_04', N'Kiến thức cơ sở ngành'),
							  ('TL_05', N'Kiến thức chuyên ngành')
INSERT INTO TAILIEU VALUES('MS_01', N'Tư tưởng Hồ Chí Minh', N'Hoàng Thị Hương Thu', 2018, 45000, 'TL_01'),
						  ('MS_02', N'NLCB chủ nghĩa Mác-Lênin', N'Bộ Giáo dục và Đào tạo', 2018, 20000, 'TL_01'),
						  ('MS_03', N'Đường lối cách mạng của Đảng Cộng sản Việt Nam', N'Bộ Giáo dục và đào tạo', 2010, 32000, 'TL_01'),
						  ('MS_04', N'Pháp luật đại cương', N'Trường Đại học Công nghiệp Hà Nội', 2016, 45000, 'TL_02'),
						  ('MS_05', N'Kỹ năng giao tiếp', N'Phạm Văn Đại', 2015, 50000, 'TL_02'),
						  ('MS_06', N'Toán học cao cấp', N'Nguyễn Đình Trí', 2000, 35000, 'TL_03'),
						  ('MS_07', N'Đại số tuyến tính', N'Trần Lưu Cường', 2005, 56000, 'TL_03'),
						  ('MS_08', N'Toán rời rạc', N'Nguyễn Tô Thành', 2001, 44000, 'TL_03'),
						  ('MS_09', N'Giáo trình cơ sở dữ liệu', N'Nguyễn Thị Thanh Huyền', 2010, 42000, 'TL_04'),
						  ('MS_10', N'Cấu trúc dữ liệu và giải thuật', N'An Văn Minh', 2016, 55000, 'TL_04'),
						  ('MS_11', N'Giáo trình phân tích thiết kế hệ thống', N'Nguyễn Thị Thanh Huyền', 2011, 25000, 'TL_04'),
						  ('MS_12', N'Kiểm thử và đảm bảo chất lượng phần mềm', N'Thạc Bình Cường, Nguyễn Đức Mận', 2011, 65000, 'TL_05')
INSERT INTO MUONTRA VALUES('M_01', 30, 'MS_01', 'DG_03'), ('M_02', 25, 'MS_06', 'DG_02')
INSERT INTO PHIEUMUON VALUES('M_01', 30000, 5000), ('M_02', 20000, 3000)


GO

select * from DOCGIA
select * from LOAITAILIEU
select * from TAILIEU
select * from MUONTRA
select * from PHIEUMUON


DELETE FROM DOCGIA WHERE SOTHE = 'DG_01'